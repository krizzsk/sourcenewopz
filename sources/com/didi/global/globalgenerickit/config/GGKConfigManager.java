package com.didi.global.globalgenerickit.config;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GGKConfigManager {
    public static void legoConfig(FragmentActivity fragmentActivity, JSONObject jSONObject, String str) {
        legoConfig(fragmentActivity, jSONObject, str, (GGKConfigCallbackAdapter) null);
    }

    public static void legoConfig(FragmentActivity fragmentActivity, JSONObject jSONObject, String str, GGKConfigCallbackAdapter gGKConfigCallbackAdapter) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            for (String equals : GGKConfigProcessor.getMaps().keySet()) {
                if (str.equals(equals)) {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("list");
                        IConfig iConfig = GGKConfigProcessor.getMaps().get(str);
                        if (!(jSONArray == null || iConfig == null)) {
                            iConfig.show(fragmentActivity, jSONArray, gGKConfigCallbackAdapter);
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void requestConfig(FragmentActivity fragmentActivity, Map<String, Object> map, String str, String str2, String str3) {
        requestConfig(fragmentActivity, map, str, str2, str3, (GGKConfigCallbackAdapter) null);
    }

    public static void requestConfig(final FragmentActivity fragmentActivity, Map<String, Object> map, String str, String str2, String str3, final GGKConfigCallbackAdapter gGKConfigCallbackAdapter) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("business_scene", str);
        if (map != null) {
            hashMap2.putAll(map);
        }
        hashMap.put(str3, new JSONObject(hashMap2));
        C85711 r4 = new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                JsonObject asJsonObject;
                SystemUtils.log(3, "Test", "====GGKConfigManager requestConfig onSuccess====Json: " + jsonObject.toString(), (Throwable) null, "com.didi.global.globalgenerickit.config.GGKConfigManager$1", 107);
                try {
                    if (jsonObject.get("errno").getAsInt() == 0 && jsonObject.has("data") && (asJsonObject = jsonObject.getAsJsonObject("data")) != null) {
                        GGKConfigManager.m15993b(fragmentActivity, new JSONObject(asJsonObject.toString()), gGKConfigCallbackAdapter);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFailure(IOException iOException) {
                SystemUtils.log(3, "Test", "====GGKConfigManager requestConfig onFailure====exception: " + iOException.getMessage(), (Throwable) null, "com.didi.global.globalgenerickit.config.GGKConfigManager$1", 127);
            }
        };
        if (!TextUtils.isEmpty(str2)) {
            Bff.call(new IBffProxy.Ability.Builder(fragmentActivity, "expo/passenger").setParams(hashMap).setServiceId(str2).setCallback(r4).build());
        } else {
            Bff.call(new IBffProxy.Ability.Builder(fragmentActivity, "expo/passenger").setParams(hashMap).setCallback(r4).build());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m15993b(FragmentActivity fragmentActivity, JSONObject jSONObject, GGKConfigCallbackAdapter gGKConfigCallbackAdapter) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    Iterator<String> it = GGKConfigProcessor.getMaps().keySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (next.equals(it.next())) {
                            try {
                                JSONArray jSONArray = jSONObject.getJSONObject(next).getJSONArray("list");
                                IConfig iConfig = GGKConfigProcessor.getMaps().get(next);
                                if (!(jSONArray == null || iConfig == null)) {
                                    SystemUtils.log(3, "Test", "====GGKConfigManager legoConfig : " + jSONArray.length(), (Throwable) null, "com.didi.global.globalgenerickit.config.GGKConfigManager", 172);
                                    iConfig.show(fragmentActivity, jSONArray, gGKConfigCallbackAdapter);
                                    break;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
