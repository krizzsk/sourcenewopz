package com.didi.soda.order.component.receipt;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.widget.SendSuccessView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.customer.widget.titlebar.TitleBarView;
import com.taxis99.R;

public class OrderReceiptView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private OrderReceiptView f43449a;

    public OrderReceiptView_ViewBinding(OrderReceiptView orderReceiptView, View view) {
        this.f43449a = orderReceiptView;
        orderReceiptView.mPageBackArea = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_page_back, "field 'mPageBackArea'", IconTextView.class);
        orderReceiptView.mTitleView = (TitleBarView) Utils.findRequiredViewAsType(view, R.id.customer_tbv_title_view, "field 'mTitleView'", TitleBarView.class);
        orderReceiptView.mRecyclerView = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_rv_send_receipt, "field 'mRecyclerView'", NovaRecyclerView.class);
        orderReceiptView.mConfirmView = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_custom_common_confirm, "field 'mConfirmView'", RFMainButton.class);
        orderReceiptView.mSuccessLayout = (SendSuccessView) Utils.findRequiredViewAsType(view, R.id.customer_layout_success, "field 'mSuccessLayout'", SendSuccessView.class);
        orderReceiptView.mReceiptTipTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_receipt_tip, "field 'mReceiptTipTv'", TextView.class);
        orderReceiptView.mDividerLine = Utils.findRequiredView(view, R.id.customer_view_divider, "field 'mDividerLine'");
    }

    public void unbind() {
        OrderReceiptView orderReceiptView = this.f43449a;
        if (orderReceiptView != null) {
            this.f43449a = null;
            orderReceiptView.mPageBackArea = null;
            orderReceiptView.mTitleView = null;
            orderReceiptView.mRecyclerView = null;
            orderReceiptView.mConfirmView = null;
            orderReceiptView.mSuccessLayout = null;
            orderReceiptView.mReceiptTipTv = null;
            orderReceiptView.mDividerLine = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
