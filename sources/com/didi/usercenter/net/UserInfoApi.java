package com.didi.usercenter.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.usercenter.bff.BffConstants;
import com.didi.usercenter.entity.UserInfo;
import com.didi.usercenter.listener.UserInfoListener;
import com.didi.usercenter.net.pojo.UserInfoReqParam;
import com.didi.usercenter.store.UserCenterStore;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserInfoApi {
    public static boolean ISTEST = false;

    public static void setOnlineUrl(String str) {
    }

    public static void setTestUrl(String str) {
    }

    public static void fetchUserInfo(final Context context, String str, String str2, final RpcService.Callback<UserInfo> callback) {
        Map<String, String> baseMap = new UserInfoReqParam(context, str, str2).getBaseMap();
        HashMap hashMap = new HashMap();
        for (String next : baseMap.keySet()) {
            hashMap.put(next, baseMap.get(next));
        }
        hashMap.put("search_type", 1);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_PROFILE).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                int asInt = jsonObject.get("errno").getAsInt();
                if (asInt == 0) {
                    JsonObject asJsonObject = jsonObject.get("data").getAsJsonObject();
                    UserInfoApi.m32416b(context, (UserInfo) new Gson().fromJson((JsonElement) asJsonObject, UserInfo.class), callback);
                    return;
                }
                UserInfoApi.m32417b(new IOException("bff error" + asInt), callback);
            }

            public void onFailure(IOException iOException) {
                UserInfoApi.m32417b(iOException, callback);
            }
        }).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m32416b(Context context, final UserInfo userInfo, final RpcService.Callback<UserInfo> callback) {
        if (userInfo == null || userInfo.getErrno() != 0) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    RpcService.Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(new IOException());
                    }
                    Iterator<UserInfoListener.InfoListener> it = UserInfoListener.getInfoListeners().iterator();
                    while (it.hasNext()) {
                        it.next().onFailure();
                    }
                }
            });
            return;
        }
        UserCenterStore.getIns().setUserInfo(context, userInfo);
        UiThreadHandler.post(new Runnable() {
            public void run() {
                RpcService.Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(userInfo);
                }
                Iterator<UserInfoListener.InfoListener> it = UserInfoListener.getInfoListeners().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onGetInfo(userInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m32417b(final IOException iOException, final RpcService.Callback<UserInfo> callback) {
        UiThreadHandler.post(new Runnable() {
            public void run() {
                RpcService.Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(iOException);
                }
                Iterator<UserInfoListener.InfoListener> it = UserInfoListener.getInfoListeners().iterator();
                while (it.hasNext()) {
                    it.next().onFailure();
                }
            }
        });
    }
}
