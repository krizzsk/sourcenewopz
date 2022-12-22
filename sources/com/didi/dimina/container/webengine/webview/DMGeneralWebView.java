package com.didi.dimina.container.webengine.webview;

import android.app.Activity;
import android.content.Context;
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
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.taxis99.R;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rui.config.RConfigConstants;

public class DMGeneralWebView extends WebView implements WebViewEngine {
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static boolean f17980h = false;

    /* renamed from: a */
    private DMMina f17981a;

    /* renamed from: b */
    private DMPage f17982b;

    /* renamed from: c */
    private DMWebViewContainer f17983c;

    /* renamed from: d */
    private DMGeneralWebChromeClient f17984d;

    /* renamed from: e */
    private DMWebViewScrollClient f17985e;

    /* renamed from: f */
    private final List<WebViewEngine.OnScrollChangedCallback> f17986f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DMSandboxHelper f17987g;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WebViewEngine.OnTitleReceiveListener f17988i;

    /* renamed from: j */
    private Activity f17989j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public WebViewEngine.OnWebViewLoadListener f17990k;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m13450a(View view) {
        return true;
    }

    public ViewGroup getWebView() {
        return this;
    }

    public boolean isSameLayerRenderingReady() {
        return false;
    }

    public void setNeedShowProgressBar(boolean z) {
    }

