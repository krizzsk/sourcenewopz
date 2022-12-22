package com.didi.soda.order.component.tips;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.bill.widgets.CustomerCartTipsGroupView;
import com.didi.soda.customer.widget.CustomerCommonBubbleView;
import com.didi.soda.customer.widget.abnormal.AbnormalView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class EditTipsView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private EditTipsView f43475a;

    public EditTipsView_ViewBinding(EditTipsView editTipsView, View view) {
        this.f43475a = editTipsView;
        editTipsView.mOrderPriceView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_cart_subtotal_money, "field 'mOrderPriceView'", TextView.class);
        editTipsView.mManuTipfeeView = (EditText) Utils.findRequiredViewAsType(view, R.id.customer_custom_cart_tips_manu_money, "field 'mManuTipfeeView'", EditText.class);
        editTipsView.mManuTipfeeViewHint = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_cart_tips_manu_money_hint, "field 'mManuTipfeeViewHint'", TextView.class);
        editTipsView.mTipfeeView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_cart_tips_subtotal_money, "field 'mTipfeeView'", TextView.class);
        editTipsView.mTipsDes = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_cart_tips_des, "field 'mTipsDes'", TextView.class);
        editTipsView.mCurrencyView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_cart_tips_manu_currency, "field 'mCurrencyView'", TextView.class);
        editTipsView.mPercentView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_cart_tips_manu_percent, "field 'mPercentView'", TextView.class);
        editTipsView.mPaymentView = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_payment, "field 'mPaymentView'", RelativeLayout.class);
        editTipsView.mPaymentIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_payment_icon, "field 'mPaymentIcon'", ImageView.class);
        editTipsView.mPayment = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_payment_value, "field 'mPayment'", TextView.class);
        editTipsView.mTipsPaidView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_cart_tips_paid, "field 'mTipsPaidView'", TextView.class);
        editTipsView.mInputBubble = (CustomerCommonBubbleView) Utils.findRequiredViewAsType(view, R.id.customer_custom_input_tip_bubble, "field 'mInputBubble'", CustomerCommonBubbleView.class);
        editTipsView.mTipsGroupView = (CustomerCartTipsGroupView) Utils.findRequiredViewAsType(view, R.id.customer_custom_cart_tips_group, "field 'mTipsGroupView'", CustomerCartTipsGroupView.class);
        editTipsView.mTipRoot = (ScrollView) Utils.findRequiredViewAsType(view, R.id.customer_tip_root, "field 'mTipRoot'", ScrollView.class);
        editTipsView.mTipGroupRoot = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.customer_dialog_cart_tips, "field 'mTipGroupRoot'", RelativeLayout.class);
        editTipsView.mErrorView = (AbnormalView) Utils.findRequiredViewAsType(view, R.id.customer_custom_tip_error, "field 'mErrorView'", AbnormalView.class);
        editTipsView.mClose = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_common_close, "field 'mClose'", IconTextView.class);
        editTipsView.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_common_title, "field 'mTitle'", TextView.class);
        editTipsView.mConfirm = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_custom_common_confirm, "field 'mConfirm'", RFMainButton.class);
        editTipsView.mSubTotal = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_tips_subtotal, "field 'mSubTotal'", LinearLayout.class);
        editTipsView.mInputLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.customer_rl_tips_input, "field 'mInputLayout'", RelativeLayout.class);
    }

    public void unbind() {
        EditTipsView editTipsView = this.f43475a;
        if (editTipsView != null) {
            this.f43475a = null;
            editTipsView.mOrderPriceView = null;
            editTipsView.mManuTipfeeView = null;
            editTipsView.mManuTipfeeViewHint = null;
            editTipsView.mTipfeeView = null;
            editTipsView.mTipsDes = null;
            editTipsView.mCurrencyView = null;
            editTipsView.mPercentView = null;
            editTipsView.mPaymentView = null;
            editTipsView.mPaymentIcon = null;
            editTipsView.mPayment = null;
            editTipsView.mTipsPaidView = null;
            editTipsView.mInputBubble = null;
            editTipsView.mTipsGroupView = null;
            editTipsView.mTipRoot = null;
            editTipsView.mTipGroupRoot = null;
            editTipsView.mErrorView = null;
            editTipsView.mClose = null;
            editTipsView.mTitle = null;
            editTipsView.mConfirm = null;
            editTipsView.mSubTotal = null;
            editTipsView.mInputLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
