package com.didi.rlab.uni_foundation.map;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class MapServiceTripPoiDataModel extends UniModel {

    /* renamed from: a */
    private double f34082a;

    /* renamed from: b */
    private double f34083b;

    public double getLat() {
        return this.f34082a;
    }

    public void setLat(double d) {
        this.f34082a = d;
    }

    public double getLng() {
        return this.f34083b;
    }

    public void setLng(double d) {
        this.f34083b = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("lat", Double.valueOf(this.f34082a));
        hashMap.put("lng", Double.valueOf(this.f34083b));
        return hashMap;
    }

    public static MapServiceTripPoiDataModel fromMap(Map<String, Object> map) {
        MapServiceTripPoiDataModel mapServiceTripPoiDataModel = new MapServiceTripPoiDataModel();
        double d = 0.0d;
        mapServiceTripPoiDataModel.f34082a = (!map.containsKey("lat") || map.get("lat") == null) ? 0.0d : ((Double) map.get("lat")).doubleValue();
        if (map.containsKey("lng") && map.get("lng") != null) {
            d = ((Double) map.get("lng")).doubleValue();
        }
        mapServiceTripPoiDataModel.f34083b = d;
        return mapServiceTripPoiDataModel;
    }
}
