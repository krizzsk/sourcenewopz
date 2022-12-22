package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.C1429L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseStrokeContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a */
    final Paint f1181a;

    /* renamed from: b */
    private final PathMeasure f1182b = new PathMeasure();

    /* renamed from: c */
    private final Path f1183c = new Path();

    /* renamed from: d */
    private final Path f1184d = new Path();

    /* renamed from: e */
    private final RectF f1185e = new RectF();

    /* renamed from: f */
    private final LottieDrawable f1186f;

    /* renamed from: g */
    private final List<PathGroup> f1187g = new ArrayList();

    /* renamed from: h */
    private final float[] f1188h;

    /* renamed from: i */
    private final BaseKeyframeAnimation<?, Float> f1189i;

    /* renamed from: j */
    private final BaseKeyframeAnimation<?, Integer> f1190j;

    /* renamed from: k */
    private final List<BaseKeyframeAnimation<?, Float>> f1191k;

    /* renamed from: l */
    private final BaseKeyframeAnimation<?, Float> f1192l;
    protected final BaseLayer layer;

    /* renamed from: m */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1193m;

    BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.f1181a = lPaint;
        this.f1186f = lottieDrawable;
        this.layer = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        this.f1181a.setStrokeCap(cap);
        this.f1181a.setStrokeJoin(join);
        this.f1181a.setStrokeMiter(f);
        this.f1190j = animatableIntegerValue.createAnimation();
        this.f1189i = animatableFloatValue.createAnimation();
        if (animatableFloatValue2 == null) {
            this.f1192l = null;
        } else {
            this.f1192l = animatableFloatValue2.createAnimation();
        }
        this.f1191k = new ArrayList(list.size());
        this.f1188h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.f1191k.add(list.get(i).createAnimation());
        }
        baseLayer.addAnimation(this.f1190j);
        baseLayer.addAnimation(this.f1189i);
        for (int i2 = 0; i2 < this.f1191k.size(); i2++) {
            baseLayer.addAnimation(this.f1191k.get(i2));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f1192l;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        this.f1190j.addUpdateListener(this);
        this.f1189i.addUpdateListener(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f1191k.get(i3).addUpdateListener(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f1192l;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(this);
        }
    }

    public void onValueChanged() {
        this.f1186f.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.mo15218a() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.mo15219a(this);
        }
        PathGroup pathGroup = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.mo15218a() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.f1187g.add(pathGroup);
                    }
                    pathGroup = new PathGroup(trimPathContent3);
                    trimPathContent3.mo15219a(this);
                }
            }
            if (content2 instanceof C1479b) {
                if (pathGroup == null) {
                    pathGroup = new PathGroup(trimPathContent);
                }
                pathGroup.paths.add((C1479b) content2);
            }
        }
        if (pathGroup != null) {
            this.f1187g.add(pathGroup);
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        C1429L.beginSection("StrokeContent#draw");
        if (Utils.hasZeroScaleAxis(matrix)) {
            C1429L.endSection("StrokeContent#draw");
            return;
        }
        this.f1181a.setAlpha(MiscUtils.clamp((int) ((((((float) i) / 255.0f) * ((float) ((IntegerKeyframeAnimation) this.f1190j).getIntValue())) / 100.0f) * 255.0f), 0, 255));
        this.f1181a.setStrokeWidth(((FloatKeyframeAnimation) this.f1189i).getFloatValue() * Utils.getScale(matrix));
        if (this.f1181a.getStrokeWidth() <= 0.0f) {
            C1429L.endSection("StrokeContent#draw");
            return;
        }
        m1260a(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1193m;
        if (baseKeyframeAnimation != null) {
            this.f1181a.setColorFilter(baseKeyframeAnimation.getValue());
        }
        for (int i2 = 0; i2 < this.f1187g.size(); i2++) {
            PathGroup pathGroup = this.f1187g.get(i2);
            if (pathGroup.trimPath != null) {
                m1259a(canvas, pathGroup, matrix);
            } else {
                C1429L.beginSection("StrokeContent#buildPath");
                this.f1183c.reset();
                for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
                    this.f1183c.addPath(((C1479b) pathGroup.paths.get(size)).getPath(), matrix);
                }
                C1429L.endSection("StrokeContent#buildPath");
                C1429L.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.f1183c, this.f1181a);
                C1429L.endSection("StrokeContent#drawPath");
            }
        }
        C1429L.endSection("StrokeContent#draw");
    }

    /* renamed from: a */
    private void m1259a(Canvas canvas, PathGroup pathGroup, Matrix matrix) {
        C1429L.beginSection("StrokeContent#applyTrimPath");
        if (pathGroup.trimPath == null) {
            C1429L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.f1183c.reset();
        for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
            this.f1183c.addPath(((C1479b) pathGroup.paths.get(size)).getPath(), matrix);
        }
        this.f1182b.setPath(this.f1183c, false);
        float length = this.f1182b.getLength();
        while (this.f1182b.nextContour()) {
            length += this.f1182b.getLength();
        }
        float floatValue = (pathGroup.trimPath.getOffset().getValue().floatValue() * length) / 360.0f;
        float floatValue2 = ((pathGroup.trimPath.getStart().getValue().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((pathGroup.trimPath.getEnd().getValue().floatValue() * length) / 100.0f) + floatValue;
        float f = 0.0f;
        for (int size2 = pathGroup.paths.size() - 1; size2 >= 0; size2--) {
            this.f1184d.set(((C1479b) pathGroup.paths.get(size2)).getPath());
            this.f1184d.transform(matrix);
            this.f1182b.setPath(this.f1184d, false);
            float length2 = this.f1182b.getLength();
            float f2 = 1.0f;
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f + length2 && f < f3) {
                    Utils.applyTrimPathIfNeeded(this.f1184d, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f1184d, this.f1181a);
                    f += length2;
                }
            }
            float f4 = f + length2;
            if (f4 >= floatValue2 && f <= floatValue3) {
                if (f4 > floatValue3 || floatValue2 >= f) {
                    float f5 = floatValue2 < f ? 0.0f : (floatValue2 - f) / length2;
                    if (floatValue3 <= f4) {
                        f2 = (floatValue3 - f) / length2;
                    }
                    Utils.applyTrimPathIfNeeded(this.f1184d, f5, f2, 0.0f);
                    canvas.drawPath(this.f1184d, this.f1181a);
                } else {
                    canvas.drawPath(this.f1184d, this.f1181a);
                }
            }
            f += length2;
        }
        C1429L.endSection("StrokeContent#applyTrimPath");
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        C1429L.beginSection("StrokeContent#getBounds");
        this.f1183c.reset();
        for (int i = 0; i < this.f1187g.size(); i++) {
            PathGroup pathGroup = this.f1187g.get(i);
            for (int i2 = 0; i2 < pathGroup.paths.size(); i2++) {
                this.f1183c.addPath(((C1479b) pathGroup.paths.get(i2)).getPath(), matrix);
            }
        }
        this.f1183c.computeBounds(this.f1185e, false);
        float floatValue = ((FloatKeyframeAnimation) this.f1189i).getFloatValue();
        RectF rectF2 = this.f1185e;
        float f = floatValue / 2.0f;
        rectF2.set(rectF2.left - f, this.f1185e.top - f, this.f1185e.right + f, this.f1185e.bottom + f);
        rectF.set(this.f1185e);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        C1429L.endSection("StrokeContent#getBounds");
    }

    /* renamed from: a */
    private void m1260a(Matrix matrix) {
        C1429L.beginSection("StrokeContent#applyDashPattern");
        if (this.f1191k.isEmpty()) {
            C1429L.endSection("StrokeContent#applyDashPattern");
            return;
        }
        float scale = Utils.getScale(matrix);
        for (int i = 0; i < this.f1191k.size(); i++) {
            this.f1188h[i] = ((Float) this.f1191k.get(i).getValue()).floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.f1188h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f1188h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.f1188h;
            fArr3[i] = fArr3[i] * scale;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f1192l;
        this.f1181a.setPathEffect(new DashPathEffect(this.f1188h, baseKeyframeAnimation == null ? 0.0f : scale * baseKeyframeAnimation.getValue().floatValue()));
        C1429L.endSection("StrokeContent#applyDashPattern");
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.OPACITY) {
            this.f1190j.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            this.f1189i.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1193m;
            if (baseKeyframeAnimation != null) {
                this.layer.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f1193m = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1193m = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.f1193m);
        }
    }

    private static final class PathGroup {
        /* access modifiers changed from: private */
        public final List<C1479b> paths;
        /* access modifiers changed from: private */
        public final TrimPathContent trimPath;

        private PathGroup(TrimPathContent trimPathContent) {
            this.paths = new ArrayList();
            this.trimPath = trimPathContent;
        }
    }
}
