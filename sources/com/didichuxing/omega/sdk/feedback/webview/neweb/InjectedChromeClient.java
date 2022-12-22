package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class InjectedChromeClient extends WebChromeClient {
    protected boolean mIsInjectedJS;
    protected JsCallJava mJsCallJava;

    public InjectedChromeClient(String str, Class cls) {
        this.mJsCallJava = new JsCallJava(str, cls);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        jsPromptResult.confirm(this.mJsCallJava.call(webView, str2));
        return true;
    }
}
