package com.didi.beatles.p099im.plugin.street;

import com.didi.beatles.p099im.protocol.host.IMHostLoader;
import com.didi.beatles.p099im.protocol.host.IMHostService;

/* renamed from: com.didi.beatles.im.plugin.street.IMStreetBridge */
public class IMStreetBridge {
    public static boolean sendStreetMessage(int i) {
        return IMHostLoader.getHost().invoke(IMHostService.ACTION_SEND_STREET_MESSAGE, Integer.valueOf(i));
    }
}
