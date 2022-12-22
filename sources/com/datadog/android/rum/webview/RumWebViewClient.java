package com.datadog.android.rum.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumResourceKind;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J.\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0018\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017J&\u0010\u001b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001eH\u0016¨\u0006 "}, mo175978d2 = {"Lcom/datadog/android/rum/webview/RumWebViewClient;", "Landroid/webkit/WebViewClient;", "()V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onProvideRumResourceAttributes", "", "", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumWebViewClient.kt */
public class RumWebViewClient extends WebViewClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String METHOD_GET = "GET";

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (str != null) {
            RumMonitor.DefaultImpls.startResource$default(GlobalRum.get(), str, "GET", str, (Map) null, 8, (Object) null);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (str != null) {
            GlobalRum.get().stopResource(str, 200, (Long) null, RumResourceKind.DOCUMENT, onProvideRumResourceAttributes(webView, str));
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        RumMonitor rumMonitor = GlobalRum.get();
        rumMonitor.addError("Error " + i + ": " + str, RumErrorSource.WEBVIEW, (Throwable) null, MapsKt.mapOf(TuplesKt.m42317to(RumAttributes.ERROR_RESOURCE_URL, str2)));
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Uri uri;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        RumMonitor rumMonitor = GlobalRum.get();
        StringBuilder sb = new StringBuilder();
        sb.append("Error ");
        sb.append(webResourceError == null ? null : Integer.valueOf(webResourceError.getErrorCode()));
        sb.append(": ");
        sb.append(webResourceError == null ? null : webResourceError.getDescription());
        String sb2 = sb.toString();
        RumErrorSource rumErrorSource = RumErrorSource.WEBVIEW;
        if (webResourceRequest == null) {
            uri = null;
        } else {
            uri = webResourceRequest.getUrl();
        }
        rumMonitor.addError(sb2, rumErrorSource, (Throwable) null, MapsKt.mapOf(TuplesKt.m42317to(RumAttributes.ERROR_RESOURCE_URL, uri)));
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Uri uri;
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        RumMonitor rumMonitor = GlobalRum.get();
        StringBuilder sb = new StringBuilder();
        sb.append("Error ");
        sb.append(webResourceResponse == null ? null : Integer.valueOf(webResourceResponse.getStatusCode()));
        sb.append(": ");
        sb.append(webResourceResponse == null ? null : webResourceResponse.getReasonPhrase());
        String sb2 = sb.toString();
        RumErrorSource rumErrorSource = RumErrorSource.WEBVIEW;
        if (webResourceRequest == null) {
            uri = null;
        } else {
            uri = webResourceRequest.getUrl();
        }
        rumMonitor.addError(sb2, rumErrorSource, (Throwable) null, MapsKt.mapOf(TuplesKt.m42317to(RumAttributes.ERROR_RESOURCE_URL, uri)));
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Integer num;
        String str;
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        RumMonitor rumMonitor = GlobalRum.get();
        if (sslError == null) {
            num = null;
        } else {
            num = Integer.valueOf(sslError.getPrimaryError());
        }
        String stringPlus = Intrinsics.stringPlus("SSL Error ", num);
        RumErrorSource rumErrorSource = RumErrorSource.WEBVIEW;
        if (sslError == null) {
            str = null;
        } else {
            str = sslError.getUrl();
        }
        rumMonitor.addError(stringPlus, rumErrorSource, (Throwable) null, MapsKt.mapOf(TuplesKt.m42317to(RumAttributes.ERROR_RESOURCE_URL, str)));
    }

    public Map<String, Object> onProvideRumResourceAttributes(WebView webView, String str) {
        return MapsKt.emptyMap();
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/datadog/android/rum/webview/RumWebViewClient$Companion;", "", "()V", "METHOD_GET", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RumWebViewClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
