package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapePath implements ContentModel {

    /* renamed from: a */
    private final String f1471a;

    /* renamed from: b */
    private final int f1472b;

    /* renamed from: c */
    private final AnimatableShapeValue f1473c;

    /* renamed from: d */
    private final boolean f1474d;

    public ShapePath(String str, int i, AnimatableShapeValue animatableShapeValue, boolean z) {
        this.f1471a = str;
        this.f1472b = i;
        this.f1473c = animatableShapeValue;
        this.f1474d = z;
    }

    public String getName() {
        return this.f1471a;
    }

    public AnimatableShapeValue getShapePath() {
        return this.f1473c;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public boolean isHidden() {
        return this.f1474d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f1471a + ", index=" + this.f1472b + '}';
    }
}
