package com.microblink.blinkbarcode.hardware.accelerometer;

/* compiled from: line */
public class IlIllIlIIl {
    private float IIlIIIllIl;
    private float IlIllIlIIl;
    private float IllIIIIllI;
    private float IllIIIllII;
    private float lIlIIIIlIl;
    private float llIIIlllll;
    private float llIIlIIlll;
    private float llIIlIlIIl;

    public IlIllIlIIl(float f, float f2) {
        this.IIlIIIllIl = f;
        this.llIIlIIlll = f / ((f2 * f) + f);
    }

    public float IlIllIlIIl() {
        return this.IlIllIlIIl;
    }

    public float IllIIIllII() {
        return this.IllIIIllII;
    }

    public float llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    public void llIIlIlIIl(float f, float f2, float f3) {
        float f4 = this.llIIlIIlll;
        float f5 = 1.0f - f4;
        float f6 = (f * f4) + (this.llIIIlllll * f5);
        this.llIIIlllll = f6;
        float f7 = (f2 * f4) + (this.IllIIIIllI * f5);
        this.IllIIIIllI = f7;
        float f8 = (f4 * f3) + (this.lIlIIIIlIl * f5);
        this.lIlIIIIlIl = f8;
        this.llIIlIlIIl = f - f6;
        this.IlIllIlIIl = f2 - f7;
        this.IllIIIllII = f3 - f8;
    }

    public void llIIlIlIIl(float f) {
        this.IIlIIIllIl = f;
        this.llIIlIIlll = f / ((1.0f * f) + f);
    }
}
