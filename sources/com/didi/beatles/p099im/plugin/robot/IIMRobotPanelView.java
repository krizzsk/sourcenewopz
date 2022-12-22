package com.didi.beatles.p099im.plugin.robot;

import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotGetConfigureResponse;
import com.didi.beatles.p099im.plugin.robot.net.response.IMRobotPraise;

/* renamed from: com.didi.beatles.im.plugin.robot.IIMRobotPanelView */
public interface IIMRobotPanelView {
    void onLoadConfigureFail();

    void onLoadConfigureSuccess(IMRobotGetConfigureResponse.Body body);

    void onLoadPraiseListSuccess();

    void onLoading();

    void onUnlockRobotFailed();

    void onUnlockRobotSuccess(IMRobotGetConfigureResponse.Robot robot);

    void onUpdatePraise(IMRobotGetConfigureResponse.Robot robot, IMRobotPraise iMRobotPraise, boolean z);
}
