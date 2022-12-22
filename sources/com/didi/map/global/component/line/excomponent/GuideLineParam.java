package com.didi.map.global.component.line.excomponent;

import com.didi.common.map.model.LatLng;

public class GuideLineParam {

    /* renamed from: a */
    int f25834a;

    /* renamed from: b */
    int f25835b = 0;

    /* renamed from: c */
    float f25836c;

    /* renamed from: d */
    int f25837d;

    /* renamed from: e */
    LatLng f25838e;

    /* renamed from: f */
    LatLng f25839f;

    public GuideLineParam(int i, LatLng latLng, LatLng latLng2) {
        this.f25834a = i;
        this.f25838e = latLng;
        this.f25839f = latLng2;
    }

    public GuideLineParam(int i, int i2, int i3, float f, LatLng latLng, LatLng latLng2) {
        this.f25834a = i;
        this.f25838e = latLng;
        this.f25839f = latLng2;
        this.f25837d = i3;
        this.f25836c = f;
        this.f25835b = i2;
    }
}
