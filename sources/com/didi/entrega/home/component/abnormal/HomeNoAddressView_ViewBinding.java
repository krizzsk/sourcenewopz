package com.didi.entrega.home.component.abnormal;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;

public class HomeNoAddressView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeNoAddressView f20639a;

    public HomeNoAddressView_ViewBinding(HomeNoAddressView homeNoAddressView) {
        this(homeNoAddressView, homeNoAddressView);
    }

    public HomeNoAddressView_ViewBinding(HomeNoAddressView homeNoAddressView, View view) {
        this.f20639a = homeNoAddressView;
        homeNoAddressView.mAddressTitleTv = (TextView) Utils.findRequiredViewAsType(view, R.id.entrega_tv_home_address_title, "field 'mAddressTitleTv'", TextView.class);
        homeNoAddressView.mAddressContentTv = (TextView) Utils.findRequiredViewAsType(view, R.id.entrega_tv_home_address_content, "field 'mAddressContentTv'", TextView.class);
        homeNoAddressView.mAddressSelectTv = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.entrega_tv_home_address_select, "field 'mAddressSelectTv'", RFMainButton.class);
        homeNoAddressView.mAddressUnSelectTv = (RFGhostButton) Utils.findRequiredViewAsType(view, R.id.entrega_tv_home_address_unselect, "field 'mAddressUnSelectTv'", RFGhostButton.class);
    }

    public void unbind() {
        HomeNoAddressView homeNoAddressView = this.f20639a;
        if (homeNoAddressView != null) {
            this.f20639a = null;
            homeNoAddressView.mAddressTitleTv = null;
            homeNoAddressView.mAddressContentTv = null;
            homeNoAddressView.mAddressSelectTv = null;
            homeNoAddressView.mAddressUnSelectTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
