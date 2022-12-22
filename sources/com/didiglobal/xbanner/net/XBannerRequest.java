package com.didiglobal.xbanner.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.xbanner.net.model.BizParams;
import com.google.gson.JsonObject;
import java.util.HashMap;
import org.json.JSONObject;

public class XBannerRequest {

    /* renamed from: a */
    private static final String f51474a = "passenger_xbanner";

    public static void expoRequest(Context context, String str, BizParams bizParams, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("select_lat", Float.valueOf(bizParams.select_lat));
        hashMap.put("select_lng", Float.valueOf(bizParams.select_lng));
        hashMap.put("user_loc_accuracy", Float.valueOf(bizParams.user_loc_accuracy));
        hashMap.put("user_loc_provider", bizParams.user_loc_provider);
        hashMap.put("page_state", Integer.valueOf(bizParams.page_state));
        hashMap.put("station_switch", Integer.valueOf(bizParams.station_switch));
        JSONObject jSONObject = new JSONObject(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("biz_param", jSONObject);
        hashMap2.put("scene", str);
        JSONObject jSONObject2 = new JSONObject(hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("passenger_xbanner", jSONObject2);
        Bff.callImmediately(new IBffProxy.Ability.Builder(context, "expo/passenger").setParams(hashMap3).setCallback(callback).build());
    }
}
