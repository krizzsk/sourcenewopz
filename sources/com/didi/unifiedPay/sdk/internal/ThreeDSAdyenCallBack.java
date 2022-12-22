package com.didi.unifiedPay.sdk.internal;

import global.didi.pay.threeds.model.Adyen3DSModel;

public interface ThreeDSAdyenCallBack {
    void onAdyenThreeDSActionHandle(Adyen3DSModel adyen3DSModel);
}
