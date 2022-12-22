package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

public class AnimatableTransform implements ModifierContent, ContentModel {

    /* renamed from: a */
    private final AnimatablePathValue f1392a;

    /* renamed from: b */
    private final AnimatableValue<PointF, PointF> f1393b;

    /* renamed from: c */
    private final AnimatableScaleValue f1394c;

    /* renamed from: d */
    private final AnimatableFloatValue f1395d;

    /* renamed from: e */
    private final AnimatableIntegerValue f1396e;

    /* renamed from: f */
    private final AnimatableFloatValue f1397f;

    /* renamed from: g */
    private final AnimatableFloatValue f1398g;

    /* renamed from: h */
    private final AnimatableFloatValue f1399h;

    /* renamed from: i */
    private final AnimatableFloatValue f1400i;

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return null;
    }

    public AnimatableTransform() {
        this((AnimatablePathValue) null, (AnimatableValue<PointF, PointF>) null, (AnimatableScaleValue) null, (AnimatableFloatValue) null, (AnimatableIntegerValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null);
    }

    public AnimatableTransform(AnimatablePathValue animatablePathValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableScaleValue animatableScaleValue, AnimatableFloatValue animatableFloatValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5) {
        this.f1392a = animatablePathValue;
        this.f1393b = animatableValue;
        this.f1394c = animatableScaleValue;
        this.f1395d = animatableFloatValue;
        this.f1396e = animatableIntegerValue;
        this.f1399h = animatableFloatValue2;
        this.f1400i = animatableFloatValue3;
        this.f1397f = animatableFloatValue4;
        this.f1398g = animatableFloatValue5;
    }

    public AnimatablePathValue getAnchorPoint() {
        return this.f1392a;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.f1393b;
    }

    public AnimatableScaleValue getScale() {
        return this.f1394c;
    }

    public AnimatableFloatValue getRotation() {
        return this.f1395d;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.f1396e;
    }

    public AnimatableFloatValue getStartOpacity() {
        return this.f1399h;
    }

    public AnimatableFloatValue getEndOpacity() {
        return this.f1400i;
    }

    public AnimatableFloatValue getSkew() {
        return this.f1397f;
    }

    public AnimatableFloatValue getSkewAngle() {
        return this.f1398g;
    }

    public TransformKeyframeAnimation createAnimation() {
        return new TransformKeyframeAnimation(this);
    }
}
