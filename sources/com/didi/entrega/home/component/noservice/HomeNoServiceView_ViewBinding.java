package com.didi.entrega.home.component.noservice;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;

public class HomeNoServiceView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeNoServiceView f20699a;

    public HomeNoServiceView_ViewBinding(HomeNoServiceView homeNoServiceView, View view) {
        this.f20699a = homeNoServiceView;
        homeNoServiceView.mSelectCityButton = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.entrega_tv_home_openedcity_select, "field 'mSelectCityButton'", RFMainButton.class);
        homeNoServiceView.mTitle = (CustomerAppCompatTextView) Utils.findRequiredViewAsType(view, R.id.entrega_tv_home_noservice_title, "field 'mTitle'", CustomerAppCompatTextView.class);
        homeNoServiceView.mContent = (CustomerAppCompatTextView) Utils.findRequiredViewAsType(view, R.id.entrega_tv_home_noservice_content, "field 'mContent'", CustomerAppCompatTextView.class);
    }

    public void unbind() {
        HomeNoServiceView homeNoServiceView = this.f20699a;
        if (homeNoServiceView != null) {
            this.f20699a = null;
            homeNoServiceView.mSelectCityButton = null;
            homeNoServiceView.mTitle = null;
            homeNoServiceView.mContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
