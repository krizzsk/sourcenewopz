package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

public class StrokeContent extends BaseStrokeContent {

    /* renamed from: b */
    private final BaseLayer f1306b;

    /* renamed from: c */
    private final String f1307c;

    /* renamed from: d */
    private final boolean f1308d;

    /* renamed from: e */
    private final BaseKeyframeAnimation<Integer, Integer> f1309e;

    /* renamed from: f */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1310f;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.getCapType().toPaintCap(), shapeStroke.getJoinType().toPaintJoin(), shapeStroke.getMiterLimit(), shapeStroke.getOpacity(), shapeStroke.getWidth(), shapeStroke.getLineDashPattern(), shapeStroke.getDashOffset());
        this.f1306b = baseLayer;
        this.f1307c = shapeStroke.getName();
        this.f1308d = shapeStroke.isHidden();
        BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeStroke.getColor().createAnimation();
        this.f1309e = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.f1309e);
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        if (!this.f1308d) {
            this.f1181a.setColor(((ColorKeyframeAnimation) this.f1309e).getIntValue());
            if (this.f1310f != null) {
                this.f1181a.setColorFilter(this.f1310f.getValue());
            }
            super.draw(canvas, matrix, i);
        }
    }

    public String getName() {
        return this.f1307c;
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.STROKE_COLOR) {
            this.f1309e.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1310f;
            if (baseKeyframeAnimation != null) {
                this.f1306b.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f1310f = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1310f = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.f1306b.addAnimation(this.f1309e);
        }
    }
}
