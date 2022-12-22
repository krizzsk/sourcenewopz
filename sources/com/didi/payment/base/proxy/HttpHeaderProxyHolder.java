package com.didi.payment.base.proxy;

import java.util.HashMap;

public class HttpHeaderProxyHolder {

    /* renamed from: a */
    private static IHeaderProxy f29917a;

    public interface IHeaderProxy {
        HashMap<String, String> getHeaders();
    }

    public static IHeaderProxy getProxy() {
        return f29917a;
    }

    public static void setProxy(IHeaderProxy iHeaderProxy) {
        f29917a = iHeaderProxy;
    }
}
