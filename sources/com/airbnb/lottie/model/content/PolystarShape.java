package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class PolystarShape implements ContentModel {

    /* renamed from: a */
    private final String f1439a;

    /* renamed from: b */
    private final Type f1440b;

    /* renamed from: c */
    private final AnimatableFloatValue f1441c;

    /* renamed from: d */
    private final AnimatableValue<PointF, PointF> f1442d;

    /* renamed from: e */
    private final AnimatableFloatValue f1443e;

    /* renamed from: f */
    private final AnimatableFloatValue f1444f;

    /* renamed from: g */
    private final AnimatableFloatValue f1445g;

    /* renamed from: h */
    private final AnimatableFloatValue f1446h;

    /* renamed from: i */
    private final AnimatableFloatValue f1447i;

    /* renamed from: j */
    private final boolean f1448j;

    public enum Type {
        STAR(1),
        POLYGON(2);
        
        private final int value;

        private Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5, AnimatableFloatValue animatableFloatValue6, boolean z) {
        this.f1439a = str;
        this.f1440b = type;
        this.f1441c = animatableFloatValue;
        this.f1442d = animatableValue;
        this.f1443e = animatableFloatValue2;
        this.f1444f = animatableFloatValue3;
        this.f1445g = animatableFloatValue4;
        this.f1446h = animatableFloatValue5;
        this.f1447i = animatableFloatValue6;
        this.f1448j = z;
    }

    public String getName() {
        return this.f1439a;
    }

    public Type getType() {
        return this.f1440b;
    }

    public AnimatableFloatValue getPoints() {
        return this.f1441c;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.f1442d;
    }

    public AnimatableFloatValue getRotation() {
        return this.f1443e;
    }

    public AnimatableFloatValue getInnerRadius() {
        return this.f1444f;
    }

    public AnimatableFloatValue getOuterRadius() {
        return this.f1445g;
    }

    public AnimatableFloatValue getInnerRoundedness() {
        return this.f1446h;
    }

    public AnimatableFloatValue getOuterRoundedness() {
        return this.f1447i;
    }

    public boolean isHidden() {
        return this.f1448j;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new PolystarContent(lottieDrawable, baseLayer, this);
    }
}
