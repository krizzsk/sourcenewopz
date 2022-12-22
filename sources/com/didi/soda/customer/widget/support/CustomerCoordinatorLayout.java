package com.didi.soda.customer.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.taxis99.R;

public class CustomerCoordinatorLayout extends CoordinatorLayout {
    public CustomerCoordinatorLayout(Context context) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme));
    }

    public CustomerCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet);
    }

    public CustomerCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet, i);
    }
}
