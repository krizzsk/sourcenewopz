package com.didi.dqr.common;

public final class PerspectiveTransform {

    /* renamed from: a */
    private final float f18552a;

    /* renamed from: b */
    private final float f18553b;

    /* renamed from: c */
    private final float f18554c;

    /* renamed from: d */
    private final float f18555d;

    /* renamed from: e */
    private final float f18556e;

    /* renamed from: f */
    private final float f18557f;

    /* renamed from: g */
    private final float f18558g;

    /* renamed from: h */
    private final float f18559h;

    /* renamed from: i */
    private final float f18560i;

    private PerspectiveTransform(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f18552a = f;
        this.f18553b = f4;
        this.f18554c = f7;
        this.f18555d = f2;
        this.f18556e = f5;
        this.f18557f = f8;
        this.f18558g = f3;
        this.f18559h = f6;
        this.f18560i = f9;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return squareToQuadrilateral(f9, f10, f11, f12, f13, f14, f15, f16).mo58275a(quadrilateralToSquare(f, f2, f3, f4, f5, f6, f7, f8));
    }

    public void transformPoints(float[] fArr) {
        float[] fArr2 = fArr;
        int length = fArr2.length;
        float f = this.f18552a;
        float f2 = this.f18553b;
        float f3 = this.f18554c;
        float f4 = this.f18555d;
        float f5 = this.f18556e;
        float f6 = this.f18557f;
        float f7 = this.f18558g;
        float f8 = this.f18559h;
        float f9 = this.f18560i;
        for (int i = 0; i < length; i += 2) {
            float f10 = fArr2[i];
            int i2 = i + 1;
            float f11 = fArr2[i2];
            float f12 = (f3 * f10) + (f6 * f11) + f9;
            fArr2[i] = (((f * f10) + (f4 * f11)) + f7) / f12;
            fArr2[i2] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            float f = fArr[i];
            float f2 = fArr2[i];
            float f3 = (this.f18554c * f) + (this.f18557f * f2) + this.f18560i;
            fArr[i] = (((this.f18552a * f) + (this.f18555d * f2)) + this.f18558g) / f3;
            fArr2[i] = (((this.f18553b * f) + (this.f18556e * f2)) + this.f18559h) / f3;
        }
    }

    public static PerspectiveTransform squareToQuadrilateral(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new PerspectiveTransform(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f11 * f10) - (f9 * f13)) / f15;
        return new PerspectiveTransform((f16 * f3) + (f3 - f), (f17 * f7) + (f7 - f), f, (f4 - f2) + (f16 * f4), (f8 - f2) + (f17 * f8), f2, f16, f17, 1.0f);
    }

    public static PerspectiveTransform quadrilateralToSquare(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return squareToQuadrilateral(f, f2, f3, f4, f5, f6, f7, f8).mo58274a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PerspectiveTransform mo58274a() {
        float f = this.f18556e;
        float f2 = this.f18560i;
        float f3 = this.f18557f;
        float f4 = this.f18559h;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = this.f18558g;
        float f7 = this.f18555d;
        float f8 = (f3 * f6) - (f7 * f2);
        float f9 = (f7 * f4) - (f * f6);
        float f10 = this.f18554c;
        float f11 = this.f18553b;
        float f12 = (f10 * f4) - (f11 * f2);
        float f13 = this.f18552a;
        return new PerspectiveTransform(f5, f8, f9, f12, (f2 * f13) - (f10 * f6), (f6 * f11) - (f4 * f13), (f11 * f3) - (f10 * f), (f10 * f7) - (f3 * f13), (f13 * f) - (f11 * f7));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PerspectiveTransform mo58275a(PerspectiveTransform perspectiveTransform) {
        PerspectiveTransform perspectiveTransform2 = perspectiveTransform;
        float f = this.f18552a;
        float f2 = perspectiveTransform2.f18552a;
        float f3 = this.f18555d;
        float f4 = perspectiveTransform2.f18553b;
        float f5 = this.f18558g;
        float f6 = perspectiveTransform2.f18554c;
        float f7 = (f * f2) + (f3 * f4) + (f5 * f6);
        float f8 = perspectiveTransform2.f18555d;
        float f9 = perspectiveTransform2.f18556e;
        float f10 = perspectiveTransform2.f18557f;
        float f11 = (f * f8) + (f3 * f9) + (f5 * f10);
        float f12 = perspectiveTransform2.f18558g;
        float f13 = perspectiveTransform2.f18559h;
        float f14 = perspectiveTransform2.f18560i;
        float f15 = (f * f12) + (f3 * f13) + (f5 * f14);
        float f16 = this.f18553b;
        float f17 = f15;
        float f18 = this.f18556e;
        float f19 = f11;
        float f20 = this.f18559h;
        float f21 = (f16 * f2) + (f18 * f4) + (f20 * f6);
        float f22 = (f20 * f14) + (f16 * f12) + (f18 * f13);
        float f23 = this.f18554c;
        float f24 = this.f18557f;
        float f25 = (f2 * f23) + (f4 * f24);
        float f26 = this.f18560i;
        float f27 = (f23 * f12) + (f24 * f13) + (f26 * f14);
        return new PerspectiveTransform(f7, f19, f17, f21, (f16 * f8) + (f18 * f9) + (f20 * f10), f22, (f6 * f26) + f25, (f8 * f23) + (f9 * f24) + (f10 * f26), f27);
    }
}
