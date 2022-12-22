package com.didi.dimina.webview.dmwebview;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.datadog.trace.api.Config;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.FontResourceLoader;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.mina.DMMinaPerfRender;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.p106ui.webview.DMWebViewContainer;
import com.didi.dimina.container.p106ui.webview.DMWebViewScrollClient;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.DebugKitStoreUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.NetworkUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.webview.container.FusionWebView;
import com.didi.dimina.webview.container.FusionWebViewClient;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.taxis99.R;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rui.config.RConfigConstants;

public class DMWebView extends FusionWebView implements WebViewEngine {
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static boolean f18245h = false;

    /* renamed from: a */
    private DMMina f18246a;

    /* renamed from: b */
    private DMPage f18247b;

    /* renamed from: c */
    private DMWebViewContainer f18248c;

    /* renamed from: d */
    private DMWebChromeClient f18249d;

    /* renamed from: e */
    private DMWebViewScrollClient f18250e;

    /* renamed from: f */
    private final List<WebViewEngine.OnScrollChangedCallback> f18251f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DMSandboxHelper f18252g;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WebViewEngine.OnTitleReceiveListener f18253i;

    /* renamed from: j */
    private boolean f18254j;

    /* renamed from: k */
    private boolean f18255k = true;

    /* renamed from: l */
    private ProgressBar f18256l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public WebViewEngine.OnWebViewLoadListener f18257m;

    public boolean isSameLayerRenderingReady() {
        return false;
    }

