package com.didi.payment.base.view.webview.overrider;

import android.webkit.WebView;

public interface OverrideUrlLoader {
    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
