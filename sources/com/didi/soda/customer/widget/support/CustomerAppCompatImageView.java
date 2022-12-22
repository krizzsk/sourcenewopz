package com.didi.soda.customer.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatImageView;
import com.taxis99.R;

public class CustomerAppCompatImageView extends AppCompatImageView {
    public CustomerAppCompatImageView(Context context) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme));
    }

    public CustomerAppCompatImageView(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet);
    }

    public CustomerAppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet, i);
    }
}
