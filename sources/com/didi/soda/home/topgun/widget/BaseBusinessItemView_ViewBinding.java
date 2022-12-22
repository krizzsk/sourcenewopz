package com.didi.soda.home.topgun.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.soda.bill.widgets.CustomerHorizontalScrollView;
import com.didi.soda.customer.widget.CouponTagFlowLayoutView;
import com.didi.soda.customer.widget.CustomerFixLineHeightTextView;
import com.taxis99.R;

public class BaseBusinessItemView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BaseBusinessItemView f43025a;

    public BaseBusinessItemView_ViewBinding(BaseBusinessItemView baseBusinessItemView) {
        this(baseBusinessItemView, baseBusinessItemView);
    }

    public BaseBusinessItemView_ViewBinding(BaseBusinessItemView baseBusinessItemView, View view) {
        this.f43025a = baseBusinessItemView;
        baseBusinessItemView.mBgImgIv = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_home_business_bg_img, "field 'mBgImgIv'", ImageView.class);
        baseBusinessItemView.mLogoAndPromContainer = (HomeLogoPromotionView) Utils.findRequiredViewAsType(view, R.id.customer_custom_home_business_logo_promotion, "field 'mLogoAndPromContainer'", HomeLogoPromotionView.class);
        baseBusinessItemView.mNameTv = (CustomerFixLineHeightTextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_business_name, "field 'mNameTv'", CustomerFixLineHeightTextView.class);
        baseBusinessItemView.mCateInfoTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_business_cate_info, "field 'mCateInfoTv'", TextView.class);
        baseBusinessItemView.mBuyingAgentTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_business_buying_agent, "field 'mBuyingAgentTv'", TextView.class);
        baseBusinessItemView.mDeliveryInfoTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_business_delivery_desc, "field 'mDeliveryInfoTv'", TextView.class);
        baseBusinessItemView.mCateLeftMaskView = Utils.findRequiredView(view, R.id.customer_view_cate_left_mask_shadow, "field 'mCateLeftMaskView'");
        baseBusinessItemView.mCateRightMaskView = Utils.findRequiredView(view, R.id.customer_view_cate_right_mask_shadow, "field 'mCateRightMaskView'");
        baseBusinessItemView.mCateInfoContainerHs = (CustomerHorizontalScrollView) Utils.findRequiredViewAsType(view, R.id.customer_hs_cate_info_container, "field 'mCateInfoContainerHs'", CustomerHorizontalScrollView.class);
        baseBusinessItemView.mDeliveryLeftMaskView = Utils.findRequiredView(view, R.id.customer_view_delivery_left_mask_shadow, "field 'mDeliveryLeftMaskView'");
        baseBusinessItemView.mDeliveryRightMaskView = Utils.findRequiredView(view, R.id.customer_view_delivery_right_mask_shadow, "field 'mDeliveryRightMaskView'");
        baseBusinessItemView.mDeliveryDescContainerHs = (CustomerHorizontalScrollView) Utils.findRequiredViewAsType(view, R.id.customer_hs_delivery_desc_container, "field 'mDeliveryDescContainerHs'", CustomerHorizontalScrollView.class);
        baseBusinessItemView.mItemMaskContainer = Utils.findRequiredView(view, R.id.customer_view_layout_mark, "field 'mItemMaskContainer'");
        baseBusinessItemView.mExceptionStatusMask = Utils.findRequiredView(view, R.id.customer_view_home_business_exception_status_mask, "field 'mExceptionStatusMask'");
        baseBusinessItemView.mBusinessExceptionStatusView = (HomeBusinessExceptionStatusView) Utils.findRequiredViewAsType(view, R.id.customer_custom_home_business_exception_status, "field 'mBusinessExceptionStatusView'", HomeBusinessExceptionStatusView.class);
        baseBusinessItemView.mRoot = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_business_root, "field 'mRoot'", ConstraintLayout.class);
        baseBusinessItemView.mGideLine = (Guideline) Utils.findRequiredViewAsType(view, R.id.customer_gl_guideline, "field 'mGideLine'", Guideline.class);
        baseBusinessItemView.mShopTipTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_home_business_shop_tip, "field 'mShopTipTv'", TextView.class);
        baseBusinessItemView.mActTipNfl = (CouponTagFlowLayoutView) Utils.findRequiredViewAsType(view, R.id.customer_nfl_home_business_act_tip, "field 'mActTipNfl'", CouponTagFlowLayoutView.class);
    }

    public void unbind() {
        BaseBusinessItemView baseBusinessItemView = this.f43025a;
        if (baseBusinessItemView != null) {
            this.f43025a = null;
            baseBusinessItemView.mBgImgIv = null;
            baseBusinessItemView.mLogoAndPromContainer = null;
            baseBusinessItemView.mNameTv = null;
            baseBusinessItemView.mCateInfoTv = null;
            baseBusinessItemView.mBuyingAgentTv = null;
            baseBusinessItemView.mDeliveryInfoTv = null;
            baseBusinessItemView.mCateLeftMaskView = null;
            baseBusinessItemView.mCateRightMaskView = null;
            baseBusinessItemView.mCateInfoContainerHs = null;
            baseBusinessItemView.mDeliveryLeftMaskView = null;
            baseBusinessItemView.mDeliveryRightMaskView = null;
            baseBusinessItemView.mDeliveryDescContainerHs = null;
            baseBusinessItemView.mItemMaskContainer = null;
            baseBusinessItemView.mExceptionStatusMask = null;
            baseBusinessItemView.mBusinessExceptionStatusView = null;
            baseBusinessItemView.mRoot = null;
            baseBusinessItemView.mGideLine = null;
            baseBusinessItemView.mShopTipTv = null;
            baseBusinessItemView.mActTipNfl = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
