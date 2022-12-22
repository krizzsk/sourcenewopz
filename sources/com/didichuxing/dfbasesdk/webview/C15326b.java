package com.didichuxing.dfbasesdk.webview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didichuxing.dfbasesdk.utils.LogUtils;

/* renamed from: com.didichuxing.dfbasesdk.webview.b */
/* compiled from: DFWebViewClient */
class C15326b extends WebViewClient {
    C15326b() {
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        LogUtils.m33564d("Webview", "onPageStarted, url===" + str);
        super.onPageStarted(webView, str, bitmap);
    }

    public void onPageFinished(WebView webView, String str) {
        LogUtils.m33564d("Webview", "onPageFinished, url===" + str);
        super.onPageFinished(webView, str);
    }
}
