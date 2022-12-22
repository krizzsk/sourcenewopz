package com.google.p217ar.core;

/* renamed from: com.google.ar.core.Quaternion */
class Quaternion {

    /* renamed from: a */
    public static final Quaternion f53448a = new Quaternion();

    /* renamed from: w */
    private float f53449w = 1.0f;

    /* renamed from: x */
    private float f53450x = 0.0f;

    /* renamed from: y */
    private float f53451y = 0.0f;

    /* renamed from: z */
    private float f53452z = 0.0f;

    public Quaternion() {
        m38260a(0.0f, 0.0f, 0.0f, 1.0f);
    }

    private Quaternion(Quaternion quaternion) {
        m38260a(quaternion.f53450x, quaternion.f53451y, quaternion.f53452z, quaternion.f53449w);
    }

    public Quaternion(float f, float f2, float f3, float f4) {
        m38260a(f, f2, f3, f4);
    }

    /* renamed from: a */
    private final void m38260a(float f, float f2, float f3, float f4) {
        this.f53450x = f;
        this.f53451y = f2;
        this.f53452z = f3;
        this.f53449w = f4;
    }

    /* renamed from: a */
    public final float mo149557a() {
        return this.f53450x;
    }

    /* renamed from: b */
    public final float mo149561b() {
        return this.f53451y;
    }

    /* renamed from: c */
    public final float mo149562c() {
        return this.f53452z;
    }

    /* renamed from: d */
    public final float mo149563d() {
        return this.f53449w;
    }

    /* renamed from: a */
    public final void mo149559a(float[] fArr, int i) {
        fArr[i] = this.f53450x;
        fArr[i + 1] = this.f53451y;
        fArr[i + 2] = this.f53452z;
        fArr[i + 3] = this.f53449w;
    }

    /* renamed from: e */
    public final Quaternion mo149564e() {
        return new Quaternion(-this.f53450x, -this.f53451y, -this.f53452z, this.f53449w);
    }

    /* renamed from: a */
    public final Quaternion mo149558a(Quaternion quaternion) {
        Quaternion quaternion2 = new Quaternion();
        float f = this.f53450x;
        float f2 = quaternion.f53449w;
        float f3 = this.f53451y;
        float f4 = quaternion.f53452z;
        float f5 = this.f53452z;
        float f6 = quaternion.f53451y;
        float f7 = this.f53449w;
        quaternion2.f53450x = (((f * f2) + (f3 * f4)) - (f5 * f6)) + (quaternion.f53450x * f7);
        float f8 = this.f53450x;
        float f9 = ((-f8) * f4) + (f3 * f2);
        float f10 = quaternion.f53450x;
        quaternion2.f53451y = f9 + (f5 * f10) + (f6 * f7);
        float f11 = quaternion.f53451y;
        float f12 = this.f53451y;
        quaternion2.f53452z = ((f8 * f11) - (f12 * f10)) + (f5 * f2) + (f4 * f7);
        quaternion2.f53449w = ((((-f8) * f10) - (f12 * f11)) - (this.f53452z * quaternion.f53452z)) + (f7 * f2);
        return quaternion2;
    }

