package com.didi.beatles.p099im.plugin.robot.net.request;

import com.didi.beatles.p099im.api.entity.IMBaseRequest;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.plugin.robot.net.request.IMRobotPraiseListRequest */
public class IMRobotPraiseListRequest extends IMBaseRequest {
    @SerializedName("body")
    public Body body;

    public IMRobotPraiseListRequest(int i, String str, long j, String str2) {
        super(22, i);
        this.body = new Body(str, j, str2);
    }

    /* renamed from: com.didi.beatles.im.plugin.robot.net.request.IMRobotPraiseListRequest$Body */
    public static class Body implements Serializable {
        @SerializedName("oid")
        public String orderId;
        @SerializedName("robot_id")
        public String robotId;
        @SerializedName("sid")
        public long sessionId;

        public Body(String str, long j, String str2) {
            this.robotId = str;
            this.sessionId = j;
            this.orderId = str2;
        }
    }
}
