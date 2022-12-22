package com.didi.beatles.p099im.plugin.robot.net.callback;

import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotGetConfigureResponse;

/* renamed from: com.didi.beatles.im.plugin.robot.net.callback.IMRobotConfigureCallback */
public interface IMRobotConfigureCallback {
    void onFailed();

    void onSucceed(IMRobotGetConfigureResponse.Body body);
}
