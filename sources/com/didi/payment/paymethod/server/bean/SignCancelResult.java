package com.didi.payment.paymethod.server.bean;

import com.google.gson.annotations.SerializedName;

public class SignCancelResult extends BaseResponse {
    @SerializedName("hint_msg")
    public String hintMsg;
}
