package com.didi.payment.base.proxy;

import android.content.Context;

public class ConfigProxyHolder {

    /* renamed from: a */
    private static IConfigProxy f29914a;

    /* renamed from: b */
    private static IGlobalPageRouterProxy f29915b;

    public interface IConfigProxy {
        boolean isDebugMode();
    }

    public interface IGlobalPageRouterProxy {
        void toHomeActivity(Context context, boolean z);
    }

    public static void releaseProxy() {
        f29914a = null;
        f29915b = null;
    }

    public static IConfigProxy getProxy() {
        return f29914a;
    }

    public static void setProxy(IConfigProxy iConfigProxy) {
        f29914a = iConfigProxy;
    }

    public static IGlobalPageRouterProxy getGlobalPageRouterProxy() {
        return f29915b;
    }

    public static void setGlobalPageRouterProxy(IGlobalPageRouterProxy iGlobalPageRouterProxy) {
        f29915b = iGlobalPageRouterProxy;
    }
}
