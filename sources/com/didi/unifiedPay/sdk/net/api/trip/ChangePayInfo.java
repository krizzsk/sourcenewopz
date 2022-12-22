package com.didi.unifiedPay.sdk.net.api.trip;

import com.didi.unifiedPay.sdk.net.api.Api;

@Api(name = "changePayInfo")
public class ChangePayInfo {
    public static final int CHANGE_PAY_TYPE = 1;
    public static final int CHANGE_PAY_TYPE_ADD = 3;
    public static final int CHANGE_PAY_TYPE_DELETE = 4;
    public static final int CHANGE_PAY_TYPE_INSTALLMENT = 6;
    public static final int CHANGE_PAY_TYPE_MARKETING = 5;
    public static final int CHANGE_PAY_TYPE_PAY_FAILED_REFRESH = 7;
    public static final int CHANGE_VOUCHER_TYPE = 2;
    public static final int NO_CHANGE = 0;
    public static final int TYPE_NOT_USE_ENTERPRISE_PAY = 20;
    public static final int TYPE_NO_ENTERPRISE_PAY = 0;
    public static final int TYPE_USE_ENTERPRISE_PAY = 21;
    public String activity_id;
    public int biz_pay_type;
    public int change_type;
    public String coupon_id;
    public String installment_number;
    public String out_trade_id;
    public String pay_channel;
    public String pay_channels;
    public String user_select;
}
