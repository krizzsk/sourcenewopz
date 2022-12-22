package com.didichuxing.xpanel.log;

import com.didichuxing.xpanel.base.XPanelCardData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class ExtensionLogHelper {

    /* renamed from: a */
    private Map<String, Object> f49541a;

    public void setLogData(Map<String, Object> map) {
        this.f49541a = map;
    }

    public void addLogData(Map<String, Object> map) {
        Map<String, Object> map2 = this.f49541a;
        if (map2 != null && map2.size() != 0 && map != null) {
            map.putAll(this.f49541a);
        }
    }

    public static void parseExtension(JSONObject jSONObject, XPanelCardData xPanelCardData) {
        JSONObject optJSONObject;
        if (jSONObject != null && xPanelCardData != null && (optJSONObject = jSONObject.optJSONObject("log_data")) != null) {
            ExtensionLogHelper extensionLogHelper = new ExtensionLogHelper();
            HashMap hashMap = new HashMap();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
            extensionLogHelper.setLogData(hashMap);
            xPanelCardData.setExtensionLogHelper(extensionLogHelper);
        }
    }
}
