package com.didi.rfusion.utils.ext;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000¨\u0006\u0003"}, mo175978d2 = {"getRootView", "Landroid/view/ViewGroup;", "Landroid/app/Activity;", "r-fusion_ninePhoneRelease"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: RFActivityExt.kt */
public final class RFActivityExtKt {
    public static final ViewGroup getRootView(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        Window window = activity.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "window");
        View decorView = window.getDecorView();
        if (decorView != null) {
            return (ViewGroup) decorView;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
