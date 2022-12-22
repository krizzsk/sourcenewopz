package com.didi.dimina.webview.log.apollo;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.didi.dimina.webview.container.FusionWebView;
import com.didi.dimina.webview.util.C7819Util;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloLog {

    public interface UploadCallback {
        void upload();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m13621b(IToggle iToggle, String str) {
        if (iToggle.allow()) {
            try {
                String str2 = (String) iToggle.getExperiment().getParam("wl", "default-error");
                if (!"default-error".equals(str2) && !TextUtils.isEmpty(str2)) {
                    JSONArray jSONArray = new JSONObject(str2).getJSONArray("l");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (str.startsWith(jSONArray.optString(i))) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m13618a(Context context, UploadCallback uploadCallback) {
        IToggle toggle = Apollo.getToggle("webview_quality_monitor_enable", false);
        if (C7819Util.isApkDebug(context) || toggle.allow()) {
            uploadCallback.upload();
        }
    }

    /* renamed from: a */
    static void m13619a(Context context, String str, String str2, String str3, String str4) {
        final Context context2 = context;
        final String str5 = str2;
        final String str6 = str4;
        final String str7 = str3;
        final String str8 = str;
        m13618a(context, (UploadCallback) new UploadCallback() {
            public void upload() {
                String str;
                IToggle toggle = Apollo.getToggle("webview_quality_monitor_enable");
                if (C7819Util.isApkDebug(context2) || ApolloLog.m13621b(toggle, str5)) {
                    str = str5;
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(str5)) {
                        Uri parse = Uri.parse(str5);
                        sb.append(parse.getScheme());
                        sb.append(HWMapConstant.HTTP.SEPARATOR);
                        sb.append(parse.getHost());
                        sb.append(parse.getPath());
                    } else {
                        sb.append("unknown");
                    }
                    str = sb.toString();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("error", str6);
                hashMap.put("res_url", str7);
                hashMap.put("source_url", str);
                OmegaSDKAdapter.trackEvent(str8, (String) null, hashMap);
            }
        });
    }

    public static void uploadHttpError(Context context, final String str, final Throwable th) {
        m13618a(context, (UploadCallback) new UploadCallback() {
            public void upload() {
                HashMap hashMap = new HashMap();
                hashMap.put("source_url", str);
                hashMap.put("src_throwable", Arrays.toString(th.getStackTrace()));
                OmegaSDKAdapter.trackEvent("webview_http_error_monitor", (String) null, hashMap);
            }
        });
    }

    public static void uploadHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Uri url = webResourceRequest.getUrl();
        StringBuilder sb = new StringBuilder();
        if (url != null) {
            sb.append(url.getScheme());
            sb.append(HWMapConstant.HTTP.SEPARATOR);
            sb.append(url.getHost());
            sb.append(url.getPath());
        }
        int i = 0;
        if (webResourceResponse != null) {
            i = webResourceResponse.getStatusCode();
        }
        m13619a(webView.getContext(), "webview_http_error_monitor", webView.getUrl(), url.toString(), Integer.valueOf(i).toString());
    }

    public static void uploadJsError(FusionWebView fusionWebView, ConsoleMessage consoleMessage) {
        String url = fusionWebView.getUrl();
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
            String sourceId = consoleMessage.sourceId();
            String message = consoleMessage.message();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(sourceId)) {
                Uri parse = Uri.parse(sourceId);
                sb.append(parse.getScheme());
                sb.append(HWMapConstant.HTTP.SEPARATOR);
                sb.append(parse.getHost());
                sb.append(parse.getPath());
            }
            if (TextUtils.isEmpty(message)) {
                message = "unknown";
            }
            m13619a(fusionWebView.getContext(), "webview_H5_error_monitor", url, sb.toString(), message);
        }
    }
}
