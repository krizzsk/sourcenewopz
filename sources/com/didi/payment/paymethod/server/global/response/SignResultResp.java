package com.didi.payment.paymethod.server.global.response;

import com.google.gson.annotations.SerializedName;

public class SignResultResp extends BaseResp {
    @SerializedName("back_url")
    public String backUrl;
    @SerializedName("cancel_url")
    public String cancelUrl;
    @SerializedName("sign_url_new")
    public String newSignUrl;
    @SerializedName("polling_frequency")
    public int pollingFrequency = 5000;
    @SerializedName("polling_times")
    public int pollingTimes = 10;
    @SerializedName("sign_url")
    public String signUrl;
}
