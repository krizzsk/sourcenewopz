package com.didi.sdk.global.paypal.model.bean;

import com.google.gson.annotations.SerializedName;

public class PayPalSignResult extends BaseResult {
    @SerializedName("back_url")
    public String backUrl;
    @SerializedName("cancel_url")
    public String cancelUrl;
    @SerializedName("card_index")
    public String cardIndex;
    @SerializedName("android_download_url")
    public String downLoadUrl;
    @SerializedName("sign_url_new")
    public String newSginUrl;
    @SerializedName("polling_frequency")
    public int pollingFrequency = 5000;
    @SerializedName("polling_times")
    public int pollingTimes = 10;
    @SerializedName("sign_param")
    public String signParam;
    @SerializedName("sign_url")
    public String signUrl;
}
