package com.didichuxing.carsliding.model;

import com.didi.common.map.model.Marker;

public class RenderResult {

    /* renamed from: a */
    private String f46265a;

    /* renamed from: b */
    private Marker f46266b;

    public RenderResult(String str, Marker marker) {
        this.f46265a = str;
        this.f46266b = marker;
    }

    public String getId() {
        return this.f46265a;
    }

    public Marker getMarkerWrapper() {
        return this.f46266b;
    }

    public String toString() {
        return this.f46265a;
    }
}
