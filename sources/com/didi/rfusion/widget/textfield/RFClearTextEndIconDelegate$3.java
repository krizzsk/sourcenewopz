package com.didi.rfusion.widget.textfield;

import android.widget.EditText;
import com.didi.rfusion.widget.textfield.RFTextInputLayout;

class RFClearTextEndIconDelegate$3 implements RFTextInputLayout.OnEditTextAttachedListener {
    final /* synthetic */ C11577a this$0;

    RFClearTextEndIconDelegate$3(C11577a aVar) {
        this.this$0 = aVar;
    }

    public void onEditTextAttached(RFTextInputLayout rFTextInputLayout) {
        EditText editText = rFTextInputLayout.getEditText();
        rFTextInputLayout.setClearIconVisible(editText.hasFocus() && C11577a.m23878b(editText.getText()));
        rFTextInputLayout.setClearIconCheckable(false);
        editText.setOnFocusChangeListener(this.this$0.f33881g);
        editText.removeTextChangedListener(this.this$0.f33880f);
        editText.addTextChangedListener(this.this$0.f33880f);
    }
}
