package com.didi.map.global.component.departure.circle;

import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import java.util.Observable;

public class ZoneCircleOption extends Observable {

    /* renamed from: a */
    private boolean f25020a = false;

    /* renamed from: b */
    private LatLng f25021b;

    /* renamed from: c */
    private float f25022c;

    /* renamed from: d */
    private int f25023d = -10366036;

    /* renamed from: e */
    private int f25024e = -1999639054;

    /* renamed from: f */
    private CircleOptions f25025f;

    public ZoneCircleOption(LatLng latLng, float f) {
        CircleOptions circleOptions = new CircleOptions();
        this.f25025f = circleOptions;
        this.f25021b = latLng;
        this.f25022c = f;
        circleOptions.center(latLng).radius((double) f);
    }

    public ZoneCircleOption stroke(int i, int i2) {
        this.f25024e = i2;
        this.f25025f.strokeWidth((float) i).strokeColor(i2);
        return this;
    }

    public ZoneCircleOption fillColor(int i) {
        this.f25023d = i;
        this.f25025f.fillColor(i);
        return this;
    }

    public ZoneCircleOption allowDragToOuter(boolean z) {
        this.f25020a = z;
        return this;
    }

    public int getFillColor() {
        return this.f25023d;
    }

    public int getStrokeColor() {
        return this.f25024e;
    }

    public CircleOptions getCircleOptions() {
        return this.f25025f;
    }

    public boolean isAllowDragToOuter() {
        return this.f25020a;
    }

    public LatLng getCenter() {
        return this.f25021b;
    }

    public float getRadius() {
        return this.f25022c;
    }
}
