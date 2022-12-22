package com.didi.entrega.customer.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import com.didi.app.nova.support.view.search.SearchViewCompat;
import com.taxis99.R;

public class CustomerSearchViewCompat extends SearchViewCompat {
    public CustomerSearchViewCompat(Context context) {
        super(new ContextThemeWrapper(context, R.style.EntregaCustomerAppTheme));
    }

    public CustomerSearchViewCompat(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.EntregaCustomerAppTheme), attributeSet);
    }

    public CustomerSearchViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.EntregaCustomerAppTheme), attributeSet, i);
    }
}
