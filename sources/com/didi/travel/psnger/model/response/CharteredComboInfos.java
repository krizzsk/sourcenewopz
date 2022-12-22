package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CharteredComboInfos extends BaseObject {
    private Map<String, List<CharteredComboInfo>> comboInfos;

    public CharteredComboInfos() {
        this.comboInfos = new HashMap();
    }

    public CharteredComboInfos(Map<String, List<CharteredComboInfo>> map) {
        HashMap hashMap = new HashMap();
        this.comboInfos = hashMap;
        if (map != null) {
            hashMap.clear();
            this.comboInfos.putAll(map);
        }
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null && optJSONObject.length() > 0) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    JSONArray jSONArray = optJSONObject.getJSONArray(next);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList(jSONArray.length());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            CharteredComboInfo charteredComboInfo = new CharteredComboInfo();
                            charteredComboInfo.parse(jSONArray.getJSONObject(i));
                            arrayList.add(charteredComboInfo);
                        }
                        this.comboInfos.put(next, arrayList);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public List<CharteredComboInfo> getComboInfos(String str) {
        return this.comboInfos.get(str);
    }
}
