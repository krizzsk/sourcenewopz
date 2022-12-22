package com.adyen.checkout.components.p058ui.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.google.android.material.textfield.TextInputEditText;
import com.taxis99.R;

/* renamed from: com.adyen.checkout.components.ui.view.AdyenTextInputEditText */
public class AdyenTextInputEditText extends TextInputEditText {
    protected static final int NO_MAX_LENGTH = -1;

    /* renamed from: a */
    private Listener f899a;

    /* renamed from: com.adyen.checkout.components.ui.view.AdyenTextInputEditText$Listener */
    public interface Listener {
        void onTextChanged(Editable editable);
    }

    public AdyenTextInputEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public AdyenTextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdyenTextInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i == 0 ? R.attr.editTextStyle : i);
        addTextChangedListener(getTextWatcher());
    }

    public void setOnChangeListener(Listener listener) {
        this.f899a = listener;
    }

    public String getRawValue() {
        return getText() != null ? getText().toString() : "";
    }

    /* access modifiers changed from: protected */
    public void afterTextChanged(Editable editable) {
        Listener listener = this.f899a;
        if (listener != null) {
            listener.onTextChanged(editable);
        }
    }

    /* access modifiers changed from: protected */
    public void enforceMaxInputLength(int i) {
        if (i != -1) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        }
    }

    private TextWatcher getTextWatcher() {
        return new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                AdyenTextInputEditText.this.afterTextChanged(editable);
            }
        };
    }
}
