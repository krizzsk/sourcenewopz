package com.didi.entrega.customer.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.cardview.widget.CardView;
import com.taxis99.R;

public class CustomerCardView extends CardView {
    public CustomerCardView(Context context) {
        super(new ContextThemeWrapper(context, R.style.EntregaCustomerAppTheme));
    }

    public CustomerCardView(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.EntregaCustomerAppTheme), attributeSet);
    }

    public CustomerCardView(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.EntregaCustomerAppTheme), attributeSet, i);
    }
}
