package com.didi.payment.creditcard.global.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class CPFWatcher implements TextWatcher {

    /* renamed from: a */
    private static final int f30567a = 14;

    /* renamed from: b */
    private static final char f30568b = '.';

    /* renamed from: c */
    private static final char f30569c = '-';

    /* renamed from: d */
    private static final int f30570d = 3;

    /* renamed from: e */
    private static final int f30571e = 7;

    /* renamed from: f */
    private static final int f30572f = 11;

    /* renamed from: g */
    private EditText f30573g;

    /* renamed from: h */
    private String f30574h;

    /* renamed from: i */
    private boolean f30575i;

    public CPFWatcher(EditText editText) {
        this.f30573g = editText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f30574h = charSequence.toString();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int length = this.f30573g.getText().length();
        if (length > 14) {
            this.f30573g.getText().delete(14, length);
        } else if (length < this.f30574h.length()) {
            String str = this.f30574h;
            char charAt = str.charAt(str.length() - 1);
            if (charAt == '.' || charAt == '-') {
                this.f30573g.getText().delete(length - 1, length);
            }
        }
        if (this.f30575i) {
            this.f30575i = false;
        } else {
            this.f30575i = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f30575i) {
            boolean z = true;
            if (editable.length() < this.f30574h.length()) {
                z = false;
            }
            String a = m21508a(editable.toString());
            int selectionEnd = this.f30573g.getSelectionEnd();
            if (z) {
                selectionEnd = (selectionEnd + a.length()) - this.f30573g.getText().length();
            }
            int min = Math.min(a.length(), Math.max(0, selectionEnd));
            this.f30573g.setText(a);
            this.f30573g.setSelection(min);
        }
    }

    /* renamed from: a */
    private String m21508a(String str) {
        if (str == null) {
            return "";
        }
        String replace = str.replace(" ", "").replace(".", "").replace("-", "");
        if (replace.length() > 11) {
            replace = replace.substring(0, 11);
        }
        StringBuilder sb = new StringBuilder(replace);
        m21509a(sb, 3, '.');
        m21509a(sb, 7, '.');
        m21509a(sb, 11, f30569c);
        return sb.toString();
    }

    /* renamed from: a */
    private void m21509a(StringBuilder sb, int i, char c) {
        if (sb.length() == i) {
            sb.insert(i, c);
        }
        if (sb.length() > i && sb.charAt(i) != c) {
            sb.insert(i, c);
        }
    }
}
