package com.didichuxing.xpanel.xcard;

import org.json.JSONObject;

public class XCardXmlInfo {
    public JSONObject data;
    public String xml;

    public XCardXmlInfo(String str, JSONObject jSONObject) {
        this.xml = str;
        this.data = jSONObject;
    }
}
