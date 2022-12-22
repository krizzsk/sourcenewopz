package com.didichuxing.publicservice.webview;

public class WebViewListenerHolder {
    private static WebViewListener sListener;

    public static WebViewListener getListener() {
        return sListener;
    }

    public static void setListener(WebViewListener webViewListener) {
        sListener = webViewListener;
    }
}
