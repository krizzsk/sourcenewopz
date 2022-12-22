package com.didi.payment.transfer.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.didi.payment.base.widget.CommonEditText;

public class BankCardInputWatcher implements TextWatcher {

    /* renamed from: a */
    int f31497a = 0;

    /* renamed from: b */
    int f31498b = 0;

    /* renamed from: c */
    boolean f31499c;

    /* renamed from: d */
    int f31500d = 0;

    /* renamed from: e */
    int f31501e = 0;

    /* renamed from: f */
    private CommonEditText f31502f;

    /* renamed from: g */
    private StringBuffer f31503g = new StringBuffer();

    public BankCardInputWatcher(CommonEditText commonEditText) {
        this.f31502f = commonEditText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f31497a = charSequence.length();
        if (this.f31503g.length() > 0) {
            StringBuffer stringBuffer = this.f31503g;
            stringBuffer.delete(0, stringBuffer.length());
        }
        this.f31501e = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (charSequence.charAt(i4) == ' ') {
                this.f31501e++;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f31498b = charSequence.length();
        this.f31503g.append(charSequence.toString());
        if (this.f31498b == this.f31497a || this.f31499c) {
            this.f31499c = false;
        } else {
            this.f31499c = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f31499c) {
            int i = 0;
            while (i < this.f31503g.length()) {
                if (this.f31503g.charAt(i) == ' ') {
                    this.f31503g.deleteCharAt(i);
                } else {
                    i++;
                }
            }
            int length = this.f31503g.length() / 4;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f31503g.length(); i3++) {
                if (length > 0) {
                    for (int i4 = 1; i4 <= length; i4++) {
                        if (i3 == (i4 * 4) + (i4 - 1)) {
                            this.f31503g.insert(i3, ' ');
                            i2++;
                        }
                    }
                }
            }
            String stringBuffer = this.f31503g.toString();
            int selectionEnd = this.f31502f.getSelectionEnd();
            this.f31500d = selectionEnd;
            int i5 = this.f31501e;
            if (i2 > i5) {
                this.f31500d = selectionEnd + (i2 - i5);
            }
            int min = Math.min(this.f31500d, stringBuffer.length());
            this.f31500d = min;
            int max = Math.max(min, 0);
            this.f31500d = max;
            this.f31500d = Math.min(max, 17);
            this.f31502f.setText(stringBuffer);
            Selection.setSelection(this.f31502f.getText(), this.f31500d);
            this.f31499c = false;
        }
    }
}
