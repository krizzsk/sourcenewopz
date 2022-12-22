package com.didi.soda.customer.p165h5.hybird;

import android.webkit.ConsoleMessage;
import android.webkit.WebView;

/* renamed from: com.didi.soda.customer.h5.hybird.WebChromeClientCallback */
public interface WebChromeClientCallback {
    void onConsoleMessage(ConsoleMessage consoleMessage);

    void onProgressChanged(WebView webView, int i);

    void onReceivedTitle(WebView webView, String str);
}
