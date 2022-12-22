package com.didi.beatles.p099im.plugin.robot.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise */
public class IMRobotPraise implements Serializable {
    public static final int TYPE_NONE = 0;
    public static final int TYPE_SEND = 1;
    public static final int TYPE_SHARE = 2;
    public transient String btnText;
    @SerializedName("praise_id")
    public String praiseId;
    public transient String robotId;
    @SerializedName("text")
    public String text;
    @SerializedName("tracking_data")
    public String trackingData;
    @SerializedName("type")
    public int type;
    @SerializedName("voice")
    public String voice;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotPraise$Type */
    public @interface Type {
    }
}
