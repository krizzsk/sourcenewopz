package com.didi.soda.address.component.feed;

import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.taxis99.R;

class AddressFeedMessagePresenter$5 extends CustomerRpcCallback<AddressEntity> {
    final /* synthetic */ C13370a this$0;

    public void onRpcSuccess(AddressEntity addressEntity, long j) {
    }

    AddressFeedMessagePresenter$5(C13370a aVar) {
        this.this$0 = aVar;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        ToastUtil.showCustomerToast(this.this$0.getScopeContext(), ResourceHelper.getString(R.string.FoodC_I_Unable_to_BjiH));
    }
}
