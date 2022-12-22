package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest */
public class IMSyncSessionStatusRequest extends IMBaseRequest {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body */
    public static class Body implements Serializable {
        public String city_id;
        public String ext_info;
        public int from;
        public long last_time;
        public String new_srt;
        public long oid;
        public int ostate;
        public String payload;
        public String peer_img;
        public String peer_nick;
        public String peer_nick_en;
        public long peer_uid;
        public long rid;
        @SerializedName("guide_id")
        public String robotGuideId;
        public String self_img;
        public String self_nick;
        public String self_nick_en;
        public long sid;
        public String soid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IMSyncSessionStatusRequest(long r5, long r7, long r9, int r11, int r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, long r16, java.lang.String r18, java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, long r26, java.lang.String r28) {
        /*
            r4 = this;
            r0 = r4
            r1 = r20
            r2 = 12
            r4.<init>(r2, r1)
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r2 = new com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body
            r2.<init>()
            r0.body = r2
            r0.product = r1
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r7
            r1.oid = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r9
            r1.rid = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r11
            r1.ostate = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r12
            r1.from = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r5
            r1.sid = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r13
            r1.new_srt = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r14
            r1.self_nick = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r15
            r1.self_img = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r16
            r1.peer_uid = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r18
            r1.peer_nick = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r19
            r1.peer_img = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r21
            r1.soid = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r22
            r1.city_id = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r23
            r1.self_nick_en = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r24
            r1.peer_nick_en = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r25
            r1.payload = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r26
            r1.last_time = r2
            com.didi.beatles.im.api.entity.IMSyncSessionStatusRequest$Body r1 = r0.body
            r2 = r28
            r1.ext_info = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.api.entity.IMSyncSessionStatusRequest.<init>(long, long, long, int, int, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IMSyncSessionStatusRequest(long j, long j2, long j3, long j4, int i, int i2, int i3, String str, long j5, String str2) {
        super(12, i3);
        int i4 = i3;
        Body body2 = new Body();
        this.body = body2;
        body2.oid = j3;
        this.body.rid = j4;
        this.body.peer_uid = j2;
        this.body.ostate = i;
        this.body.from = i2;
        this.body.sid = j;
        this.body.payload = str;
        this.body.last_time = j5;
        this.body.ext_info = str2;
    }

    public void setRobotGuideId(String str) {
        Body body2 = this.body;
        if (body2 != null) {
            body2.robotGuideId = str;
        }
    }
}
