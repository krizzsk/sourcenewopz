package com.didi.map.sdk.sharetrack.entity;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class DiDiRouteSegment {

    /* renamed from: a */
    private LatLng f28629a;

    /* renamed from: b */
    private List<LatLng> f28630b;

    public LatLng getDestPoint() {
        return this.f28629a;
    }

    public void setDestPoint(LatLng latLng) {
        this.f28629a = latLng;
    }

    public List<LatLng> getLatLngList() {
        return this.f28630b;
    }

    public void setLatLngList(List<LatLng> list) {
        this.f28630b = list;
    }
}
