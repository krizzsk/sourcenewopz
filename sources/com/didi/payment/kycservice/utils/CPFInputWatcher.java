package com.didi.payment.kycservice.utils;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;

public class CPFInputWatcher implements TextWatcher {

    /* renamed from: a */
    int f30921a = 0;

    /* renamed from: b */
    int f30922b = 0;

    /* renamed from: c */
    boolean f30923c;

    /* renamed from: d */
    int f30924d = 0;

    /* renamed from: e */
    int f30925e = 0;

    /* renamed from: f */
    private EditText f30926f;

    /* renamed from: g */
    private StringBuffer f30927g = new StringBuffer();

    public CPFInputWatcher(EditText editText) {
        this.f30926f = editText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f30921a = charSequence.length();
        if (this.f30927g.length() > 0) {
            StringBuffer stringBuffer = this.f30927g;
            stringBuffer.delete(0, stringBuffer.length());
        }
        this.f30925e = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (charSequence.charAt(i4) == '.' || charSequence.charAt(i4) == '-') {
                this.f30925e++;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f30922b = charSequence.length();
        this.f30927g.append(charSequence.toString());
        if (this.f30922b == this.f30921a || this.f30923c) {
            this.f30923c = false;
        } else {
            this.f30923c = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f30923c) {
            int i = 0;
            while (i < this.f30927g.length()) {
                if (this.f30927g.charAt(i) == '.' || this.f30927g.charAt(i) == '-') {
                    this.f30927g.deleteCharAt(i);
                } else {
                    i++;
                }
            }
            int length = this.f30927g.length() / 3;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f30927g.length(); i3++) {
                if (length > 0) {
                    for (int i4 = 1; i4 <= length; i4++) {
                        if (i3 == (i4 * 3) + (i4 - 1)) {
                            if (i2 < 2) {
                                this.f30927g.insert(i3, '.');
                            } else {
                                this.f30927g.insert(i3, '-');
                            }
                            i2++;
                        }
                    }
                }
            }
            String stringBuffer = this.f30927g.toString();
            int selectionEnd = this.f30926f.getSelectionEnd();
            this.f30924d = selectionEnd;
            int i5 = this.f30925e;
            if (i2 > i5) {
                this.f30924d = selectionEnd + (i2 - i5);
            }
            int min = Math.min(this.f30924d, stringBuffer.length());
            this.f30924d = min;
            int max = Math.max(min, 0);
            this.f30924d = max;
            this.f30924d = Math.min(max, 14);
            this.f30926f.setText(stringBuffer);
            Selection.setSelection(this.f30926f.getText(), this.f30924d);
            this.f30923c = false;
        }
    }
}
