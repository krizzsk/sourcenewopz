package com.didi.onehybrid.internalmodules;

import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import org.json.JSONArray;

public class StaticModule extends BaseHybridModule {

    /* renamed from: a */
    private WebViewJavascriptBridge f29594a;

    public StaticModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f29594a = hybridableContainer.getWebView().getJavascriptBridge();
    }

    @JsInterface({"getExportMethods"})
    public void getExportModules(CallbackFunction callbackFunction) {
        JSONArray exportModules = this.f29594a.getExportModules();
        if (callbackFunction != null) {
            callbackFunction.onCallBack(exportModules);
        }
    }
}
