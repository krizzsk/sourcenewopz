package com.didi.soda.address.component.feed;

import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;

class AddressFeedMessagePresenter$4 extends CustomerRpcCallback<HomeAddressEntity> {
    final /* synthetic */ C13370a this$0;

    AddressFeedMessagePresenter$4(C13370a aVar) {
        this.this$0 = aVar;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        this.this$0.m27382b((HomeAddressEntity) null);
        if (sFRpcException.getCode() == -1) {
            this.this$0.m27392j();
        }
    }

    public void onRpcSuccess(HomeAddressEntity homeAddressEntity, long j) {
        this.this$0.m27382b(homeAddressEntity);
        if (homeAddressEntity == null || !AddressUtil.checkAddressValid(homeAddressEntity.address)) {
            this.this$0.m27392j();
        }
    }
}
