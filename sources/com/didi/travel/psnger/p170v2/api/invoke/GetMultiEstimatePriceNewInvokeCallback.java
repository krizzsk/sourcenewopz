package com.didi.travel.psnger.p170v2.api.invoke;

import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.bff.BffV2InvokeCallback;
import com.didi.travel.psnger.model.response.ExpoDataResponse;

/* renamed from: com.didi.travel.psnger.v2.api.invoke.GetMultiEstimatePriceNewInvokeCallback */
public class GetMultiEstimatePriceNewInvokeCallback extends BffV2InvokeCallback<ExpoDataResponse> {
    public GetMultiEstimatePriceNewInvokeCallback(Api api, Object[] objArr, BffResponseListener<ExpoDataResponse> bffResponseListener) {
        super(api, objArr, bffResponseListener);
    }
}
