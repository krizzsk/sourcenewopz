package com.didi.travel.psnger.p170v2.api;

import com.didi.travel.p171v2.store.IStoreCallback;
import com.didi.travel.psnger.model.response.CarOrder;

/* renamed from: com.didi.travel.psnger.v2.api.CreateOrderStoreCallback */
public class CreateOrderStoreCallback implements IStoreCallback<CarOrder> {
    public boolean isValid(Object[] objArr, CarOrder carOrder) {
        return true;
    }

    public String getStoreApiDetailKey(Object[] objArr, CarOrder carOrder) {
        return carOrder == null ? IStoreCallback.DEFAULT_API_DETAIL_KEY : carOrder.oid;
    }
}
