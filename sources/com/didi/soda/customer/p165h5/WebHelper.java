package com.didi.soda.customer.p165h5;

import android.app.Application;
import com.didi.foundation.sdk.log.LogService;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.FusionWebViewClient;
import com.didi.security.wireless.adapter.WSGHybridModule;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.p165h5.hybird.CustomerBizAgent;
import com.didi.soda.customer.p165h5.hybird.CustomerGlobalJsBridge;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridModule;
import com.didi.soda.web.WebInitializer;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.tools.LogUtil;
import com.didichuxing.omega.sdk.analysis.OmegaJS;
import com.didichuxing.omega.sdk.analysis.OmegaWebViewClient;

/* renamed from: com.didi.soda.customer.h5.WebHelper */
public class WebHelper {

    /* renamed from: a */
    private static final String f41307a = "WebHelper";

    public static void init(Application application) {
        WebInitializer.start(application).setBusinessAgent(new CustomerBizAgent(application)).exportGlobalJsBridge(CustomerGlobalJsBridge.class).exportJsBridge(CustomerHybridModule.NAME_SPACE, CustomerHybridModule.class).exportJsBridge("WSGHybridModule", WSGHybridModule.class).isAddFusionAgent(!GlobalContext.isEmbed()).setProgressBarColor(SkinUtil.getBrandPrimaryColor()).setLogUtil(new LogUtil.LogInterface() {
            public void debug(String str) {
                LogService.getLogger(WebConstant.WEB_LOG_TAG).debug(str, new Object[0]);
            }

            public void erro(String str) {
                LogService.getLogger(WebConstant.WEB_LOG_TAG).error(str, new Object[0]);
            }

            public void info(String str) {
                LogService.getLogger(WebConstant.WEB_LOG_TAG).info(str, new Object[0]);
            }
        }).execute();
    }

    public static void attachOmegaJS(FusionWebView fusionWebView, FusionWebViewClient fusionWebViewClient) {
        if (CustomerApolloUtil.isWebViewOmegaOn()) {
            com.didi.soda.customer.foundation.log.util.LogUtil.m29100d(f41307a, "isWebViewOmegaOn");
            fusionWebViewClient.setWebviewClient(new OmegaWebViewClient());
            fusionWebView.addJavascriptInterface(OmegaJS.getInstance(), "OmegaSDK");
            return;
        }
        com.didi.soda.customer.foundation.log.util.LogUtil.m29100d(f41307a, "isWebViewOmegaOff");
    }
}
