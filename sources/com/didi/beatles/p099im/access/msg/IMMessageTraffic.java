package com.didi.beatles.p099im.access.msg;

/* renamed from: com.didi.beatles.im.access.msg.IMMessageTraffic */
public class IMMessageTraffic {
    public final String messageId;
    public final String sessionId;

    public IMMessageTraffic(long j, long j2) {
        this.messageId = j + "";
        this.sessionId = j2 + "";
    }
}
