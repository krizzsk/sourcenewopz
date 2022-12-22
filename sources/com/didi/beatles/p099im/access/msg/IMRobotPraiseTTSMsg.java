package com.didi.beatles.p099im.access.msg;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.access.msg.IMRobotPraiseTTSMsg */
public class IMRobotPraiseTTSMsg implements Serializable {
    public String afterTripVoiceUrl;
    public long messageId;
    public String onTripVoiceUrl;
    public String orderId;
    public String praiseId;

    public IMRobotPraiseTTSMsg(long j, String str, String str2, String str3, String str4) {
        this.messageId = j;
        this.praiseId = str;
        this.onTripVoiceUrl = str2;
        this.afterTripVoiceUrl = str3;
        this.orderId = str4;
    }
}
