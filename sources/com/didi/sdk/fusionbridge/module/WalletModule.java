package com.didi.sdk.fusionbridge.module;

import android.app.Activity;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import org.json.JSONObject;

public class WalletModule extends BaseHybridModule {

    /* renamed from: a */
    private Activity f36007a;

    public WalletModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f36007a = hybridableContainer.getActivity();
    }

    @JsInterface({"gotoWallet"})
    public void skipToWalletHomepage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity(this.f36007a, 1, new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_H5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
