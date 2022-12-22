package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.C1429L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class GradientFillContent implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a */
    private static final int f1225a = 32;

    /* renamed from: b */
    private final String f1226b;

    /* renamed from: c */
    private final boolean f1227c;

    /* renamed from: d */
    private final BaseLayer f1228d;

    /* renamed from: e */
    private final LongSparseArray<LinearGradient> f1229e = new LongSparseArray<>();

    /* renamed from: f */
    private final LongSparseArray<RadialGradient> f1230f = new LongSparseArray<>();

    /* renamed from: g */
    private final Path f1231g = new Path();

    /* renamed from: h */
    private final Paint f1232h = new LPaint(1);

    /* renamed from: i */
    private final RectF f1233i = new RectF();

    /* renamed from: j */
    private final List<C1479b> f1234j = new ArrayList();

    /* renamed from: k */
    private final GradientType f1235k;

    /* renamed from: l */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f1236l;

    /* renamed from: m */
    private final BaseKeyframeAnimation<Integer, Integer> f1237m;

    /* renamed from: n */
    private final BaseKeyframeAnimation<PointF, PointF> f1238n;

    /* renamed from: o */
    private final BaseKeyframeAnimation<PointF, PointF> f1239o;

    /* renamed from: p */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f1240p;

    /* renamed from: q */
    private ValueCallbackKeyframeAnimation f1241q;

    /* renamed from: r */
    private final LottieDrawable f1242r;

    /* renamed from: s */
    private final int f1243s;

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientFill gradientFill) {
        this.f1228d = baseLayer;
        this.f1226b = gradientFill.getName();
        this.f1227c = gradientFill.isHidden();
        this.f1242r = lottieDrawable;
        this.f1235k = gradientFill.getGradientType();
        this.f1231g.setFillType(gradientFill.getFillType());
        this.f1243s = (int) (lottieDrawable.getComposition().getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientFill.getGradientColor().createAnimation();
        this.f1236l = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.f1236l);
        BaseKeyframeAnimation<Integer, Integer> createAnimation2 = gradientFill.getOpacity().createAnimation();
        this.f1237m = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(this.f1237m);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientFill.getStartPoint().createAnimation();
        this.f1238n = createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(this.f1238n);
        BaseKeyframeAnimation<PointF, PointF> createAnimation4 = gradientFill.getEndPoint().createAnimation();
        this.f1239o = createAnimation4;
        createAnimation4.addUpdateListener(this);
        baseLayer.addAnimation(this.f1239o);
    }

    public void onValueChanged() {
        this.f1242r.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = list2.get(i);
            if (content instanceof C1479b) {
                this.f1234j.add((C1479b) content);
            }
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        if (!this.f1227c) {
            C1429L.beginSection("GradientFillContent#draw");
            this.f1231g.reset();
            for (int i2 = 0; i2 < this.f1234j.size(); i2++) {
                this.f1231g.addPath(this.f1234j.get(i2).getPath(), matrix);
            }
            this.f1231g.computeBounds(this.f1233i, false);
            if (this.f1235k == GradientType.LINEAR) {
                shader = m1268a();
            } else {
                shader = m1270b();
            }
            shader.setLocalMatrix(matrix);
            this.f1232h.setShader(shader);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1240p;
            if (baseKeyframeAnimation != null) {
                this.f1232h.setColorFilter(baseKeyframeAnimation.getValue());
            }
            this.f1232h.setAlpha(MiscUtils.clamp((int) ((((((float) i) / 255.0f) * ((float) this.f1237m.getValue().intValue())) / 100.0f) * 255.0f), 0, 255));
            canvas.drawPath(this.f1231g, this.f1232h);
            C1429L.endSection("GradientFillContent#draw");
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.f1231g.reset();
        for (int i = 0; i < this.f1234j.size(); i++) {
            this.f1231g.addPath(this.f1234j.get(i).getPath(), matrix);
        }
        this.f1231g.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public String getName() {
        return this.f1226b;
    }

    /* renamed from: a */
    private LinearGradient m1268a() {
        long c = (long) m1271c();
        LinearGradient linearGradient = this.f1229e.get(c);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF value = this.f1238n.getValue();
        PointF value2 = this.f1239o.getValue();
        GradientColor value3 = this.f1236l.getValue();
        LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, m1269a(value3.getColors()), value3.getPositions(), Shader.TileMode.CLAMP);
        this.f1229e.put(c, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: b */
    private RadialGradient m1270b() {
        long c = (long) m1271c();
        RadialGradient radialGradient = this.f1230f.get(c);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF value = this.f1238n.getValue();
        PointF value2 = this.f1239o.getValue();
        GradientColor value3 = this.f1236l.getValue();
        int[] a = m1269a(value3.getColors());
        float[] positions = value3.getPositions();
        float f = value.x;
        float f2 = value.y;
        float hypot = (float) Math.hypot((double) (value2.x - f), (double) (value2.y - f2));
        RadialGradient radialGradient2 = new RadialGradient(f, f2, hypot <= 0.0f ? 0.001f : hypot, a, positions, Shader.TileMode.CLAMP);
        this.f1230f.put(c, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: c */
    private int m1271c() {
        int round = Math.round(this.f1238n.getProgress() * ((float) this.f1243s));
        int round2 = Math.round(this.f1239o.getProgress() * ((float) this.f1243s));
        int round3 = Math.round(this.f1236l.getProgress() * ((float) this.f1243s));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    /* renamed from: a */
    private int[] m1269a(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f1241q;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.getValue();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.OPACITY) {
            this.f1237m.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f1240p;
            if (baseKeyframeAnimation != null) {
                this.f1228d.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f1240p = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1240p = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.f1228d.addAnimation(this.f1240p);
        } else if (t == LottieProperty.GRADIENT_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.f1241q;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.f1228d.removeAnimation(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.f1241q = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1241q = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            this.f1228d.addAnimation(this.f1241q);
        }
    }
}
