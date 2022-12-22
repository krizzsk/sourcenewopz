package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class JsCallback {
    private static final String JS_CALLBACK_FMT = "javascript:didi.bridge._callback(%s);";

    /* renamed from: id */
    private final String f48486id;
    private final WeakReference<WebView> mWebViewRef;

    public JsCallback(WebView webView, String str) {
        this.mWebViewRef = new WeakReference<>(webView);
        this.f48486id = str;
    }

    public void apply(JSONObject jSONObject) throws JsCallbackException {
        WebView webView = (WebView) this.mWebViewRef.get();
        if (webView != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", this.f48486id);
                jSONObject2.put("result", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            webView.loadUrl(String.format(JS_CALLBACK_FMT, new Object[]{jSONObject2.toString()}));
            return;
        }
        throw new JsCallbackException("the WebView related to the JsCallback has been recycled");
    }

    public static class JsCallbackException extends Exception {
        public JsCallbackException(String str) {
            super(str);
        }
    }
}
