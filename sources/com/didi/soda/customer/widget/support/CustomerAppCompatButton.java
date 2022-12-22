package com.didi.soda.customer.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatButton;
import com.taxis99.R;

public class CustomerAppCompatButton extends AppCompatButton {
    public CustomerAppCompatButton(Context context) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme));
    }

    public CustomerAppCompatButton(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet);
    }

    public CustomerAppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet, i);
    }
}
