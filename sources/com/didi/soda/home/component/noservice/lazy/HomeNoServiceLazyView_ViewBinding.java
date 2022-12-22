package com.didi.soda.home.component.noservice.lazy;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.soda.home.widget.HeaderInfoLayout;
import com.taxis99.R;

public class HomeNoServiceLazyView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeNoServiceLazyView f42608a;

    public HomeNoServiceLazyView_ViewBinding(HomeNoServiceLazyView homeNoServiceLazyView, View view) {
        this.f42608a = homeNoServiceLazyView;
        homeNoServiceLazyView.mStatusBarView = Utils.findRequiredView(view, R.id.customer_home_non_status_bar, "field 'mStatusBarView'");
        homeNoServiceLazyView.mHeaderInfoLayout = (HeaderInfoLayout) Utils.findRequiredViewAsType(view, R.id.customer_home_non_header_info, "field 'mHeaderInfoLayout'", HeaderInfoLayout.class);
        homeNoServiceLazyView.mImageView = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.customer_home_non_image, "field 'mImageView'", LottieAnimationView.class);
        homeNoServiceLazyView.mTitleView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_non_title, "field 'mTitleView'", TextView.class);
        homeNoServiceLazyView.mSubtitleView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_non_subtitle, "field 'mSubtitleView'", TextView.class);
        homeNoServiceLazyView.mButtonLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_home_non_bottom_layout, "field 'mButtonLayout'", LinearLayout.class);
        homeNoServiceLazyView.mScrollView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.customer_sv_non_scroll_view, "field 'mScrollView'", ScrollView.class);
    }

    public void unbind() {
        HomeNoServiceLazyView homeNoServiceLazyView = this.f42608a;
        if (homeNoServiceLazyView != null) {
            this.f42608a = null;
            homeNoServiceLazyView.mStatusBarView = null;
            homeNoServiceLazyView.mHeaderInfoLayout = null;
            homeNoServiceLazyView.mImageView = null;
            homeNoServiceLazyView.mTitleView = null;
            homeNoServiceLazyView.mSubtitleView = null;
            homeNoServiceLazyView.mButtonLayout = null;
            homeNoServiceLazyView.mScrollView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
