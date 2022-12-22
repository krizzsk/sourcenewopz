package com.didi.soda.customer.p165h5;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridWebChromeClient;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridWebViewClient;
import com.didi.soda.customer.p165h5.hybird.WebChromeClientCallback;
import com.didi.soda.customer.p165h5.hybird.WebViewClientCallback;
import com.didi.soda.web.activity.SodaWebActivity;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;

/* renamed from: com.didi.soda.customer.h5.CustomerWebActivity */
public class CustomerWebActivity extends SodaWebActivity implements WebChromeClientCallback, WebViewClientCallback {
    public static final String WEB_SINGLE_ACTIVITY_FLAG = "&flag=singleActivity";
    public static final String WEB_SINGLE_ACTIVITY_FLAG_KEY = "flag";
    public static final String WEB_SINGLE_ACTIVITY_FLAG_VALUE = "singleActivity";

    /* renamed from: a */
    private static final String f41282a = "CustomerWebActivity";

    public void onConsoleMessage(ConsoleMessage consoleMessage) {
    }

    public void onPageFinished(WebView webView, String str) {
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    public void onProgressChanged(WebView webView, int i) {
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    public void shouldInterceptRequest(WebView webView, String str) {
    }

    public static boolean matchSingleWebActivity(Bundle bundle) {
        if (bundle == null || bundle.getString(WEB_SINGLE_ACTIVITY_FLAG_KEY) == null) {
            return false;
        }
        return WEB_SINGLE_ACTIVITY_FLAG_VALUE.equals(bundle.getString(WEB_SINGLE_ACTIVITY_FLAG_KEY));
    }

    public static boolean matchSingleWebActivity(Uri uri) {
        if (uri == null || uri.getQueryParameter(WEB_SINGLE_ACTIVITY_FLAG_KEY) == null) {
            return false;
        }
        return WEB_SINGLE_ACTIVITY_FLAG_VALUE.equals(uri.getQueryParameter(WEB_SINGLE_ACTIVITY_FLAG_KEY));
    }

    public void onReceivedTitle(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && getTitleBar() != null && !TextUtils.isEmpty(str) && !str.contains(".com") && !str.contains("html") && !str.contains("/") && !str.contains("?")) {
            getTitleBar().setTitle(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        try {
            super.onCreate(bundle);
            m29235a();
        } catch (Exception unused) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public boolean remoteDebuggingEnable() {
        return CustomerToolBoxUtil.DEBUG;
    }

    /* renamed from: a */
    private void m29235a() {
        FusionWebView webView = getWebView();
        if (webView == null) {
            LogUtil.m29102e(f41282a, "iniJsFunctions - webactivty fusionWebView is null");
            OmegaSDKAdapter.trackEvent("soda_c_x_webactivty_webview_null");
            finish();
            return;
        }
        CustomerHybridWebViewClient customerHybridWebViewClient = new CustomerHybridWebViewClient(webView, this);
        customerHybridWebViewClient.setWebPageStateListener(this);
        WebHelper.attachOmegaJS(webView, customerHybridWebViewClient);
        webView.setWebViewClient(customerHybridWebViewClient);
        webView.setWebChromeClient(new CustomerHybridWebChromeClient(webView, this));
    }
}
