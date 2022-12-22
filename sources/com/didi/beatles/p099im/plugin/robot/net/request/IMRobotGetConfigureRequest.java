package com.didi.beatles.p099im.plugin.robot.net.request;

import com.didi.beatles.p099im.api.entity.IMBaseRequest;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.plugin.robot.net.request.IMRobotGetConfigureRequest */
public class IMRobotGetConfigureRequest extends IMBaseRequest {
    @SerializedName("body")
    public Body body;

    public IMRobotGetConfigureRequest(int i, long j, String str, String str2) {
        super(21, i);
        this.body = new Body(j, str, str2);
    }

    /* renamed from: com.didi.beatles.im.plugin.robot.net.request.IMRobotGetConfigureRequest$Body */
    private static class Body implements Serializable {
        @SerializedName("oid")
        public String orderId;
        @SerializedName("guide_id")
        public String robotGuideId;
        @SerializedName("sid")
        public long sessionId;

        public Body(long j, String str, String str2) {
            this.sessionId = j;
            this.orderId = str;
            this.robotGuideId = str2;
        }
    }
}
