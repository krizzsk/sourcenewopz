package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMCreateSessionRequest */
public class IMCreateSessionRequest extends IMBaseRequest {
    public Body body = new Body();

    /* renamed from: com.didi.beatles.im.api.entity.IMCreateSessionRequest$Body */
    public static class Body implements Serializable {
        public int oid;
        public long[] uids;
    }

    public IMCreateSessionRequest() {
        super(7);
    }

    public void singleChat(int i, long j, long j2) {
        long[] jArr = {j, j2};
        this.body.uids = jArr;
        this.body.oid = i;
    }

    public void multiChat(int i, long[] jArr) {
        this.body.uids = jArr;
        this.body.oid = i;
    }
}
