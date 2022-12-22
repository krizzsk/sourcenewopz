package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

public class Repeater implements ContentModel {

    /* renamed from: a */
    private final String f1454a;

    /* renamed from: b */
    private final AnimatableFloatValue f1455b;

    /* renamed from: c */
    private final AnimatableFloatValue f1456c;

    /* renamed from: d */
    private final AnimatableTransform f1457d;

    /* renamed from: e */
    private final boolean f1458e;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z) {
        this.f1454a = str;
        this.f1455b = animatableFloatValue;
        this.f1456c = animatableFloatValue2;
        this.f1457d = animatableTransform;
        this.f1458e = z;
    }

    public String getName() {
        return this.f1454a;
    }

    public AnimatableFloatValue getCopies() {
        return this.f1455b;
    }

    public AnimatableFloatValue getOffset() {
        return this.f1456c;
    }

    public AnimatableTransform getTransform() {
        return this.f1457d;
    }

    public boolean isHidden() {
        return this.f1458e;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RepeaterContent(lottieDrawable, baseLayer, this);
    }
}
