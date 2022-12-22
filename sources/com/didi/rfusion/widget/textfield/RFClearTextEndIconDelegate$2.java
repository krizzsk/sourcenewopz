package com.didi.rfusion.widget.textfield;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

class RFClearTextEndIconDelegate$2 implements View.OnFocusChangeListener {
    final /* synthetic */ C11577a this$0;

    RFClearTextEndIconDelegate$2(C11577a aVar) {
        this.this$0 = aVar;
    }

    public void onFocusChange(View view, boolean z) {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
        C11577a aVar = this.this$0;
        if (!z3 || !z) {
            z2 = false;
        }
        aVar.m23875a(z2);
    }
}
