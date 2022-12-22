package com.didi.sdk.webview.jsbridge;

import com.didi.sdk.webview.jsbridge.JsCallback;
import org.json.JSONObject;

public class JsCallbackWraper {

    /* renamed from: a */
    private JsCallback f38488a;

    public void apply(JSONObject jSONObject) {
        JsCallback jsCallback = this.f38488a;
        if (jsCallback != null) {
            try {
                jsCallback.apply(jSONObject);
            } catch (JsCallback.JsCallbackException e) {
                e.printStackTrace();
            }
        }
    }
}
