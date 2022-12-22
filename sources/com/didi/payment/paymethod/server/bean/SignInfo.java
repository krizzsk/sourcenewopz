package com.didi.payment.paymethod.server.bean;

import com.google.gson.annotations.SerializedName;

public class SignInfo extends BaseResponse {
    @SerializedName("activity_msg")
    public String activityMsg;
    @SerializedName("button_msg")
    public String buttonMsg;
    @SerializedName("channel_id")
    public int channelId;
    @SerializedName("notice_msg")
    public String noticeMsg;
}
