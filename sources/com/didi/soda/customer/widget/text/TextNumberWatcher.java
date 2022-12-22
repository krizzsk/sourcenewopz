package com.didi.soda.customer.widget.text;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class TextNumberWatcher implements TextWatcher {

    /* renamed from: a */
    private static final String f42236a = "TextNumberWatcher";

    /* renamed from: b */
    private OnChangedListener f42237b;

    /* renamed from: c */
    private EditText f42238c;

    /* renamed from: d */
    private int f42239d;

    /* renamed from: e */
    private boolean f42240e = true;

    /* renamed from: f */
    private String f42241f;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    private TextNumberWatcher(EditText editText, int i, OnChangedListener onChangedListener) {
        this.f42238c = editText;
        editText.addTextChangedListener(this);
        this.f42239d = i;
        this.f42237b = onChangedListener;
    }

    public static TextWatcher watch(EditText editText, int i, OnChangedListener onChangedListener) {
        return new TextNumberWatcher(editText, i, onChangedListener);
    }

    public void afterTextChanged(Editable editable) {
        if (!this.f42240e) {
            this.f42240e = true;
            return;
        }
        String obj = editable.toString();
        this.f42241f = obj;
        int length = obj.length();
        int i = this.f42239d;
        if (length > i) {
            this.f42240e = false;
            String substring = this.f42241f.substring(0, i);
            this.f42241f = substring;
            this.f42238c.setText(substring);
            if (this.f42241f.length() >= 1) {
                this.f42238c.setSelection(this.f42241f.length());
            }
        }
        OnChangedListener onChangedListener = this.f42237b;
        if (onChangedListener != null) {
            onChangedListener.onChanged(this.f42241f);
        }
    }
}
