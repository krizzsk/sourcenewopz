package com.didi.dimina.container.secondparty.jsmodule.jsbridge.raven;

import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.secondparty.DMConfig4Di;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.raven.RavenSdk;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class RavenSubJSBridge {

    /* renamed from: a */
    private String f17265a;

    public RavenSubJSBridge(DMConfig dMConfig) {
        LogUtil.m13411i("RavenSubJSBridge init");
        if (dMConfig != null && (dMConfig.getLaunchConfig() instanceof DMConfig4Di.LaunchConfig)) {
            this.f17265a = ((DMConfig4Di.LaunchConfig) dMConfig.getLaunchConfig()).getRavenId();
        }
    }

    public void traceRaven(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("RavenSubJSBridge trace: " + jSONObject);
        if (jSONObject.has("eventName")) {
            String optString = jSONObject.optString("eventName", "");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                HashMap hashMap = new HashMap();
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject.opt(next));
                    }
                }
                if (TextUtils.isEmpty(this.f17265a)) {
                    CallBackUtil.onFail("天眼 app id 为空", callbackFunction);
                    return;
                } else if (RavenSdk.isInit()) {
                    RavenSdk.getInstance().trackEvent(this.f17265a, optString, hashMap);
                    CallBackUtil.onSuccess(callbackFunction);
                    return;
                } else {
                    CallBackUtil.onFail("天眼未初始化", callbackFunction);
                    return;
                }
            }
        }
        CallBackUtil.onFail("埋点参数出错", callbackFunction);
    }
}
