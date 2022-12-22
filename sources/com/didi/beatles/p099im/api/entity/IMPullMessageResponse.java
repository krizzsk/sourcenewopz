package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMPullMessageResponse */
public class IMPullMessageResponse extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMPullMessageResponse$Ack */
    public static class Ack implements Serializable {
        public long mid;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMPullMessageResponse$Body */
    public static class Body implements Serializable {
        public Ack ack;
        public long backfill_uid;
        public List<GroupEntity> group;
        @SerializedName("pull_scene")
        public int pullScene;
        public String recom;
        public long recom_sid;
        public Single single;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMPullMessageResponse$GroupEntity */
    public static class GroupEntity implements Serializable {
        public long lmt;
        public long max_mid;
        public List<IMMessageDown> msgs;
        public long sid;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMPullMessageResponse$Single */
    public static class Single implements Serializable {
        public long max_mid;
        public List<IMMessageDown> msgs;
    }

    public long getAckMid() {
        Body body2 = this.body;
        if (body2 == null || body2.ack == null) {
            return 0;
        }
        return this.body.ack.mid;
    }
}
