package com.android.didi.bfflib.concurrent;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BffAbilityMapModel {
    public Map<String, List<String>> data;
    public String errmsg;
    public int errno;

    public void parseAbilityMap(JsonObject jsonObject) {
        this.errno = jsonObject.get("errno").getAsInt();
        this.errmsg = jsonObject.get("errmsg").getAsString();
        if (jsonObject.get("data") != null) {
            parseDate(jsonObject.get("data").getAsJsonObject().toString());
        }
    }

    private void parseDate(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = new JSONObject();
        }
        this.data = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.data.put(next, parseGroup(jSONObject.optJSONArray(next)));
        }
    }

    private List<String> parseGroup(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }
}
