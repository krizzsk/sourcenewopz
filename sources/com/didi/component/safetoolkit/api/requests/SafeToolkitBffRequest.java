package com.didi.component.safetoolkit.api.requests;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.common.helper.SceneHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.util.HashMap;

public class SafeToolkitBffRequest {
    public static void reportMonitorState(Context context, RpcService.Callback<JsonObject> callback, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("state", Integer.valueOf(i2));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_MONITOR_STATE).setParams(hashMap).setCallback(callback).build());
    }

    public static void reportUserState(Context context, RpcService.Callback<JsonObject> callback, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("bubble_id", str);
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_MONITOR_USER_STATE).setParams(hashMap).setCallback(callback).build());
    }

    public static void reportEvent(Context context, RpcService.Callback<JsonObject> callback, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("push_id", SceneHelper.getInstance().pushId);
        hashMap.put("order_id", str);
        hashMap.put("code", Integer.valueOf(i));
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_MONITOR_REPORT_EVENT).setParams(hashMap).setCallback(callback).build());
    }
}
