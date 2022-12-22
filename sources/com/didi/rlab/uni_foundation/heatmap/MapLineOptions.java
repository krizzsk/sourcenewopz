package com.didi.rlab.uni_foundation.heatmap;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.HashMap;
import java.util.Map;

public class MapLineOptions extends UniModel {

    /* renamed from: a */
    private long f34020a;

    /* renamed from: b */
    private String f34021b;

    /* renamed from: c */
    private boolean f34022c;

    /* renamed from: d */
    private long f34023d;

    /* renamed from: e */
    private double f34024e;

    /* renamed from: f */
    private long f34025f;

    /* renamed from: g */
    private long f34026g;

    /* renamed from: h */
    private long f34027h;

    /* renamed from: i */
    private double f34028i;

    public long getZIndex() {
        return this.f34020a;
    }

    public void setZIndex(long j) {
        this.f34020a = j;
    }

    public String getColor() {
        return this.f34021b;
    }

    public void setColor(String str) {
        this.f34021b = str;
    }

    public boolean getHasDirectionArrow() {
        return this.f34022c;
    }

    public void setHasDirectionArrow(boolean z) {
        this.f34022c = z;
    }

    public long getWidth() {
        return this.f34023d;
    }

    public void setWidth(long j) {
        this.f34023d = j;
    }

    public double getSpace() {
        return this.f34024e;
    }

    public void setSpace(double d) {
        this.f34024e = d;
    }

    public long getLineEndType() {
        return this.f34025f;
    }

    public void setLineEndType(long j) {
        this.f34025f = j;
    }

    public long getLineJoinType() {
        return this.f34026g;
    }

    public void setLineJoinType(long j) {
        this.f34026g = j;
    }

    public long getType() {
        return this.f34027h;
    }

    public void setType(long j) {
        this.f34027h = j;
    }

    public double getRouteRadius() {
        return this.f34028i;
    }

    public void setRouteRadius(double d) {
        this.f34028i = d;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("zIndex", Long.valueOf(this.f34020a));
        hashMap.put("color", this.f34021b);
        hashMap.put("hasDirectionArrow", Boolean.valueOf(this.f34022c));
        hashMap.put("width", Long.valueOf(this.f34023d));
        hashMap.put(BlocksConst.WIDGET_PARAMS_SPACE, Double.valueOf(this.f34024e));
        hashMap.put("lineEndType", Long.valueOf(this.f34025f));
        hashMap.put("lineJoinType", Long.valueOf(this.f34026g));
        hashMap.put("type", Long.valueOf(this.f34027h));
        hashMap.put("routeRadius", Double.valueOf(this.f34028i));
        return hashMap;
    }

    public static MapLineOptions fromMap(Map<String, Object> map) {
        MapLineOptions mapLineOptions = new MapLineOptions();
        long j = 0;
        mapLineOptions.f34020a = (!map.containsKey("zIndex") || map.get("zIndex") == null) ? 0 : ((Number) map.get("zIndex")).longValue();
        mapLineOptions.f34021b = (!map.containsKey("color") || map.get("color") == null) ? "" : (String) map.get("color");
        mapLineOptions.f34022c = (!map.containsKey("hasDirectionArrow") || map.get("hasDirectionArrow") == null) ? false : ((Boolean) map.get("hasDirectionArrow")).booleanValue();
        mapLineOptions.f34023d = (!map.containsKey("width") || map.get("width") == null) ? 0 : ((Number) map.get("width")).longValue();
        double d = 0.0d;
        mapLineOptions.f34024e = (!map.containsKey(BlocksConst.WIDGET_PARAMS_SPACE) || map.get(BlocksConst.WIDGET_PARAMS_SPACE) == null) ? 0.0d : ((Double) map.get(BlocksConst.WIDGET_PARAMS_SPACE)).doubleValue();
        mapLineOptions.f34025f = (!map.containsKey("lineEndType") || map.get("lineEndType") == null) ? 0 : ((Number) map.get("lineEndType")).longValue();
        mapLineOptions.f34026g = (!map.containsKey("lineJoinType") || map.get("lineJoinType") == null) ? 0 : ((Number) map.get("lineJoinType")).longValue();
        if (map.containsKey("type") && map.get("type") != null) {
            j = ((Number) map.get("type")).longValue();
        }
        mapLineOptions.f34027h = j;
        if (map.containsKey("routeRadius") && map.get("routeRadius") != null) {
            d = ((Double) map.get("routeRadius")).doubleValue();
        }
        mapLineOptions.f34028i = d;
        return mapLineOptions;
    }
}
