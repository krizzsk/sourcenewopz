package com.didi.dimina.container.bridge.base;

import com.didi.dimina.container.webengine.WebViewEngine;

public class BaseHybridModule {
    public WebViewEngine mDMWebViewDelegate;

    public void onDestroy() {
    }

    public BaseHybridModule(WebViewEngine webViewEngine) {
        this.mDMWebViewDelegate = webViewEngine;
    }
}
