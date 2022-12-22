package com.didi.payment.base.proxy;

import com.didi.payment.base.web.WebViewModel;

public class WebViewProxyHolder {

    /* renamed from: a */
    private static IWebViewProxy f29921a;

    public interface IWebViewProxy {
        void callWebActivity(WebViewModel webViewModel);
    }

    public static IWebViewProxy getProxy() {
        return f29921a;
    }

    public static void setProxy(IWebViewProxy iWebViewProxy) {
        f29921a = iWebViewProxy;
    }
}
