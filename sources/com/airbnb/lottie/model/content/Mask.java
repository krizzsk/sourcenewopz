package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

public class Mask {

    /* renamed from: a */
    private final MaskMode f1432a;

    /* renamed from: b */
    private final AnimatableShapeValue f1433b;

    /* renamed from: c */
    private final AnimatableIntegerValue f1434c;

    /* renamed from: d */
    private final boolean f1435d;

    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean z) {
        this.f1432a = maskMode;
        this.f1433b = animatableShapeValue;
        this.f1434c = animatableIntegerValue;
        this.f1435d = z;
    }

    public MaskMode getMaskMode() {
        return this.f1432a;
    }

    public AnimatableShapeValue getMaskPath() {
        return this.f1433b;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.f1434c;
    }

    public boolean isInverted() {
        return this.f1435d;
    }
}
