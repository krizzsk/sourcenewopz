package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class EllipseContent implements KeyPathElementContent, C1479b, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a */
    private static final float f1206a = 0.55228f;

    /* renamed from: b */
    private final Path f1207b = new Path();

    /* renamed from: c */
    private final String f1208c;

    /* renamed from: d */
    private final LottieDrawable f1209d;

    /* renamed from: e */
    private final BaseKeyframeAnimation<?, PointF> f1210e;

    /* renamed from: f */
    private final BaseKeyframeAnimation<?, PointF> f1211f;

    /* renamed from: g */
    private final CircleShape f1212g;

    /* renamed from: h */
    private CompoundTrimPathContent f1213h = new CompoundTrimPathContent();

    /* renamed from: i */
    private boolean f1214i;

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        this.f1208c = circleShape.getName();
        this.f1209d = lottieDrawable;
        this.f1210e = circleShape.getSize().createAnimation();
        this.f1211f = circleShape.getPosition().createAnimation();
        this.f1212g = circleShape;
        baseLayer.addAnimation(this.f1210e);
        baseLayer.addAnimation(this.f1211f);
        this.f1210e.addUpdateListener(this);
        this.f1211f.addUpdateListener(this);
    }

    public void onValueChanged() {
        m1267a();
    }

    /* renamed from: a */
    private void m1267a() {
        this.f1214i = false;
        this.f1209d.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.mo15218a() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f1213h.mo15211a(trimPathContent);
                    trimPathContent.mo15219a(this);
                }
            }
        }
    }

    public String getName() {
        return this.f1208c;
    }

    public Path getPath() {
        if (this.f1214i) {
            return this.f1207b;
        }
        this.f1207b.reset();
        if (this.f1212g.isHidden()) {
            this.f1214i = true;
            return this.f1207b;
        }
        PointF value = this.f1210e.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        float f3 = f * f1206a;
        float f4 = f1206a * f2;
        this.f1207b.reset();
        if (this.f1212g.isReversed()) {
            float f5 = -f2;
            this.f1207b.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.f1207b.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            float f10 = f5;
            this.f1207b.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f11 = f3 + 0.0f;
            this.f1207b.cubicTo(f11, f2, f, f9, f, 0.0f);
            this.f1207b.cubicTo(f, f8, f11, f10, 0.0f, f10);
        } else {
            float f12 = -f2;
            this.f1207b.moveTo(0.0f, f12);
            float f13 = f3 + 0.0f;
            float f14 = 0.0f - f4;
            this.f1207b.cubicTo(f13, f12, f, f14, f, 0.0f);
            float f15 = f4 + 0.0f;
            this.f1207b.cubicTo(f, f15, f13, f2, 0.0f, f2);
            float f16 = 0.0f - f3;
            float f17 = -f;
            this.f1207b.cubicTo(f16, f2, f17, f15, f17, 0.0f);
            float f18 = f12;
            this.f1207b.cubicTo(f17, f14, f16, f18, 0.0f, f18);
        }
        PointF value2 = this.f1211f.getValue();
        this.f1207b.offset(value2.x, value2.y);
        this.f1207b.close();
        this.f1213h.apply(this.f1207b);
        this.f1214i = true;
        return this.f1207b;
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.ELLIPSE_SIZE) {
            this.f1210e.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POSITION) {
            this.f1211f.setValueCallback(lottieValueCallback);
        }
    }
}
