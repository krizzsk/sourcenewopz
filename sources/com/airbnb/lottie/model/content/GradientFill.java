package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientFillContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class GradientFill implements ContentModel {

    /* renamed from: a */
    private final GradientType f1409a;

    /* renamed from: b */
    private final Path.FillType f1410b;

    /* renamed from: c */
    private final AnimatableGradientColorValue f1411c;

    /* renamed from: d */
    private final AnimatableIntegerValue f1412d;

    /* renamed from: e */
    private final AnimatablePointValue f1413e;

    /* renamed from: f */
    private final AnimatablePointValue f1414f;

    /* renamed from: g */
    private final String f1415g;

    /* renamed from: h */
    private final AnimatableFloatValue f1416h;

    /* renamed from: i */
    private final AnimatableFloatValue f1417i;

    /* renamed from: j */
    private final boolean f1418j;

    public GradientFill(String str, GradientType gradientType, Path.FillType fillType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, boolean z) {
        this.f1409a = gradientType;
        this.f1410b = fillType;
        this.f1411c = animatableGradientColorValue;
        this.f1412d = animatableIntegerValue;
        this.f1413e = animatablePointValue;
        this.f1414f = animatablePointValue2;
        this.f1415g = str;
        this.f1416h = animatableFloatValue;
        this.f1417i = animatableFloatValue2;
        this.f1418j = z;
    }

    public String getName() {
        return this.f1415g;
    }

    public GradientType getGradientType() {
        return this.f1409a;
    }

    public Path.FillType getFillType() {
        return this.f1410b;
    }

    public AnimatableGradientColorValue getGradientColor() {
        return this.f1411c;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.f1412d;
    }

    public AnimatablePointValue getStartPoint() {
        return this.f1413e;
    }

    public AnimatablePointValue getEndPoint() {
        return this.f1414f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AnimatableFloatValue mo15333a() {
        return this.f1416h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public AnimatableFloatValue mo15334b() {
        return this.f1417i;
    }

    public boolean isHidden() {
        return this.f1418j;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientFillContent(lottieDrawable, baseLayer, this);
    }
}
