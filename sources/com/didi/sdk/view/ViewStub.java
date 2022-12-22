package com.didi.sdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.didi.sdk.async.AsyncLayoutFactory;
import java.lang.ref.WeakReference;

public class ViewStub extends View {

    /* renamed from: a */
    private int f37928a;

    /* renamed from: b */
    private WeakReference<View> f37929b;

    /* renamed from: c */
    private LayoutInflater f37930c;

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public ViewStub(Context context, int i) {
        super(context);
        this.f37928a = i;
        setVisibility(8);
        setWillNotDraw(true);
    }

    public ViewStub(Context context, int i, int i2, int i3) {
        this(context, i);
        setLayoutParams(new ViewGroup.LayoutParams(i2, i3));
    }

    public ViewStub(Context context, WeakReference<View> weakReference) {
        super(context);
        this.f37929b = weakReference;
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getLayoutResource() {
        return this.f37928a;
    }

    public void setLayoutResource(int i) {
        this.f37928a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f37930c = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f37930c;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setVisibility(int i) {
        View view;
        WeakReference<View> weakReference = this.f37929b;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            super.setVisibility(i);
            if (i == 0 || i == 4) {
                inflate();
                return;
            }
            return;
        }
        view.setVisibility(i);
    }

    /* renamed from: a */
    private View m26849a(ViewGroup viewGroup) {
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(this.f37928a);
        if (viewByResId != null) {
            return viewByResId;
        }
        LayoutInflater layoutInflater = this.f37930c;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(getContext());
        }
        return layoutInflater.inflate(this.f37928a, viewGroup, false);
    }

    /* renamed from: a */
    private void m26850a(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        if (Build.VERSION.SDK_INT >= 21 && getOutlineProvider() != null) {
            view.setOutlineProvider(getOutlineProvider());
            view.setClipToOutline(true);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    public View inflate() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f37928a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View a = m26849a(viewGroup);
            m26850a(a, viewGroup);
            this.f37929b = new WeakReference<>(a);
            return a;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }
}
