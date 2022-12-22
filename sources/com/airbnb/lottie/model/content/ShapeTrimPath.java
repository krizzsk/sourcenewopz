package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapeTrimPath implements ContentModel {

    /* renamed from: a */
    private final String f1487a;

    /* renamed from: b */
    private final Type f1488b;

    /* renamed from: c */
    private final AnimatableFloatValue f1489c;

    /* renamed from: d */
    private final AnimatableFloatValue f1490d;

    /* renamed from: e */
    private final AnimatableFloatValue f1491e;

    /* renamed from: f */
    private final boolean f1492f;

    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z) {
        this.f1487a = str;
        this.f1488b = type;
        this.f1489c = animatableFloatValue;
        this.f1490d = animatableFloatValue2;
        this.f1491e = animatableFloatValue3;
        this.f1492f = z;
    }

    public String getName() {
        return this.f1487a;
    }

    public Type getType() {
        return this.f1488b;
    }

    public AnimatableFloatValue getEnd() {
        return this.f1490d;
    }

    public AnimatableFloatValue getStart() {
        return this.f1489c;
    }

    public AnimatableFloatValue getOffset() {
        return this.f1491e;
    }

    public boolean isHidden() {
        return this.f1492f;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.f1489c + ", end: " + this.f1490d + ", offset: " + this.f1491e + "}";
    }
}
