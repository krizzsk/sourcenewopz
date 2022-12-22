package com.didi.entrega.customer.foundation.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.taxis99.R;

public final class AndroidBug5497Workaround {

    /* renamed from: a */
    private static AndroidBug5497Workaround f20062a;
    public static boolean sInterceptGlobalDialog;

    /* renamed from: b */
    private View f20063b;

    /* renamed from: c */
    private View f20064c;

    /* renamed from: d */
    private Activity f20065d;

    /* renamed from: e */
    private ViewTreeObserver.OnGlobalLayoutListener f20066e;

    /* renamed from: f */
    private int f20067f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OnSoftInputVisibilityListener f20068g;

    public interface OnSoftInputVisibilityListener {
        void onVisibility(boolean z);
    }

    private AndroidBug5497Workaround(Activity activity) {
        this.f20065d = activity;
        View findViewById = activity.findViewById(R.id.entrega_conductor_root_layout);
        this.f20064c = findViewById;
        this.f20067f = findViewById.getHeight();
    }

    public static AndroidBug5497Workaround getInstance(Activity activity) {
        if (f20062a == null) {
            f20062a = new AndroidBug5497Workaround(activity);
        }
        return f20062a;
    }

    public void assistComponent(ScopeContext scopeContext, final View view) {
        LogUtil.m14765i("Dialog usable", "assistComponent");
        final ViewTreeObserver viewTreeObserver = this.f20065d.getWindow().getDecorView().getViewTreeObserver();
        final C80941 r1 = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m14811a(view, this.mUsableHeightPrevious, false);
            }
        };
        scopeContext.getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                viewTreeObserver.removeOnGlobalLayoutListener(r1);
            }
        });
        viewTreeObserver.addOnGlobalLayoutListener(r1);
    }

    public void assistGlobalDialog(final View view) {
        LogUtil.m14765i("Dialog usable", "assistGlobalDialog");
        this.f20063b = view;
        this.f20066e = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                if (!AndroidBug5497Workaround.sInterceptGlobalDialog) {
                    this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m14811a(view, this.mUsableHeightPrevious, true);
                }
            }
        };
        this.f20063b.getViewTreeObserver().addOnGlobalLayoutListener(this.f20066e);
    }

    public void assistLocalDialog(ScopeContext scopeContext, final View view) {
        final C80974 r0 = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m14811a(view, this.mUsableHeightPrevious, true);
            }
        };
        scopeContext.getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(r0);
            }
        });
        view.getViewTreeObserver().addOnGlobalLayoutListener(r0);
    }

    public void destroyGlobal() {
        View view = this.f20063b;
        if (!(view == null || this.f20066e == null)) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f20066e);
        }
        f20062a = null;
    }

    public void setOnSoftInputVisibilityListener(ScopeContext scopeContext, OnSoftInputVisibilityListener onSoftInputVisibilityListener) {
        this.f20068g = onSoftInputVisibilityListener;
        scopeContext.getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                OnSoftInputVisibilityListener unused = AndroidBug5497Workaround.this.f20068g = null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m14811a(View view, int i, boolean z) {
        int a = m14810a(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LogUtil.m14765i("Dialog usable", a + "/" + i + " " + this.f20067f);
        int i2 = this.f20067f;
        if (i2 == 0 || a == i) {
            return i;
        }
        int i3 = i2 - a;
        if (i3 > i2 / 4) {
            if (z) {
                layoutParams.height = i2 - i3;
            }
            OnSoftInputVisibilityListener onSoftInputVisibilityListener = this.f20068g;
            if (onSoftInputVisibilityListener != null) {
                onSoftInputVisibilityListener.onVisibility(true);
            }
        } else {
            if (z) {
                layoutParams.height = i2;
            }
            OnSoftInputVisibilityListener onSoftInputVisibilityListener2 = this.f20068g;
            if (onSoftInputVisibilityListener2 != null) {
                onSoftInputVisibilityListener2.onVisibility(false);
            }
            i3 = 0;
        }
        if (z) {
            view.requestLayout();
        } else {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i3);
        }
        return a;
    }

    /* renamed from: a */
    private int m14810a(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int top = this.f20065d.getWindow().getDecorView().getTop();
        View view2 = this.f20064c;
        if (view2 != null) {
            this.f20067f = view2.getHeight();
        }
        return rect.bottom - top;
    }
}
