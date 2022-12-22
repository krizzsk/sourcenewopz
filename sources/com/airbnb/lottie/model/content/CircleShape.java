package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class CircleShape implements ContentModel {

    /* renamed from: a */
    private final String f1402a;

    /* renamed from: b */
    private final AnimatableValue<PointF, PointF> f1403b;

    /* renamed from: c */
    private final AnimatablePointValue f1404c;

    /* renamed from: d */
    private final boolean f1405d;

    /* renamed from: e */
    private final boolean f1406e;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z, boolean z2) {
        this.f1402a = str;
        this.f1403b = animatableValue;
        this.f1404c = animatablePointValue;
        this.f1405d = z;
        this.f1406e = z2;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }

    public String getName() {
        return this.f1402a;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.f1403b;
    }

    public AnimatablePointValue getSize() {
        return this.f1404c;
    }

    public boolean isReversed() {
        return this.f1405d;
    }

    public boolean isHidden() {
        return this.f1406e;
    }
}
