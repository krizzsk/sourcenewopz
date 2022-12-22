package com.didi.payment.creditcard.global.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class Mask {
    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m21523b(String str) {
        return str.replaceAll("[.]", "").replaceAll("[-]", "").replaceAll("[/]", "").replaceAll("[(]", "").replaceAll("[)]", "").replaceAll("[ ]", "");
    }

    public static TextWatcher insert(final String str, final EditText editText) {
        return new TextWatcher() {
            boolean isUpdating;
            String old = "";

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String a = Mask.m21523b(charSequence.toString());
                if (this.isUpdating) {
                    this.old = a;
                    this.isUpdating = false;
                    return;
                }
                String str = "";
                int i4 = 0;
                for (char c : str.toCharArray()) {
                    if (c == '#' || a.length() <= 2) {
                        try {
                            str = str + a.charAt(i4);
                            i4++;
                        } catch (Exception unused) {
                        }
                    } else {
                        str = str + c;
                    }
                }
                this.isUpdating = true;
                editText.setText(str);
                editText.setSelection(str.length());
            }
        };
    }
}
