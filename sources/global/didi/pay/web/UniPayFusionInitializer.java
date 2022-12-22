package global.didi.pay.web;

import android.app.Application;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.FusionInitConfig;
import com.didi.onehybrid.jsbridge.ExportNamespace;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import global.didi.pay.web.p237js.UniPayBridgeModule;

public class UniPayFusionInitializer {
    private static final String DEFAULT_MODULE_NAME = "DidiBridgeAdapter";

    public static void init(Application application, BusinessAgent businessAgent) {
        FusionEngine.init(application, new FusionInitConfig.Builder().setBusinessAgent(businessAgent).build());
    }

    public static void exportUniPayWebBridge() {
        if (!isExportModuleNameExist("DidiBridgeAdapter")) {
            FusionEngine.export("DidiBridgeAdapter", UniPayBridgeModule.class);
        }
    }

    private static boolean isExportModuleNameExist(String str) {
        ExportNamespace exportNamespace;
        if (WebViewJavascriptBridge.namespaceMap == null || (exportNamespace = WebViewJavascriptBridge.namespaceMap.get("DidiBridgeAdapter")) == null || !str.equals(exportNamespace.getExportModuleName())) {
            return false;
        }
        return true;
    }
}
