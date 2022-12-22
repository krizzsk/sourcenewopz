package com.didi.beatles.p099im.plugin;

import com.didi.beatles.p099im.event.IMSendAddressEvent;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.plugin.IMHostProxy */
public class IMHostProxy {

    /* renamed from: a */
    private static final String f9467a = IMHostProxy.class.getSimpleName();

    /* renamed from: b */
    private IMPluginSendListener f9468b;

    private IMHostProxy() {
    }

    public static IMHostProxy getInstance() {
        return Holder.INSTANCE;
    }

    public void registerPluginSendListener(IMPluginSendListener iMPluginSendListener) {
        this.f9468b = null;
        this.f9468b = iMPluginSendListener;
    }

    public void unregisterPluginSendListener(IMPluginSendListener iMPluginSendListener) {
        this.f9468b = null;
    }

    public boolean navigation(int i, String str) {
        IMLog.m6631d(f9467a, C4234I.m6591t("[navigation] pluginId=", Integer.valueOf(i), " |scheme=", str));
        IMPluginSendListener iMPluginSendListener = this.f9468b;
        if (iMPluginSendListener == null) {
            IMLog.m6632e(f9467a, "[navigation] failed with NULL listener");
            return false;
        } else if (iMPluginSendListener.getHostContext() == null) {
            IMLog.m6632e(f9467a, "[navigation] failed with NULL context");
            return false;
        } else {
            IMCommonUtil.startUriActivity(this.f9468b.getHostContext(), str);
            return true;
        }
    }

    public boolean sendTextMessage(int i, String str) {
        IMLog.m6631d(f9467a, C4234I.m6591t("[sendTextMessage] -> ", str));
        IMPluginSendListener iMPluginSendListener = this.f9468b;
        if (iMPluginSendListener == null) {
            IMLog.m6632e(f9467a, "[sendTextMessage] failed with NULL listener");
            return false;
        }
        iMPluginSendListener.sendPluginTextMessage(i, str, 65536, (Object) null);
        return true;
    }

    public boolean sendPluginMessage(int i, String str, String str2, int i2) {
        IMLog.m6631d(f9467a, C4234I.m6591t("[sendPluginMessage] content= ", str, " |listText=", str2));
        IMPluginSendListener iMPluginSendListener = this.f9468b;
        if (iMPluginSendListener == null) {
            IMLog.m6632e(f9467a, "[sendPluginMessage] failed with NULL listener");
            return false;
        }
        iMPluginSendListener.sendPluginMessage(i, str, str2, i2);
        return true;
    }

    public boolean sendStreetViewMessage(int i) {
        IMLog.m6631d(f9467a, C4234I.m6591t("[sendStreetViewMessage] pluginId= ", Integer.valueOf(i)));
        IMPluginSendListener iMPluginSendListener = this.f9468b;
        if (iMPluginSendListener == null) {
            IMLog.m6632e(f9467a, "[sendStreetViewMessage] failed with NULL listener");
            return false;
        }
        iMPluginSendListener.sendStreetViewMessage(i);
        return true;
    }

    public boolean sendLocationMessage(IMSendAddressEvent iMSendAddressEvent, boolean z) {
        String str = f9467a;
        StringBuilder sb = new StringBuilder();
        sb.append(C4234I.m6591t("[sendLocationMessage] sendAddressEvent=" + iMSendAddressEvent.toString()));
        sb.append("needDialog");
        sb.append(z);
        IMLog.m6631d(str, sb.toString());
        IMPluginSendListener iMPluginSendListener = this.f9468b;
        if (iMPluginSendListener == null) {
            IMLog.m6632e(f9467a, "[sendLocationMessage] failed with NULL listener");
            return false;
        }
        iMPluginSendListener.sendLocationMessage(iMSendAddressEvent, z);
        return true;
    }

    /* renamed from: com.didi.beatles.im.plugin.IMHostProxy$Holder */
    private static final class Holder {
        /* access modifiers changed from: private */
        public static final IMHostProxy INSTANCE = new IMHostProxy();

        private Holder() {
        }
    }
}
