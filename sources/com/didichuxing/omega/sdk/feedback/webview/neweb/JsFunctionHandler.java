package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.webkit.WebView;
import com.didichuxing.omega.sdk.feedback.webview.neweb.JavascriptBridge;
import com.didichuxing.omega.sdk.feedback.webview.neweb.JsCallback;
import org.json.JSONObject;

class JsFunctionHandler {
    JsFunctionHandler() {
    }

    public static void callHandler(WebView webView, String str, JsCallback jsCallback) {
        JavascriptBridge javascriptBridge;
        JavascriptBridge.Function function;
        if ((webView instanceof BaseWebView) && (javascriptBridge = ((BaseWebView) webView).getJavascriptBridge()) != null && (function = javascriptBridge.getFunction(str)) != null) {
            JSONObject execute = function.execute();
            if (jsCallback != null && function.isAutoCallbackJs()) {
                try {
                    jsCallback.apply(execute);
                } catch (JsCallback.JsCallbackException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
