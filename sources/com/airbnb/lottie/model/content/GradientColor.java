package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

public class GradientColor {

    /* renamed from: a */
    private final float[] f1407a;

    /* renamed from: b */
    private final int[] f1408b;

    public GradientColor(float[] fArr, int[] iArr) {
        this.f1407a = fArr;
        this.f1408b = iArr;
    }

    public float[] getPositions() {
        return this.f1407a;
    }

    public int[] getColors() {
        return this.f1408b;
    }

    public int getSize() {
        return this.f1408b.length;
    }

    public void lerp(GradientColor gradientColor, GradientColor gradientColor2, float f) {
        if (gradientColor.f1408b.length == gradientColor2.f1408b.length) {
            for (int i = 0; i < gradientColor.f1408b.length; i++) {
                this.f1407a[i] = MiscUtils.lerp(gradientColor.f1407a[i], gradientColor2.f1407a[i], f);
                this.f1408b[i] = GammaEvaluator.evaluate(f, gradientColor.f1408b[i], gradientColor2.f1408b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.f1408b.length + " vs " + gradientColor2.f1408b.length + ")");
    }
}
