package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapeFill implements ContentModel {

    /* renamed from: a */
    private final boolean f1462a;

    /* renamed from: b */
    private final Path.FillType f1463b;

    /* renamed from: c */
    private final String f1464c;

    /* renamed from: d */
    private final AnimatableColorValue f1465d;

    /* renamed from: e */
    private final AnimatableIntegerValue f1466e;

    /* renamed from: f */
    private final boolean f1467f;

    public ShapeFill(String str, boolean z, Path.FillType fillType, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, boolean z2) {
        this.f1464c = str;
        this.f1462a = z;
        this.f1463b = fillType;
        this.f1465d = animatableColorValue;
        this.f1466e = animatableIntegerValue;
        this.f1467f = z2;
    }

    public String getName() {
        return this.f1464c;
    }

    public AnimatableColorValue getColor() {
        return this.f1465d;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.f1466e;
    }

    public Path.FillType getFillType() {
        return this.f1463b;
    }

    public boolean isHidden() {
        return this.f1467f;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f1462a + '}';
    }
}
