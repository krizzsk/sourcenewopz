package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMSysAudioMsgBody */
public class IMSysAudioMsgBody implements Serializable {
    @SerializedName("background")
    public String bgImg;
    @SerializedName("icon")
    public String cardImg;
    @SerializedName("content")
    public String hint;
    @SerializedName("title")
    public String text;
    @SerializedName("tcolor")
    public String titleColor;
    @SerializedName("voice_url")
    public String voice;
}
