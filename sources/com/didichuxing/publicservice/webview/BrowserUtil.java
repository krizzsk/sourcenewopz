package com.didichuxing.publicservice.webview;

import android.content.Context;

public class BrowserUtil {
    public static void startInternalWebActivity(Context context, String str, String str2) {
        WebViewListener listener = WebViewListenerHolder.getListener();
        if (listener != null) {
            WebViewModelProxy webViewModelProxy = new WebViewModelProxy();
            webViewModelProxy.setContext(context);
            webViewModelProxy.setTitle(str);
            webViewModelProxy.setUrl(str2);
            listener.callWebView(webViewModelProxy);
        }
    }
}
