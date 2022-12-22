package com.didi.component.service.cancelreason.bff;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.service.cancelreason.cache.CancelReasonStore;
import com.didi.component.service.cancelreason.model.CancelReasonListResponse;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;

public class CancelReasonBff {
    public static void cancelReasonListGet(Context context, String str, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", str);
        hashMap.put(ParamKeys.PARAM_CANCEL_REASON_ROLE, 1);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_GET_CANCEL_REASON).setParams(hashMap).setCallback(callback).build());
    }

    public static void cancelReasonListGet(Context context, String str) {
        cancelReasonListGet(context, str, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
                CancelReasonStore.getInstance().saveCurrCancelReasonInfo(((CancelReasonListResponse) new Gson().fromJson((JsonElement) jsonObject, CancelReasonListResponse.class)).data.cancel_reason_info);
            }
        });
    }

    public static void cancelReasonSubmit(Context context, String str, String str2, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("oid", str);
        hashMap.put(ParamKeys.PARAM_CANCEL_REASON_ROLE, 1);
        hashMap.put("reason_id", str2);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_SUBMIT_CANCEL_REASON).setParams(hashMap).setCallback(callback).build());
    }

    public static void cancelReasonSubmit(Context context, String str, String str2) {
        cancelReasonSubmit(context, str, str2, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
            }
        });
    }
}
