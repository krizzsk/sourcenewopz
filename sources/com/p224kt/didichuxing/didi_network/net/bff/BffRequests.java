package com.p224kt.didichuxing.didi_network.net.bff;

import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.p224kt.didichuxing.didi_network.DidiNetworkPlugin;
import com.p224kt.didichuxing.didi_network.net.ResponseListener;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.kt.didichuxing.didi_network.net.bff.BffRequests */
public class BffRequests {

    /* renamed from: a */
    private static BffRequests f55481a;

    public static BffRequests getInstance() {
        if (f55481a == null) {
            f55481a = new BffRequests();
        }
        return f55481a;
    }

    public void send(String str, Map<String, Object> map, final ResponseListener responseListener) {
        Bff.call(new IBffProxy.Ability.Builder(DidiNetworkPlugin.mContext, str).setParams(map).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                responseListener.onReceiveResponse(new Gson().toJson((JsonElement) jsonObject));
            }

            public void onFailure(IOException iOException) {
                responseListener.onReceiveError("Connect error");
            }
        }).build());
    }
}
