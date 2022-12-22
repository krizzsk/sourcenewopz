package com.didi.entrega.customer.p113h5.hybird;

import android.graphics.Bitmap;
import android.webkit.WebView;

/* renamed from: com.didi.entrega.customer.h5.hybird.WebViewClientCallback */
public interface WebViewClientCallback {
    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onReceivedError(WebView webView, int i, String str, String str2);

    void shouldInterceptRequest(WebView webView, String str);
}
