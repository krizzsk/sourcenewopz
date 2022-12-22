package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;

public class OfflinePayStatus {
    @SerializedName("third_party_params")
    public String offline_pay_params;
    @SerializedName("pay_channel")
    public int pay_channel;
    @SerializedName("result_type")
    public int resultType;

    public PrepayInfo transToPrepayInfo() {
        PrepayInfo prepayInfo = new PrepayInfo();
        prepayInfo.resultType = this.resultType;
        prepayInfo.pay_channel = this.pay_channel;
        prepayInfo.offline_pay_params = this.offline_pay_params;
        return prepayInfo;
    }
}
