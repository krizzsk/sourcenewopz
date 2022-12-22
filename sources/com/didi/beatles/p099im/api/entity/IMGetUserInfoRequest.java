package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMGetUserInfoRequest */
public class IMGetUserInfoRequest extends IMBaseRequest {
    public Body body = new Body();

    /* renamed from: com.didi.beatles.im.api.entity.IMGetUserInfoRequest$Body */
    public static class Body implements Serializable {
        public long[] uids;
    }

    public IMGetUserInfoRequest() {
        super(8);
    }

    public void setUid(long j) {
        long[] jArr = {j};
        this.body.uids = jArr;
    }

    public void setUids(long[] jArr) {
        this.body.uids = jArr;
    }
}
