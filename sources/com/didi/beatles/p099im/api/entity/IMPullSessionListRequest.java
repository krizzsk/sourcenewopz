package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMPullSessionListRequest */
public class IMPullSessionListRequest extends IMBaseRequest {
    public Body body = new Body();

    /* renamed from: com.didi.beatles.im.api.entity.IMPullSessionListRequest$Body */
    public static class Body implements Serializable {
        public int cnt;
        public Single single = new Single();
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMPullSessionListRequest$Single */
    public static class Single implements Serializable {
        public long last_mid;
    }

    public IMPullSessionListRequest() {
        super(2);
    }

    public void singleLastMid(long j) {
        this.body.single.last_mid = j;
    }

    public void pageCount(int i) {
        this.body.cnt = i;
    }
}
