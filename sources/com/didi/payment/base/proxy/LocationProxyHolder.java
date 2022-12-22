package com.didi.payment.base.proxy;

public class LocationProxyHolder {

    /* renamed from: a */
    private static ILocationProxy f29920a;

    public interface ILocationProxy {
        void requestLocationAndCityId();
    }

    public static ILocationProxy getProxy() {
        return f29920a;
    }

    public static void setProxy(ILocationProxy iLocationProxy) {
        f29920a = iLocationProxy;
    }
}
