package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class MapPolygonOptions extends UniModel {

    /* renamed from: a */
    private String f34045a;

    /* renamed from: b */
    private long f34046b;

    /* renamed from: c */
    private double f34047c;

    /* renamed from: d */
    private String f34048d;

    /* renamed from: e */
    private double f34049e;

    /* renamed from: f */
    private double f34050f;

    public String getFillColor() {
        return this.f34045a;
    }

    public void setFillColor(String str) {
        this.f34045a = str;
    }

    public long getZIndex() {
        return this.f34046b;
    }

    public void setZIndex(long j) {
        this.f34046b = j;
    }

    public double getStrokeWidth() {
        return this.f34047c;
    }

    public void setStrokeWidth(double d) {
        this.f34047c = d;
    }

    public String getStrokeColor() {
        return this.f34048d;
    }

    public void setStrokeColor(String str) {
        this.f34048d = str;
    }

    public double getCenterLng() {
        return this.f34049e;
    }

    public void setCenterLng(double d) {
        this.f34049e = d;
    }

    public double getCenterLat() {
        return this.f34050f;
    }

    public void setCenterLat(double d) {
        this.f34050f = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("fillColor", this.f34045a);
        hashMap.put("zIndex", Long.valueOf(this.f34046b));
        hashMap.put("strokeWidth", Double.valueOf(this.f34047c));
        hashMap.put("strokeColor", this.f34048d);
        hashMap.put("centerLng", Double.valueOf(this.f34049e));
        hashMap.put("centerLat", Double.valueOf(this.f34050f));
        return hashMap;
    }

    public static MapPolygonOptions fromMap(Map<String, Object> map) {
        MapPolygonOptions mapPolygonOptions = new MapPolygonOptions();
        String str = "";
        mapPolygonOptions.f34045a = (!map.containsKey("fillColor") || map.get("fillColor") == null) ? str : (String) map.get("fillColor");
        mapPolygonOptions.f34046b = (!map.containsKey("zIndex") || map.get("zIndex") == null) ? 0 : ((Number) map.get("zIndex")).longValue();
        double d = 0.0d;
        mapPolygonOptions.f34047c = (!map.containsKey("strokeWidth") || map.get("strokeWidth") == null) ? 0.0d : ((Double) map.get("strokeWidth")).doubleValue();
        if (map.containsKey("strokeColor") && map.get("strokeColor") != null) {
            str = (String) map.get("strokeColor");
        }
        mapPolygonOptions.f34048d = str;
        mapPolygonOptions.f34049e = (!map.containsKey("centerLng") || map.get("centerLng") == null) ? 0.0d : ((Double) map.get("centerLng")).doubleValue();
        if (map.containsKey("centerLat") && map.get("centerLat") != null) {
            d = ((Double) map.get("centerLat")).doubleValue();
        }
        mapPolygonOptions.f34050f = d;
        return mapPolygonOptions;
    }
}
