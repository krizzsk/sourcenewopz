package com.didi.soda.customer.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatCheckBox;

public class CustomerCheckbox extends AppCompatCheckBox {

    /* renamed from: a */
    private static final int f42185a = 2132017965;

    public CustomerCheckbox(Context context) {
        super(new ContextThemeWrapper(context, f42185a));
    }

    public CustomerCheckbox(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, f42185a), attributeSet);
    }

    public CustomerCheckbox(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, f42185a), attributeSet, i);
    }
}
