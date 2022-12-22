package com.didichuxing.publicservice.resourcecontrol.utils;

import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.general.SecutityKey;
import com.didichuxing.publicservice.network.HttpHelper;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestUtils {
    /* access modifiers changed from: private */
    public static final String TAG = RequestUtils.class.getSimpleName();

    public static void postRequestNotAddPublicParams(String str, HashMap<String, Object> hashMap, HttpHelper.RequestCallBack requestCallBack, int i) {
        if (hashMap == null || ResourceManager.getManager().getApplication() == null) {
            AppUtils.log(TAG + " -> postRequest ======= urlParams, context is null... resourceUrl: " + str);
            return;
        }
        hashMap.putAll(ResourceManager.getManager().getPublicParams());
        for (Map.Entry next : hashMap.entrySet()) {
            if (next.getValue() != null) {
                hashMap.put(next.getKey(), String.valueOf(next.getValue()).replace(" ", ""));
            }
        }
        hashMap.put("sig", SecutityKey.getInstance().renderSignatureStr(hashMap, ResourceManager.SECRET));
        if (hashMap.get("from") != null) {
            if ("".equals((String) hashMap.get("from"))) {
                ResourceManager.getManager().setIsTheOne(true);
            } else {
                ResourceManager.getManager().setIsTheOne(false);
            }
            hashMap.put("from", AppUtils.encodeParam((String) hashMap.get("from")));
        } else {
            ResourceManager.getManager().setIsTheOne(true);
        }
        AppUtils.encodeParamsWithUTF8(hashMap);
        HttpHelper.post(ConstantUtils.getRCServerUrl() + str, hashMap, requestCallBack, i);
    }

    public static IBffProxy.Ability requestPopup(String str, String str2, HashMap<String, Object> hashMap, final HttpHelper.RequestCallBack requestCallBack) {
        if (ResourceManager.getManager().getDevice() != null) {
            if (ResourceManager.getManager().getDevice().lang != null) {
                hashMap.put("lang", ResourceManager.getManager().getDevice().lang);
            }
            if (ResourceLocale.isResourceLocaleIsGl() || ResourceLocale.isResourceLocaleIsPt()) {
                hashMap.put("suuid", ResourceManager.getManager().getDevice().suuid);
                hashMap.put("uid", ResourceManager.getManager().getDevice().uid);
            }
        }
        hashMap.put("nl", 1);
        IBffProxy.Ability build = new IBffProxy.Ability.Builder(ResourceManager.getManager().getApplication(), str).setServiceId(str2).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                if (jsonObject == null) {
                    requestCallBack.onFail();
                    return;
                }
                String jsonObject2 = jsonObject.toString();
                AppUtils.log(RequestUtils.TAG + "@requestPopup, json = " + jsonObject2);
                try {
                    requestCallBack.onSuccess(new HttpHelper.HttpResult(new JSONObject(jsonObject2)));
                } catch (JSONException e) {
                    e.printStackTrace();
                    requestCallBack.onFail();
                }
            }

            public void onFailure(IOException iOException) {
                requestCallBack.onFail();
            }
        }).build();
        Bff.call(build);
        return build;
    }
}
