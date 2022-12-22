package com.didi.map.global.component.myLocation.view;

import com.didi.common.map.model.LatLng;

public class LocationAccuracyCircleOptions {

    /* renamed from: a */
    private LatLng f26073a;

    /* renamed from: b */
    private float f26074b;

    /* renamed from: c */
    private float f26075c;

    /* renamed from: d */
    private float f26076d;

    public LatLng getPosition() {
        return this.f26073a;
    }

    public void setPosition(LatLng latLng) {
        this.f26073a = latLng;
    }

    public float getAccuracy() {
        return this.f26074b;
    }

    public void setAccuracy(float f) {
        this.f26074b = f;
    }

    public float getDefMinAccuracy() {
        return this.f26075c;
    }

    public void setDefMinAccuracy(float f) {
        this.f26075c = f;
    }

    public float getDefMaxAccuracy() {
        return this.f26076d;
    }

    public void setDefMaxAccuracy(float f) {
        this.f26076d = f;
    }

    public String toString() {
        return "LocationAccuracyCircleOptions{position=" + this.f26073a + ", accuracy=" + this.f26074b + ", defMinAccuracy=" + this.f26075c + ", defMaxAccuracy=" + this.f26076d + '}';
    }
}
