package com.didi.soda.address.component.feed;

import com.didi.soda.address.component.feed.Contract;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressPageListEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew;

class AddressFeedMessagePresenter$3 extends CustomerRpcCallback<AddressPageListEntity> {
    final /* synthetic */ C13370a this$0;

    AddressFeedMessagePresenter$3(C13370a aVar) {
        this.this$0 = aVar;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        PageRenderingTrackerNew.Companion.trackExceptionUtil(this.this$0.getScopeContext());
        ((Contract.AbsAddressFeedMessageView) this.this$0.getLogicView()).hideLoading();
        this.this$0.mo98340a(sFRpcException.getCode(), sFRpcException.getMessage());
    }

    public void onRpcSuccess(AddressPageListEntity addressPageListEntity, long j) {
        ((Contract.AbsAddressFeedMessageView) this.this$0.getLogicView()).hideLoading();
        PageRenderingTrackerNew.Companion.trackEndAndReportUtil(this.this$0.getScopeContext());
        this.this$0.m27374a(addressPageListEntity);
        ((Contract.AbsAddressFeedMessageView) this.this$0.getLogicView()).showOrHideLoginView();
    }
}
