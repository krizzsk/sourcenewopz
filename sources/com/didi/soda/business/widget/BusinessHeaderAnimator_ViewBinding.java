package com.didi.soda.business.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.home.topgun.widget.HomeBusinessExceptionStatusView;
import com.taxis99.R;

public class BusinessHeaderAnimator_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessHeaderAnimator f39819a;

    public BusinessHeaderAnimator_ViewBinding(BusinessHeaderAnimator businessHeaderAnimator, View view) {
        this.f39819a = businessHeaderAnimator;
        businessHeaderAnimator.mBusinessNameTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_business_home_name, "field 'mBusinessNameTv'", TextView.class);
        businessHeaderAnimator.mDeliveryTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_business_home_delivery_desc, "field 'mDeliveryTv'", TextView.class);
        businessHeaderAnimator.mHeaderBackgroundImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_background_img, "field 'mHeaderBackgroundImg'", ImageView.class);
        businessHeaderAnimator.mMarketingContainer = Utils.findRequiredView(view, R.id.customer_ll_marketing_container, "field 'mMarketingContainer'");
        businessHeaderAnimator.mClassifyTabContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_business_classify_layout, "field 'mClassifyTabContainer'", RelativeLayout.class);
        businessHeaderAnimator.mBusinessLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_custom_business_home_logo, "field 'mBusinessLogo'", ImageView.class);
        businessHeaderAnimator.mBusinessExceptionStatusView = (HomeBusinessExceptionStatusView) Utils.findRequiredViewAsType(view, R.id.customer_custom_business_exception_status, "field 'mBusinessExceptionStatusView'", HomeBusinessExceptionStatusView.class);
        businessHeaderAnimator.mHeaderBgMask = Utils.findRequiredView(view, R.id.customer_view_business_home_background_mask, "field 'mHeaderBgMask'");
        businessHeaderAnimator.mCloseIcon = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_close, "field 'mCloseIcon'", IconTextView.class);
        businessHeaderAnimator.mSearchIcon = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_search, "field 'mSearchIcon'", IconTextView.class);
        businessHeaderAnimator.mTitleContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_business_home_close_container, "field 'mTitleContainer'", ConstraintLayout.class);
        businessHeaderAnimator.mHeaderCardContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_header_card, "field 'mHeaderCardContainer'", LinearLayout.class);
        businessHeaderAnimator.mStickyNameTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_business_sticky_name, "field 'mStickyNameTv'", TextView.class);
        businessHeaderAnimator.mAttentionInfoContainer = Utils.findRequiredView(view, R.id.customer_cl_attention_info_container, "field 'mAttentionInfoContainer'");
        businessHeaderAnimator.mShadowView = Utils.findRequiredView(view, R.id.customer_classify_shadow, "field 'mShadowView'");
        businessHeaderAnimator.mDividerLine = Utils.findRequiredView(view, R.id.customer_view_divider, "field 'mDividerLine'");
        businessHeaderAnimator.mFavorLoadingView = (LottieLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_custom_favor_loading, "field 'mFavorLoadingView'", LottieLoadingView.class);
        businessHeaderAnimator.mFavorImageIv = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_favor, "field 'mFavorImageIv'", IconTextView.class);
        businessHeaderAnimator.mBusinessTabTipTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_business_tab_tip, "field 'mBusinessTabTipTv'", TextView.class);
    }

    public void unbind() {
        BusinessHeaderAnimator businessHeaderAnimator = this.f39819a;
        if (businessHeaderAnimator != null) {
            this.f39819a = null;
            businessHeaderAnimator.mBusinessNameTv = null;
            businessHeaderAnimator.mDeliveryTv = null;
            businessHeaderAnimator.mHeaderBackgroundImg = null;
            businessHeaderAnimator.mMarketingContainer = null;
            businessHeaderAnimator.mClassifyTabContainer = null;
            businessHeaderAnimator.mBusinessLogo = null;
            businessHeaderAnimator.mBusinessExceptionStatusView = null;
            businessHeaderAnimator.mHeaderBgMask = null;
            businessHeaderAnimator.mCloseIcon = null;
            businessHeaderAnimator.mSearchIcon = null;
            businessHeaderAnimator.mTitleContainer = null;
            businessHeaderAnimator.mHeaderCardContainer = null;
            businessHeaderAnimator.mStickyNameTv = null;
            businessHeaderAnimator.mAttentionInfoContainer = null;
            businessHeaderAnimator.mShadowView = null;
            businessHeaderAnimator.mDividerLine = null;
            businessHeaderAnimator.mFavorLoadingView = null;
            businessHeaderAnimator.mFavorImageIv = null;
            businessHeaderAnimator.mBusinessTabTipTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
