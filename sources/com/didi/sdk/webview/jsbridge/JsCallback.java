package com.didi.sdk.webview.jsbridge;

import android.webkit.WebView;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class JsCallback {

    /* renamed from: a */
    private static final String f38484a = "javascript:%s(%s);";

    /* renamed from: b */
    private WeakReference<WebView> f38485b;

    /* renamed from: c */
    private String f38486c;

    /* renamed from: d */
    private String f38487d;

    public JsCallback(WebView webView, String str, String str2) {
        this.f38485b = new WeakReference<>(webView);
        this.f38486c = str;
        this.f38487d = str2;
    }

    public void apply(JSONObject jSONObject) throws JsCallbackException {
        WebView webView = (WebView) this.f38485b.get();
        if (webView != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", this.f38486c);
                jSONObject2.put("errno", 0);
                jSONObject2.put("errmsg", "");
                jSONObject2.put("result", jSONObject);
            } catch (JSONException unused) {
            }
            String format = String.format(f38484a, new Object[]{this.f38487d, jSONObject2.toString()});
            Logger logger = LoggerFactory.getLogger("JsBridge");
            logger.debug("JsCallback execJs: " + format, new Object[0]);
            webView.loadUrl(format);
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
