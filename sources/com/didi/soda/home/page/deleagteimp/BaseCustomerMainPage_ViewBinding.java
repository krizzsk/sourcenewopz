package com.didi.soda.home.page.deleagteimp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class BaseCustomerMainPage_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BaseCustomerMainPage f42715a;

    public BaseCustomerMainPage_ViewBinding(BaseCustomerMainPage baseCustomerMainPage, View view) {
        this.f42715a = baseCustomerMainPage;
        baseCustomerMainPage.mMainPageContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.customer_rl_main_page_container, "field 'mMainPageContainer'", ViewGroup.class);
        baseCustomerMainPage.mLoadingViewContain = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_loading_container, "field 'mLoadingViewContain'", FrameLayout.class);
        baseCustomerMainPage.mFeedContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_feed_container, "field 'mFeedContainer'", FrameLayout.class);
        baseCustomerMainPage.mFilterContianer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_filter_container, "field 'mFilterContianer'", FrameLayout.class);
        baseCustomerMainPage.mHomeWebContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.customer_fl_home_web_container, "field 'mHomeWebContainer'", ViewGroup.class);
        baseCustomerMainPage.mNoAddressContianer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_no_address_container, "field 'mNoAddressContianer'", FrameLayout.class);
        baseCustomerMainPage.mTitleBarContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.customer_fl_title_bar_container, "field 'mTitleBarContainer'", ViewGroup.class);
        baseCustomerMainPage.mTaskBubContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.customer_fl_home_task_bub, "field 'mTaskBubContainer'", ViewGroup.class);
        baseCustomerMainPage.mHomeNoServiceContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_home_nonsuport_container, "field 'mHomeNoServiceContainer'", FrameLayout.class);
        baseCustomerMainPage.mCartContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_cart_container, "field 'mCartContainer'", FrameLayout.class);
    }

    public void unbind() {
        BaseCustomerMainPage baseCustomerMainPage = this.f42715a;
        if (baseCustomerMainPage != null) {
            this.f42715a = null;
            baseCustomerMainPage.mMainPageContainer = null;
            baseCustomerMainPage.mLoadingViewContain = null;
            baseCustomerMainPage.mFeedContainer = null;
            baseCustomerMainPage.mFilterContianer = null;
            baseCustomerMainPage.mHomeWebContainer = null;
            baseCustomerMainPage.mNoAddressContianer = null;
            baseCustomerMainPage.mTitleBarContainer = null;
            baseCustomerMainPage.mTaskBubContainer = null;
            baseCustomerMainPage.mHomeNoServiceContainer = null;
            baseCustomerMainPage.mCartContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
