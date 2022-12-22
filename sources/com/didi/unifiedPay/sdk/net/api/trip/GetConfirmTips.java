package com.didi.unifiedPay.sdk.net.api.trip;

import com.didi.unifiedPay.sdk.net.api.Api;

@Api(name = "getConfirmInfo")
public class GetConfirmTips {
    public int channel_id;
    public String currency;
    public long total_fee;
}
