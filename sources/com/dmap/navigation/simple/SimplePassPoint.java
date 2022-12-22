package com.dmap.navigation.simple;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.location.IPassPoint;

public class SimplePassPoint implements IPassPoint {

    /* renamed from: a */
    private final int f52041a;

    /* renamed from: b */
    private final int f52042b;

    /* renamed from: c */
    private final LatLng f52043c;

    public SimplePassPoint(int i, int i2, LatLng latLng) {
        this.f52041a = i;
        this.f52042b = i2;
        this.f52043c = latLng;
    }

    public String toString() {
        return "SimplePassPoint{pointIndex=" + this.f52041a + ", coorIndex=" + this.f52042b + ", latLng=" + this.f52043c + '}';
    }

    public int getPointIndex() {
        return this.f52041a;
    }

    public int getCoorIndex() {
        return this.f52042b;
    }

    public LatLng getLatLng() {
        return this.f52043c;
    }
}
