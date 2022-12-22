package com.didi.dimina.container.webengine;

import android.app.Activity;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.p106ui.webview.DMWebViewContainer;
import com.didi.dimina.container.p106ui.webview.DMWebViewScrollClient;
import com.didi.dimina.container.page.DMPage;

public interface WebViewEngine {

    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2);
    }

    public interface OnTitleReceiveListener {
        void onReceiveTitle(String str);
    }

    public interface OnWebViewLoadListener {
        public static final Boolean CONTINUE_OVERRIDE = null;

        void onPageFinished(WebViewEngine webViewEngine, String str);

        void onReceivedError(WebViewEngine webViewEngine, String str);

        WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, WebResourceRequest webResourceRequest, String str);

        WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, String str, String str2);

        Boolean shouldOverrideUrlLoading(WebViewEngine webViewEngine, String str);
    }

    public interface WebViewEngineValueCallback<T> {
        void onReceiveValue(T t);
    }

    void addJavascriptInterface(Object obj, String str);

    void addScrollChangedCallback(OnScrollChangedCallback onScrollChangedCallback);

    void dmCreate(DMWebViewContainer dMWebViewContainer, DMPage dMPage, DMMina dMMina, DMMinaNavigatorDelegate dMMinaNavigatorDelegate);

    void dmDestroy();

    void dmPause();

    void dmResume();

    void evaluateJavascript(String str, WebViewEngineValueCallback<String> webViewEngineValueCallback);

    Activity getActivity();

    DMWebViewContainer getContainer();

    DMWebViewScrollClient getDiminaWebViewScrollClient();

    DMMina getDmMina();

    DMPage getDmPage();

    String getTitle();

    String getUrl();

    String getUserAgentString();

    ViewGroup getWebView();

    int getWebViewContentHeight();

    boolean isSameLayerRenderingReady();

    void loadUrl(String str);

    void removeScrollChangedCallback(OnScrollChangedCallback onScrollChangedCallback);

    void setNeedShowProgressBar(boolean z);

    void setOnLoadStatusListener(OnWebViewLoadListener onWebViewLoadListener);

    void setOnTitleReceiveListener(OnTitleReceiveListener onTitleReceiveListener);

    void setUserAgentString(String str);

    boolean tryH5GoBack();
}
