package com.didi.entrega.customer.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatCheckBox;

public class CustomerCheckbox extends AppCompatCheckBox {

    /* renamed from: a */
    private static final int f20610a = 2132017965;

    public CustomerCheckbox(Context context) {
        super(new ContextThemeWrapper(context, f20610a));
    }

    public CustomerCheckbox(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, f20610a), attributeSet);
    }

    public CustomerCheckbox(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, f20610a), attributeSet, i);
    }
}
