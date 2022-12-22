package com.didi.unifiedPay.sdk.net.api.nontrip;

import com.didi.unifiedPay.sdk.net.api.Api;

@Api(name = "getPayInfo")
public class NonTripGetPayInfo {
    public String biz_content;
    public String out_trade_id;
    public String sign;
    public String sign_type;
}
