package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMCheckSessionEnableRequest */
public class IMCheckSessionEnableRequest extends IMBaseRequest {
    public Body body = new Body();

    /* renamed from: com.didi.beatles.im.api.entity.IMCheckSessionEnableRequest$Body */
    public static class Body implements Serializable {
        public long[] sids;
    }

    public IMCheckSessionEnableRequest() {
        super(15);
    }

    public void setSid(long j) {
        long[] jArr = {j};
        this.body.sids = jArr;
    }

    public void setSids(long[] jArr) {
        this.body.sids = jArr;
    }
}
