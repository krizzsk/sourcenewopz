package com.didi.dimina.container.bridge;

import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.b */
/* compiled from: LogSubJSBridge */
class C7431b {
    C7431b() {
        LogUtil.m13411i("LogSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54568a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("LogSubJSBridge logDebug: " + jSONObject);
        if (jSONObject.has("msg")) {
            LogUtil.m13411i(jSONObject.optString("msg"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54569b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("LogSubJSBridge logInfo: " + jSONObject);
        if (jSONObject.has("msg")) {
            LogUtil.m13411i(jSONObject.optString("msg"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54570c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("LogSubJSBridge logWarn: " + jSONObject);
        if (jSONObject.has("msg")) {
            LogUtil.m13413w(jSONObject.optString("msg"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo54571d(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("LogSubJSBridge logError: " + jSONObject);
        if (jSONObject.has("msg")) {
            LogUtil.m13409e(jSONObject.optString("msg"));
        }
    }
}
