package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMDeleteSessionRequest */
public class IMDeleteSessionRequest extends IMBaseRequest {
    public Body body = new Body();

    /* renamed from: com.didi.beatles.im.api.entity.IMDeleteSessionRequest$Body */
    public static class Body implements Serializable {
        public long sid;
    }

    public IMDeleteSessionRequest() {
        super(6);
    }
}
