package com.didichuxing.dfbasesdk.webview;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import org.json.JSONObject;

/* renamed from: com.didichuxing.dfbasesdk.webview.d */
/* compiled from: JsBridgeImpl */
class C15329d {

    /* renamed from: a */
    static final String f46954a = "Webview";

    /* renamed from: b */
    private static final String f46955b = "undefined";

    /* renamed from: c */
    private static final String f46956c = "javascript:";

    /* renamed from: d */
    private static final String f46957d = "_diface_callback_handler";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C15328c f46958e;

    C15329d(C15328c cVar) {
        this.f46958e = cVar;
    }

    @JavascriptInterface
    public void invoke(String str, String str2, String str3) {
        LogUtils.m33564d(f46954a, "invoke from js, command=" + str + ", params=" + str2 + ", callback=" + str3);
        if (!TextUtils.isEmpty(str) && !"undefined".equals(str) && !TextUtils.isEmpty(str2) && !"undefined".equals(str2)) {
            try {
                UIHandler.post(new JsBridgeImpl$1(this, str, new JSONObject(str2)));
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
                BusUtils.post(new JsCallbackEvent(str, 1002, e.getMessage()).build());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115953a(WebView webView, JsCallbackEvent jsCallbackEvent) {
        String str = "javascript:_diface_callback_handler('" + jsCallbackEvent.command + "', '" + jsCallbackEvent.mo115940a() + "')";
        LogUtils.m33564d(f46954a, "callback to js, js=" + str);
        m33655a(webView, str);
    }

    /* renamed from: a */
    static void m33655a(WebView webView, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith(f46956c)) {
                str = f46956c + str;
            }
            if (Build.VERSION.SDK_INT < 19) {
                webView.loadUrl(str);
            } else {
                webView.evaluateJavascript(str, new JsBridgeImpl$2());
            }
        }
    }
}
