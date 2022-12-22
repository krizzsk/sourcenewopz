package com.didiglobal.pay.paysecure.prepaidcard;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: KeyboardUtil.kt */
final class KeyboardUtil$Companion$showKeyboard$1 implements Runnable {

    /* renamed from: $v */
    final /* synthetic */ View f50384$v;

    KeyboardUtil$Companion$showKeyboard$1(View view) {
        this.f50384$v = view;
    }

    public final void run() {
        this.f50384$v.requestFocus();
        Object systemService = this.f50384$v.getContext().getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).showSoftInput(this.f50384$v, 1);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
