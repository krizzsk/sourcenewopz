package com.didi.safetoolkit.util;

import android.content.Context;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/safetoolkit/util/SfInputMethodUtil;", "", "()V", "showInputMethod", "", "context", "Landroid/content/Context;", "editText", "Landroid/widget/EditText;", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: SfInputMethodUtil.kt */
public final class SfInputMethodUtil {
    public static final SfInputMethodUtil INSTANCE = new SfInputMethodUtil();

    private SfInputMethodUtil() {
    }

    public final void showInputMethod(Context context, EditText editText) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(editText, "editText");
        try {
            Object systemService = context.getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager != null) {
                    new Handler().postDelayed(new SfInputMethodUtil$showInputMethod$1(inputMethodManager, editText), (long) 100);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        } catch (Exception unused) {
        }
    }
}
