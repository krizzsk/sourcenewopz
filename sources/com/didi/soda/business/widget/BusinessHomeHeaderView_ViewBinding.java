package com.didi.soda.business.widget;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.widget.headerview.CustomerTabLayout;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.home.topgun.widget.HomeBusinessExceptionStatusView;
import com.taxis99.R;

public class BusinessHomeHeaderView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessHomeHeaderView f39835a;

    public BusinessHomeHeaderView_ViewBinding(BusinessHomeHeaderView businessHomeHeaderView) {
        this(businessHomeHeaderView, businessHomeHeaderView);
    }

    public BusinessHomeHeaderView_ViewBinding(BusinessHomeHeaderView businessHomeHeaderView, View view) {
        this.f39835a = businessHomeHeaderView;
        businessHomeHeaderView.mBusinessNameTv = (TailIconTextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_business_home_name, "field 'mBusinessNameTv'", TailIconTextView.class);
        businessHomeHeaderView.mDeliveryTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_business_home_delivery_desc, "field 'mDeliveryTv'", TextView.class);
        businessHomeHeaderView.mHeaderBackgroundImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_background_img, "field 'mHeaderBackgroundImg'", ImageView.class);
        businessHomeHeaderView.mBusinessMarketingTips = (NovaFlowLayout) Utils.findRequiredViewAsType(view, R.id.customer_custom_marketing_tags, "field 'mBusinessMarketingTips'", NovaFlowLayout.class);
        businessHomeHeaderView.mHeaderMoreTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_header_more, "field 'mHeaderMoreTv'", TextView.class);
        businessHomeHeaderView.mClassifyTabContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_business_classify_layout, "field 'mClassifyTabContainer'", RelativeLayout.class);
        businessHomeHeaderView.mMoreClassifyBtn = Utils.findRequiredView(view, R.id.customer_tv_business_more_classify, "field 'mMoreClassifyBtn'");
        businessHomeHeaderView.mClassifyTab = (CustomerTabLayout) Utils.findRequiredViewAsType(view, R.id.customer_custom_business_classify, "field 'mClassifyTab'", CustomerTabLayout.class);
        businessHomeHeaderView.mBusinessLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_custom_business_home_logo, "field 'mBusinessLogo'", ImageView.class);
        businessHomeHeaderView.mBusinessExceptionStatusView = (HomeBusinessExceptionStatusView) Utils.findRequiredViewAsType(view, R.id.customer_custom_business_exception_status, "field 'mBusinessExceptionStatusView'", HomeBusinessExceptionStatusView.class);
        businessHomeHeaderView.mHeaderBgMask = Utils.findRequiredView(view, R.id.customer_view_business_home_background_mask, "field 'mHeaderBgMask'");
        businessHomeHeaderView.mCloseIcon = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_close, "field 'mCloseIcon'", IconTextView.class);
        businessHomeHeaderView.mSearchIcon = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_search, "field 'mSearchIcon'", IconTextView.class);
        businessHomeHeaderView.mTitleContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_business_home_close_container, "field 'mTitleContainer'", ConstraintLayout.class);
        businessHomeHeaderView.mHeaderCardContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_header_card, "field 'mHeaderCardContainer'", LinearLayout.class);
        businessHomeHeaderView.mStickyNameTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_business_sticky_name, "field 'mStickyNameTv'", TextView.class);
        businessHomeHeaderView.mAttentionInfoContainer = Utils.findRequiredView(view, R.id.customer_cl_attention_info_container, "field 'mAttentionInfoContainer'");
        businessHomeHeaderView.mAttentionInfoContentTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_attention_info_content, "field 'mAttentionInfoContentTv'", TextView.class);
        businessHomeHeaderView.mAttentionInfoImageIv = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_attention_info_image, "field 'mAttentionInfoImageIv'", ImageView.class);
        businessHomeHeaderView.mAttentionMaskContainer = Utils.findRequiredView(view, R.id.customer_view_layout_mark, "field 'mAttentionMaskContainer'");
        businessHomeHeaderView.mFavorImageIv = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_home_favor, "field 'mFavorImageIv'", IconTextView.class);
        businessHomeHeaderView.mFavorLoadingView = (LottieLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_custom_favor_loading, "field 'mFavorLoadingView'", LottieLoadingView.class);
        businessHomeHeaderView.mFavorContainerView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_business_favor_container, "field 'mFavorContainerView'", FrameLayout.class);
        businessHomeHeaderView.mShimmerTitleFavorDelegate = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_favor_delegate, "field 'mShimmerTitleFavorDelegate'", IconTextView.class);
        businessHomeHeaderView.mBusinessTabTipTv = (CustomerAppCompatTextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_business_tab_tip, "field 'mBusinessTabTipTv'", CustomerAppCompatTextView.class);
    }

    public void unbind() {
        BusinessHomeHeaderView businessHomeHeaderView = this.f39835a;
        if (businessHomeHeaderView != null) {
            this.f39835a = null;
            businessHomeHeaderView.mBusinessNameTv = null;
            businessHomeHeaderView.mDeliveryTv = null;
            businessHomeHeaderView.mHeaderBackgroundImg = null;
            businessHomeHeaderView.mBusinessMarketingTips = null;
            businessHomeHeaderView.mHeaderMoreTv = null;
            businessHomeHeaderView.mClassifyTabContainer = null;
            businessHomeHeaderView.mMoreClassifyBtn = null;
            businessHomeHeaderView.mClassifyTab = null;
            businessHomeHeaderView.mBusinessLogo = null;
            businessHomeHeaderView.mBusinessExceptionStatusView = null;
            businessHomeHeaderView.mHeaderBgMask = null;
            businessHomeHeaderView.mCloseIcon = null;
            businessHomeHeaderView.mSearchIcon = null;
            businessHomeHeaderView.mTitleContainer = null;
            businessHomeHeaderView.mHeaderCardContainer = null;
            businessHomeHeaderView.mStickyNameTv = null;
            businessHomeHeaderView.mAttentionInfoContainer = null;
            businessHomeHeaderView.mAttentionInfoContentTv = null;
            businessHomeHeaderView.mAttentionInfoImageIv = null;
            businessHomeHeaderView.mAttentionMaskContainer = null;
            businessHomeHeaderView.mFavorImageIv = null;
            businessHomeHeaderView.mFavorLoadingView = null;
            businessHomeHeaderView.mFavorContainerView = null;
            businessHomeHeaderView.mShimmerTitleFavorDelegate = null;
            businessHomeHeaderView.mBusinessTabTipTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
