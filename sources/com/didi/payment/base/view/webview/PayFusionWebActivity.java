package com.didi.payment.base.view.webview;

import android.app.Application;
import android.os.Bundle;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.FusionInitConfig;
import com.didi.payment.base.view.webview.fusion.FusionAgent;
import com.didi.payment.base.view.webview.fusion.model.FusionBridgeModule;
import com.didi.sdk.apm.SystemUtils;

public class PayFusionWebActivity extends PayBaseWebActivity {
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m21036a(getApplication());
        FusionEngine.export("DidiBridgeAdapter", FusionBridgeModule.class);
        super.onCreate(bundle);
    }

    /* renamed from: a */
    private void m21036a(Application application) {
        FusionEngine.init(application, new FusionInitConfig.Builder().setBusinessAgent(new FusionAgent(application)).build());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            Class<?> cls = Class.forName("com.didi.sdk.fusionbridge.module.FusionBridgeModule");
            if (cls != null) {
                FusionEngine.export("DidiBridgeAdapter", cls);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public FusionBridgeModule getFusionBridge() {
        if (this.mWebView == null) {
            return null;
        }
        return (FusionBridgeModule) this.mWebView.getExportModuleInstance(FusionBridgeModule.class);
    }
}
