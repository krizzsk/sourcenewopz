package com.didiglobal.privacysdk.bff;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.one.netdetect.http.ResponseListener;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.privacysdk.GlobalPrivacySDK;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BffService {
    public static void getFeatureList(Context context, final ResponseListener<Map<String, Boolean>> responseListener, final List<String> list) {
        if (list != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            put(hashMap, "ticket", m36362a());
            put(hashMap, "uID", m36364b());
            put(hashMap, "appID", getAppId(context));
            put(hashMap, "appType", m36363a(context));
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strArr[i] = list.get(i);
            }
            hashMap.put("features", strArr);
            Bff.call(new IBffProxy.Ability.Builder(context, "pmc/getFeatureBatch").setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    HashMap hashMap = new HashMap();
                    try {
                        JsonObject asJsonObject = jsonObject.get("data").getAsJsonObject();
                        for (String str : list) {
                            boolean z = true;
                            if (asJsonObject.get(str).getAsJsonObject().get("featureState").getAsInt() != 1) {
                                z = false;
                            }
                            hashMap.put(str, Boolean.valueOf(z));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ResponseListener responseListener = responseListener;
                    if (responseListener != null) {
                        responseListener.onSuccess(hashMap);
                    }
                }

                public void onFailure(IOException iOException) {
                    ResponseListener responseListener = responseListener;
                    if (responseListener != null) {
                        responseListener.onFail(iOException);
                    }
                }
            }).build());
        }
    }

    public static void setFeature(Context context, String str, boolean z, final ResponseListener<JsonObject> responseListener) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            put(hashMap, "ticket", m36362a());
            put(hashMap, "uID", m36364b());
            put(hashMap, "appID", getAppId(context));
            put(hashMap, "appType", m36363a(context));
            put(hashMap, "feature", str);
            putInteger(hashMap, "featureState", Integer.valueOf(z ? 1 : 2));
            Bff.call(new IBffProxy.Ability.Builder(context, "pmc/setFeature").setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    ResponseListener responseListener = responseListener;
                    if (responseListener != null) {
                        responseListener.onSuccess(jsonObject);
                    }
                }

                public void onFailure(IOException iOException) {
                    ResponseListener responseListener = responseListener;
                    if (responseListener != null) {
                        responseListener.onFail(iOException);
                    }
                }
            }).build());
        }
    }

    protected static void put(Map map, String str, Object obj) {
        String valueOf = String.valueOf(obj);
        if (TextUtil.isEmpty(valueOf)) {
            map.put(str, "");
        } else {
            map.put(str, valueOf.trim());
        }
    }

    protected static void putInteger(Map map, String str, Object obj) {
        if (obj instanceof Integer) {
            map.put(str, Integer.valueOf(Integer.parseInt(String.valueOf(obj))));
        } else {
            put(map, str, obj);
        }
    }

    protected static void putBoolean(Map map, String str, Object obj) {
        if (obj instanceof Boolean) {
            map.put(str, obj);
        } else {
            put(map, str, obj);
        }
    }

    /* renamed from: a */
    private static String m36362a() {
        return GlobalPrivacySDK.getToken();
    }

    /* renamed from: b */
    private static String m36364b() {
        return GlobalPrivacySDK.getUserId();
    }

    public static String getAppId(Context context) {
        return GlobalPrivacySDK.getAppId(context);
    }

    /* renamed from: a */
    private static String m36363a(Context context) {
        return GlobalPrivacySDK.getAppType(context);
    }
}
