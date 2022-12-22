package com.didi.beatles.p099im.plugin;

import com.didi.beatles.p099im.protocol.plugin.IMPluginService;
import com.didi.beatles.p099im.protocol.service.IMSpiServiceProvider;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.plugin.IMPluginFactory */
public final class IMPluginFactory {

    /* renamed from: a */
    private static final String f9472a = IMPluginFactory.class.getSimpleName();

    public static IMPluginService getPlugin(int i) {
        if (i <= 0) {
            return null;
        }
        IMPluginService iMPluginService = (IMPluginService) IMSpiServiceProvider.getService(IMPluginService.class, String.valueOf(i));
        IMLog.m6631d(f9472a, C4234I.m6591t("[getPlugin] pluginId=", Integer.valueOf(i), " |plugin=", iMPluginService));
        return iMPluginService;
    }
}
