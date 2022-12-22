package com.didi.dimina.webview;

import android.content.Context;
import android.webkit.WebView;
import com.didi.dimina.webview.resource.FusionCacheConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class BusinessAgent {
    protected Context appContext;

    public String addCommonQuery(String str) {
        return str;
    }

    public String getBusinessUA() {
        return "";
    }

    public Map<String, String> getCommonHeaders() {
        return null;
    }

    public abstract String getUserPhone();

    public boolean isOfflineOpen() {
        return false;
    }

    public abstract boolean isWhiteUrl(Context context, String str);

    public boolean needPreInitWebView() {
        return true;
    }

    public void refreshAppLocale(Context context) {
    }

    public boolean shouldIntercept(Context context, String str) {
        return false;
    }

    public boolean shouldInterceptLoadResource(WebView webView, String str, String str2) {
        return false;
    }

    public BusinessAgent(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public List<String> getPreloadUrlList() {
        return Collections.emptyList();
    }

    public FusionCacheConfig getCacheConfig() {
        return new FusionCacheConfig();
    }

    public static class DummyBusinessAgent extends BusinessAgent {
        public String getUserPhone() {
            return "";
        }

        public boolean isWhiteUrl(Context context, String str) {
            return false;
        }

        public void refreshAppLocale(Context context) {
        }

        public boolean shouldIntercept(Context context, String str) {
            return false;
        }

        public DummyBusinessAgent(Context context) {
            super(context);
        }
    }
}
