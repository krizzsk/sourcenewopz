package com.didi.beatles.p099im.plugin.robot.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotMessageContent */
public class IMRobotMessageContent implements Serializable {
    @SerializedName("after_trip_voice")
    public String afterTripVoiceFid;
    @SerializedName("card_img")
    public String cardImg;
    @SerializedName("is_anon")
    public int isAnon;
    @SerializedName("on_trip_voice")
    public String onTripVoiceFid;
    @SerializedName("order_id")
    public String orderId;
    @SerializedName("praise_id")
    public String praiseId;
    @SerializedName("share_btn")
    public String shareBtn;
    @SerializedName("share_url")
    public String shareUrl;
    @SerializedName("text")
    public String text;
    @SerializedName("title")
    public String title;
    @SerializedName("voice")
    public String voice;

    public boolean isAnon() {
        return this.isAnon == 1;
    }
}
