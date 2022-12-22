package com.didi.soda.business.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class BusinessSearchPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessSearchPage f39740a;

    public BusinessSearchPage_ViewBinding(BusinessSearchPage businessSearchPage, View view) {
        this.f39740a = businessSearchPage;
        businessSearchPage.mBusinessHotWordContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_business_words_container, "field 'mBusinessHotWordContainer'", FrameLayout.class);
        businessSearchPage.mBusinessCartContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_business_cart_container, "field 'mBusinessCartContainer'", FrameLayout.class);
        businessSearchPage.mBusinessSearchContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_business_search_container, "field 'mBusinessSearchContainer'", FrameLayout.class);
        businessSearchPage.mAddAnimationContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.customer_add_cart_animation_container, "field 'mAddAnimationContainer'", ViewGroup.class);
    }

    public void unbind() {
        BusinessSearchPage businessSearchPage = this.f39740a;
        if (businessSearchPage != null) {
            this.f39740a = null;
            businessSearchPage.mBusinessHotWordContainer = null;
            businessSearchPage.mBusinessCartContainer = null;
            businessSearchPage.mBusinessSearchContainer = null;
            businessSearchPage.mAddAnimationContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
