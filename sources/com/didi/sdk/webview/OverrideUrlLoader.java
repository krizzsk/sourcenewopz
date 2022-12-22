package com.didi.sdk.webview;

import android.webkit.WebView;

public interface OverrideUrlLoader {
    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
