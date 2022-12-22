package com.didi.dimina.starbox.module.jsbridge;

import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.starbox.extend.ExtendEvent;
import com.didi.dimina.starbox.extend.ExtendEventManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExtendSubJSBridge {

    /* renamed from: a */
    private final JSONArray f18005a = new JSONArray();

    public ExtendSubJSBridge() {
        LogUtil.m13411i("ExtendSubJSBridge init");
    }

    public void readExtendConfiguration(CallbackFunction callbackFunction) {
        for (ExtendEvent next : ExtendEventManager.getExtendEventManager().getExtendEventList()) {
            JSONObject jSONObject = new JSONObject();
            JSONUtil.put(jSONObject, "eventName", (Object) next.getEventName());
            JSONUtil.put(jSONObject, "eventType", (Object) next.getEventType());
            JSONUtil.put(this.f18005a, jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "data", (Object) this.f18005a);
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    public void executeExtendMethod(JSONObject jSONObject) {
        if (jSONObject.has("eventType")) {
            String optString = jSONObject.optString("eventType");
            for (ExtendEvent next : ExtendEventManager.getExtendEventManager().getExtendEventList()) {
                if (next.getEventType().equals(optString)) {
                    next.executeEvent();
                }
            }
        }
    }
}
