package com.didi.dimina.container.p106ui.webview;

import android.webkit.JavascriptInterface;
import com.didi.dimina.container.webengine.WebViewEngine;

/* renamed from: com.didi.dimina.container.ui.webview.DMWebViewJSInterface */
public class DMWebViewJSInterface {
    public static String TAG = "DiminaWebViewBridge";
    private final WebViewEngine mWebView;

    public DMWebViewJSInterface(WebViewEngine webViewEngine) {
        this.mWebView = webViewEngine;
    }

    @JavascriptInterface
    public void invoke(String str, String str2, String str3, String str4) {
        try {
            this.mWebView.getDmMina().getMessageTransfer().invokeNativeFromWebView(this.mWebView, str, str2, str3, str4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public void publish(String str) {
        try {
            this.mWebView.getDmMina().getMessageTransfer().sendMessageToServiceFromWebView(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
