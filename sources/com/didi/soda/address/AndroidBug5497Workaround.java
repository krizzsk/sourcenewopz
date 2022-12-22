package com.didi.soda.address;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.taxis99.R;

public final class AndroidBug5497Workaround {

    /* renamed from: a */
    private static AndroidBug5497Workaround f38633a;
    public static boolean sInterceptGlobalDialog;

    /* renamed from: b */
    private View f38634b;

    /* renamed from: c */
    private View f38635c;

    /* renamed from: d */
    private Activity f38636d;

    /* renamed from: e */
    private ViewTreeObserver.OnGlobalLayoutListener f38637e;

    /* renamed from: f */
    private int f38638f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OnSoftInputVisibilityListener f38639g;

    public interface OnSoftInputVisibilityListener {
        void onVisibility(boolean z);
    }

    private AndroidBug5497Workaround(Activity activity) {
        this.f38636d = activity;
        View findViewById = activity.findViewById(R.id.customer_conductor_root_layout);
        this.f38635c = findViewById;
        this.f38638f = findViewById.getHeight();
    }

    public static AndroidBug5497Workaround getInstance(Activity activity) {
        if (f38633a == null) {
            f38633a = new AndroidBug5497Workaround(activity);
        }
        return f38633a;
    }

    public void assistComponent(ScopeContext scopeContext, final View view) {
        LogUtil.m29104i("Dialog usable", "assistComponent");
        final ViewTreeObserver viewTreeObserver = this.f38636d.getWindow().getDecorView().getViewTreeObserver();
        final C133631 r1 = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m27358a(view, this.mUsableHeightPrevious, false);
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
        LogUtil.m29104i("Dialog usable", "assistGlobalDialog");
        this.f38634b = view;
        this.f38637e = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                if (!AndroidBug5497Workaround.sInterceptGlobalDialog) {
                    this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m27358a(view, this.mUsableHeightPrevious, true);
                }
            }
        };
        this.f38634b.getViewTreeObserver().addOnGlobalLayoutListener(this.f38637e);
    }

    public void assistLocalDialog(ScopeContext scopeContext, final View view) {
        final C133664 r0 = new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mUsableHeightPrevious;

            public void onGlobalLayout() {
                this.mUsableHeightPrevious = AndroidBug5497Workaround.this.m27358a(view, this.mUsableHeightPrevious, true);
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
        View view = this.f38634b;
        if (!(view == null || this.f38637e == null)) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f38637e);
        }
        f38633a = null;
    }

    public void setOnSoftInputVisibilityListener(ScopeContext scopeContext, OnSoftInputVisibilityListener onSoftInputVisibilityListener) {
        this.f38639g = onSoftInputVisibilityListener;
        scopeContext.getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                OnSoftInputVisibilityListener unused = AndroidBug5497Workaround.this.f38639g = null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m27358a(View view, int i, boolean z) {
        int a = m27357a(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LogUtil.m29104i("Dialog usable", a + "/" + i + " " + this.f38638f);
        int i2 = this.f38638f;
        if (i2 == 0 || a == i) {
            return i;
        }
        int i3 = i2 - a;
        if (i3 > i2 / 4) {
            if (z) {
                layoutParams.height = i2 - i3;
            }
            OnSoftInputVisibilityListener onSoftInputVisibilityListener = this.f38639g;
            if (onSoftInputVisibilityListener != null) {
                onSoftInputVisibilityListener.onVisibility(true);
            }
        } else {
            if (z) {
                layoutParams.height = i2;
            }
            OnSoftInputVisibilityListener onSoftInputVisibilityListener2 = this.f38639g;
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
    private int m27357a(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int top = this.f38636d.getWindow().getDecorView().getTop();
        View view2 = this.f38635c;
        if (view2 != null) {
            this.f38638f = view2.getHeight();
        }
        return rect.bottom - top;
    }
}
