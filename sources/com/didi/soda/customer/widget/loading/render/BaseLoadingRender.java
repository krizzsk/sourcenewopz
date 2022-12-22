package com.didi.soda.customer.widget.loading.render;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.widget.loading.ILoadingRender;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLoadingRender implements ILoadingRender {
    public static final String LOADING_BACKGROUND_COLOR = "Loading::Background::Color";
    public static final String LOADING_DURATION = "Loading::Duration";
    public static final String LOADING_GRAVITY = "Loading::Gravity";
    public static final String LOADING_INTERPOLATOR_ID = "Loading::Interpolator::Id";
    public static final int MAX_PARENT_LEVEL = 1;
    public static final int STATUS_RENDER_CREATED = 1;
    public static final int STATUS_RENDER_HIDE = 0;
    public static final int STATUS_RENDER_LAYOUT = 2;
    public static final int STATUS_RENDER_SHOWING = 3;

    /* renamed from: a */
    List<ILoadingRender.Callback> f42093a = new ArrayList();

    /* renamed from: b */
    private int f42094b = 0;

    /* renamed from: c */
    private View f42095c;

    /* renamed from: d */
    private int f42096d = 80;
    public int mRenderStatus = 0;

    /* access modifiers changed from: protected */
    public int maxParentSearchLevel() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public abstract View onCreateView(Context context, Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract void onStartLoading();

    /* access modifiers changed from: package-private */
    public abstract void onStopLoading();

    public final void addCallback(ILoadingRender.Callback callback) {
        this.f42093a.add(callback);
    }

    public final void layoutRender(View view, ViewGroup viewGroup) {
        if (m29694a(2)) {
            this.f42094b = 0;
            onLayoutView(view, m29693a(view), viewGroup);
            for (ILoadingRender.Callback onLayout : this.f42093a) {
                onLayout.onLayout();
            }
        }
    }

    public final void start() {
        if (m29694a(3)) {
            LogUtil.m29100d("BaseLoadingRender", "base render start");
            onStartLoading();
            for (ILoadingRender.Callback onStart : this.f42093a) {
                onStart.onStart();
            }
        }
    }

    public final void stop() {
        if (m29694a(0)) {
            LogUtil.m29100d("BaseLoadingRender", "base render stop");
            onStopLoading();
            View view = this.f42095c;
            if (!(view == null || view.getParent() == null)) {
                ((ViewGroup) this.f42095c.getParent()).removeView(this.f42095c);
            }
            for (ILoadingRender.Callback onStop : this.f42093a) {
                onStop.onStop();
            }
            this.f42093a.clear();
        }
    }

    public void createRender(Context context, Bundle bundle) {
        if (m29694a(1)) {
            this.f42095c = onCreateView(context, bundle);
            this.f42096d = bundle.getInt("Loading::Gravity", 80);
            for (ILoadingRender.Callback onCreate : this.f42093a) {
                onCreate.onCreate(bundle);
            }
        }
    }

    public Rect getBorder() {
        return new Rect(0, 0, this.f42095c.getMeasuredWidth(), this.f42095c.getMeasuredHeight());
    }

    public View getView() {
        return this.f42095c;
    }

    public void onLayoutView(View view, ViewGroup viewGroup, ViewGroup viewGroup2) {
        int measuredWidth = view.getMeasuredWidth();
        ViewGroup.LayoutParams a = m29692a(view, viewGroup, new ViewGroup.LayoutParams(measuredWidth, -2));
        View view2 = this.f42095c;
        if (!(view2 == null || view2.getParent() == null)) {
            ((ViewGroup) this.f42095c.getParent()).removeView(this.f42095c);
        }
        if (viewGroup2 != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            viewGroup2.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            this.f42095c.setX((float) (i - i3));
            if (this.f42096d == 48) {
                this.f42095c.setY((float) (i2 - i4));
            } else {
                this.f42095c.setY(((float) (i2 - i4)) + ((float) view.getMeasuredHeight()));
            }
            viewGroup2.addView(this.f42095c, new ViewGroup.LayoutParams(measuredWidth, -2));
        } else if (viewGroup == null) {
        } else {
            if (viewGroup.getLayoutParams() != null && viewGroup == view && this.f42096d == 80 && viewGroup.getLayoutParams().height == -2) {
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, viewGroup.getMeasuredHeight()));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, -2);
                layoutParams.gravity = 80;
                frameLayout.addView(this.f42095c, layoutParams);
                viewGroup.addView(frameLayout);
                return;
            }
            viewGroup.addView(this.f42095c, a);
        }
    }

    /* renamed from: a */
    private boolean m29694a(int i) {
        int i2 = this.mRenderStatus;
        if (i2 == 0 ? i == 0 || i == 1 : i2 == 1 ? i == 0 || i == 2 : i2 == 2 ? i == 3 : i2 == 3 && i == 0) {
            this.mRenderStatus = i;
            return true;
        }
        LogUtil.m29100d("BaseLoadingRender", "[ERROR] status " + this.mRenderStatus + "can't move to " + i);
        return false;
    }

    /* renamed from: a */
    private ViewGroup.LayoutParams m29692a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        int measuredWidth = view.getMeasuredWidth();
        if (viewGroup instanceof FrameLayout) {
            layoutParams = new FrameLayout.LayoutParams(measuredWidth, -2);
            if (view == viewGroup) {
                if (this.f42096d == 48) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 48;
                } else {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
                }
            } else if (this.f42096d == 48) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = view.getMeasuredHeight();
            }
        } else if (viewGroup instanceof ConstraintLayout) {
            layoutParams = new ConstraintLayout.LayoutParams(measuredWidth, -2);
            if (view == viewGroup) {
                if (this.f42096d == 48) {
                    ((ConstraintLayout.LayoutParams) layoutParams).topToTop = view.getId();
                } else {
                    ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = view.getId();
                }
            } else if (this.f42096d == 48) {
                ((ConstraintLayout.LayoutParams) layoutParams).topToTop = view.getId();
            } else {
                ((ConstraintLayout.LayoutParams) layoutParams).topToBottom = view.getId();
            }
        } else if (viewGroup instanceof RelativeLayout) {
            layoutParams = new RelativeLayout.LayoutParams(measuredWidth, -2);
            if (view == viewGroup) {
                if (this.f42096d == 48) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(10);
                } else {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
                }
            } else if (this.f42096d == 48) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(6, view.getId());
            } else {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(3, view.getId());
            }
        }
        return layoutParams;
    }

    /* renamed from: a */
    private ViewGroup m29693a(View view) {
        if (this.f42094b > maxParentSearchLevel()) {
            return null;
        }
        this.f42094b++;
        ViewParent parent = view.getParent();
        if (m29695b(view)) {
            return (ViewGroup) view;
        }
        if (parent instanceof ViewGroup) {
            return m29693a((View) (ViewGroup) parent);
        }
        return null;
    }

    /* renamed from: b */
    private boolean m29695b(View view) {
        return (view instanceof FrameLayout) || (view instanceof ConstraintLayout) || (view instanceof RelativeLayout);
    }
}
