package com.didi.unifylogin.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.unifylogin.utils.phone.PhoneUtils;

public class CPFWatcher implements TextWatcher {

    /* renamed from: a */
    private static final int f44906a = 14;

    /* renamed from: b */
    private static final char f44907b = '.';

    /* renamed from: c */
    private static final char f44908c = '-';

    /* renamed from: d */
    private static final int f44909d = 3;

    /* renamed from: e */
    private static final int f44910e = 7;

    /* renamed from: f */
    private static final int f44911f = 11;

    /* renamed from: g */
    private EditText f44912g;

    /* renamed from: h */
    private Button f44913h;

    /* renamed from: i */
    private TextView f44914i;

    /* renamed from: j */
    private String f44915j;

    /* renamed from: k */
    private boolean f44916k;

    public CPFWatcher(EditText editText, Button button, TextView textView) {
        this.f44912g = editText;
        this.f44913h = button;
        this.f44914i = textView;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f44915j = charSequence.toString();
        if (this.f44914i.getVisibility() != 0) {
            this.f44914i.setVisibility(0);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int length = this.f44912g.getText().length();
        if (length > 14) {
            this.f44912g.getText().delete(14, length);
        } else if (length < this.f44915j.length()) {
            String str = this.f44915j;
            char charAt = str.charAt(str.length() - 1);
            if (charAt == '.' || charAt == '-') {
                this.f44912g.getText().delete(length - 1, length);
            }
        }
        if (this.f44916k) {
            this.f44916k = false;
        } else {
            this.f44916k = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f44916k) {
            boolean z = editable.length() >= this.f44915j.length();
            if (PhoneUtils.isNum(CommonUtils.deleteNonNum(editable.toString()))) {
                this.f44913h.setEnabled(true);
            } else {
                this.f44913h.setEnabled(false);
            }
            String a = m32207a(editable.toString());
            int selectionEnd = this.f44912g.getSelectionEnd();
            if (z) {
                selectionEnd = (selectionEnd + a.length()) - this.f44912g.getText().length();
            }
            int min = Math.min(a.length(), Math.max(0, selectionEnd));
            this.f44912g.setText(a);
            this.f44912g.setSelection(min);
        }
    }

    /* renamed from: a */
    private String m32207a(String str) {
        if (str == null) {
            return "";
        }
        String deleteNonNum = CommonUtils.deleteNonNum(str);
        if (deleteNonNum.length() > 11) {
            deleteNonNum = deleteNonNum.substring(0, 11);
        }
        StringBuilder sb = new StringBuilder(deleteNonNum);
        m32208a(sb, 3, '.');
        m32208a(sb, 7, '.');
        m32208a(sb, 11, f44908c);
        return sb.toString();
    }

    /* renamed from: a */
    private void m32208a(StringBuilder sb, int i, char c) {
        if (sb.length() == i) {
            sb.insert(i, c);
        }
        if (sb.length() > i && sb.charAt(i) != c) {
            sb.insert(i, c);
        }
    }
}
