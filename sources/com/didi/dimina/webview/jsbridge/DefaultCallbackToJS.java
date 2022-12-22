package com.didi.dimina.webview.jsbridge;

import com.didi.dimina.container.bridge.base.CallbackFunction;

public class DefaultCallbackToJS implements CallbackFunction {

    /* renamed from: a */
    private final WebViewJavascriptBridge f18271a;

    /* renamed from: b */
    private final String f18272b;

    public DefaultCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, String str, String str2) {
        this.f18272b = str;
        this.f18271a = webViewJavascriptBridge;
    }

    public void onCallBack(Object... objArr) {
        CallbackMessage callbackMessage = new CallbackMessage();
        callbackMessage.setCallbackId(this.f18272b);
        callbackMessage.setCallbackArguments(objArr);
        this.f18271a.mo57965a(callbackMessage);
    }
}
