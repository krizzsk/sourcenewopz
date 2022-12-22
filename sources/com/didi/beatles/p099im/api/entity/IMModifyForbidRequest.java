package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMModifyForbidRequest */
public class IMModifyForbidRequest extends IMBaseRequest {
    public Body body;

    public static IMModifyForbidRequest newForbidGroupRequest(long j, int i) {
        return new IMModifyForbidRequest(j, 0, 1, i);
    }

    public static IMModifyForbidRequest newForbidHelperRequest(long j, int i) {
        return new IMModifyForbidRequest(0, j, 2, i);
    }

    private IMModifyForbidRequest(long j, long j2, int i, int i2) {
        super(311);
        this.body = new Body(j, j2, i, i2);
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMModifyForbidRequest$Body */
    public static class Body implements Serializable {
        public int forbid;
        public long sid;
        public int type;
        public long uid;

        public Body(long j, long j2, int i, int i2) {
            this.sid = j;
            this.uid = j2;
            this.type = i;
            this.forbid = i2;
        }
    }
}
