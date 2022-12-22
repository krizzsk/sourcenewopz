package com.didi.sdk.util;

import com.didichuxing.apollo.sdk.Apollo;

public class WebViewUtils {
    public static boolean isUrlStartWithHttps(String str) {
        if (str == null) {
            return false;
        }
        try {
            if (!Apollo.getToggle("global_webView_contains_token_with_https").allow() || !str.startsWith("http://")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
