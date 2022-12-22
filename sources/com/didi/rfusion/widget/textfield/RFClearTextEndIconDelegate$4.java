package com.didi.rfusion.widget.textfield;

import android.widget.EditText;

class RFClearTextEndIconDelegate$4 implements Runnable {
    final /* synthetic */ C11577a this$0;
    final /* synthetic */ EditText val$editText;

    RFClearTextEndIconDelegate$4(C11577a aVar, EditText editText) {
        this.this$0 = aVar;
        this.val$editText = editText;
    }

    public void run() {
        this.val$editText.removeTextChangedListener(this.this$0.f33880f);
    }
}
