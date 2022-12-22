package com.didi.beatles.p099im.access.msg;

/* renamed from: com.didi.beatles.im.access.msg.IMMessageFilter */
public class IMMessageFilter {
    public String messageId;
    public String sessionId;
    public String userId;

    public IMMessageFilter(String str, String str2, String str3) {
        this.sessionId = str;
        this.messageId = str2;
        this.userId = str3;
    }

    public int hashCode() {
        return String.valueOf(this.sessionId + "-" + this.messageId + "-" + this.userId).hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof IMMessageFilter) {
            IMMessageFilter iMMessageFilter = (IMMessageFilter) obj;
            return String.valueOf(this.sessionId).equals(iMMessageFilter.sessionId) && String.valueOf(this.messageId).equals(iMMessageFilter.messageId) && String.valueOf(this.userId).equals(iMMessageFilter.userId);
        }
    }
}
