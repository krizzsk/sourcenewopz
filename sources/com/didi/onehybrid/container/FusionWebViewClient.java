package com.didi.onehybrid.container;

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
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.onehybrid.log.FusionLogHelper;
import com.didi.onehybrid.log.apollo.ApolloLog;
import com.didi.onehybrid.resource.FusionResourceManager;
import com.didi.onehybrid.resource.FusionUrlPreLoader;
import com.didi.onehybrid.resource.offline.OfflineBundleManager;
import com.didi.onehybrid.resource.offline.UrlTrieTree;
import com.didi.onehybrid.util.C10393Util;
import com.didi.onehybrid.util.FusionMimeTypeMap;
import com.didi.onehybrid.util.OmegaUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class FusionWebViewClient extends WebViewClient {
    private static int EXCEPTION_COUNT = 0;
    private static final String TAG = "FusionWebViewClient";
    private BusinessAgent mBusinessAgent;
    private Activity mContext;
    private FusionRuntimeInfo mFusionRuntimeInfo;
    private Map<String, String> mRequestHeaders = new HashMap();
    private String[] mSchemeIntent;
    private FusionUrlPreLoader mUrlPreloader;
    private String mUserAgent;
    private WebViewJavascriptBridge mWebJavascriptBridge;
    private FusionWebView mWebView;
    private WebViewClient mWebViewClient;

    public FusionWebViewClient(HybridableContainer hybridableContainer) {
        this.mWebView = hybridableContainer.getWebView();
        this.mContext = hybridableContainer.getActivity();
        this.mWebJavascriptBridge = new WebViewJavascriptBridge(hybridableContainer);
        this.mUserAgent = this.mWebView.getSettings().getUserAgentString();
        this.mBusinessAgent = FusionEngine.getBusinessAgent();
        this.mFusionRuntimeInfo = this.mWebView.getFusionRuntimeInfo();
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
        if (this.mBusinessAgent.interceptWhenOverrideUrlLoading(str)) {
            printLog("fusionwebviewclient intercept by bizAgent invoke view.loadUrl(url) " + str);
            webView.loadUrl(str);
            return true;
        }
        if (str.startsWith("fusion://")) {
            String queryParameter = Uri.parse(str).getQueryParameter("origin");
            if (!C10393Util.isApkDebug(this.mContext)) {
                if (TextUtils.isEmpty(queryParameter)) {
                    return false;
                }
                if (!this.mBusinessAgent.isWhiteUrl(this.mContext, queryParameter)) {
                    this.mFusionRuntimeInfo.recordRejectBridgeUrl(str);
                    return false;
                }
            }
            if (str.startsWith("fusion://invokeNative")) {
                this.mWebJavascriptBridge.handleInvokeFromJs(str);
                return true;
            } else if (str.startsWith("fusion://callbackNative")) {
                this.mWebJavascriptBridge.handleResponseFromJS(str);
                return true;
            }
        }
        if (schemeToIntent(webView.getContext(), str)) {
            return true;
        }
        WebViewClient webViewClient = this.mWebViewClient;
        return webViewClient == null ? super.shouldOverrideUrlLoading(webView, str) : webViewClient.shouldOverrideUrlLoading(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        printLog(str + "| onPageStarted开始加载");
        this.mFusionRuntimeInfo.recordPageStartTime(System.currentTimeMillis());
        FusionWebView fusionWebView = this.mWebView;
        if (fusionWebView != null && fusionWebView.shouldInterceptRequest() && this.mBusinessAgent.getCacheConfig().needBlockImage()) {
            this.mWebView.getSettings().setBlockNetworkImage(true);
        }
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onPageStarted(webView, str, bitmap);
        } else {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        printLog(str + "| onPageFinished结束加载");
        this.mFusionRuntimeInfo.recordPageEndTime(System.currentTimeMillis());
        FusionWebView fusionWebView = this.mWebView;
        if (fusionWebView != null && fusionWebView.shouldInterceptRequest() && this.mBusinessAgent.getCacheConfig().needBlockImage()) {
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
        FusionWebView fusionWebView = this.mWebView;
        if (fusionWebView != null) {
            fusionWebView.hiddenLoadProgress();
        }
        printLog(str2 + "| onReceivedError加载失败");
    }

    public void onLoadResource(WebView webView, String str) {
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
            if (!TextUtils.isEmpty(str2)) {
                if (this.mBusinessAgent.isWhiteUrl(this.mContext, str2) || C10393Util.isApkDebug(this.mContext)) {
                    if (str.startsWith("fusion://invokeNative")) {
                        this.mWebJavascriptBridge.handleInvokeFromJs(str);
                    }
                    if (str.startsWith("fusion://callbackNative")) {
                        this.mWebJavascriptBridge.handleResponseFromJS(str);
                    }
                } else {
                    this.mFusionRuntimeInfo.recordRejectBridgeUrl(str);
                }
            }
        }
        WebViewClient webViewClient = this.mWebViewClient;
        if (webViewClient == null) {
            super.onLoadResource(webView, str);
        } else {
            webViewClient.onLoadResource(webView, str);
        }
        printLog(str + "| onLoadResource加载成功");
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return interceptRequest(str, this.mRequestHeaders);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        File findBundleFile;
        String uri = webResourceRequest.getUrl().toString();
        SystemUtils.log(3, TAG, uri + " ----shouldInterceptRequest Begin", (Throwable) null, "com.didi.onehybrid.container.FusionWebViewClient", 276);
        if (webResourceRequest.getMethod().toUpperCase().equals("GET")) {
            String mimeTypeFromUrl = FusionMimeTypeMap.getMimeTypeFromUrl(uri);
            if (!TextUtils.isEmpty(mimeTypeFromUrl) && this.mBusinessAgent.isOfflineOpen() && OfflineBundleManager.isInitialized() && (findBundleFile = OfflineBundleManager.getInstance().findBundleFile(uri)) != null) {
                try {
                    WebResourceResponse webResourceResponse = new WebResourceResponse(mimeTypeFromUrl, "UTF-8", new BufferedInputStream(new FileInputStream(findBundleFile)));
                    HashMap hashMap = new HashMap();
                    hashMap.put("fusion_source", "offline");
                    if (mimeTypeFromUrl.equals("js")) {
                        hashMap.put("Access-Control-Allow-Origin", "*");
                    }
                    webResourceResponse.setResponseHeaders(hashMap);
                    SystemUtils.log(3, TAG, uri + " ----shouldInterceptRequest end", (Throwable) null, "com.didi.onehybrid.container.FusionWebViewClient", 295);
                    String pureUrl = UrlTrieTree.getPureUrl(uri);
                    if (pureUrl.endsWith("driver-page/register") || pureUrl.endsWith("driver-page/register/index.html")) {
                        OmegaUtils.offline_url(pureUrl, true);
                    }
                    return webResourceResponse;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            FusionWebView fusionWebView = this.mWebView;
            if (fusionWebView != null && fusionWebView.shouldInterceptRequest()) {
                WebResourceResponse interceptRequest = interceptRequest(uri, requestHeaders);
                if (interceptRequest != null) {
                    this.mFusionRuntimeInfo.addFileCacheUrl(uri);
                } else {
                    this.mFusionRuntimeInfo.addCdnUrl(uri);
                }
                return interceptRequest;
            }
        }
        this.mFusionRuntimeInfo.addCdnUrl(uri);
        return null;
    }

    private WebResourceResponse interceptRequest(String str, Map<String, String> map) {
        WebResourceResponse webResourceResponse = null;
        if (!C10393Util.hasStoragePermissions(this.mContext) || EXCEPTION_COUNT >= 10 || Build.VERSION.SDK_INT < 21) {
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
                    ApolloLog.uploadHttpError((Context) this.mContext, str, th);
                    return webResourceResponse;
                } catch (Exception e) {
                    e.printStackTrace();
                    return webResourceResponse;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            EXCEPTION_COUNT++;
            ApolloLog.uploadHttpError((Context) this.mContext, str, th);
            return webResourceResponse;
        }
    }

    public WebViewJavascriptBridge getJavascriptBridge() {
        return this.mWebJavascriptBridge;
    }

    private void printLog(String str) {
        if (C10393Util.isApkDebug(this.mContext)) {
            SystemUtils.log(4, "HybridLog", str, (Throwable) null, "com.didi.onehybrid.container.FusionWebViewClient", 361);
        }
        Activity activity = this.mContext;
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

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (renderProcessGoneDetail != null && !renderProcessGoneDetail.didCrash()) {
            SystemUtils.log(6, TAG, "System killed the WebView rendering process to reclaim memory. Recreating...", (Throwable) null, "com.didi.onehybrid.container.FusionWebViewClient", 465);
            removeAndFinishCurActivityByRenderProcessGone();
            return true;
        } else if (renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        } else {
            SystemUtils.log(6, TAG, "The WebView rendering process crashed!", (Throwable) null, "com.didi.onehybrid.container.FusionWebViewClient", 485);
            removeAndFinishCurActivityByRenderProcessGone();
            return true;
        }
    }

    private void removeAndFinishCurActivityByRenderProcessGone() {
        ViewGroup viewGroup;
        if (this.mWebView != null) {
            SystemUtils.log(6, TAG, "The WebView rendering process crashed and current url is :" + this.mWebView.getUrl(), (Throwable) null, "com.didi.onehybrid.container.FusionWebViewClient", 500);
            ViewParent parent = this.mWebView.getParent();
            if ((parent instanceof ViewGroup) && (viewGroup = (ViewGroup) parent) != null) {
                viewGroup.removeView(this.mWebView);
                this.mWebView.destroy();
                this.mWebView = null;
            }
        }
        if (this.mContext != null) {
            SystemUtils.log(6, TAG, "The WebView rendering process crashed and current activity is :" + this.mContext, (Throwable) null, "com.didi.onehybrid.container.FusionWebViewClient", 514);
            this.mContext.finish();
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
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
