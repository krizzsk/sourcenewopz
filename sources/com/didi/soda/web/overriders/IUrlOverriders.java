package com.didi.soda.web.overriders;

import android.webkit.WebView;

public interface IUrlOverriders {
    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
