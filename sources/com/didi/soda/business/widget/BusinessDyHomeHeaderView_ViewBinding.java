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
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class BusinessDyHomeHeaderView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessDyHomeHeaderView f39803a;

    public BusinessDyHomeHeaderView_ViewBinding(BusinessDyHomeHeaderView businessDyHomeHeaderView) {
        this(businessDyHomeHeaderView, businessDyHomeHeaderView);
    }

    public BusinessDyHomeHeaderView_ViewBinding(BusinessDyHomeHeaderView businessDyHomeHeaderView, View view) {
        this.f39803a = businessDyHomeHeaderView;
        businessDyHomeHeaderView.mHeaderBackgroundImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_background_img, "field 'mHeaderBackgroundImg'", ImageView.class);
        businessDyHomeHeaderView.mClassifyTabContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_business_classify_layout, "field 'mClassifyTabContainer'", ConstraintLayout.class);
        businessDyHomeHeaderView.mBusinessLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_custom_business_home_logo, "field 'mBusinessLogo'", ImageView.class);
        businessDyHomeHeaderView.mCloseIcon = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_close, "field 'mCloseIcon'", RFIconView.class);
        businessDyHomeHeaderView.mSearchIcon = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_search, "field 'mSearchIcon'", RFIconView.class);
        businessDyHomeHeaderView.mTitleContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_business_home_close_container, "field 'mTitleContainer'", ConstraintLayout.class);
        businessDyHomeHeaderView.mHeaderCardContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_rl_header_card, "field 'mHeaderCardContainer'", FrameLayout.class);
        businessDyHomeHeaderView.mStickyNameTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_business_sticky_name, "field 'mStickyNameTv'", TextView.class);
        businessDyHomeHeaderView.mFavorImageIv = (RFIconView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_favor, "field 'mFavorImageIv'", RFIconView.class);
        businessDyHomeHeaderView.mFavorLoadingView = (LottieLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_custom_favor_loading, "field 'mFavorLoadingView'", LottieLoadingView.class);
        businessDyHomeHeaderView.mFavorContainerView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_business_favor_container, "field 'mFavorContainerView'", FrameLayout.class);
        businessDyHomeHeaderView.mShimmerTitleFavorDelegate = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_favor_delegate, "field 'mShimmerTitleFavorDelegate'", IconTextView.class);
        businessDyHomeHeaderView.mLogoContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_header_logo_container, "field 'mLogoContainer'", FrameLayout.class);
        businessDyHomeHeaderView.mStickyNavigationView = (BusinessDyStickyNavigationView) Utils.findRequiredViewAsType(view, R.id.customer_dy_sticky_navigation_container, "field 'mStickyNavigationView'", BusinessDyStickyNavigationView.class);
        businessDyHomeHeaderView.mClassifyALayout = (BusinessDyClassifyALayout) Utils.findRequiredViewAsType(view, R.id.customer_bcb_business_classify_a_layout, "field 'mClassifyALayout'", BusinessDyClassifyALayout.class);
        businessDyHomeHeaderView.mClassifyBLayout = (BusinessDyClassifyBLayout) Utils.findRequiredViewAsType(view, R.id.customer_bcb_business_classify_b_layout, "field 'mClassifyBLayout'", BusinessDyClassifyBLayout.class);
        businessDyHomeHeaderView.mHeaderCardShadowView = Utils.findRequiredView(view, R.id.customer_header_card_shadow, "field 'mHeaderCardShadowView'");
    }

    public void unbind() {
        BusinessDyHomeHeaderView businessDyHomeHeaderView = this.f39803a;
        if (businessDyHomeHeaderView != null) {
            this.f39803a = null;
            businessDyHomeHeaderView.mHeaderBackgroundImg = null;
            businessDyHomeHeaderView.mClassifyTabContainer = null;
            businessDyHomeHeaderView.mBusinessLogo = null;
            businessDyHomeHeaderView.mCloseIcon = null;
            businessDyHomeHeaderView.mSearchIcon = null;
            businessDyHomeHeaderView.mTitleContainer = null;
            businessDyHomeHeaderView.mHeaderCardContainer = null;
            businessDyHomeHeaderView.mStickyNameTv = null;
            businessDyHomeHeaderView.mFavorImageIv = null;
            businessDyHomeHeaderView.mFavorLoadingView = null;
            businessDyHomeHeaderView.mFavorContainerView = null;
            businessDyHomeHeaderView.mShimmerTitleFavorDelegate = null;
            businessDyHomeHeaderView.mLogoContainer = null;
            businessDyHomeHeaderView.mStickyNavigationView = null;
            businessDyHomeHeaderView.mClassifyALayout = null;
            businessDyHomeHeaderView.mClassifyBLayout = null;
            businessDyHomeHeaderView.mHeaderCardShadowView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
