package com.didi.soda.business.widget;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;

public class BusinessDyStickyNavigationView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessDyStickyNavigationView f39805a;

    public BusinessDyStickyNavigationView_ViewBinding(BusinessDyStickyNavigationView businessDyStickyNavigationView) {
        this(businessDyStickyNavigationView, businessDyStickyNavigationView);
    }

    public BusinessDyStickyNavigationView_ViewBinding(BusinessDyStickyNavigationView businessDyStickyNavigationView, View view) {
        this.f39805a = businessDyStickyNavigationView;
        businessDyStickyNavigationView.mCloseIcon = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_navigation_close, "field 'mCloseIcon'", RFIconView.class);
        businessDyStickyNavigationView.mSearchIcon = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_navigation_search, "field 'mSearchIcon'", RFIconView.class);
        businessDyStickyNavigationView.mTitleContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_business_navigation_close_container, "field 'mTitleContainer'", ConstraintLayout.class);
        businessDyStickyNavigationView.mSearchDescContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_business_search_container, "field 'mSearchDescContainer'", ConstraintLayout.class);
    }

    public void unbind() {
        BusinessDyStickyNavigationView businessDyStickyNavigationView = this.f39805a;
        if (businessDyStickyNavigationView != null) {
            this.f39805a = null;
            businessDyStickyNavigationView.mCloseIcon = null;
            businessDyStickyNavigationView.mSearchIcon = null;
            businessDyStickyNavigationView.mTitleContainer = null;
            businessDyStickyNavigationView.mSearchDescContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
