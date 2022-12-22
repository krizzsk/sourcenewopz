package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionModel extends UniModel {

    /* renamed from: a */
    private List<MapPositionModel> f34055a;

    public List<MapPositionModel> getPositionModel() {
        return this.f34055a;
    }

    public void setPositionModel(List<MapPositionModel> list) {
        this.f34055a = list;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("positionModel", map(this.f34055a, $$Lambda$PositionModel$OZY5Gch4cPtlLdxfZFNSbMKIYy0.INSTANCE));
        return hashMap;
    }

    public static PositionModel fromMap(Map<String, Object> map) {
        PositionModel positionModel = new PositionModel();
        positionModel.f34055a = (!map.containsKey("positionModel") || map.get("positionModel") == null) ? new ArrayList<>() : map((List) map.get("positionModel"), $$Lambda$PositionModel$gaA2DB5Bzg4Expqvn83UiBgK6U4.INSTANCE);
        return positionModel;
    }
}
