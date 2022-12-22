package com.didi.payment.paymethod.server.global.response;

import com.google.gson.annotations.SerializedName;

public class SignCancelResp extends BaseResp {
    @SerializedName("hint_msg")
    public String hingMsg;
}
