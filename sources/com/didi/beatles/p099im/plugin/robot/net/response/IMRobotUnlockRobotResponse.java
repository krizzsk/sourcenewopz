package com.didi.beatles.p099im.plugin.robot.net.response;

import com.didi.beatles.p099im.api.entity.IMBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotUnlockRobotResponse */
public class IMRobotUnlockRobotResponse extends IMBaseResponse {
    @SerializedName("body")
    public Body body;

    /* renamed from: com.didi.beatles.im.plugin.robot.net.response.IMRobotUnlockRobotResponse$Body */
    public static class Body implements Serializable {
        @SerializedName("praise_list")
        public List<IMRobotPraise> praiseList;
    }
}
