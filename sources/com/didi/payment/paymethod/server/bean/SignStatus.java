package com.didi.payment.paymethod.server.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SignStatus extends BaseResponse {
    public static final int CHANNEL_ALIPAY = 134;
    public static final int CHANNEL_BANK = 136;
    public static final int CHANNEL_CASH = 153;
    public static final int CHANNEL_CREDIT_PAY = 161;
    public static final int CHANNEL_DIDI_PAY = 169;
    public static final int CHANNEL_GLOBAL_ALIPAY = 171;
    public static final int CHANNEL_GLOBAL_WEIXIN = 170;
    public static final int CHANNEL_INTERNATIONAL_CREDIT_CARD = 150;
    public static final int CHANNEL_PAYPAL = 152;
    public static final int CHANNEL_QQ = 144;
    public static final int CHANNEL_WEIXIN = 133;
    public static final int CHANNEL_ZHIFUTONG = 162;
    public static final int SIGN_BIND = 4;
    public static final int SIGN_FAILED = 2;
    public static final int SIGN_SUCC = 1;
    public static final int UNSIGN = 0;
    @SerializedName("dialog_msg")
    public String dialogMsg;
    @SerializedName("dialog_title")
    public String dialogTitle;
    @SerializedName("hint_msg")
    public String hintMsg;
    @SerializedName("sign_data")
    public List<SignInfo> signInfoArrayList;
    @SerializedName("sign_status")
    public int status;
}
