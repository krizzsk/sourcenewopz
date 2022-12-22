package com.didi.hawaii.mapsdk.gesture;

public final class MoveDistancesObject {

    /* renamed from: a */
    private final float f23517a;

    /* renamed from: b */
    private final float f23518b;

    /* renamed from: c */
    private float f23519c;

    /* renamed from: d */
    private float f23520d;

    /* renamed from: e */
    private float f23521e;

    /* renamed from: f */
    private float f23522f;

    /* renamed from: g */
    private float f23523g;

    /* renamed from: h */
    private float f23524h;

    /* renamed from: i */
    private float f23525i;

    /* renamed from: j */
    private float f23526j;

    public MoveDistancesObject(float f, float f2) {
        this.f23517a = f;
        this.f23518b = f2;
    }

    public void addNewPosition(float f, float f2) {
        float f3 = this.f23521e;
        this.f23519c = f3;
        float f4 = this.f23522f;
        this.f23520d = f4;
        this.f23521e = f;
        this.f23522f = f2;
        this.f23523g = f3 - f;
        this.f23524h = f4 - f2;
        this.f23525i = this.f23517a - f;
        this.f23526j = this.f23518b - f2;
    }

    public float getInitialX() {
        return this.f23517a;
    }

    public float getInitialY() {
        return this.f23518b;
    }

    public float getPreviousX() {
        return this.f23519c;
    }

    public float getPreviousY() {
        return this.f23520d;
    }

    public float getCurrentX() {
        return this.f23521e;
    }

    public float getCurrentY() {
        return this.f23522f;
    }

    public float getDistanceXSinceLast() {
        return this.f23523g;
    }

    public float getDistanceYSinceLast() {
        return this.f23524h;
    }

    public float getDistanceXSinceStart() {
        return this.f23525i;
    }

    public float getDistanceYSinceStart() {
        return this.f23526j;
    }
}
