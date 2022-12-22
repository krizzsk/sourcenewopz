package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMDeleteSessionResponse */
public class IMDeleteSessionResponse extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMDeleteSessionResponse$Body */
    public static class Body implements Serializable {
        public long sid;
    }
}
