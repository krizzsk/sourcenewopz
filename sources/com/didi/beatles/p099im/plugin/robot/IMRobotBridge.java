package com.didi.beatles.p099im.plugin.robot;

import android.text.TextUtils;
import com.didi.beatles.p099im.plugin.robot.net.request.IMSendRobotMessageContent;
import com.didi.beatles.p099im.protocol.host.IMHostLoader;
import com.didi.beatles.p099im.protocol.host.IMHostService;
import com.didi.beatles.p099im.protocol.model.IMPluginMsgWrapper;
import com.didi.beatles.p099im.utils.IMJsonUtil;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotBridge */
public final class IMRobotBridge {
    private IMRobotBridge() {
    }

    public static boolean navigation(String str) {
        return IMHostLoader.getHost().invoke("navigation", 3, str);
    }

    public static boolean sendPluginMessage(IMSendRobotMessageContent iMSendRobotMessageContent, String str, int i) {
        String jsonFromObject = IMJsonUtil.jsonFromObject(iMSendRobotMessageContent);
        if (TextUtils.isEmpty(jsonFromObject)) {
            return false;
        }
        IMPluginMsgWrapper iMPluginMsgWrapper = new IMPluginMsgWrapper(i, jsonFromObject, str);
        return IMHostLoader.getHost().invoke(IMHostService.ACTION_SEND_PLUGIN_MESSAGE, 3, iMPluginMsgWrapper);
    }
}
