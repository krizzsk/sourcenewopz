package com.didi.unifiedPay.sdk.net.api.merchant;

import com.didi.unifiedPay.sdk.net.api.Api;
import global.didi.pay.threeds.utils.ThreeDSUtils;

@Api(name = "prePay")
public class MerchantPrepay {
    public String activity_id;
    public String coupon_id;
    public String installment_number;
    public String merchant_wsgenv;
    public String need_3ds = String.valueOf(ThreeDSUtils.needThreeds());
    public String os_type = "Android";
    public String out_trade_id;
    public String password_token;
    public String pay_channel;
    public String pay_channels;
    public String three_ds_v2;
    public String threeds_callback_scheme;
}
