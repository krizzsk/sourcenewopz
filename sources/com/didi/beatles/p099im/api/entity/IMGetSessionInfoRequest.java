package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMGetSessionInfoRequest */
public class IMGetSessionInfoRequest extends IMBaseRequest {
    public Body body = new Body();

    /* renamed from: com.didi.beatles.im.api.entity.IMGetSessionInfoRequest$Body */
    public static class Body implements Serializable {
        long[] peer_uid;
        public long[] sids;
    }

    public IMGetSessionInfoRequest(int i) {
        super(5, i);
    }

    public void setSid(long j) {
        long[] jArr = {j};
        this.body.sids = jArr;
    }

    public void setSids(long[] jArr) {
        this.body.sids = jArr;
    }

    public void setUids(long[] jArr) {
        this.body.peer_uid = jArr;
    }
}
