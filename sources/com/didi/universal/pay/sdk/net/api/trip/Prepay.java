package com.didi.universal.pay.sdk.net.api.trip;

import com.didi.universal.pay.sdk.net.api.Api;
import java.io.Serializable;

@Api(name = "prePay")
public class Prepay implements Serializable {
    public String app_scheme;
    public String appid;
    public int biz_pay_type;
    public String coupon_id;
    public int has_deduction;
    public String monthly_card_id;
    public String out_token;
    public String out_trade_id;
    public String pay_channel;
    public String pay_channels;
    public String session_id;
}
