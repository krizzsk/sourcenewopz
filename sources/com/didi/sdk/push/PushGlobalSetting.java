package com.didi.sdk.push;

import com.didi.map.google.config.Config;
import com.didi.sdk.push.PushItem;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import org.apache.commons.logging.LogFactory;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ServiceProvider({ISetting.class})
public class PushGlobalSetting extends BaseSetting {
    public String getSettings() {
        PushLog.m26280d(PushCallback.TAG, "使用了global adapter逻辑");
        return createProtoJson();
    }

    private static String createProtoJson() {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject addPushV4 = addPushV4();
            if (addPushV4 != null) {
                jSONArray.put(addPushV4);
            }
            JSONObject addPushV5 = addPushV5();
            if (addPushV5 != null) {
                jSONArray.put(addPushV5);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("l", jSONArray);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private static JSONObject addPushV4() {
        try {
            IExperiment experiment = Apollo.getToggle("global_push_switcher").getExperiment();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "push_new_v2");
            jSONObject.put("type", PushItem.LoadType.LOAD_FROM_NAME);
            jSONObject.put("ver", "4");
            jSONObject.put("supportJni2", true);
            jSONObject.put(LogFactory.PRIORITY_KEY, 3);
            jSONObject.put("tls", true);
            jSONObject.put(AgentOptions.PORT, 25641);
            jSONObject.put("writeBufCheckRepeat", experiment.getParam("wb_chk_rep", 5000));
            jSONObject.put("writeTimeout", experiment.getParam("w_timeout", 10000));
            jSONObject.put("routeType", experiment.getParam(Config.ROUTE_TYPE_KEY, 0));
            jSONObject.put("heartBeatInterval", experiment.getParam("hb_intvl", 5));
            jSONObject.put("heartBeatRetryInterval", experiment.getParam("hb_r_intvl", 5));
            jSONObject.put("confVersion", experiment.getParam("conf_ver", 0));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static JSONObject addPushV5() {
        try {
            IToggle toggle = Apollo.getToggle("global_push_switcher");
            IExperiment experiment = toggle.getExperiment();
            int intValue = ((Integer) experiment.getParam("quic", -1)).intValue();
            IToggle toggle2 = Apollo.getToggle("quic_andriod_br_pax");
            int intValue2 = ((Integer) toggle2.getExperiment().getParam("quic", -1)).intValue();
            if ((!toggle.allow() || intValue != 1) && (!toggle2.allow() || intValue2 != 1)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "push_quic");
            jSONObject.put("type", PushItem.LoadType.LOAD_FROM_NAME);
            jSONObject.put("ver", "5");
            jSONObject.put("supportJni2", true);
            jSONObject.put(LogFactory.PRIORITY_KEY, 4);
            jSONObject.put("tls", true);
            jSONObject.put("quic", true);
            jSONObject.put(AgentOptions.PORT, 26443);
            jSONObject.put("writeBufCheckRepeat", experiment.getParam("wb_chk_rep", 5000));
            jSONObject.put("writeTimeout", experiment.getParam("w_timeout", 10000));
            jSONObject.put("routeType", experiment.getParam(Config.ROUTE_TYPE_KEY, 0));
            jSONObject.put("heartBeatInterval", experiment.getParam("hb_intvl", 5));
            jSONObject.put("heartBeatRetryInterval", experiment.getParam("hb_r_intvl", 5));
            jSONObject.put("confVersion", experiment.getParam("conf_ver", 0));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
