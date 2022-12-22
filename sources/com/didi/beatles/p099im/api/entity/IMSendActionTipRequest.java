package com.didi.beatles.p099im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMSendActionTipRequest */
public class IMSendActionTipRequest extends IMBaseRequest {
    public static final transient String ACTION_SEND_IMAGE = "send_image";
    public Body body;

    public IMSendActionTipRequest(int i, long j, long j2, String str, int i2) {
        super(20, i);
        this.body = new Body(j, j2, str, i2);
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMSendActionTipRequest$Body */
    public static class Body implements Serializable {
        public String action_id;
        public long send_uid;
        public int times;
        public long to_uid;

        public Body(long j, long j2, String str, int i) {
            this.to_uid = j;
            this.send_uid = j2;
            this.action_id = str;
            this.times = i;
        }
    }
}
