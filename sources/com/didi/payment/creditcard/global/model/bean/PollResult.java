package com.didi.payment.creditcard.global.model.bean;

import com.google.gson.annotations.SerializedName;

public class PollResult extends BaseResult {
    @SerializedName("dialog_msg")
    public String dialog_msg;
    @SerializedName("dialog_title")
    public String dialog_title;
    @SerializedName("hint_msg")
    public String hint_msg;
    @SerializedName("layer_msg")
    public String layer_msg;
    @SerializedName("layer_title")
    public String newSginUrl;
    @SerializedName("notice_msg")
    public String notice_msg;
    @SerializedName("sign_status")
    public int sign_status;
    @SerializedName("threeDSAction")
    public String threeDSAction;
    @SerializedName("threeDSShopper")
    public String threeDSShopper;
    @SerializedName("threeDSVendor")
    public String threeDSVendor;
}
