package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMPullMessageRequest */
public class IMPullMessageRequest extends IMBaseRequest {
    private static String LAST_LAT = "";
    private Body body = new Body();
    private final boolean isNeedSync;
    public boolean isPollingRequest;

    /* renamed from: com.didi.beatles.im.api.entity.IMPullMessageRequest$Body */
    public static class Body implements Serializable {
        public Ack ack;
        public int cnt;
        public Group group;
        @SerializedName("notify_authority")
        public int notifyAuthority;
        @SerializedName("pull_scene")
        public int pullScene;
        public long sid;
        public Single single = new Single();
        public int sync;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMPullMessageRequest$Group */
    public static class Group implements Serializable {
        public long last_mid;
        public long sid;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMPullMessageRequest$Single */
    public static class Single implements Serializable {
        public long last_mid;
    }

    public IMPullMessageRequest(int i, int i2) {
        super(1, i);
        if (!String.valueOf(LAST_LAT).equals(this.lag)) {
            LAST_LAT = this.lag;
            this.isNeedSync = true;
        } else {
            this.isNeedSync = false;
        }
        this.body.sync = this.isNeedSync ? 1 : 0;
        this.body.pullScene = i2;
    }

    public void singleLastMid(long j) {
        this.body.single.last_mid = j;
    }

    public void setSid(long j) {
        this.body.sid = j;
    }

    public void group(long j, long j2) {
        this.body.group.sid = j;
        this.body.group.last_mid = j2;
    }

    public void setAckSid(long j) {
        this.body.ack = new Ack(j);
    }

    public void isSync(int i) {
        Body body2 = this.body;
        if (this.isNeedSync) {
            i = 1;
        }
        body2.sync = i;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMPullMessageRequest$Ack */
    public static class Ack implements Serializable {
        public long sid;

        public Ack(long j) {
            this.sid = j;
        }
    }

    public void setNotifyAuthority(boolean z) {
        this.body.notifyAuthority = z ? 1 : 0;
    }

    public boolean isPollingRequest() {
        return this.isPollingRequest;
    }
}
