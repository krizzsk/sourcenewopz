package com.didi.global.globalgenerickit.model;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globalgenerickit.utils.JsonUtil;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentConfigModel implements BffGsonStruct {
    public String cdn;
    public JsonObject data;
    public JsonObject extension;

    /* renamed from: id */
    public String f22193id;
    public Map<String, Object> logMap;
    public String template;
    @SerializedName("ui_config")
    public UIConfig uiConfig;

    public static class Extension {
        @SerializedName("log_data")
        public JsonObject logData;
    }

    public static class UIConfig {
        @SerializedName("height")
        public int uiConfigHeight;
        @SerializedName("priority")
        public int uiConfigPriority;
        @SerializedName("width")
        public int uiConfigWidth;
    }

    public boolean isNative() {
        return true;
    }

    public boolean isXml() {
        return false;
    }

    public void parse(ComponentConfigModel componentConfigModel) {
        JSONObject optJSONObject;
        if (componentConfigModel != null && componentConfigModel.extension != null) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(componentConfigModel.extension.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("log_data")) != null) {
                try {
                    this.logMap = JsonUtil.jsonToMap(optJSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
