package com.didi.soda.order.component.debtpay;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.soda.bill.widgets.CustomerBottomButton;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class DebtOrderPayView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private DebtOrderPayView f43386a;

    public DebtOrderPayView_ViewBinding(DebtOrderPayView debtOrderPayView, View view) {
        this.f43386a = debtOrderPayView;
        debtOrderPayView.mClose = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_common_dialog_close, "field 'mClose'", IconTextView.class);
        debtOrderPayView.mConfirm = (CustomerBottomButton) Utils.findRequiredViewAsType(view, R.id.customer_custom_common_dialog_confirm, "field 'mConfirm'", CustomerBottomButton.class);
        debtOrderPayView.mPaymentMoney = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_payment_total_money, "field 'mPaymentMoney'", TextView.class);
        debtOrderPayView.mPaymentIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_payment_card_icon, "field 'mPaymentIcon'", ImageView.class);
        debtOrderPayView.mPaymentCardNum = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_payment_card_number, "field 'mPaymentCardNum'", TextView.class);
        debtOrderPayView.mChangePaymentMethod = Utils.findRequiredView(view, R.id.customer_custom_change_payment_method, "field 'mChangePaymentMethod'");
        debtOrderPayView.mBackground = Utils.findRequiredView(view, R.id.customer_view_alph_black_top, "field 'mBackground'");
    }

    public void unbind() {
        DebtOrderPayView debtOrderPayView = this.f43386a;
        if (debtOrderPayView != null) {
            this.f43386a = null;
            debtOrderPayView.mClose = null;
            debtOrderPayView.mConfirm = null;
            debtOrderPayView.mPaymentMoney = null;
            debtOrderPayView.mPaymentIcon = null;
            debtOrderPayView.mPaymentCardNum = null;
            debtOrderPayView.mChangePaymentMethod = null;
            debtOrderPayView.mBackground = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
