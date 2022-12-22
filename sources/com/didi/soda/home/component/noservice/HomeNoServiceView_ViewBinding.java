package com.didi.soda.home.component.noservice;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.soda.home.widget.HeaderInfoLayout;
import com.taxis99.R;

public class HomeNoServiceView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeNoServiceView f42601a;

    public HomeNoServiceView_ViewBinding(HomeNoServiceView homeNoServiceView, View view) {
        this.f42601a = homeNoServiceView;
        homeNoServiceView.mStatusBarView = Utils.findRequiredView(view, R.id.customer_home_non_status_bar, "field 'mStatusBarView'");
        homeNoServiceView.mHeaderInfoLayout = (HeaderInfoLayout) Utils.findRequiredViewAsType(view, R.id.customer_home_non_header_info, "field 'mHeaderInfoLayout'", HeaderInfoLayout.class);
        homeNoServiceView.mImageView = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.customer_home_non_image, "field 'mImageView'", LottieAnimationView.class);
        homeNoServiceView.mTitleView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_non_title, "field 'mTitleView'", TextView.class);
        homeNoServiceView.mSubtitleView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_non_subtitle, "field 'mSubtitleView'", TextView.class);
        homeNoServiceView.mButtonLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_home_non_bottom_layout, "field 'mButtonLayout'", LinearLayout.class);
        homeNoServiceView.mScrollView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.customer_sv_non_scroll_view, "field 'mScrollView'", ScrollView.class);
    }

    public void unbind() {
        HomeNoServiceView homeNoServiceView = this.f42601a;
        if (homeNoServiceView != null) {
            this.f42601a = null;
            homeNoServiceView.mStatusBarView = null;
            homeNoServiceView.mHeaderInfoLayout = null;
            homeNoServiceView.mImageView = null;
            homeNoServiceView.mTitleView = null;
            homeNoServiceView.mSubtitleView = null;
            homeNoServiceView.mButtonLayout = null;
            homeNoServiceView.mScrollView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
