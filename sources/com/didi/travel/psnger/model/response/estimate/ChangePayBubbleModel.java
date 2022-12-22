package com.didi.travel.psnger.model.response.estimate;

import com.google.gson.annotations.SerializedName;

public class ChangePayBubbleModel {
    @SerializedName("action_type")
    public int actionType;
    @SerializedName("discount")
    public String discount;
    @SerializedName("discount_msg")
    public String disountMsg;
    @SerializedName("pay_tag")
    public int payTag;
    @SerializedName("style")
    public int style;
    @SerializedName("text")
    public String text;
}
