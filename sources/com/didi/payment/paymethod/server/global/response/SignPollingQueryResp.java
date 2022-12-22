package com.didi.payment.paymethod.server.global.response;

import com.google.gson.annotations.SerializedName;

public class SignPollingQueryResp extends BaseResp {
    public static final int SIGN_FAILED = 2;
    public static final int SIGN_SUCCESS = 1;
    public static final int UNSIGN = 0;
    @SerializedName("hint_msg")
    public String hintMsg;
    @SerializedName("sign_status")
    public int status;
}
