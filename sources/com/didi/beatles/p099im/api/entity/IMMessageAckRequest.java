package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMMessageAckRequest */
public class IMMessageAckRequest extends IMBaseRequest {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMMessageAckRequest$Body */
    public static class Body implements Serializable {
        public long mid;
        public long peer_uid;
        public long sid;
    }

    public IMMessageAckRequest(long j, long j2, long j3) {
        super(9);
        Body body2 = new Body();
        this.body = body2;
        body2.sid = j;
        this.body.mid = j2;
        this.body.peer_uid = j3;
    }
}
