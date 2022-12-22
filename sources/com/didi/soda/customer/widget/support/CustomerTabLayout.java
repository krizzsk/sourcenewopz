package com.didi.soda.customer.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import com.google.android.material.tabs.TabLayout;
import com.taxis99.R;

public class CustomerTabLayout extends TabLayout {
    public CustomerTabLayout(Context context) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme));
    }

    public CustomerTabLayout(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet);
    }

    public CustomerTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet, i);
    }
}
