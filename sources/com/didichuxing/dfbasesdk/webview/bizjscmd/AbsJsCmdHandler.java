package com.didichuxing.dfbasesdk.webview.bizjscmd;

import com.didichuxing.dfbasesdk.webview.JsCallbackEvent;

public abstract class AbsJsCmdHandler implements IBizJsCmdHandler {

    /* renamed from: a */
    private IJsCallback f46948a;

    public void setCallback(IJsCallback iJsCallback) {
        this.f46948a = iJsCallback;
    }

    public final void onJsCallback(JsCallbackEvent jsCallbackEvent) {
        IJsCallback iJsCallback = this.f46948a;
        if (iJsCallback != null) {
            iJsCallback.onJsCallback(jsCallbackEvent);
        }
    }
}
