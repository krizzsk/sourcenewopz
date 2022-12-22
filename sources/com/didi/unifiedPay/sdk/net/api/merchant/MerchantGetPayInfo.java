package com.didi.unifiedPay.sdk.net.api.merchant;

import com.didi.unifiedPay.sdk.net.api.Api;

@Api(name = "getPayInfo")
public class MerchantGetPayInfo {
    public String app_id;
    public String from_type;
    public String merchant_id;
    public String merchant_order_id;
    public String nonce_str;
    public String out_trade_id;
    public String pay_order_id;
    public String sign;
    public String timestamp;
    public String version;
}
