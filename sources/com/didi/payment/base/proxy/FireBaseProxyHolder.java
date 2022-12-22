package com.didi.payment.base.proxy;

import java.util.Map;

public class FireBaseProxyHolder {

    /* renamed from: a */
    private static IFireBaseProxy f29916a;

    public interface IFireBaseProxy {
        void trackEvent(String str, Map<String, Object> map);
    }

    public static IFireBaseProxy getProxy() {
        return f29916a;
    }

    public static void setProxy(IFireBaseProxy iFireBaseProxy) {
        f29916a = iFireBaseProxy;
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        IFireBaseProxy iFireBaseProxy = f29916a;
        if (iFireBaseProxy != null) {
            iFireBaseProxy.trackEvent(str, map);
        }
    }
}
