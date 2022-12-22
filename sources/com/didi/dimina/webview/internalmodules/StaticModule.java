package com.didi.dimina.webview.internalmodules;

import com.didi.dimina.container.bridge.base.BaseHybridModule;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.webview.container.FusionWebView;
import com.didi.dimina.webview.jsbridge.WebViewJavascriptBridge;
import org.json.JSONArray;

public class StaticModule extends BaseHybridModule {

    /* renamed from: a */
    private final WebViewJavascriptBridge f18259a;

    public StaticModule(WebViewEngine webViewEngine) {
        super(webViewEngine);
        this.f18259a = ((FusionWebView) webViewEngine.getWebView()).getJavascriptBridge();
    }

    @JsInterface({"getExportMethods"})
    public void getExportModules(CallbackFunction callbackFunction) {
        JSONArray exportModules = this.f18259a.getExportModules();
        if (callbackFunction != null) {
            callbackFunction.onCallBack(exportModules);
        }
    }
}
