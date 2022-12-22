package com.didi.hawaii.mapsdk.gesture;

public class MultiFingerDistancesObject {

    /* renamed from: a */
    private final float f23535a;

    /* renamed from: b */
    private final float f23536b;

    /* renamed from: c */
    private final float f23537c;

    /* renamed from: d */
    private final float f23538d;

    /* renamed from: e */
    private final float f23539e;

    /* renamed from: f */
    private final float f23540f;

    public MultiFingerDistancesObject(float f, float f2, float f3, float f4) {
        this.f23535a = f;
        this.f23536b = f2;
        this.f23537c = f3;
        this.f23538d = f4;
        this.f23539e = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        this.f23540f = (float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
    }

    public float getPrevFingersDiffX() {
        return this.f23535a;
    }

    public float getPrevFingersDiffY() {
        return this.f23536b;
    }

    public float getCurrFingersDiffX() {
        return this.f23537c;
    }

    public float getCurrFingersDiffY() {
        return this.f23538d;
    }

    public float getPrevFingersDiffXY() {
        return this.f23539e;
    }

    public float getCurrFingersDiffXY() {
        return this.f23540f;
    }
}