    public DMGeneralWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13447a(context);
    }

    public DMGeneralWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13447a(context);
    }

    public DMGeneralWebView(Context context) {
        super(context);
        m13447a(context);
    }

    /* renamed from: a */
    private void m13447a(Context context) {
        if (context instanceof Activity) {
            this.f17989j = (Activity) context;
            WebSettings settings = getSettings();
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setJavaScriptEnabled(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(false);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setDomStorageEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(false);
            settings.setAppCacheMaxSize(10485760);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            setHapticFeedbackEnabled(false);
            setBackgroundColor(getContext().getResources().getColor(R.color.dimina_color_00000000));
            setWebContentsDebuggingEnabled(DebugKitStoreUtil.getWebContentsDebuggingEnabled());
            DMGeneralWebChromeClient dMGeneralWebChromeClient = new DMGeneralWebChromeClient(this);
            this.f17984d = dMGeneralWebChromeClient;
            setWebChromeClient(dMGeneralWebChromeClient);
            settings.setTextZoom(100);
            settings.setMinimumFontSize(1);
            settings.setMinimumLogicalFontSize(1);
            settings.setSupportZoom(false);
            settings.setDisplayZoomControls(false);
            settings.setAllowFileAccess(true);
            settings.setAllowContentAccess(true);
            setOnLongClickListener($$Lambda$DMGeneralWebView$ZpAhfPexcGm_VzZBFSEgDyvZtWA.INSTANCE);
            if (Dimina.getConfig().isDebug()) {
                settings.setCacheMode(2);
            } else {
                settings.setCacheMode(-1);
            }
        } else {
            throw new RuntimeException("WebView only support Activity context");
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
        for (WebViewEngine.OnScrollChangedCallback onScroll : this.f17986f) {
            onScroll.onScroll(i, i2);
        }
        this.f17985e.onScrollChanged(i, i2, i3, i4);
    }

    private class MyGeneralWebViewClient extends WebViewClient {
        private final WebViewEngine mDMWebView;

        MyGeneralWebViewClient(WebViewEngine webViewEngine) {
            this.mDMWebView = webViewEngine;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            String title = webView.getTitle();
            if (!TextUtils.isEmpty(title) && !URLUtil.isNetworkUrl(title) && !title.endsWith(".html") && !title.endsWith(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX) && DMGeneralWebView.this.f17988i != null) {
                DMGeneralWebView.this.f17988i.onReceiveTitle(title);
            }
            if (DMGeneralWebView.this.f17990k != null) {
                DMGeneralWebView.this.f17990k.onPageFinished(DMGeneralWebView.this, str);
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            LogUtil.m13411i("webview interceptReq, url===" + str);
            if (isVirtualDomainUrl(str)) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(DMGeneralWebView.this.f17987g.url2filepath(str));
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
                return FontResourceLoader.getFontResourceResponse(DMGeneralWebView.this.getContext(), Uri.parse(str));
            } else {
                return super.shouldInterceptRequest(webView, str);
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                String uri = webResourceRequest.getUrl().toString();
                LogUtil.m13411i("webview interceptReq2, url===" + uri);
                if (FontResourceLoader.isFontRequest(uri)) {
                    return FontResourceLoader.getFontResourceResponse(DMGeneralWebView.this.getContext(), webResourceRequest.getUrl());
                }
                if (isVirtualDomainUrl(uri)) {
                    return shouldInterceptRequest(webView, uri);
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.m13409e("shouldInterceptRequest 发生异常, " + e.toString());
                if (this.mDMWebView.getDmMina() != null) {
                    TraceUtil.trackWvInterceptorRequestError(this.mDMWebView.getDmMina().getMinaIndex(), webResourceRequest.getUrl().toString(), e);
                }
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
            if (DMGeneralWebView.this.f17990k != null && webResourceRequest != null) {
                DMGeneralWebView.this.f17990k.onReceivedError(DMGeneralWebView.this, webResourceRequest.getUrl().toString());
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
            if (DMGeneralWebView.this.f17990k != null) {
                DMGeneralWebView.this.f17990k.onReceivedError(DMGeneralWebView.this, str2);
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
                    if (DMGeneralWebView.this.f17990k != null) {
                        DMGeneralWebView.this.f17990k.onReceivedError(DMGeneralWebView.this, sb.toString());
                    }
                } catch (Exception unused) {
                }
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (!DMGeneralWebView.f17980h && !Dimina.getConfig().getAdapterConfig().getWsgService().isBackground(DMGeneralWebView.this.getContext())) {
                boolean unused = DMGeneralWebView.f17980h = true;
                TraceUtil.traceWebViewCrash(this.mDMWebView.getDmMina().getMinaIndex());
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
    }

    public DMMina getDmMina() {
        return this.f17981a;
    }

    public DMPage getDmPage() {
        return this.f17982b;
    }

    public DMWebViewContainer getContainer() {
        return this.f17983c;
    }

    public Activity getActivity() {
        return this.f17989j;
    }

    public void setOnLoadStatusListener(WebViewEngine.OnWebViewLoadListener onWebViewLoadListener) {
        this.f17990k = onWebViewLoadListener;
    }

    public void dmCreate(DMWebViewContainer dMWebViewContainer, DMPage dMPage, DMMina dMMina, DMMinaNavigatorDelegate dMMinaNavigatorDelegate) {
        this.f17981a = dMMina;
        this.f17982b = dMPage;
        this.f17983c = dMWebViewContainer;
        this.f17985e = new DMWebViewScrollClient(dMMina);
        this.f17987g = new DMSandboxHelper(this.f17981a.getConfig());
        String extraUA = this.f17981a.getConfig().getLaunchConfig().getExtraUA();
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
        setWebViewClient(new MyGeneralWebViewClient(this));
        DMMinaPerfRender perfRender = this.f17981a.getPerformance().getPerfRender();
        if (perfRender != null) {
            perfRender.addPerfObj2WebView(this);
        }
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
    }

    public void loadUrl(final String str) {
        LogUtil.iRelease("DMGeneralWebView", "loadUrlWithProp: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            super.loadUrl(str);
        } else {
            UIHandlerUtil.post(new Runnable() {
                public void run() {
                    DMGeneralWebView.super.loadUrl(str);
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
        this.f17988i = onTitleReceiveListener;
        this.f17984d.setOnTitleReceiveListener(onTitleReceiveListener);
    }

    public String getUrl() {
        return super.getUrl();
    }

    public void evaluateJavascript(String str, final WebViewEngine.WebViewEngineValueCallback<String> webViewEngineValueCallback) {
        evaluateJavascript(str, new ValueCallback<String>() {
            public void onReceiveValue(String str) {
                WebViewEngine.WebViewEngineValueCallback webViewEngineValueCallback = webViewEngineValueCallback;
                if (webViewEngineValueCallback != null) {
                    webViewEngineValueCallback.onReceiveValue(str);
                }
            }
        });
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
        return this.f17985e;
    }

    public void addScrollChangedCallback(WebViewEngine.OnScrollChangedCallback onScrollChangedCallback) {
        if (!this.f17986f.contains(onScrollChangedCallback)) {
            this.f17986f.add(onScrollChangedCallback);
        }
    }

    public void removeScrollChangedCallback(WebViewEngine.OnScrollChangedCallback onScrollChangedCallback) {
        this.f17986f.remove(onScrollChangedCallback);
    }
}
