package com.didi.sdk.payment.view.browser;

import com.didi.sdk.pay.base.PayBaseInjecter;

public class WebViewListenerHolder {

    /* renamed from: a */
    private static WebViewListener f36919a;

    public static WebViewListener getListener() {
        return f36919a;
    }

    public static void setListener(WebViewListener webViewListener) {
        f36919a = webViewListener;
        PayBaseInjecter.injectWebViewProxy(webViewListener);
    }
}
