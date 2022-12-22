package com.didi.entrega.customer.widget.text;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class TextNumberWatcher implements TextWatcher {

    /* renamed from: a */
    private static final String f20617a = "TextNumberWatcher";

    /* renamed from: b */
    private OnChangedListener f20618b;

    /* renamed from: c */
    private EditText f20619c;

    /* renamed from: d */
    private int f20620d;

    /* renamed from: e */
    private boolean f20621e = true;

    /* renamed from: f */
    private String f20622f;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    private TextNumberWatcher(EditText editText, int i, OnChangedListener onChangedListener) {
        this.f20619c = editText;
        editText.addTextChangedListener(this);
        this.f20620d = i;
        this.f20618b = onChangedListener;
    }

    public static TextWatcher watch(EditText editText, int i, OnChangedListener onChangedListener) {
        return new TextNumberWatcher(editText, i, onChangedListener);
    }

    public void afterTextChanged(Editable editable) {
        if (!this.f20621e) {
            this.f20621e = true;
            return;
        }
        String obj = editable.toString();
        this.f20622f = obj;
        int length = obj.length();
        int i = this.f20620d;
        if (length > i) {
            this.f20621e = false;
            String substring = this.f20622f.substring(0, i);
            this.f20622f = substring;
            this.f20619c.setText(substring);
            if (this.f20622f.length() >= 1) {
                this.f20619c.setSelection(this.f20622f.length());
            }
        }
        OnChangedListener onChangedListener = this.f20618b;
        if (onChangedListener != null) {
            onChangedListener.onChanged(this.f20622f);
        }
    }
}
