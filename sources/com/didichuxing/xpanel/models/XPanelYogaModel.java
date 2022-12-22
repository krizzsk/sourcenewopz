package com.didichuxing.xpanel.models;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class XPanelYogaModel extends IXPanelModel {

    /* renamed from: a */
    private String f49581a;

    /* renamed from: b */
    private JSONObject f49582b;

    public boolean parse(JSONObject jSONObject, JSONObject jSONObject2) {
        return false;
    }

    public XPanelYogaModel(String str) {
        this.f49581a = str;
    }

    public void bindExtension(JSONObject jSONObject) {
        this.f49582b = jSONObject;
    }

    public HashMap<String, Object> getExtension() {
        if (this.f49582b == null) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        JSONObject optJSONObject = this.f49582b.optJSONObject("log_data");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = optJSONObject.opt(next);
                if (opt != null) {
                    hashMap.put(next, opt);
                }
            }
        }
        return hashMap;
    }

    public String getTemplate() {
        return this.f49581a;
    }
}
