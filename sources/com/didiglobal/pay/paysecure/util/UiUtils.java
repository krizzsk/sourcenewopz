package com.didiglobal.pay.paysecure.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/util/UiUtils;", "", "()V", "hideKeyboard", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "showKeyboard", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UiUtils.kt */
public final class UiUtils {
    public static final UiUtils INSTANCE = new UiUtils();

    private UiUtils() {
    }

    public final void hideKeyboard(Context context, View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        if (context != null) {
            Object systemService = context.getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public final void showKeyboard(Context context, View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        if (context != null) {
            Object systemService = context.getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).toggleSoftInput(2, 1);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }
}
