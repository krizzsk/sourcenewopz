package com.didi.dimina.container.secondparty.jsmodule.jsbridge.omega;

import android.text.TextUtils;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.LogUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class OmegaSubJSBridge {
    public OmegaSubJSBridge() {
        LogUtil.m13411i("OmegaSubJSBridge init");
    }

    public void trace(String str, JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("OmegaSubJSBridge reportAnalytics: " + str + "," + jSONObject);
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.opt(next));
                }
            }
            OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
        }
    }

    public void trace(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("NavigationBarSubJSBridge trace: " + jSONObject);
        if (jSONObject.has("eventId")) {
            String optString = jSONObject.optString("eventId", "");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                HashMap hashMap = new HashMap();
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject.opt(next));
                    }
                }
                OmegaSDKAdapter.trackEvent(optString, (Map<String, Object>) hashMap);
            }
        }
    }
}
