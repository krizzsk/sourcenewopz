package com.didi.beatles.p099im.plugin.robot;

import android.content.Context;
import android.view.View;
import com.didi.beatles.p099im.protocol.host.IMTabInvokeEnv;
import com.didi.beatles.p099im.protocol.model.IMExtendActionItem;
import com.didi.beatles.p099im.protocol.model.IMTabActionItem;
import com.didi.beatles.p099im.protocol.plugin.IMPluginService;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;

@ServiceProvider(alias = "3", value = {IMPluginService.class})
/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotPluginService */
public class IMRobotPluginService implements IMPluginService {

    /* renamed from: a */
    private static final String f9516a = IMRobotPluginService.class.getSimpleName();

    public int getPluginId() {
        return 3;
    }

    public String getMessageBracket(Context context) {
        return context.getString(R.string.im_plugin_robot_bracket);
    }

    public IMExtendActionItem getExtendActionItem(Context context) {
        return new IMRobotActionItem(context);
    }

    public IMTabActionItem getTabActionItem(Context context, IMTabInvokeEnv iMTabInvokeEnv) {
        return new IMRobotTabActionItem(context, iMTabInvokeEnv);
    }

    public Class<? extends View> getMessageViewClazz() {
        return IMRobotMessageView.class;
    }
}
