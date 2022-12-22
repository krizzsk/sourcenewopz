package com.didi.travel.psnger.model.response;

import com.didi.common.map.model.LatLng;
import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class QuotaFenceInfo extends BaseObject {
    public List<List<LatLng>> geoFence;

    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        if (jSONObject != null && jSONObject.has("data") && (optJSONArray = jSONObject.optJSONArray("data")) != null && optJSONArray.length() != 0) {
            this.geoFence = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (!(optJSONObject == null || (optJSONArray2 = optJSONObject.optJSONArray("map_item")) == null || optJSONArray2.length() <= 0)) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i2);
                        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i3);
                                if (optJSONObject2 != null) {
                                    arrayList.add(new LatLng(optJSONObject2.optDouble("lat"), optJSONObject2.optDouble("lng")));
                                }
                            }
                            if (arrayList.size() > 0) {
                                this.geoFence.add(arrayList);
                            }
                        }
                    }
                }
            }
        }
    }
}
