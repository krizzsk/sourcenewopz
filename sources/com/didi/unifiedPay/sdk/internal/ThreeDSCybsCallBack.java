package com.didi.unifiedPay.sdk.internal;

import global.didi.pay.threeds.model.Cybs3DSModel;

public interface ThreeDSCybsCallBack {
    void onCybsThreeDSActionHandle(Cybs3DSModel cybs3DSModel);
}
