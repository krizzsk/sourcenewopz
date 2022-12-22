package com.didi.beatles.p099im.plugin.robot.net.callback;

import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotUnlockRobotResponse;

/* renamed from: com.didi.beatles.im.plugin.robot.net.callback.IMRobotUnlockCallback */
public interface IMRobotUnlockCallback {
    void onFailed();

    void onSucceed(IMRobotUnlockRobotResponse.Body body);
}
