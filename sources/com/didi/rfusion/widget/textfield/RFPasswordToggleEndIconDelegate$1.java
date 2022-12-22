package com.didi.rfusion.widget.textfield;

import android.text.Editable;
import android.text.TextWatcher;

class RFPasswordToggleEndIconDelegate$1 implements TextWatcher {
    final /* synthetic */ C11581e this$0;

    public void afterTextChanged(Editable editable) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    RFPasswordToggleEndIconDelegate$1(C11581e eVar) {
        this.this$0 = eVar;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.this$0.f33926c.setChecked(!this.this$0.m23942b());
    }
}
