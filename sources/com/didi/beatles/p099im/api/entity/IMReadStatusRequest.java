package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMReadStatusRequest */
public class IMReadStatusRequest extends IMBaseRequest {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMReadStatusRequest$Body */
    public static class Body implements Serializable {
        public List<Long> mids;
        public long peer_uid;
        public long sid;
    }

    public IMReadStatusRequest(int i, long j, long j2, List<Long> list) {
        super(i);
        Body body2 = new Body();
        this.body = body2;
        body2.sid = j;
        this.body.mids = list;
        this.body.peer_uid = j2;
    }
}
