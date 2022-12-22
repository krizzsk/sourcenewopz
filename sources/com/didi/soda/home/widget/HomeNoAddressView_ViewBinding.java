package com.didi.soda.home.widget;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;

public class HomeNoAddressView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeNoAddressView f43296a;

    public HomeNoAddressView_ViewBinding(HomeNoAddressView homeNoAddressView) {
        this(homeNoAddressView, homeNoAddressView);
    }

    public HomeNoAddressView_ViewBinding(HomeNoAddressView homeNoAddressView, View view) {
        this.f43296a = homeNoAddressView;
        homeNoAddressView.mAddressTitleTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_address_title, "field 'mAddressTitleTv'", TextView.class);
        homeNoAddressView.mAddressContentTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_address_content, "field 'mAddressContentTv'", TextView.class);
        homeNoAddressView.mAddressSelectTv = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_address_select, "field 'mAddressSelectTv'", RFMainButton.class);
        homeNoAddressView.mAddressUnSelectTv = (RFGhostButton) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_address_unselect, "field 'mAddressUnSelectTv'", RFGhostButton.class);
    }

    public void unbind() {
        HomeNoAddressView homeNoAddressView = this.f43296a;
        if (homeNoAddressView != null) {
            this.f43296a = null;
            homeNoAddressView.mAddressTitleTv = null;
            homeNoAddressView.mAddressContentTv = null;
            homeNoAddressView.mAddressSelectTv = null;
            homeNoAddressView.mAddressUnSelectTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
