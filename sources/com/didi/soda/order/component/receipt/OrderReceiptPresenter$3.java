package com.didi.soda.order.component.receipt;

import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.order.component.receipt.Contract;

class OrderReceiptPresenter$3 extends CustomerRpcCallback<Object> {
    final /* synthetic */ C14122a this$0;

    OrderReceiptPresenter$3(C14122a aVar) {
        this.this$0 = aVar;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        ((Contract.AbsOrderReceiptView) this.this$0.getLogicView()).hideLoading();
    }

    public void onRpcSuccess(Object obj, long j) {
        ((Contract.AbsOrderReceiptView) this.this$0.getLogicView()).hideSoftInput();
        ((Contract.AbsOrderReceiptView) this.this$0.getLogicView()).hideLoading();
        this.this$0.m30776g();
        ((Contract.AbsOrderReceiptView) this.this$0.getLogicView()).showSendSuccessView(this.this$0.f43452c);
    }
}
