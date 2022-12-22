package com.didi.crossplatform.track.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class PerformanceList extends ArrayList<PerformanceItem> {
    public Map<String, Object> parseMap() {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < size(); i++) {
            PerformanceItem performanceItem = (PerformanceItem) get(i);
            if (performanceItem != null) {
                jSONArray.put(performanceItem.parseJson());
            }
        }
        hashMap.put("measurements", jSONArray.toString());
        return hashMap;
    }
}