    public DMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13590b();
    }

    public DMWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13590b();
    }

    public DMWebView(Context context) {
        super(context);
        m13590b();
    }

    /* renamed from: b */
    private void m13590b() {
        setHapticFeedbackEnabled(false);
        setBackgroundColor(getContext().getResources().getColor(R.color.dimina_color_00000000));
        setWebContentsDebuggingEnabled(DebugKitStoreUtil.getWebContentsDebuggingEnabled());
        DMWebChromeClient dMWebChromeClient = new DMWebChromeClient(this);
        this.f18249d = dMWebChromeClient;
        setWebChromeClient(dMWebChromeClient);
        WebSettings settings = getSettings();
        settings.setTextZoom(100);
        settings.setMinimumFontSize(1);
        settings.setMinimumLogicalFontSize(1);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                return true;
            }
        });
        if (Dimina.getConfig().isDebug()) {
            settings.setCacheMode(2);
        } else {
            settings.setCacheMode(-1);
        }
    }

    public boolean onCheckIsTextEditor() {
        try {
            return super.onCheckIsTextEditor();
        } catch (Throwable unused) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        for (WebViewEngine.OnScrollChangedCallback onScroll : this.f18251f) {
            onScroll.onScroll(i, i2);
        }
        this.f18250e.onScrollChanged(i, i2, i3, i4);
    }

    public void dmCreate(DMWebViewContainer dMWebViewContainer, DMPage dMPage, DMMina dMMina, DMMinaNavigatorDelegate dMMinaNavigatorDelegate) {
        this.f18246a = dMMina;
        this.f18247b = dMPage;
        this.f18248c = dMWebViewContainer;
        this.f18250e = new DMWebViewScrollClient(dMMina);
        this.f18252g = new DMSandboxHelper(this.f18246a.getConfig());
        String extraUA = this.f18246a.getConfig().getLaunchConfig().getExtraUA();
        if (!TextUtils.isEmpty(extraUA) && !extraUA.startsWith(";")) {
            extraUA = ";" + extraUA;
        }
        String userAgentString = getSettings().getUserAgentString();
        StringBuilder sb = new StringBuilder("native_sdk/2.24.4");
        if (!(Dimina.getConfig() == null || Dimina.getConfig().getApp() == null)) {
            try {
                sb.append(" native_app_version/");
                sb.append(Dimina.getConfig().getAdapterConfig().getWsgService().getAppVersionName(Dimina.getConfig().getApp()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(userAgentString)) {
            if (!userAgentString.startsWith(" ")) {
                sb.append(" ");
            }
            sb.append(userAgentString);
        }
        if (!TextUtils.isEmpty(extraUA)) {
            if (!extraUA.startsWith(" ")) {
                sb.append(" ");
            }
            sb.append(extraUA);
        }
        getSettings().setUserAgentString(sb.toString());
        setWebViewClient(new MyFusionWebViewClient(this));
        DMMinaPerfRender perfRender = this.f18246a.getPerformance().getPerfRender();
        if (perfRender != null) {
            perfRender.addPerfObj2WebView(this);
        }
        m13592c();
    }

    public void dmResume() {
        onResume();
    }

    public void dmPause() {
        onPause();
    }

    public void dmDestroy() {
        clearHistory();
        loadUrl("about:blank");
        freeMemory();
        stopLoading();
        getSettings().setJavaScriptEnabled(false);
        removeAllViews();
        destroy();
        this.f18254j = true;
    }

    public void loadUrl(final String str) {
        LogUtil.iRelease("DMWebView", "loadUrlWithProp: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            super.loadUrl(str);
        } else {
            UIHandlerUtil.post(new Runnable() {
                public void run() {
                    DMWebView.super.loadUrl(str);
                }
            });
        }
    }

    public void evaluateJavascript(String str, final WebViewEngine.WebViewEngineValueCallback<String> webViewEngineValueCallback) {
        if (!this.f18254j) {
            evaluateJavascript(str, new ValueCallback<String>() {
                public void onReceiveValue(String str) {
                    WebViewEngine.WebViewEngineValueCallback webViewEngineValueCallback = webViewEngineValueCallback;
                    if (webViewEngineValueCallback != null) {
                        webViewEngineValueCallback.onReceiveValue(str);
                    }
                }
            });
        }
    }

    public String getUserAgentString() {
        return getSettings().getUserAgentString();
    }

    public void setUserAgentString(String str) {
        getSettings().setUserAgentString(str);
    }

    public void setOnTitleReceiveListener(WebViewEngine.OnTitleReceiveListener onTitleReceiveListener) {
        this.f18253i = onTitleReceiveListener;
        this.f18249d.setOnTitleReceiveListener(onTitleReceiveListener);
    }

    public boolean tryH5GoBack() {
        String str;
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        String url = getUrl();
        int i = -1;
        while (canGoBackOrForward(i) && (!TextUtils.equals(url, "about:blank") || NetworkUtil.isAvailable(getContext()))) {
            WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
            if (itemAtIndex == null) {
                str = null;
            } else {
                str = itemAtIndex.getUrl();
            }
            if (str == null || TextUtils.equals(str, "about:blank")) {
                i--;
            } else {
                goBackOrForward(i);
                return true;
            }
        }
        return false;
    }

    public int getWebViewContentHeight() {
        return Math.round(((float) getContentHeight()) * getResources().getDisplayMetrics().density);
    }

    public DMWebViewScrollClient getDiminaWebViewScrollClient() {
        return this.f18250e;
    }

    public void addScrollChangedCallback(WebViewEngine.OnScrollChangedCallback onScrollChangedCallback) {
        if (!this.f18251f.contains(onScrollChangedCallback)) {
            this.f18251f.add(onScrollChangedCallback);
        }
    }

    public void removeScrollChangedCallback(WebViewEngine.OnScrollChangedCallback onScrollChangedCallback) {
        this.f18251f.remove(onScrollChangedCallback);
    }

    public DMMina getDmMina() {
        return this.f18246a;
    }

    public DMPage getDmPage() {
        return this.f18247b;
    }

    public DMWebViewContainer getContainer() {
        return this.f18248c;
    }

    public FusionWebView getWebView() {
        return super.getWebView();
    }

    public void setOnLoadStatusListener(WebViewEngine.OnWebViewLoadListener onWebViewLoadListener) {
        this.f18257m = onWebViewLoadListener;
    }

    private class MyFusionWebViewClient extends FusionWebViewClient {
        private WebViewEngine mDMWebView;
        private WebViewClient mWebViewClient;

        MyFusionWebViewClient(WebViewEngine webViewEngine) {
            super(webViewEngine.getActivity(), DMWebView.this);
            this.mDMWebView = webViewEngine;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            String title = webView.getTitle();
            if (!TextUtils.isEmpty(title) && !URLUtil.isNetworkUrl(title) && !title.endsWith(".html") && !title.endsWith(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX) && DMWebView.this.f18253i != null) {
                DMWebView.this.f18253i.onReceiveTitle(title);
            }
            if (DMWebView.this.f18257m != null) {
                DMWebView.this.f18257m.onPageFinished(DMWebView.this, str);
            }
        }

        public void setWebviewClient(WebViewClient webViewClient) {
            super.setWebviewClient(webViewClient);
            this.mWebViewClient = webViewClient;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Boolean shouldOverrideUrlLoading;
            if (str.startsWith("fusion://")) {
                if (str.startsWith("fusion://invokeNative")) {
                    getJavascriptBridge().handleInvokeFromJs(str);
                    return true;
                } else if (str.startsWith("fusion://callbackNative")) {
                    getJavascriptBridge().handleResponseFromJS(str);
                    return true;
                }
            } else if (str.startsWith("tel")) {
                try {
                    webView.getContext().startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)).addFlags(268435456));
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (DMWebView.this.f18257m != null && (shouldOverrideUrlLoading = DMWebView.this.f18257m.shouldOverrideUrlLoading(DMWebView.this, str)) != WebViewEngine.OnWebViewLoadListener.CONTINUE_OVERRIDE) {
                return shouldOverrideUrlLoading.booleanValue();
            }
            WebViewClient webViewClient = this.mWebViewClient;
            return webViewClient == null ? super.shouldOverrideUrlLoading(webView, str) : webViewClient.shouldOverrideUrlLoading(webView, str);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse shouldInterceptRequest;
            LogUtil.m13411i("webview interceptReq, url===" + str);
            if (isVirtualDomainUrl(str)) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(DMWebView.this.f18252g.url2filepath(str));
                    String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
                    String str2 = AsyncHttpRequest.HEADER_ACCEPT_ALL;
                    if (!TextUtils.isEmpty(fileExtensionFromUrl)) {
                        if (fileExtensionFromUrl.equals("js")) {
                            str2 = "application/x-javascript";
                        } else {
                            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
                        }
                    }
                    return new WebResourceResponse(str2, "UTF-8", fileInputStream);
                } catch (Exception e) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", str);
                        hashMap.put("error", Log.getStackTraceString(e));
                        TraceUtil.trackEventError(this.mDMWebView.getDmMina().getMinaIndex(), "WebviewException", 1001, JSONUtil.toJson(hashMap));
                        return null;
                    } catch (Exception unused) {
                        return null;
                    }
                }
            } else if (FontResourceLoader.isFontRequest(str)) {
                return FontResourceLoader.getFontResourceResponse(DMWebView.this.getContext(), Uri.parse(str));
            } else {
                if (DMWebView.this.f18257m == null || (shouldInterceptRequest = DMWebView.this.f18257m.shouldInterceptRequest((WebViewEngine) DMWebView.this, str, getPathFromPage())) == null) {
                    return super.shouldInterceptRequest(webView, str);
                }
                return shouldInterceptRequest;
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse shouldInterceptRequest;
            try {
                String uri = webResourceRequest.getUrl().toString();
                LogUtil.m13411i("webview interceptReq2, url===" + uri);
                if (FontResourceLoader.isFontRequest(uri)) {
                    return FontResourceLoader.getFontResourceResponse(DMWebView.this.getContext(), webResourceRequest.getUrl());
                }
                if (isVirtualDomainUrl(uri)) {
                    return shouldInterceptRequest(webView, uri);
                }
                if (DMWebView.this.f18257m == null || (shouldInterceptRequest = DMWebView.this.f18257m.shouldInterceptRequest((WebViewEngine) DMWebView.this, webResourceRequest, getPathFromPage())) == null) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
                return shouldInterceptRequest;
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.m13409e("shouldInterceptRequest 发生异常, " + e.toString());
                if (this.mDMWebView.getDmMina() != null) {
                    TraceUtil.trackWvInterceptorRequestError(this.mDMWebView.getDmMina().getMinaIndex(), webResourceRequest.getUrl().toString(), e);
                }
                return null;
            }
        }

        private String getPathFromPage() {
            try {
                return DMWebView.this.getDmPage().getUrl();
            } catch (Throwable unused) {
                return null;
            }
        }

        private boolean isVirtualDomainUrl(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith(DMSandboxHelper.VIRTUAL_DOMAIN_URL);
        }

        public void onLoadResource(WebView webView, String str) {
            if (str.endsWith("origin=")) {
                str = str + Config.DEFAULT_AGENT_HOST;
            }
            super.onLoadResource(webView, str);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            String str = "";
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            DMMina dmMina = this.mDMWebView.getDmMina();
            if (dmMina != null) {
                try {
                    String str2 = dmMina.getConfig().getLaunchConfig().getAppId() + str;
                    if (webResourceError != null) {
                        str = webResourceError.toString();
                        if (Build.VERSION.SDK_INT >= 23 && webResourceError.getDescription() != null) {
                            str = webResourceError.getErrorCode() + RConfigConstants.KEYWORD_COLOR_SIGN + webResourceError.getDescription().toString();
                        }
                        if (!(Build.VERSION.SDK_INT < 21 || webResourceRequest == null || webResourceRequest.getUrl() == null)) {
                            str = str + "#url:" + webResourceRequest.getUrl();
                        }
                    }
                    TraceUtil.traceLoadError(dmMina.getMinaIndex(), webView.getUrl(), str2, str);
                } catch (Exception unused) {
                }
            }
            if (DMWebView.this.f18257m != null) {
                DMWebView.this.f18257m.onReceivedError(DMWebView.this, webResourceRequest.getUrl().toString());
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            DMMina dmMina = this.mDMWebView.getDmMina();
            if (dmMina != null) {
                try {
                    String appId = dmMina.getConfig().getLaunchConfig().getAppId();
                    String url = webView.getUrl();
                    TraceUtil.traceLoadError(dmMina.getMinaIndex(), url, appId, i + RConfigConstants.KEYWORD_COLOR_SIGN + str + "#url:" + str2);
                } catch (Exception unused) {
                }
            }
            if (DMWebView.this.f18257m != null) {
                DMWebView.this.f18257m.onReceivedError(DMWebView.this, str2);
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            DMMina dmMina = this.mDMWebView.getDmMina();
            if (dmMina != null) {
                try {
                    String appId = dmMina.getConfig().getLaunchConfig().getAppId();
                    String url = webView.getUrl();
                    Uri url2 = webResourceRequest.getUrl();
                    StringBuilder sb = new StringBuilder();
                    if (url2 != null) {
                        sb.append(url2.getScheme());
                        sb.append(HWMapConstant.HTTP.SEPARATOR);
                        sb.append(url2.getHost());
                        sb.append(url2.getPath());
                    }
                    int i = 0;
                    if (webResourceResponse != null) {
                        i = webResourceResponse.getStatusCode();
                    }
                    TraceUtil.traceLoadError(dmMina.getMinaIndex(), url, appId, i + "#url:" + url2);
                    if (DMWebView.this.f18257m != null) {
                        DMWebView.this.f18257m.onReceivedError(DMWebView.this, sb.toString());
                    }
                } catch (Exception unused) {
                }
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (!DMWebView.f18245h && !Dimina.getConfig().getAdapterConfig().getWsgService().isBackground(DMWebView.this.getContext())) {
                boolean unused = DMWebView.f18245h = true;
                TraceUtil.traceWebViewCrash(this.mDMWebView.getDmMina().getMinaIndex());
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
    }

    /* renamed from: c */
    private void m13592c() {
        try {
            if (!this.f18255k) {
                return;
            }
            if (this.f18256l == null) {
                ProgressBar progressBar = new ProgressBar(getContext(), (AttributeSet) null, 16842872);
                this.f18256l = progressBar;
                progressBar.setLayoutParams(new ViewGroup.LayoutParams(-1, 6));
                this.f18256l.setProgressDrawable(new ClipDrawable(new ColorDrawable(this.f18246a.getConfig().getUIConfig().getProgressBarColor()), 3, 1));
                this.f18256l.setVisibility(8);
                addView(this.f18256l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNeedShowProgressBar(boolean z) {
        ProgressBar progressBar;
        this.f18255k = z;
        if (!z && (progressBar = this.f18256l) != null) {
            removeView(progressBar);
            this.f18256l = null;
        }
    }

    public void showLoadProgress(int i) {
        ProgressBar progressBar;
        if (this.f18255k && (progressBar = this.f18256l) != null) {
            if (progressBar.getVisibility() == 8) {
                this.f18256l.setVisibility(0);
            }
            this.f18256l.setProgress(i);
        }
    }

    public void hiddenLoadProgress() {
        ProgressBar progressBar = this.f18256l;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }
}
