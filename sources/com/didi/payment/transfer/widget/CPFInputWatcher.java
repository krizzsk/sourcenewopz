package com.didi.payment.transfer.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.didi.payment.base.widget.CommonEditText;

public class CPFInputWatcher implements TextWatcher {

    /* renamed from: a */
    int f31504a = 0;

    /* renamed from: b */
    int f31505b = 0;

    /* renamed from: c */
    boolean f31506c;

    /* renamed from: d */
    int f31507d = 0;

    /* renamed from: e */
    int f31508e = 0;

    /* renamed from: f */
    private CommonEditText f31509f;

    /* renamed from: g */
    private StringBuffer f31510g = new StringBuffer();

    public CPFInputWatcher(CommonEditText commonEditText) {
        this.f31509f = commonEditText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f31504a = charSequence.length();
        if (this.f31510g.length() > 0) {
            StringBuffer stringBuffer = this.f31510g;
            stringBuffer.delete(0, stringBuffer.length());
        }
        this.f31508e = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (charSequence.charAt(i4) == '.' || charSequence.charAt(i4) == '-') {
                this.f31508e++;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f31505b = charSequence.length();
        this.f31510g.append(charSequence.toString());
        if (this.f31505b == this.f31504a || this.f31506c) {
            this.f31506c = false;
        } else {
            this.f31506c = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f31506c) {
            int i = 0;
            while (i < this.f31510g.length()) {
                if (this.f31510g.charAt(i) == '.' || this.f31510g.charAt(i) == '-') {
                    this.f31510g.deleteCharAt(i);
                } else {
                    i++;
                }
            }
            int length = this.f31510g.length() / 3;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f31510g.length(); i3++) {
                if (length > 0) {
                    for (int i4 = 1; i4 <= length; i4++) {
                        if (i3 == (i4 * 3) + (i4 - 1)) {
                            if (i2 < 2) {
                                this.f31510g.insert(i3, '.');
                            } else {
                                this.f31510g.insert(i3, '-');
                            }
                            i2++;
                        }
                    }
                }
            }
            String stringBuffer = this.f31510g.toString();
            int selectionEnd = this.f31509f.getSelectionEnd();
            this.f31507d = selectionEnd;
            int i5 = this.f31508e;
            if (i2 > i5) {
                this.f31507d = selectionEnd + (i2 - i5);
            }
            int min = Math.min(this.f31507d, stringBuffer.length());
            this.f31507d = min;
            int max = Math.max(min, 0);
            this.f31507d = max;
            this.f31507d = Math.min(max, 14);
            this.f31509f.setText(stringBuffer);
            Selection.setSelection(this.f31509f.getText(), this.f31507d);
            this.f31506c = false;
        }
    }
}
