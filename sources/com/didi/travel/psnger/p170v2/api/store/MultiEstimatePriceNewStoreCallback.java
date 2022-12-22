package com.didi.travel.psnger.p170v2.api.store;

import com.didi.travel.p171v2.store.IStoreCallback;
import com.didi.travel.psnger.model.response.ExpoDataResponse;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.travel.psnger.v2.api.store.MultiEstimatePriceNewStoreCallback */
public class MultiEstimatePriceNewStoreCallback implements IStoreCallback<ExpoDataResponse> {

    /* renamed from: a */
    private AtomicInteger f44251a = new AtomicInteger(0);

    public String getStoreApiDetailKey(Object[] objArr, ExpoDataResponse expoDataResponse) {
        return IStoreCallback.DEFAULT_API_DETAIL_KEY;
    }

    public boolean isValid(Object[] objArr, ExpoDataResponse expoDataResponse) {
        return true;
    }
}
