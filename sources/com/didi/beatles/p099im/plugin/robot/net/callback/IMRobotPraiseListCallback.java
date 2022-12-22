package com.didi.beatles.p099im.plugin.robot.net.callback;

import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotPraise;
import java.util.List;

/* renamed from: com.didi.beatles.im.plugin.robot.net.callback.IMRobotPraiseListCallback */
public interface IMRobotPraiseListCallback {
    void onFailed();

    void onSucceed(List<IMRobotPraise> list);
}
