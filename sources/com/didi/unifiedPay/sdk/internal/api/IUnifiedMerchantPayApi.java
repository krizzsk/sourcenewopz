package com.didi.unifiedPay.sdk.internal.api;

import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchantcore.model.DPayRequest;
import org.json.JSONObject;

public interface IUnifiedMerchantPayApi {
    void setDPayRequest(DPayRequest dPayRequest);

    void setExtraParam(JSONObject jSONObject);

    void setRequestType(MerchantRequestType merchantRequestType);
}
