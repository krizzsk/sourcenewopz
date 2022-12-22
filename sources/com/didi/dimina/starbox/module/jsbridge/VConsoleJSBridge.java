package com.didi.dimina.starbox.module.jsbridge;

import android.text.TextUtils;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.DebugKitStoreUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONObject;

public class VConsoleJSBridge {
    public VConsoleJSBridge() {
        LogUtil.m13411i("VConsoleJSBridge init");
    }

    public void setVConsole(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("VConsoleJSBridge setVConsole");
        if (!jSONObject.has("enable")) {
            CallBackUtil.onFail("enable 为空", callbackFunction);
            return;
        }
        String optString = jSONObject.optString("appId", "");
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("appId 为空", callbackFunction);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("enable", false);
        DebugKitStoreUtil.setVConsole(optString, optBoolean);
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "enable", optBoolean);
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    public void getVConsole(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("VConsoleJSBridge getVConsole");
        String optString = jSONObject.optString("appId", "");
        if (TextUtils.isEmpty(optString)) {
            CallBackUtil.onFail("appId 为空", callbackFunction);
            return;
        }
        boolean vConsole = DebugKitStoreUtil.getVConsole(optString);
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "enable", vConsole);
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }
}
