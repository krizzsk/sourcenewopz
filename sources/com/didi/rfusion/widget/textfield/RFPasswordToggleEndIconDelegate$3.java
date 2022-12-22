package com.didi.rfusion.widget.textfield;

import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import com.didi.rfusion.widget.textfield.RFTextInputLayout;

class RFPasswordToggleEndIconDelegate$3 implements RFTextInputLayout.OnEndIconChangedListener {
    final /* synthetic */ C11581e this$0;

    RFPasswordToggleEndIconDelegate$3(C11581e eVar) {
        this.this$0 = eVar;
    }

    public void onEndIconChanged(RFTextInputLayout rFTextInputLayout, int i) {
        EditText editText = rFTextInputLayout.getEditText();
        if (editText != null && i == 1) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new Runnable(editText) {
                public final /* synthetic */ EditText f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    RFPasswordToggleEndIconDelegate$3.this.lambda$onEndIconChanged$0$RFPasswordToggleEndIconDelegate$3(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onEndIconChanged$0$RFPasswordToggleEndIconDelegate$3(EditText editText) {
        editText.removeTextChangedListener(this.this$0.f33927d);
    }
}
