package com.airbnb.lottie.utils;

public class GammaEvaluator {
    /* renamed from: a */
    private static float m1465a(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow((double) f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    /* renamed from: b */
    private static float m1466b(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((double) ((f + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    public static int evaluate(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((float) ((i >> 24) & 255)) / 255.0f;
        float b = m1466b(((float) ((i >> 16) & 255)) / 255.0f);
        float b2 = m1466b(((float) ((i >> 8) & 255)) / 255.0f);
        float b3 = m1466b(((float) (i & 255)) / 255.0f);
        float b4 = m1466b(((float) ((i2 >> 16) & 255)) / 255.0f);
        float b5 = m1466b(((float) ((i2 >> 8) & 255)) / 255.0f);
        float b6 = b3 + (f * (m1466b(((float) (i2 & 255)) / 255.0f) - b3));
        return (Math.round(m1465a(b + ((b4 - b) * f)) * 255.0f) << 16) | (Math.round((f2 + (((((float) ((i2 >> 24) & 255)) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(m1465a(b2 + ((b5 - b2) * f)) * 255.0f) << 8) | Math.round(m1465a(b6) * 255.0f);
    }
}
