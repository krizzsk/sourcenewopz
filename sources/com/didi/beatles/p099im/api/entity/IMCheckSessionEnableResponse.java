package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMCheckSessionEnableResponse */
public class IMCheckSessionEnableResponse extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMCheckSessionEnableResponse$Body */
    public static class Body implements Serializable {
        public SessionEnableInfo[] info;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMCheckSessionEnableResponse$SessionEnableInfo */
    public static class SessionEnableInfo implements Serializable {
        public int enable;
        public long sid;
    }
}
