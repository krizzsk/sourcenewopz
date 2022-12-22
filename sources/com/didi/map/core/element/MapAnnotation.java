package com.didi.map.core.element;

import com.didi.map.outer.model.LatLng;

public class MapAnnotation {

    /* renamed from: e */
    private static final int f24733e = 0;

    /* renamed from: f */
    private static final int f24734f = 1;

    /* renamed from: g */
    private static final int f24735g = 2;

    /* renamed from: a */
    private long f24736a;

    /* renamed from: b */
    private LatLng f24737b;

    /* renamed from: c */
    private String f24738c;

    /* renamed from: d */
    private final long f24739d;

    /* renamed from: h */
    private final int f24740h;

    public MapAnnotation(long j, String str, LatLng latLng, long j2, int i) {
        this.f24736a = j;
        this.f24737b = latLng;
        this.f24738c = str;
        this.f24739d = j2;
        this.f24740h = i;
    }

    public long getId() {
        return this.f24736a;
    }

    public LatLng getPosition() {
        return this.f24737b;
    }

    public String getName() {
        return this.f24738c;
    }

    public long getPoiId() {
        return this.f24739d;
    }

    public int getPoiType() {
        return this.f24740h;
    }
}
