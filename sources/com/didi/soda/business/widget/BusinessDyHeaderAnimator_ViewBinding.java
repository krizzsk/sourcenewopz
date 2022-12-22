package com.didi.soda.business.widget;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class BusinessDyHeaderAnimator_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessDyHeaderAnimator f39790a;

    public BusinessDyHeaderAnimator_ViewBinding(BusinessDyHeaderAnimator businessDyHeaderAnimator, View view) {
        this.f39790a = businessDyHeaderAnimator;
        businessDyHeaderAnimator.mHeaderBackgroundImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_background_img, "field 'mHeaderBackgroundImg'", ImageView.class);
        businessDyHeaderAnimator.mClassifyTabContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_business_classify_layout, "field 'mClassifyTabContainer'", ConstraintLayout.class);
        businessDyHeaderAnimator.mBusinessLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_custom_business_home_logo, "field 'mBusinessLogo'", ImageView.class);
        businessDyHeaderAnimator.mCloseIcon = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_close, "field 'mCloseIcon'", RFIconView.class);
        businessDyHeaderAnimator.mSearchIcon = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_search, "field 'mSearchIcon'", RFIconView.class);
        businessDyHeaderAnimator.mTitleContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_business_home_close_container, "field 'mTitleContainer'", ConstraintLayout.class);
        businessDyHeaderAnimator.mHeaderCardContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_rl_header_card, "field 'mHeaderCardContainer'", FrameLayout.class);
        businessDyHeaderAnimator.mHeadeRoot = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.business_dy_header_root, "field 'mHeadeRoot'", ConstraintLayout.class);
        businessDyHeaderAnimator.mStickyNameTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_business_sticky_name, "field 'mStickyNameTv'", TextView.class);
        businessDyHeaderAnimator.mFavorLoadingView = (LottieLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_custom_favor_loading, "field 'mFavorLoadingView'", LottieLoadingView.class);
        businessDyHeaderAnimator.mFavorImageIv = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_favor, "field 'mFavorImageIv'", RFIconView.class);
        businessDyHeaderAnimator.mLogoContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_header_logo_container, "field 'mLogoContainer'", FrameLayout.class);
        businessDyHeaderAnimator.mStickyNavigationView = (BusinessDyStickyNavigationView) Utils.findRequiredViewAsType(view, R.id.customer_dy_sticky_navigation_container, "field 'mStickyNavigationView'", BusinessDyStickyNavigationView.class);
        businessDyHeaderAnimator.mClassifyALayout = (BusinessDyClassifyALayout) Utils.findRequiredViewAsType(view, R.id.customer_bcb_business_classify_a_layout, "field 'mClassifyALayout'", BusinessDyClassifyALayout.class);
        businessDyHeaderAnimator.mClassifyBLayout = (BusinessDyClassifyBLayout) Utils.findRequiredViewAsType(view, R.id.customer_bcb_business_classify_b_layout, "field 'mClassifyBLayout'", BusinessDyClassifyBLayout.class);
        businessDyHeaderAnimator.mHeaderCardShadowView = Utils.findRequiredView(view, R.id.customer_header_card_shadow, "field 'mHeaderCardShadowView'");
    }

    public void unbind() {
        BusinessDyHeaderAnimator businessDyHeaderAnimator = this.f39790a;
        if (businessDyHeaderAnimator != null) {
            this.f39790a = null;
            businessDyHeaderAnimator.mHeaderBackgroundImg = null;
            businessDyHeaderAnimator.mClassifyTabContainer = null;
            businessDyHeaderAnimator.mBusinessLogo = null;
            businessDyHeaderAnimator.mCloseIcon = null;
            businessDyHeaderAnimator.mSearchIcon = null;
            businessDyHeaderAnimator.mTitleContainer = null;
            businessDyHeaderAnimator.mHeaderCardContainer = null;
            businessDyHeaderAnimator.mHeadeRoot = null;
            businessDyHeaderAnimator.mStickyNameTv = null;
            businessDyHeaderAnimator.mFavorLoadingView = null;
            businessDyHeaderAnimator.mFavorImageIv = null;
            businessDyHeaderAnimator.mLogoContainer = null;
            businessDyHeaderAnimator.mStickyNavigationView = null;
            businessDyHeaderAnimator.mClassifyALayout = null;
            businessDyHeaderAnimator.mClassifyBLayout = null;
            businessDyHeaderAnimator.mHeaderCardShadowView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
