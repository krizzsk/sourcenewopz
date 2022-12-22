package com.didi.dimina.container.secondparty.jsmodule.jsbridge.apollo;

import android.text.TextUtils;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloSubJSBridge {
    public ApolloSubJSBridge() {
        LogUtil.m13411i("ApolloSubJSBridge init");
    }

    public void enableApollo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("ApolloSubJSBridge enableApollo: " + jSONObject);
        if (jSONObject.has("name")) {
            IToggle toggle = Apollo.getToggle(jSONObject.optString("name"));
            if (toggle == null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONUtil.put(jSONObject2, "enable", 0);
                callbackFunction.onCallBack(jSONObject2);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            JSONUtil.put(jSONObject3, "enable", toggle.allow() ? 1 : 0);
            callbackFunction.onCallBack(jSONObject3);
            return;
        }
        JSONObject jSONObject4 = new JSONObject();
        JSONUtil.put(jSONObject4, "enable", 0);
        callbackFunction.onCallBack(jSONObject4);
    }

    public void dataFromApollo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("ApolloSubJSBridge dataFromApollo: " + jSONObject);
        if (jSONObject.has("name") || jSONObject.has("keys")) {
            String optString = jSONObject.optString("name");
            JSONArray optJSONArray = jSONObject.optJSONArray("keys");
            if (optJSONArray == null) {
                callbackFunction.onCallBack(new Object[0]);
                return;
            }
            IToggle toggle = Apollo.getToggle(optString);
            if (toggle == null) {
                callbackFunction.onCallBack(new Object[0]);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString2 = optJSONArray.optString(i);
                String a = m12761a(toggle, optString2);
                if (a != null && !TextUtils.equals(a, "")) {
                    JSONUtil.put(jSONObject2, optString2, (Object) a);
                }
            }
            callbackFunction.onCallBack(jSONObject2);
            return;
        }
        callbackFunction.onCallBack(new Object[0]);
    }

    /* renamed from: a */
    private String m12761a(IToggle iToggle, String str) {
        IExperiment experiment = iToggle.getExperiment();
        if (experiment != null) {
            return (String) experiment.getParam(str, "");
        }
        return null;
    }
}
