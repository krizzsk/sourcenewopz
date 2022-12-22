package com.didi.soda.customer.widget.support;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import com.didi.app.nova.support.view.edittext.EditTextCompat;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class CustomerEditTextCompat extends EditTextCompat {
    public CustomerEditTextCompat(Context context) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme));
        m29734a(context, (AttributeSet) null);
    }

    public CustomerEditTextCompat(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet);
        m29734a(context, attributeSet);
    }

    public CustomerEditTextCompat(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet, i);
        m29734a(context, attributeSet);
    }

    /* renamed from: a */
    private void m29734a(Context context, AttributeSet attributeSet) {
        int i = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CustomerAppCompatTextView);
            i = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }
        if (i == 0) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.NORMAL);
        } else if (i == 1) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.MEDIUM);
        } else if (i == 2) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.BOLD);
        } else if (i != 3) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.NORMAL);
        } else {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.LIGHT);
        }
    }
}
