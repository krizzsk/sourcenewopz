package com.didi.zxing.barcodescanner.camera;

import android.graphics.Rect;
import com.didi.zxing.barcodescanner.Size;

public class FitXYStrategy extends PreviewScalingStrategy {

    /* renamed from: a */
    private static final String f45389a = "FitXYStrategy";

    /* renamed from: a */
    private static float m32579a(float f) {
        return f < 1.0f ? 1.0f / f : f;
    }

    /* access modifiers changed from: protected */
    public float getScore(Size size, Size size2) {
        if (size.width <= 0 || size.height <= 0) {
            return 0.0f;
        }
        float a = (1.0f / m32579a((((float) size.width) * 1.0f) / ((float) size2.width))) / m32579a((((float) size.height) * 1.0f) / ((float) size2.height));
        float a2 = m32579a(((((float) size.width) * 1.0f) / ((float) size.height)) / ((((float) size2.width) * 1.0f) / ((float) size2.height)));
        return a * (((1.0f / a2) / a2) / a2);
    }

    public Rect scalePreview(Size size, Size size2) {
        return new Rect(0, 0, size2.width, size2.height);
    }
}
