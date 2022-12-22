package com.didichuxing.sofa.animation;

/* renamed from: com.didichuxing.sofa.animation.m */
/* compiled from: ElasticEaseOut */
class C16467m extends C16462h {
    C16467m(float f) {
        super(f);
    }

    /* renamed from: a */
    public Float mo121111a(float f, float f2, float f3, float f4) {
        if (f == 0.0f) {
            return Float.valueOf(f2);
        }
        float f5 = f / f4;
        if (f5 == 1.0f) {
            return Float.valueOf(f2 + f3);
        }
        float f6 = 0.3f * f4;
        return Float.valueOf((((float) Math.pow(2.0d, (double) (-10.0f * f5))) * f3 * ((float) Math.sin((double) ((((f5 * f4) - (f6 / 4.0f)) * 6.2831855f) / f6)))) + f3 + f2);
    }
}
