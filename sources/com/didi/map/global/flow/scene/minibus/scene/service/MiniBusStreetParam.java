package com.didi.map.global.flow.scene.minibus.scene.service;

import com.didi.common.map.model.LatLng;

public class MiniBusStreetParam {

    /* renamed from: a */
    private String f26412a;

    /* renamed from: b */
    private LatLng f26413b;

    /* renamed from: c */
    private String f26414c;

    /* renamed from: d */
    private String f26415d;

    public MiniBusStreetParam(String str, LatLng latLng, String str2, String str3) {
        this.f26412a = str;
        this.f26413b = latLng;
        this.f26414c = str2;
        this.f26415d = str3;
    }

    public String getStreetViewUrl() {
        return this.f26412a;
    }

    public LatLng getAddressPosition() {
        return this.f26413b;
    }

    public String getAddressName() {
        return this.f26414c;
    }

    public String getAddressPoiId() {
        return this.f26415d;
    }

    public String toString() {
        return "MiniBusStreetParam{streetViewUrl='" + this.f26412a + '\'' + ", addressPosition=" + this.f26413b + ", addressName='" + this.f26414c + '\'' + ", addressPoiId='" + this.f26415d + '\'' + '}';
    }
}