    /* renamed from: a */
    public static Quaternion m38259a(Quaternion quaternion, Quaternion quaternion2, float f) {
        float f2;
        Quaternion quaternion3 = new Quaternion();
        float f3 = (quaternion.f53450x * quaternion2.f53450x) + (quaternion.f53451y * quaternion2.f53451y) + (quaternion.f53452z * quaternion2.f53452z) + (quaternion.f53449w * quaternion2.f53449w);
        if (f3 < 0.0f) {
            Quaternion quaternion4 = new Quaternion(quaternion2);
            f3 = -f3;
            quaternion4.f53450x = -quaternion4.f53450x;
            quaternion4.f53451y = -quaternion4.f53451y;
            quaternion4.f53452z = -quaternion4.f53452z;
            quaternion4.f53449w = -quaternion4.f53449w;
            quaternion2 = quaternion4;
        }
        float acos = (float) Math.acos((double) f3);
        float sqrt = (float) Math.sqrt((double) (1.0f - (f3 * f3)));
        if (((double) Math.abs(sqrt)) > 0.001d) {
            float f4 = 1.0f / sqrt;
            f2 = ((float) Math.sin((double) ((1.0f - f) * acos))) * f4;
            f = ((float) Math.sin((double) (f * acos))) * f4;
        } else {
            f2 = 1.0f - f;
        }
        float f5 = (quaternion.f53450x * f2) + (quaternion2.f53450x * f);
        quaternion3.f53450x = f5;
        float f6 = (quaternion.f53451y * f2) + (quaternion2.f53451y * f);
        quaternion3.f53451y = f6;
        float f7 = (quaternion.f53452z * f2) + (quaternion2.f53452z * f);
        quaternion3.f53452z = f7;
        float f8 = (f2 * quaternion.f53449w) + (f * quaternion2.f53449w);
        quaternion3.f53449w = f8;
        float sqrt2 = (float) (1.0d / Math.sqrt((double) ((((f5 * f5) + (f6 * f6)) + (f7 * f7)) + (f8 * f8))));
        quaternion3.f53450x *= sqrt2;
        quaternion3.f53451y *= sqrt2;
        quaternion3.f53452z *= sqrt2;
        quaternion3.f53449w *= sqrt2;
        return quaternion3;
    }

    /* renamed from: a */
    public final void mo149560a(float[] fArr, int i, int i2) {
        float f = this.f53450x;
        float f2 = this.f53451y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f53452z;
        float f5 = f3 + (f4 * f4);
        float f6 = this.f53449w;
        float f7 = f5 + (f6 * f6);
        float f8 = 0.0f;
        if (f7 > 0.0f) {
            f8 = 2.0f / f7;
        }
        float f9 = this.f53450x;
        float f10 = f9 * f8;
        float f11 = this.f53451y;
        float f12 = f11 * f8;
        float f13 = this.f53452z;
        float f14 = f8 * f13;
        float f15 = this.f53449w;
        float f16 = f15 * f10;
        float f17 = f15 * f12;
        float f18 = f15 * f14;
        float f19 = f10 * f9;
        float f20 = f9 * f12;
        float f21 = f9 * f14;
        float f22 = f12 * f11;
        float f23 = f11 * f14;
        float f24 = f13 * f14;
        fArr[i] = 1.0f - (f22 + f24);
        fArr[i + 4] = f20 - f18;
        fArr[i + 8] = f21 + f17;
        int i3 = i + 1;
        fArr[i3] = f20 + f18;
        fArr[i3 + 4] = 1.0f - (f24 + f19);
        fArr[i3 + 8] = f23 - f16;
        int i4 = i + 2;
        fArr[i4] = f21 - f17;
        fArr[i4 + 4] = f23 + f16;
        fArr[i4 + 8] = 1.0f - (f19 + f22);
    }

    /* renamed from: a */
    public static void m38261a(Quaternion quaternion, float[] fArr, int i, float[] fArr2, int i2) {
        float f = fArr[i];
        float f2 = fArr[i + 1];
        float f3 = fArr[i + 2];
        float f4 = quaternion.f53450x;
        float f5 = quaternion.f53451y;
        float f6 = quaternion.f53452z;
        float f7 = quaternion.f53449w;
        float f8 = ((f7 * f) + (f5 * f3)) - (f6 * f2);
        float f9 = ((f7 * f2) + (f6 * f)) - (f4 * f3);
        float f10 = ((f7 * f3) + (f4 * f2)) - (f5 * f);
        float f11 = -f4;
        float f12 = ((f * f11) - (f2 * f5)) - (f3 * f6);
        float f13 = -f6;
        float f14 = -f5;
        fArr2[i2] = (((f8 * f7) + (f12 * f11)) + (f9 * f13)) - (f10 * f14);
        fArr2[i2 + 1] = (((f9 * f7) + (f12 * f14)) + (f10 * f11)) - (f8 * f13);
        fArr2[i2 + 2] = (((f10 * f7) + (f12 * f13)) + (f8 * f14)) - (f9 * f11);
    }

    public String toString() {
        return String.format("[%.3f, %.3f, %.3f, %.3f]", new Object[]{Float.valueOf(this.f53450x), Float.valueOf(this.f53451y), Float.valueOf(this.f53452z), Float.valueOf(this.f53449w)});
    }
}
