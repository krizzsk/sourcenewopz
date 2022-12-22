package com.android.didi.bfflib.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.Map;

public class BffRequest {
    private Bff.BffConfig mBffConfig;
    private Context mContext;
    private IBffRpcService mService;

    public BffRequest(Context context, Bff.BffConfig bffConfig) {
        this.mContext = context;
        this.mBffConfig = bffConfig;
        this.mService = (IBffRpcService) new RpcServiceFactory(context).newRpcService(IBffRpcService.class, this.mBffConfig.getHostAddr());
    }

    public void requestAbility(Map<String, Object> map, RpcService.Callback<String> callback) {
        this.mService.ability(map, callback);
    }

    public void requestAbilityV2(Map<String, Object> map, RpcService.CallbackV2<String> callbackV2) {
        this.mService.abilityV2(map, callbackV2);
    }
}
