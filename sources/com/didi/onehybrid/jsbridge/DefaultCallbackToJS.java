package com.didi.onehybrid.jsbridge;

import com.didi.onehybrid.devmode.FusionRuntimeInfo;

public class DefaultCallbackToJS implements CallbackFunction {

    /* renamed from: a */
    private WebViewJavascriptBridge f29607a;

    /* renamed from: b */
    private String f29608b;

    /* renamed from: c */
    private FusionRuntimeInfo f29609c;

    /* renamed from: d */
    private String f29610d;

    public DefaultCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, String str, String str2) {
        this.f29608b = str;
        this.f29607a = webViewJavascriptBridge;
        this.f29610d = str2;
        this.f29609c = webViewJavascriptBridge.getFusionRuntimeInfo();
    }

    public void onCallBack(Object... objArr) {
        CallbackMessage callbackMessage = new CallbackMessage();
        callbackMessage.setCallbackId(this.f29608b);
        callbackMessage.setCallbackArguments(objArr);
        this.f29607a.mo80684a(callbackMessage);
        this.f29609c.recordBridgeCallback(this.f29610d, callbackMessage.toString());
    }
}
