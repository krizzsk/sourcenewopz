package com.didi.sdk.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class LazyInflateView {
    public static String TAG = LazyInflateView.class.getSimpleName();

    /* renamed from: a */
    private boolean f37835a;
    /* access modifiers changed from: protected */
    public boolean isInflated;
    /* access modifiers changed from: protected */
    public Context mContext;
    protected View mInflatedView;
    protected int mLayoutResourceId = -1;
    protected OnInflateListener mOnInflateListener;
    protected ViewGroup mParent;
    protected ViewStub mViewStub;

    /* access modifiers changed from: protected */
    public abstract void onInflate(View view);

    public LazyInflateView(Context context, ViewGroup viewGroup, int i, int i2, int i3) {
        this.mContext = context;
        this.mParent = viewGroup;
        this.mLayoutResourceId = i;
        ViewStub viewStub = new ViewStub(context, i, i2, i3);
        this.mViewStub = viewStub;
        if (viewStub != null) {
            viewStub.setVisibility(8);
        }
        attach();
    }

    public LazyInflateView(Context context, ViewGroup viewGroup, int i) {
        this.mContext = context;
        this.mParent = viewGroup;
        this.mLayoutResourceId = i;
        ViewStub viewStub = new ViewStub(context, i);
        this.mViewStub = viewStub;
        if (viewStub != null) {
            viewStub.setVisibility(8);
        }
        attach();
    }

    public Context getContext() {
        return this.mContext;
    }

    public void attach() {
        ViewGroup viewGroup;
        if (!this.f37835a && (viewGroup = this.mParent) != null) {
            View view = this.mInflatedView;
            if (view != null) {
                viewGroup.addView(view);
                this.f37835a = true;
                return;
            }
            ViewStub viewStub = this.mViewStub;
            if (viewStub != null) {
                if (viewStub.getParent() == null) {
                    this.mParent.addView(this.mViewStub);
                }
                this.f37835a = true;
            }
        }
    }

    public void show() {
        if (!this.isInflated) {
            inflate();
        }
        if (this.mInflatedView.getVisibility() != 0) {
            this.mInflatedView.setVisibility(0);
        }
    }

    public void hide() {
        if (this.isInflated && this.mInflatedView.getVisibility() != 8) {
            this.mInflatedView.setVisibility(8);
        }
    }

    public void inflate() {
        if (!this.isInflated) {
            ViewStub viewStub = this.mViewStub;
            if (viewStub != null) {
                this.mInflatedView = viewStub.inflate();
            }
            this.isInflated = true;
            onInflate(this.mInflatedView);
            OnInflateListener onInflateListener = this.mOnInflateListener;
            if (onInflateListener != null) {
                onInflateListener.onInflate(this.mInflatedView);
            }
        }
    }

    public boolean isInflated() {
        return this.isInflated;
    }

    public boolean isShow() {
        return this.isInflated && this.mInflatedView.getVisibility() == 0;
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.mOnInflateListener = onInflateListener;
    }

    public View getInflatedView() {
        return this.mInflatedView;
    }

    public View getRealView() {
        if (this.isInflated) {
            return this.mInflatedView;
        }
        return this.mViewStub;
    }

    public ViewGroup getParent() {
        if (getRealView() != null) {
            return (ViewGroup) getRealView().getParent();
        }
        return null;
    }
}
