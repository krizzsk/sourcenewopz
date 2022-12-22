package com.didi.beatles.p099im.plugin.robot.net.request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.plugin.robot.net.request.IMSendRobotMessageContent */
public class IMSendRobotMessageContent implements Serializable {
    @SerializedName("card_img")
    public String cardImg;
    @SerializedName("is_anon")
    public int isAnon;
    @SerializedName("order_id")
    public String orderId;
    @SerializedName("praise_id")
    public String praiseId;
    @SerializedName("robot_id")
    public String robotId;
    @SerializedName("share_btn")
    public String shareBtnText;
    @SerializedName("share_url")
    public String shareUrl;
    @SerializedName("text")
    public String text;
    @SerializedName("title")
    public String title;
    @SerializedName("voice")
    public String voice;
}
