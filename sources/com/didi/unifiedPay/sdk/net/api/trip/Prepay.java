package com.didi.unifiedPay.sdk.net.api.trip;

import com.didi.unifiedPay.sdk.net.api.Api;
import global.didi.pay.threeds.utils.ThreeDSUtils;

@Api(name = "prePay")
public class Prepay {
    public static final int TYPE_NOT_USE_ENTERPRISE_PAY = 20;
    public static final int TYPE_NO_ENTERPRISE_PAY = 0;
    public static final int TYPE_USE_ENTERPRISE_PAY = 21;
    public String activity_id;
    public int biz_pay_type;
    public String coupon_id;
    public String installment_number;
    public String need_3ds = String.valueOf(ThreeDSUtils.needThreeds());
    public String os_type = "Android";
    public String out_trade_id;
    public String password_token;
    public String pay_channel;
    public String pay_channels;
    public String redirect_scheme;
    public String three_ds_v2;
    public String threeds_callback_scheme;
}
