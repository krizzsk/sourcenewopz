package com.didi.dimina.container.debug.uncaught.error;

import android.app.Activity;
import android.util.AttributeSet;
import android.view.Window;
import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/dimina/container/debug/uncaught/error/UncaughtErrorPageManager;", "", "()V", "TAG", "", "mActivity", "Landroid/app/Activity;", "mPopupWindow", "Landroid/widget/PopupWindow;", "mView", "Lcom/didi/dimina/container/debug/uncaught/error/UncaughtErrorView;", "dismiss", "", "init", "acty", "show", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UncaughtErrorPageManager.kt */
public final class UncaughtErrorPageManager {
    public static final UncaughtErrorPageManager INSTANCE = new UncaughtErrorPageManager();
    public static final String TAG = "UncaughtErrorPageManager";

    /* renamed from: a */
    private static UncaughtErrorView f16799a;

    /* renamed from: b */
    private static PopupWindow f16800b;

    /* renamed from: c */
    private static Activity f16801c;

    private UncaughtErrorPageManager() {
    }

    public final void init(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "acty");
        f16801c = activity;
        Activity activity2 = f16801c;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        }
        f16799a = new UncaughtErrorView(activity2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public final void show() {
        PopupWindow popupWindow = f16800b;
        if ((popupWindow == null || !popupWindow.isShowing()) && !UncaughtErrorManager.INSTANCE.getShowingQueue().isEmpty()) {
            UncaughtErrorBean remove = UncaughtErrorManager.INSTANCE.getShowingQueue().remove();
            UncaughtErrorView uncaughtErrorView = f16799a;
            if (uncaughtErrorView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            Intrinsics.checkExpressionValueIsNotNull(remove, "data");
            uncaughtErrorView.refreshUi(remove);
            UncaughtErrorView uncaughtErrorView2 = f16799a;
            if (uncaughtErrorView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mView");
            }
            PopupWindow popupWindow2 = new PopupWindow(uncaughtErrorView2, -1, -1);
            f16800b = popupWindow2;
            if (popupWindow2 != null) {
                popupWindow2.setOutsideTouchable(false);
                Activity activity = f16801c;
                if (activity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                }
                Window window = activity.getWindow();
                Intrinsics.checkExpressionValueIsNotNull(window, "mActivity.window");
                popupWindow2.showAtLocation(window.getDecorView(), 48, 0, 0);
            }
        }
    }

    public final void dismiss() {
        PopupWindow popupWindow = f16800b;
        if (popupWindow != null) {
            popupWindow.dismiss();
            f16800b = null;
        }
        show();
    }
}
