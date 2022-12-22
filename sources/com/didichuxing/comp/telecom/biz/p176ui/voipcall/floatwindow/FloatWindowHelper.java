package com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.didichuxing.comp.telecom.biz.p176ui.voipcall.floatwindow.task.FloatContainerView;
import com.google.android.material.badge.BadgeDrawable;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0012J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/FloatWindowHelper;", "", "()V", "windowManager", "Landroid/view/WindowManager;", "addView", "", "context", "Landroid/content/Context;", "view", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/task/FloatContainerView;", "params", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/CallFloatWindowLayoutParams;", "configWindowView", "Landroid/view/WindowManager$LayoutParams;", "getStatusBarHeight", "", "hideFloatView", "Landroid/view/View;", "toHide", "", "removeFloatView", "showFloatView", "updateView", "Companion", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.FloatWindowHelper */
/* compiled from: FloatWindowHelper.kt */
public final class FloatWindowHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final FloatWindowHelper f46324b = new FloatWindowHelper();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WindowManager f46325a;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/FloatWindowHelper$Companion;", "", "()V", "instance", "Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/FloatWindowHelper;", "getInstance", "()Lcom/didichuxing/comp/telecom/biz/ui/voipcall/floatwindow/FloatWindowHelper;", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* renamed from: com.didichuxing.comp.telecom.biz.ui.voipcall.floatwindow.FloatWindowHelper$Companion */
    /* compiled from: FloatWindowHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FloatWindowHelper getInstance() {
            return FloatWindowHelper.f46324b;
        }
    }

    public final void showFloatView(Context context, FloatContainerView floatContainerView, CallFloatWindowLayoutParams callFloatWindowLayoutParams) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(floatContainerView, "view");
        Intrinsics.checkParameterIsNotNull(callFloatWindowLayoutParams, "params");
        try {
            floatContainerView.setVisibility(0);
            if (floatContainerView.getWindowToken() == null) {
                m33257b(context, floatContainerView, callFloatWindowLayoutParams);
            } else {
                m33256a(context, floatContainerView, callFloatWindowLayoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void removeFloatView(Context context, View view) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(view, "view");
        try {
            if (this.f46325a == null) {
                this.f46325a = (WindowManager) context.getSystemService("window");
            }
            WindowManager windowManager = this.f46325a;
            if (windowManager != null) {
                windowManager.removeView(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hideFloatView(Context context, View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(view, "view");
        if (z) {
            try {
                view.setVisibility(8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            view.setVisibility(0);
        }
    }

    /* renamed from: a */
    private final void m33256a(Context context, FloatContainerView floatContainerView, CallFloatWindowLayoutParams callFloatWindowLayoutParams) {
        WindowManager.LayoutParams a = m33255a(callFloatWindowLayoutParams, context, floatContainerView);
        WindowManager windowManager = this.f46325a;
        if (windowManager != null) {
            windowManager.updateViewLayout(floatContainerView, a);
        }
    }

    /* renamed from: b */
    private final void m33257b(Context context, FloatContainerView floatContainerView, CallFloatWindowLayoutParams callFloatWindowLayoutParams) {
        WindowManager.LayoutParams a = m33255a(callFloatWindowLayoutParams, context, floatContainerView);
        WindowManager windowManager = this.f46325a;
        if (windowManager != null) {
            windowManager.addView(floatContainerView, a);
        }
    }

    /* renamed from: a */
    private final WindowManager.LayoutParams m33255a(CallFloatWindowLayoutParams callFloatWindowLayoutParams, Context context, FloatContainerView floatContainerView) {
        int i;
        if (this.f46325a == null) {
            this.f46325a = (WindowManager) context.getSystemService("window");
        }
        WindowManager.LayoutParams lp = callFloatWindowLayoutParams.getLp();
        if (lp == null) {
            lp = new WindowManager.LayoutParams();
            lp.width = -2;
            lp.height = -2;
        }
        lp.format = -2;
        lp.gravity = BadgeDrawable.TOP_START;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources != null ? resources.getDisplayMetrics() : null;
        Ref.IntRef intRef = new Ref.IntRef();
        int i2 = 0;
        intRef.element = displayMetrics != null ? displayMetrics.widthPixels : 0;
        int i3 = displayMetrics != null ? displayMetrics.heightPixels : 0;
        if (callFloatWindowLayoutParams.hasLocationCache()) {
            Integer cacheX = callFloatWindowLayoutParams.getCacheX();
            lp.x = cacheX != null ? cacheX.intValue() : 0;
            Integer cacheY = callFloatWindowLayoutParams.getCacheY();
            if (cacheY != null) {
                i2 = cacheY.intValue();
            }
            lp.y = i2;
        } else if (callFloatWindowLayoutParams.getAlignEnd()) {
            floatContainerView.measure(View.MeasureSpec.makeMeasureSpec(intRef.element, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE));
            lp.x = intRef.element - floatContainerView.getMeasuredWidth();
            lp.y = 0;
        }
        lp.flags = 8;
        if (Build.VERSION.SDK_INT >= 26) {
            i = 2038;
        } else {
            i = Build.VERSION.SDK_INT >= 25 ? 2002 : 2005;
        }
        lp.type = i;
        floatContainerView.setTag(R.id.voip_call_float_window_lp, lp);
        floatContainerView.setCustomTouchListener(new FloatWindowHelper$configWindowView$1(this, lp, intRef, callFloatWindowLayoutParams));
        return lp;
    }

    /* renamed from: a */
    private final int m33254a(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
