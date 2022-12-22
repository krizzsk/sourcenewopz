package com.didi.soda.business.widget;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.soda.customer.widget.headerview.CustomerTabLayout;
import com.taxis99.R;

public class BusinessDyClassifyBLayout_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessDyClassifyBLayout f39775a;

    public BusinessDyClassifyBLayout_ViewBinding(BusinessDyClassifyBLayout businessDyClassifyBLayout) {
        this(businessDyClassifyBLayout, businessDyClassifyBLayout);
    }

    public BusinessDyClassifyBLayout_ViewBinding(BusinessDyClassifyBLayout businessDyClassifyBLayout, View view) {
        this.f39775a = businessDyClassifyBLayout;
        businessDyClassifyBLayout.mClassifyTab = (CustomerTabLayout) Utils.findRequiredViewAsType(view, R.id.customer_ctl_business_classify_tab, "field 'mClassifyTab'", CustomerTabLayout.class);
        businessDyClassifyBLayout.mMenuContainer = Utils.findRequiredView(view, R.id.customer_fl_business_classify_menu, "field 'mMenuContainer'");
    }

    public void unbind() {
        BusinessDyClassifyBLayout businessDyClassifyBLayout = this.f39775a;
        if (businessDyClassifyBLayout != null) {
            this.f39775a = null;
            businessDyClassifyBLayout.mClassifyTab = null;
            businessDyClassifyBLayout.mMenuContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
