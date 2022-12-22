package com.didi.dimina.webview.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.dimina.webview.BusinessAgent;
import com.didi.dimina.webview.FusionEngine;
import com.didi.dimina.webview.jsbridge.WebViewJavascriptBridge;
import com.didi.dimina.webview.log.FusionLogHelper;
import com.didi.dimina.webview.log.apollo.ApolloLog;
import com.didi.dimina.webview.resource.FusionResourceManager;
import com.didi.dimina.webview.resource.FusionUrlPreLoader;
import com.didi.dimina.webview.resource.offline.OfflineBundleManager;
import com.didi.dimina.webview.util.C7819Util;
import com.didi.dimina.webview.util.FusionMimeTypeMap;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class FusionWebViewClient extends WebViewClient {
    private static int EXCEPTION_COUNT;
    private final BusinessAgent mBusinessAgent;
    private final Context mContext;
    private String mCurrentPageUrl;
    private final Map<String, String> mRequestHeaders = new HashMap();
    private String[] mSchemeIntent;
    private FusionUrlPreLoader mUrlPreloader;
    private final String mUserAgent;
    private final WebViewJavascriptBridge mWebJavascriptBridge;
    private final FusionWebView mWebView;
    private WebViewClient mWebViewClient;

    public FusionWebViewClient(Activity activity, FusionWebView fusionWebView) {
        this.mWebView = fusionWebView;
        this.mContext = activity;
        this.mWebJavascriptBridge = new WebViewJavascriptBridge(activity, fusionWebView);
        this.mUserAgent = this.mWebView.getSettings().getUserAgentString();
        this.mBusinessAgent = FusionEngine.getBusinessAgent();
        this.mRequestHeaders.put("User-Agent", this.mUserAgent);
        IToggle toggle = Apollo.getToggle("passenger_fusion_scheme_intent");
        if (toggle.allow()) {
            this.mSchemeIntent = ((String) toggle.getExperiment().getParam("scheme", "")).split(",");
        }
    }

    public void setWebviewClient(WebViewClient webViewClient) {
        if (webViewClient != null) {
            this.mWebViewClient = webViewClient;
        }
    }

    public void setUrlPreLoader(FusionUrlPreLoader fusionUrlPreLoader) {
        this.mUrlPreloader = fusionUrlPreLoader;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (schemeToIntent(webView.getContext(), str)) {
            return true;
        }
        String url = webView.getUrl();
        if (TextUtils.isEmpty(url)) {
            url = webView.getOriginalUrl();
        }
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        if (!this.mBusinessAgent.isWhiteUrl(this.mContext, Uri.parse(url).getHost())) {
            return false;
        }
        if (str.startsWith("fusion://")) {
            String queryParameter = Uri.parse(str).getQueryParameter("origin");
            if (!C7819Util.isApkDebug(this.mContext) && (TextUtils.isEmpty(queryParameter) || !this.mBusinessAgent.isWhiteUrl(this.mContext, queryParameter))) {
                return false;
            }
            if (str.startsWith("fusion://invokeNative")) {
                this.mWebJavascriptBridge.handleInvokeFromJs(str);
                return true;
            } else if (str.startsWith("fusion://callbackNative")) {
                this.mWebJavascriptBridge.handleResponseFromJS(str);
                return true;
            }
        }
        WebViewClient webViewClient = this.mWebViewClient;
        return webViewClient == null ? super.shouldOverrideUrlLoading(webView, str) : webViewClient.shouldOverrideUrlLoading(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        printLog(str + "| onPageStarted开始加载");
        this.mCurrentPageUrl = str;
        if (this.mWebView.shouldInterceptRequest() && this.mBusinessAgent.getCacheConfig().needBlockImage()) {
            this.mWebView.getSettings().setBlockNetworkImage(true);
        }
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onPageStarted(webView, str, bitmap);
        } else {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        final Context context = webView.getContext();
        if (!(context instanceof Activity) || webView == null) {
            SystemUtils.log(6, "onRenderProcessGone", SDKConsts.BOOLEAN_FALSE, (Throwable) null, "com.didi.dimina.webview.container.FusionWebViewClient", 183);
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        webView.post(new Runnable() {
            public void run() {
                Activity activity = (Activity) context;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
        });
        SystemUtils.log(6, "onRenderProcessGone", "true", (Throwable) null, "com.didi.dimina.webview.container.FusionWebViewClient", 180);
        return true;
    }

    public void onPageFinished(WebView webView, String str) {
        printLog(str + "| onPageFinished结束加载");
        if (this.mWebView.shouldInterceptRequest() && this.mBusinessAgent.getCacheConfig().needBlockImage()) {
            this.mWebView.getSettings().setBlockNetworkImage(false);
        }
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onPageFinished(webView, str);
        } else {
            webViewClient.onPageFinished(webView, str);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.cancel();
        printLog(sslError.getUrl() + "| onReceivedSslError加载失败");
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onReceivedError(webView, i, str, str2);
        } else {
            webViewClient.onReceivedError(webView, i, str, str2);
        }
        printLog(str2 + "| onReceivedError加载失败");
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.mWebViewClient == null || webResourceRequest.isForMainFrame()) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        } else {
            this.mWebViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        }
        printLog(webResourceRequest.getUrl() + "| onReceivedError(TargetApi(23))加载失败");
    }

    public void onLoadResource(WebView webView, String str) {
        if (this.mBusinessAgent.shouldInterceptLoadResource(webView, this.mCurrentPageUrl, str)) {
            WebViewClient webViewClient = this.mWebViewClient;
            if (webViewClient == null) {
                super.onLoadResource(webView, str);
            } else {
                webViewClient.onLoadResource(webView, str);
            }
            printLog(str + "| onLoadResource 被拦截");
            return;
        }
        if (str.startsWith("fusion://")) {
            Uri parse = Uri.parse(str);
            String str2 = null;
            if (!isWhiteUseOriginUrl()) {
                str2 = parse.getQueryParameter("origin");
            } else {
                String url = webView.getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = getOriginalUrl(webView);
                }
                if (!TextUtils.isEmpty(url)) {
                    str2 = Uri.parse(url).getHost();
                }
            }
            if (!TextUtils.isEmpty(str2) && (this.mBusinessAgent.isWhiteUrl(this.mContext, str2) || C7819Util.isApkDebug(this.mContext))) {
                if (str.startsWith("fusion://invokeNative")) {
                    this.mWebJavascriptBridge.handleInvokeFromJs(str);
                }
                if (str.startsWith("fusion://callbackNative")) {
                    this.mWebJavascriptBridge.handleResponseFromJS(str);
                }
            }
        }
        WebViewClient webViewClient2 = this.mWebViewClient;
        if (webViewClient2 == null) {
            super.onLoadResource(webView, str);
        } else {
            webViewClient2.onLoadResource(webView, str);
        }
        printLog(str + "| onLoadResource加载成功");
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return interceptRequest(str, this.mRequestHeaders);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        File findBundleFileEx;
        String uri = webResourceRequest.getUrl().toString();
        if (!webResourceRequest.getMethod().toUpperCase().equals("GET")) {
            return null;
        }
        String mimeTypeFromUrl = FusionMimeTypeMap.getMimeTypeFromUrl(uri);
        if (!TextUtils.isEmpty(mimeTypeFromUrl) && !mimeTypeFromUrl.equals("text/html") && this.mWebView.shouldSearchInBundle() && OfflineBundleManager.isInitialized() && (findBundleFileEx = OfflineBundleManager.getInstance().findBundleFileEx(uri)) != null) {
            try {
                WebResourceResponse webResourceResponse = new WebResourceResponse(mimeTypeFromUrl, "UTF-8", new BufferedInputStream(new FileInputStream(findBundleFileEx)));
                HashMap hashMap = new HashMap();
                hashMap.put("fusion_source", "offline");
                hashMap.put("Access-Control-Allow-Origin", "*");
                webResourceResponse.setResponseHeaders(hashMap);
                return webResourceResponse;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (this.mWebView.shouldInterceptRequest()) {
            return interceptRequest(uri, requestHeaders);
        }
        return null;
    }

    private WebResourceResponse interceptRequest(String str, Map<String, String> map) {
        WebResourceResponse webResourceResponse = null;
        if (!C7819Util.isUsePicDiskCache || EXCEPTION_COUNT >= 10 || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            FusionResourceManager.FusionResource fusionResource = FusionResourceManager.getFusionResource(str, map, this.mUrlPreloader);
            if (fusionResource == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(fusionResource.mimeType, "UTF-8", fusionResource.body);
            try {
                webResourceResponse2.setResponseHeaders(fusionResource.header);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
                EXCEPTION_COUNT++;
                try {
                    ApolloLog.uploadHttpError(this.mContext, str, th);
                    return webResourceResponse;
                } catch (Exception e) {
                    e.printStackTrace();
                    return webResourceResponse;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            EXCEPTION_COUNT++;
            ApolloLog.uploadHttpError(this.mContext, str, th);
            return webResourceResponse;
        }
    }

    public WebViewJavascriptBridge getJavascriptBridge() {
        return this.mWebJavascriptBridge;
    }

    private void printLog(String str) {
        if (C7819Util.isApkDebug(this.mContext)) {
            SystemUtils.log(4, "HybridLog", str, (Throwable) null, "com.didi.dimina.webview.container.FusionWebViewClient", 364);
        }
        Activity activity = (Activity) this.mContext;
        if (FusionLogHelper.isFusionLogOpen(activity) && !TextUtils.isEmpty(str) && (activity instanceof UpdateUIHandler)) {
            ((UpdateUIHandler) activity).updateUI("debug_log", str);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onFormResubmission(webView, message, message2);
        } else {
            webViewClient.onFormResubmission(webView, message, message2);
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.doUpdateVisitedHistory(webView, str, z);
        } else {
            webViewClient.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.mWebViewClient;
        return webViewClient == null ? super.shouldOverrideKeyEvent(webView, keyEvent) : webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onScaleChanged(webView, f, f2);
        } else {
            webViewClient.onScaleChanged(webView, f, f2);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        try {
            ApolloLog.uploadHttpError(webView, webResourceRequest, webResourceResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isWhiteUseOriginUrl() {
        IToggle toggle = Apollo.getToggle("webview_host_whitelist_v5");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("is_use_origin_url", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    private String getOriginalUrl(WebView webView) {
        try {
            return webView.getOriginalUrl();
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean schemeToIntent(Context context, String str) {
        String[] strArr = this.mSchemeIntent;
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                if (str.startsWith(strArr[i])) {
                    try {
                        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    } catch (RuntimeException unused) {
                        continue;
                    }
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
