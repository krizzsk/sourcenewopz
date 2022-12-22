package com.didi.travel.psnger.p170v2.session;

import java.io.Serializable;

/* renamed from: com.didi.travel.psnger.v2.session.SessionEvent */
public class SessionEvent implements Serializable {
    private final int mPageId;
    private final String mSessionKey;
    private final String mSessionTag;

    public SessionEvent(int i, String str, String str2) {
        this.mPageId = i;
        this.mSessionTag = str;
        this.mSessionKey = str2;
    }

    public int getPageId() {
        return this.mPageId;
    }

    public String getSessionTag() {
        return this.mSessionTag;
    }

    public String getSessionKey() {
        return this.mSessionKey;
    }

    public String toString() {
        return "SessionEvent{mPageId=" + this.mPageId + ", mSessionKey='" + this.mSessionKey + '}';
    }
}
