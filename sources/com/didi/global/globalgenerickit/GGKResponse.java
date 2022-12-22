package com.didi.global.globalgenerickit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GGKResponse {
    protected String error_msg;
    protected int error_no = -800;
    protected Map<String, List<GGKData>> result = new HashMap();

    public String getErrorMsg() {
        return this.error_msg;
    }

    public int getErrorNo() {
        return this.error_no;
    }

    public Map<String, List<GGKData>> getResult() {
        return this.result;
    }

    public List<GGKData> getResult(String str) {
        return this.result.get(str);
    }

    public GGKResponse parse(JSONObject jSONObject) {
        GGKData parse;
        this.error_no = jSONObject.optInt("error_no");
        this.error_msg = jSONObject.optString("error_msg");
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = optJSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    List list = this.result.get(next);
                    if (list == null) {
                        list = new LinkedList();
                        this.result.put(next, list);
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (!(optJSONObject2 == null || (parse = new GGKData().parse(optJSONObject2)) == null)) {
                            list.add(parse);
                        }
                    }
                }
            }
        }
        return this;
    }

    public GGKResponse parse(String str) {
        try {
            return parse(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
