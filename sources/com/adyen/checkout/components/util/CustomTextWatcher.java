package com.adyen.checkout.components.util;

import android.text.Editable;

public abstract class CustomTextWatcher extends SimpleTextWatcher {

    /* renamed from: a */
    private boolean f910a;

    public abstract void afterTextChangedByUser(Editable editable);

    /* renamed from: a */
    private boolean m1060a() {
        return this.f910a;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z = true;
        if (Math.abs(i3 - i2) != 1) {
            z = false;
        }
        this.f910a = z;
    }

    public void afterTextChanged(Editable editable) {
        if (m1060a()) {
            afterTextChangedByUser(editable);
        }
    }
}
