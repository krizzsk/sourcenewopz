package com.didichuxing.omega.sdk.analysis;

import android.net.Uri;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.didi.raven.config.RavenKey;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.xiaojuchefu.prism.monitor.PrismConstants;

public class OmegaWebChromeClient extends WebChromeClient {
    private static String OMEGA_SCHEME = "OmegaSDK://";
    private WebChromeClient webChromeClient;

    public OmegaWebChromeClient() {
    }

    public OmegaWebChromeClient(WebChromeClient webChromeClient2) {
        this.webChromeClient = webChromeClient2;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith(OMEGA_SCHEME)) {
            try {
                Uri parse = Uri.parse(str2);
                String host = parse.getHost();
                if ("trackEvent".equals(host)) {
                    String queryParameter = parse.getQueryParameter("e");
                    String queryParameter2 = parse.getQueryParameter("l");
                    String queryParameter3 = parse.getQueryParameter(RavenKey.ATTRS);
                    String queryParameter4 = parse.getQueryParameter(NotificationCompat.CATEGORY_SYSTEM);
                    if (queryParameter != null) {
                        Event event = new Event(queryParameter, queryParameter2);
                        event.setFrom(PrismConstants.Symbol.f56077H5);
                        if (queryParameter3 != null && queryParameter3.length() > 0) {
                            event.putAllAttrs(JsonUtil.json2Map(queryParameter3));
                        }
                        if (queryParameter4 != null && queryParameter4.length() > 0) {
                            event.eventMap().putAll(JsonUtil.json2Map(queryParameter4));
                        }
                        Tracker.trackEvent(event);
                    }
                } else if ("trackError".equals(host)) {
                    String queryParameter5 = parse.getQueryParameter("msg");
                    String queryParameter6 = parse.getQueryParameter(RavenKey.ATTRS);
                    String queryParameter7 = parse.getQueryParameter(NotificationCompat.CATEGORY_SYSTEM);
                    if (queryParameter5 != null) {
                        Event event2 = new Event("OMGH5JsError", queryParameter5);
                        event2.setFrom(PrismConstants.Symbol.f56077H5);
                        if (queryParameter6 != null) {
                            event2.putAllAttrs(JsonUtil.json2Map(queryParameter6));
                        }
                        if (queryParameter7 != null && queryParameter7.length() > 0) {
                            event2.eventMap().putAll(JsonUtil.json2Map(queryParameter7));
                        }
                        Tracker.trackEvent(event2);
                    }
                } else {
                    Tracker.trackGood("Unsupported H5 brige method", new Exception(host));
                }
            } catch (Throwable th) {
                Tracker.trackGood("onJsPrompt fail", th);
            }
            jsPromptResult.confirm("Omega OK!");
            return true;
        }
        WebChromeClient webChromeClient2 = this.webChromeClient;
        if (webChromeClient2 == null) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return webChromeClient2.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }
}
