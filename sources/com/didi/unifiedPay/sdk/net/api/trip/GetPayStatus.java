package com.didi.unifiedPay.sdk.net.api.trip;

import com.didi.unifiedPay.sdk.net.api.Api;

@Api(name = "getPayStatus")
public class GetPayStatus {
    public String out_token;
    public String out_trade_id;
}
