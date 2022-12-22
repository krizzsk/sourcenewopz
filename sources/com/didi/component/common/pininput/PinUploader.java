package com.didi.component.common.pininput;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.constant.BffConstants;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.util.HashMap;

public class PinUploader {

    /* renamed from: a */
    private Context f11672a;

    public static boolean isTestEnviroment(Context context) {
        return false;
    }

    public PinUploader(Context context) {
        this.f11672a = context;
    }

    public void uploadPin(String str, final RpcService.Callback<Response> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConsts.TAG_KEY_PIN, str);
        Bff.call(new IBffProxy.Ability.Builder(this.f11672a, BffConstants.AbilityID.ABILITY_SET_USERPIN).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                Response response = new Response();
                response.code = jsonObject.get("errno").getAsInt();
                response.msg = jsonObject.get("errmsg").getAsString();
                callback.onSuccess(response);
            }

            public void onFailure(IOException iOException) {
                callback.onFailure(iOException);
            }
        }).build());
    }

    public static class Response {
        @SerializedName("errno")
        public int code = -1;
        @SerializedName("errmsg")
        public String msg;

        public String toString() {
            return String.format("{code: %s, msg: %s}", new Object[]{Integer.valueOf(this.code), this.msg});
        }
    }
}
