package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class GradientStroke implements ContentModel {

    /* renamed from: a */
    private final String f1419a;

    /* renamed from: b */
    private final GradientType f1420b;

    /* renamed from: c */
    private final AnimatableGradientColorValue f1421c;

    /* renamed from: d */
    private final AnimatableIntegerValue f1422d;

    /* renamed from: e */
    private final AnimatablePointValue f1423e;

    /* renamed from: f */
    private final AnimatablePointValue f1424f;

    /* renamed from: g */
    private final AnimatableFloatValue f1425g;

    /* renamed from: h */
    private final ShapeStroke.LineCapType f1426h;

    /* renamed from: i */
    private final ShapeStroke.LineJoinType f1427i;

    /* renamed from: j */
    private final float f1428j;

    /* renamed from: k */
    private final List<AnimatableFloatValue> f1429k;

    /* renamed from: l */
    private final AnimatableFloatValue f1430l;

    /* renamed from: m */
    private final boolean f1431m;

    public GradientStroke(String str, GradientType gradientType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2, boolean z) {
        this.f1419a = str;
        this.f1420b = gradientType;
        this.f1421c = animatableGradientColorValue;
        this.f1422d = animatableIntegerValue;
        this.f1423e = animatablePointValue;
        this.f1424f = animatablePointValue2;
        this.f1425g = animatableFloatValue;
        this.f1426h = lineCapType;
        this.f1427i = lineJoinType;
        this.f1428j = f;
        this.f1429k = list;
        this.f1430l = animatableFloatValue2;
        this.f1431m = z;
    }

    public String getName() {
        return this.f1419a;
    }

    public GradientType getGradientType() {
        return this.f1420b;
    }

    public AnimatableGradientColorValue getGradientColor() {
        return this.f1421c;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.f1422d;
    }

    public AnimatablePointValue getStartPoint() {
        return this.f1423e;
    }

    public AnimatablePointValue getEndPoint() {
        return this.f1424f;
    }

    public AnimatableFloatValue getWidth() {
        return this.f1425g;
    }

    public ShapeStroke.LineCapType getCapType() {
        return this.f1426h;
    }

    public ShapeStroke.LineJoinType getJoinType() {
        return this.f1427i;
    }

    public List<AnimatableFloatValue> getLineDashPattern() {
        return this.f1429k;
    }

    public AnimatableFloatValue getDashOffset() {
        return this.f1430l;
    }

    public float getMiterLimit() {
        return this.f1428j;
    }

    public boolean isHidden() {
        return this.f1431m;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientStrokeContent(lottieDrawable, baseLayer, this);
    }
}
