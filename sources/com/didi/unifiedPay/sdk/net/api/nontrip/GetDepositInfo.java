package com.didi.unifiedPay.sdk.net.api.nontrip;

import com.didi.unifiedPay.sdk.net.api.Api;

@Api(name = "getDepositInfo")
public class GetDepositInfo {
    public String biz_content;
    public String sign;
    public String sign_type;
}
