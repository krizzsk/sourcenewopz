package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class MapPositionModel extends UniModel {

    /* renamed from: a */
    private double f34051a;

    /* renamed from: b */
    private double f34052b;

    public double getLat() {
        return this.f34051a;
    }

    public void setLat(double d) {
        this.f34051a = d;
    }

    public double getLng() {
        return this.f34052b;
    }

    public void setLng(double d) {
        this.f34052b = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("lat", Double.valueOf(this.f34051a));
        hashMap.put("lng", Double.valueOf(this.f34052b));
        return hashMap;
    }

    public static MapPositionModel fromMap(Map<String, Object> map) {
        MapPositionModel mapPositionModel = new MapPositionModel();
        double d = 0.0d;
        mapPositionModel.f34051a = (!map.containsKey("lat") || map.get("lat") == null) ? 0.0d : ((Double) map.get("lat")).doubleValue();
        if (map.containsKey("lng") && map.get("lng") != null) {
            d = ((Double) map.get("lng")).doubleValue();
        }
        mapPositionModel.f34052b = d;
        return mapPositionModel;
    }
}
