package com.didi.soda.business.page;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class BusinessHomePage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessHomePage f39732a;

    public BusinessHomePage_ViewBinding(BusinessHomePage businessHomePage, View view) {
        this.f39732a = businessHomePage;
        businessHomePage.mDynamicNoticeContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_business_dynamic_notice_container, "field 'mDynamicNoticeContainer'", FrameLayout.class);
        businessHomePage.mBusinessMenuContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_business_home_container, "field 'mBusinessMenuContainer'", FrameLayout.class);
        businessHomePage.mBusinessHomeParent = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_business_parent, "field 'mBusinessHomeParent'", ConstraintLayout.class);
        businessHomePage.mBusinessDetailContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_business_detail_container, "field 'mBusinessDetailContainer'", FrameLayout.class);
        businessHomePage.mCategoryContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_business_category_container, "field 'mCategoryContainer'", FrameLayout.class);
        businessHomePage.mCartContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_cart_container, "field 'mCartContainer'", FrameLayout.class);
        businessHomePage.mAddCartAnimationContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_add_cart_animation_container, "field 'mAddCartAnimationContainer'", FrameLayout.class);
    }

    public void unbind() {
        BusinessHomePage businessHomePage = this.f39732a;
        if (businessHomePage != null) {
            this.f39732a = null;
            businessHomePage.mDynamicNoticeContainer = null;
            businessHomePage.mBusinessMenuContainer = null;
            businessHomePage.mBusinessHomeParent = null;
            businessHomePage.mBusinessDetailContainer = null;
            businessHomePage.mCategoryContainer = null;
            businessHomePage.mCartContainer = null;
            businessHomePage.mAddCartAnimationContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
