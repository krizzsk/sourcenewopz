package com.didi.sdk.bff;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.receiver.ReceiverConstant;
import com.didi.one.netdetect.http.ResponseListener;
import com.didi.sdk.app.BroadcastSender;
import com.didi.sdk.bff.BffConstants;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BffService {
    public static void getSafetyConfig(final Context context) {
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_SAFETY_CONFIG).setCallback(new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
                if (jsonObject.get("errno").getAsInt() == 0) {
                    JsonObject asJsonObject = jsonObject.get("data").getAsJsonObject();
                    HashMap hashMap = new HashMap();
                    hashMap.put("have_passed_order_recent", Integer.valueOf(asJsonObject.get("have_passed_order_recent").getAsInt()));
                    hashMap.put("have_riding_order_switch", Integer.valueOf(asJsonObject.get("have_riding_order_switch").getAsInt()));
                    hashMap.put("is_reporting_police", Integer.valueOf(asJsonObject.get("is_reporting_police").getAsInt()));
                    Intent intent = new Intent();
                    intent.setAction(ReceiverConstant.ACTION_SAFETY);
                    intent.setData(Uri.parse("OneReceiver://"));
                    intent.putExtra("extra", hashMap);
                    BroadcastSender.getInstance(context).sendBroadcast(intent);
                }
            }
        }).build());
    }

    public static void getFeatureList(Context context, final ResponseListener<Map<String, Boolean>> responseListener, final List<String> list) {
        if (list != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            put(hashMap, "ticket", getToken());
            put(hashMap, "uID", getUid());
            put(hashMap, "appID", getAppId(context));
            put(hashMap, "appType", getAppType(context));
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
            put(hashMap, "ticket", getToken());
            put(hashMap, "uID", getUid());
            put(hashMap, "appID", getAppId(context));
            put(hashMap, "appType", getAppType(context));
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

    public static String getToken() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
    }

    public static String getUid() {
        return NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
    }

    public static String getAppId(Context context) {
        if (AppUtils.isBrazilApp(context)) {
            return "60004";
        }
        return AppUtils.isGlobalApp(context) ? "60000" : "";
    }

    public static String getAppType(Context context) {
        if (AppUtils.isBrazilApp(context)) {
            return NativeContentAd.ASSET_IMAGE;
        }
        return AppUtils.isGlobalApp(context) ? "1016" : "";
    }
}
