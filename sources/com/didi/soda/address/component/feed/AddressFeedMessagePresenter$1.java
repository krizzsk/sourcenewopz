package com.didi.soda.address.component.feed;

import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.util.LocationUtil;

class AddressFeedMessagePresenter$1 implements LocationUtil.LocationCallback {
    final /* synthetic */ C13370a this$0;

    AddressFeedMessagePresenter$1(C13370a aVar) {
        this.this$0 = aVar;
    }

    public void onLocationError() {
        LogUtil.m29104i("AddressFeedMessagePresenter", "onLocationError");
        this.this$0.m27382b((HomeAddressEntity) null);
        this.this$0.m27392j();
    }

    public void onLocationSuccess(LatLng latLng) {
        LogUtil.m29104i("AddressFeedMessagePresenter", "onLocationSuccess");
        this.this$0.m27390h();
    }
}
