package com.didi.sdk.fusionbridge;

import android.app.Application;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.FusionInitConfig;
import com.didi.sdk.fusionbridge.module.ContactModule;
import com.didi.sdk.fusionbridge.module.ShareEntranceModule;
import com.didi.sdk.fusionbridge.module.ShareModule;
import com.didi.sdk.fusionbridge.module.WalletModule;
import com.didi.sdk.webview.ExtendFusionBridgeModule;

public class FusionInitializer {
    public static void execute(Application application) {
        FusionEngine.init(application, new FusionInitConfig.Builder().setBusinessAgent(new GlobalBusinessAgent(application)).addExtraAttr("progressbar_color", -224941).build());
        m25453a();
    }

    /* renamed from: a */
    private static void m25453a() {
        FusionEngine.export("ShareModule", ShareModule.class);
        FusionEngine.export("ContactModule", ContactModule.class);
        FusionEngine.export("ShareEntranceModule", ShareEntranceModule.class);
        FusionEngine.export("DidiBridgeAdapter", ExtendFusionBridgeModule.class);
        FusionEngine.export("walletModule", WalletModule.class);
    }
}
