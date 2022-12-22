package com.didi.soda.customer.base.lazycomponent;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.RestrictContext;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.base.lazycomponent.ILazyPresenter;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public abstract class ILazyView<P extends ILazyPresenter> implements RestrictContext {
    private static final String TAG = "ILazyView";
    private Context mContext;
    private InflateBlock mInflateBlock;
    private boolean mIsInitialized = false;
    private View mLazyView;
    private P mPresenter;

    private interface InflateBlock {
        View invoke();
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutResource();

    /* access modifiers changed from: package-private */
    public void attachPresenter(P p) {
        this.mPresenter = p;
    }

    private void attachContext(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ScopeContext getScopeContext() {
        P p = this.mPresenter;
        if (p != null) {
            return p.getScopeContext();
        }
        throw new IllegalStateException("Presenter not attach to this view of " + getClass().getName());
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public P getPresenter() {
        return this.mPresenter;
    }

    /* access modifiers changed from: package-private */
    public void innerAttach(ViewGroup viewGroup) {
        initLayoutResource(viewGroup);
        attachContext(viewGroup.getContext());
        onAttach();
    }

    /* access modifiers changed from: package-private */
    public void innerDetach() {
        onDetach();
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onAttach");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onCreate");
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onStart");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onResume");
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onPause");
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onStop");
        }
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onDetach");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (LazyComponent.f40349a) {
            LazyComponent.log(getClass().getSimpleName() + " : onDestroy");
        }
    }

    /* access modifiers changed from: protected */
    public void initLayoutResource(ViewGroup viewGroup) {
        if (getLayoutResource() != 0) {
            this.mInflateBlock = new InflateBlock(viewGroup) {
                public final /* synthetic */ ViewGroup f$1;

                {
                    this.f$1 = r2;
                }

                public final View invoke() {
                    return ILazyView.this.lambda$initLayoutResource$0$ILazyView(this.f$1);
                }
            };
        } else {
            LogUtil.m29102e(TAG, "you should override getLayoutResource method correctly");
        }
    }

    public /* synthetic */ View lambda$initLayoutResource$0$ILazyView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutResource(), viewGroup);
    }

    private void dispatchInitializedEvent() {
        this.mPresenter.initialized();
    }

    public View getView() {
        if (this.mInflateBlock == null) {
            LogUtil.m29102e(TAG, "还没有设置资源id mLayoutId = " + getLayoutResource());
            return null;
        }
        load();
        return this.mLazyView;
    }

    public void load() {
        if (!this.mIsInitialized) {
            this.mIsInitialized = true;
            InflateBlock inflateBlock = this.mInflateBlock;
            if (inflateBlock == null) {
                LogUtil.m29102e(TAG, "还没有设置资源id mLayoutId = " + getLayoutResource());
                return;
            }
            View invoke = inflateBlock.invoke();
            this.mLazyView = invoke;
            ButterKnife.bind((Object) this, invoke);
            dispatchInitializedEvent();
        }
    }

    public Resources getResources() {
        return this.mContext.getResources();
    }

    public AssetManager getAssets() {
        return this.mContext.getAssets();
    }

    public Resources.Theme getTheme() {
        return this.mContext.getTheme();
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final int getColor(int i) {
        return getResources().getColor(i);
    }

    public final Drawable getDrawable(int i) {
        return getResources().getDrawable(i);
    }
}
