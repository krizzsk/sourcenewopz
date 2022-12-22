package com.didi.sdk.global.paypal.model.bean;

import com.google.gson.annotations.SerializedName;

public class PayPalSignCancelResult extends BaseResult {
    @SerializedName("button_title")
    public String buttonTitle = "";
    @SerializedName("layer_msg")
    public String content = "";
    @SerializedName("default_flag")
    public int defaultFlag = 0;
    @SerializedName("hint_msg")
    public String hingMsg;
    @SerializedName("notice_msg")
    public String notice_msg = "";
    @SerializedName("layer_title")
    public String title = "";
}
