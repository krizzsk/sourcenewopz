package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMCloseSessionRequest */
public class IMCloseSessionRequest extends IMBaseRequest {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMCloseSessionRequest$Body */
    public static class Body implements Serializable {
        public long peer_uid;
        public long sid;
    }

    public IMCloseSessionRequest(long j, long j2) {
        super(13);
        Body body2 = new Body();
        this.body = body2;
        body2.sid = j;
        this.body.peer_uid = j2;
    }
}
