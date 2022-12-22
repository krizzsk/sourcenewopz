package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RectangleContent implements KeyPathElementContent, C1479b, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a */
    private final Path f1279a = new Path();

    /* renamed from: b */
    private final RectF f1280b = new RectF();

    /* renamed from: c */
    private final String f1281c;

    /* renamed from: d */
    private final boolean f1282d;

    /* renamed from: e */
    private final LottieDrawable f1283e;

    /* renamed from: f */
    private final BaseKeyframeAnimation<?, PointF> f1284f;

    /* renamed from: g */
    private final BaseKeyframeAnimation<?, PointF> f1285g;

    /* renamed from: h */
    private final BaseKeyframeAnimation<?, Float> f1286h;

    /* renamed from: i */
    private CompoundTrimPathContent f1287i = new CompoundTrimPathContent();

    /* renamed from: j */
    private boolean f1288j;

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.f1281c = rectangleShape.getName();
        this.f1282d = rectangleShape.isHidden();
        this.f1283e = lottieDrawable;
        this.f1284f = rectangleShape.getPosition().createAnimation();
        this.f1285g = rectangleShape.getSize().createAnimation();
        this.f1286h = rectangleShape.getCornerRadius().createAnimation();
        baseLayer.addAnimation(this.f1284f);
        baseLayer.addAnimation(this.f1285g);
        baseLayer.addAnimation(this.f1286h);
        this.f1284f.addUpdateListener(this);
        this.f1285g.addUpdateListener(this);
        this.f1286h.addUpdateListener(this);
    }

    public String getName() {
        return this.f1281c;
    }

    public void onValueChanged() {
        m1281a();
    }

    /* renamed from: a */
    private void m1281a() {
        this.f1288j = false;
        this.f1283e.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.mo15218a() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f1287i.mo15211a(trimPathContent);
                    trimPathContent.mo15219a(this);
                }
            }
        }
    }

    public Path getPath() {
        float f;
        if (this.f1288j) {
            return this.f1279a;
        }
        this.f1279a.reset();
        if (this.f1282d) {
            this.f1288j = true;
            return this.f1279a;
        }
        PointF value = this.f1285g.getValue();
        float f2 = value.x / 2.0f;
        float f3 = value.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f1286h;
        if (baseKeyframeAnimation == null) {
            f = 0.0f;
        } else {
            f = ((FloatKeyframeAnimation) baseKeyframeAnimation).getFloatValue();
        }
        float min = Math.min(f2, f3);
        if (f > min) {
            f = min;
        }
        PointF value2 = this.f1284f.getValue();
        this.f1279a.moveTo(value2.x + f2, (value2.y - f3) + f);
        this.f1279a.lineTo(value2.x + f2, (value2.y + f3) - f);
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i > 0) {
            float f4 = f * 2.0f;
            this.f1280b.set((value2.x + f2) - f4, (value2.y + f3) - f4, value2.x + f2, value2.y + f3);
            this.f1279a.arcTo(this.f1280b, 0.0f, 90.0f, false);
        }
        this.f1279a.lineTo((value2.x - f2) + f, value2.y + f3);
        if (i > 0) {
            float f5 = f * 2.0f;
            this.f1280b.set(value2.x - f2, (value2.y + f3) - f5, (value2.x - f2) + f5, value2.y + f3);
            this.f1279a.arcTo(this.f1280b, 90.0f, 90.0f, false);
        }
        this.f1279a.lineTo(value2.x - f2, (value2.y - f3) + f);
        if (i > 0) {
            float f6 = f * 2.0f;
            this.f1280b.set(value2.x - f2, value2.y - f3, (value2.x - f2) + f6, (value2.y - f3) + f6);
            this.f1279a.arcTo(this.f1280b, 180.0f, 90.0f, false);
        }
        this.f1279a.lineTo((value2.x + f2) - f, value2.y - f3);
        if (i > 0) {
            float f7 = f * 2.0f;
            this.f1280b.set((value2.x + f2) - f7, value2.y - f3, value2.x + f2, (value2.y - f3) + f7);
            this.f1279a.arcTo(this.f1280b, 270.0f, 90.0f, false);
        }
        this.f1279a.close();
        this.f1287i.apply(this.f1279a);
        this.f1288j = true;
        return this.f1279a;
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.RECTANGLE_SIZE) {
            this.f1285g.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POSITION) {
            this.f1284f.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.CORNER_RADIUS) {
            this.f1286h.setValueCallback(lottieValueCallback);
        }
    }
}
