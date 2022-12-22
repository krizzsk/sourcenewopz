package com.didi.soda.customer.biz.popdialog.natived.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class PromoCodePopDialogView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PromoCodePopDialogView f40517a;

    public PromoCodePopDialogView_ViewBinding(PromoCodePopDialogView promoCodePopDialogView, View view) {
        this.f40517a = promoCodePopDialogView;
        promoCodePopDialogView.mRootView = Utils.findRequiredView(view, R.id.customer_ll_pop_root, "field 'mRootView'");
        promoCodePopDialogView.mPopImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_pop_image, "field 'mPopImage'", ImageView.class);
        promoCodePopDialogView.mPopClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_pop_close, "field 'mPopClose'", ImageView.class);
        promoCodePopDialogView.mPromocodeParent = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_promocode_parent, "field 'mPromocodeParent'", ConstraintLayout.class);
        promoCodePopDialogView.mMessageParent = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_message_parent, "field 'mMessageParent'", ConstraintLayout.class);
        promoCodePopDialogView.mExchangingParent = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_message_exchanging_parent, "field 'mExchangingParent'", ConstraintLayout.class);
        promoCodePopDialogView.mMessageBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_message_back, "field 'mMessageBack'", ImageView.class);
        promoCodePopDialogView.mMessagePage = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_message, "field 'mMessagePage'", ImageView.class);
        promoCodePopDialogView.mResultIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_message_result_icon, "field 'mResultIcon'", ImageView.class);
        promoCodePopDialogView.mResultTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_message_result_title, "field 'mResultTitle'", TextView.class);
        promoCodePopDialogView.mResultContent = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_message_result_content, "field 'mResultContent'", TextView.class);
        promoCodePopDialogView.mMessageTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_message_title, "field 'mMessageTitle'", TextView.class);
        promoCodePopDialogView.mPromoCode = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_message_promo_code, "field 'mPromoCode'", TextView.class);
        promoCodePopDialogView.mMessageExchanging = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_message_exchanging, "field 'mMessageExchanging'", TextView.class);
        promoCodePopDialogView.mLoading = (LottieLoadingView) Utils.findRequiredViewAsType(view, R.id.customer_custom_loading, "field 'mLoading'", LottieLoadingView.class);
        promoCodePopDialogView.mMessageFront = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_message_front, "field 'mMessageFront'", ImageView.class);
        promoCodePopDialogView.mMessageResultBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_message_exchang_result_btn, "field 'mMessageResultBtn'", TextView.class);
        promoCodePopDialogView.mGroupPromoCode = (Group) Utils.findRequiredViewAsType(view, R.id.customer_custom_promo_code_area, "field 'mGroupPromoCode'", Group.class);
        promoCodePopDialogView.mGroupExchangeResult = (Group) Utils.findRequiredViewAsType(view, R.id.customer_custom_exchange_result_area, "field 'mGroupExchangeResult'", Group.class);
        promoCodePopDialogView.mGroupExchanging = (Group) Utils.findRequiredViewAsType(view, R.id.customer_custom_exchanging_area, "field 'mGroupExchanging'", Group.class);
        promoCodePopDialogView.mPopContent = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.customer_rl_pop_promo_content, "field 'mPopContent'", RelativeLayout.class);
    }

    public void unbind() {
        PromoCodePopDialogView promoCodePopDialogView = this.f40517a;
        if (promoCodePopDialogView != null) {
            this.f40517a = null;
            promoCodePopDialogView.mRootView = null;
            promoCodePopDialogView.mPopImage = null;
            promoCodePopDialogView.mPopClose = null;
            promoCodePopDialogView.mPromocodeParent = null;
            promoCodePopDialogView.mMessageParent = null;
            promoCodePopDialogView.mExchangingParent = null;
            promoCodePopDialogView.mMessageBack = null;
            promoCodePopDialogView.mMessagePage = null;
            promoCodePopDialogView.mResultIcon = null;
            promoCodePopDialogView.mResultTitle = null;
            promoCodePopDialogView.mResultContent = null;
            promoCodePopDialogView.mMessageTitle = null;
            promoCodePopDialogView.mPromoCode = null;
            promoCodePopDialogView.mMessageExchanging = null;
            promoCodePopDialogView.mLoading = null;
            promoCodePopDialogView.mMessageFront = null;
            promoCodePopDialogView.mMessageResultBtn = null;
            promoCodePopDialogView.mGroupPromoCode = null;
            promoCodePopDialogView.mGroupExchangeResult = null;
            promoCodePopDialogView.mGroupExchanging = null;
            promoCodePopDialogView.mPopContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
