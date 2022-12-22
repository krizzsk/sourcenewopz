package com.didi.soda.home.component.phone;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.home.widget.InputPhoneLayout;
import com.taxis99.R;

public class HomePhoneView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomePhoneView f42615a;

    public HomePhoneView_ViewBinding(HomePhoneView homePhoneView, View view) {
        this.f42615a = homePhoneView;
        homePhoneView.mBackView = Utils.findRequiredView(view, R.id.customer_tv_back_view, "field 'mBackView'");
        homePhoneView.mInputPhoneLayout = (InputPhoneLayout) Utils.findRequiredViewAsType(view, R.id.customer_v_home_input_layout, "field 'mInputPhoneLayout'", InputPhoneLayout.class);
        homePhoneView.mPrivacyTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_privacy_text, "field 'mPrivacyTextView'", TextView.class);
        homePhoneView.mPrivacyLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_tv_privacy_layout, "field 'mPrivacyLayout'", LinearLayout.class);
        homePhoneView.mSubmitBtn = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_v_home_phone_submit, "field 'mSubmitBtn'", RFMainButton.class);
        homePhoneView.mScrollView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.customer_sv_home_input_phone_scroll, "field 'mScrollView'", ScrollView.class);
    }

    public void unbind() {
        HomePhoneView homePhoneView = this.f42615a;
        if (homePhoneView != null) {
            this.f42615a = null;
            homePhoneView.mBackView = null;
            homePhoneView.mInputPhoneLayout = null;
            homePhoneView.mPrivacyTextView = null;
            homePhoneView.mPrivacyLayout = null;
            homePhoneView.mSubmitBtn = null;
            homePhoneView.mScrollView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
