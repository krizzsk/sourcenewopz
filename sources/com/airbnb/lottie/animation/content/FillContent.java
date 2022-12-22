package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.C1429L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class FillContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a */
    private final Path f1215a = new Path();

    /* renamed from: b */
    private final Paint f1216b = new LPaint(1);

    /* renamed from: c */
    private final BaseLayer f1217c;

    /* renamed from: d */
    private final String f1218d;

    /* renamed from: e */
    private final boolean f1219e;

    /* renamed from: f */
    private final List<C1479b> f1220f = new ArrayList();

    /* renamed from: g */
    private final BaseKeyframeAnimation<Integer, Integer> f1221g;

    /* renamed from: h */
    private final BaseKeyframeAnimation<Integer, Integer> f1222h;

    /* renamed from: i */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1223i;

    /* renamed from: j */
    private final LottieDrawable f1224j;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        this.f1217c = baseLayer;
        this.f1218d = shapeFill.getName();
        this.f1219e = shapeFill.isHidden();
        this.f1224j = lottieDrawable;
        if (shapeFill.getColor() == null || shapeFill.getOpacity() == null) {
            this.f1221g = null;
            this.f1222h = null;
            return;
        }
        this.f1215a.setFillType(shapeFill.getFillType());
        BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeFill.getColor().createAnimation();
        this.f1221g = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.f1221g);
        BaseKeyframeAnimation<Integer, Integer> createAnimation2 = shapeFill.getOpacity().createAnimation();
        this.f1222h = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(this.f1222h);
    }

    public void onValueChanged() {
        this.f1224j.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = list2.get(i);
            if (content instanceof C1479b) {
                this.f1220f.add((C1479b) content);
            }
        }
    }

    public String getName() {
        return this.f1218d;
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        if (!this.f1219e) {
            C1429L.beginSection("FillContent#draw");
            this.f1216b.setColor(((ColorKeyframeAnimation) this.f1221g).getIntValue());
            this.f1216b.setAlpha(MiscUtils.clamp((int) ((((((float) i) / 255.0f) * ((float) this.f1222h.getValue().intValue())) / 100.0f) * 255.0f), 0, 255));
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1223i;
            if (baseKeyframeAnimation != null) {
                this.f1216b.setColorFilter(baseKeyframeAnimation.getValue());
            }
            this.f1215a.reset();
            for (int i2 = 0; i2 < this.f1220f.size(); i2++) {
                this.f1215a.addPath(this.f1220f.get(i2).getPath(), matrix);
            }
            canvas.drawPath(this.f1215a, this.f1216b);
            C1429L.endSection("FillContent#draw");
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.f1215a.reset();
        for (int i = 0; i < this.f1220f.size(); i++) {
            this.f1215a.addPath(this.f1220f.get(i).getPath(), matrix);
        }
        this.f1215a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.COLOR) {
            this.f1221g.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.OPACITY) {
            this.f1222h.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1223i;
            if (baseKeyframeAnimation != null) {
                this.f1217c.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f1223i = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1223i = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.f1217c.addAnimation(this.f1223i);
        }
    }
}
