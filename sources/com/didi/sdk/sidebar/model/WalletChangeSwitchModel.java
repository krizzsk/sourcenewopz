package com.didi.sdk.sidebar.model;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.business.BffCallbackAdapter;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.sdk.bff.BffConstants;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

public class WalletChangeSwitchModel {

    /* renamed from: a */
    private Context f37425a;

    public WalletChangeSwitchModel(Context context) {
        this.f37425a = context;
    }

    public void getSwitchStatus(BffResponseListener<WalletChangeResponse> bffResponseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("switch_key", "wallet_return_change_switch");
        Bff.call(new IBffProxy.Ability.Builder(this.f37425a, BffConstants.AbilityID.ABILITY_GET_STATUS).setParams(hashMap).setBffCallBack(new BffCallbackAdapter(bffResponseListener)).build());
    }

    public void setSwitchStatus(boolean z, BffResponseListener<WalletChangeResponse> bffResponseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("switch_key", "wallet_return_change_switch");
        hashMap.put("switch_status", z ? "1" : "2");
        Bff.call(new IBffProxy.Ability.Builder(this.f37425a, BffConstants.AbilityID.ABILITY_SET_STATUS).setParams(hashMap).setBffCallBack(new BffCallbackAdapter(bffResponseListener)).build());
    }

    public class WalletChangeResponse extends BffBaseObject {
        @SerializedName("wallet_return_change_switch")
        public String changeSwitchFlag;

        public WalletChangeResponse() {
        }
    }
}
