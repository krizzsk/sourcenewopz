package com.didi.beatles.p099im.plugin.robot.net.request;

import com.didi.beatles.p099im.api.entity.IMBaseRequest;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.plugin.robot.net.request.IMRobotUnlockRobotRequest */
public class IMRobotUnlockRobotRequest extends IMBaseRequest {
    @SerializedName("body")
    public Body body;

    public IMRobotUnlockRobotRequest(int i, String str) {
        super(23, i);
        this.body = new Body(str);
    }

    /* renamed from: com.didi.beatles.im.plugin.robot.net.request.IMRobotUnlockRobotRequest$Body */
    public static class Body implements Serializable {
        @SerializedName("robot_id")
        public String robotId;

        public Body(String str) {
            this.robotId = str;
        }
    }
}
