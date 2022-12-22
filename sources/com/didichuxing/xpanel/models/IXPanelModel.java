package com.didichuxing.xpanel.models;

import com.didichuxing.xpanel.agent.net.ParseJsonUtil;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public abstract class IXPanelModel {

    /* renamed from: a */
    private static final String f49575a = "log_data";
    protected HashMap<String, Object> mDefaultLogData;

    public abstract HashMap<String, Object> getExtension();

    public abstract String getTemplate();

    public abstract boolean parse(JSONObject jSONObject, JSONObject jSONObject2);

    public final HashMap<String, Object> getExtensions() {
        HashMap<String, Object> extension = getExtension();
        if (extension == null) {
            return this.mDefaultLogData;
        }
        HashMap<String, Object> hashMap = this.mDefaultLogData;
        if (hashMap != null) {
            extension.putAll(hashMap);
        }
        return extension;
    }

    public final boolean defaultParse(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject optJSONObject;
        if (!(jSONObject2 == null || (optJSONObject = jSONObject2.optJSONObject(f49575a)) == null)) {
            this.mDefaultLogData = new HashMap<>();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.mDefaultLogData.put(next, ParseJsonUtil.optString(optJSONObject, next, ""));
            }
        }
        return parse(jSONObject, jSONObject2);
    }
}
