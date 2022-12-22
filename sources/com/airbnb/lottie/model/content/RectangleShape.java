package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class RectangleShape implements ContentModel {

    /* renamed from: a */
    private final String f1449a;

    /* renamed from: b */
    private final AnimatableValue<PointF, PointF> f1450b;

    /* renamed from: c */
    private final AnimatablePointValue f1451c;

    /* renamed from: d */
    private final AnimatableFloatValue f1452d;

    /* renamed from: e */
    private final boolean f1453e;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, AnimatableFloatValue animatableFloatValue, boolean z) {
        this.f1449a = str;
        this.f1450b = animatableValue;
        this.f1451c = animatablePointValue;
        this.f1452d = animatableFloatValue;
        this.f1453e = z;
    }

    public String getName() {
        return this.f1449a;
    }

    public AnimatableFloatValue getCornerRadius() {
        return this.f1452d;
    }

    public AnimatablePointValue getSize() {
        return this.f1451c;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.f1450b;
    }

    public boolean isHidden() {
        return this.f1453e;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.f1450b + ", size=" + this.f1451c + '}';
    }
}
