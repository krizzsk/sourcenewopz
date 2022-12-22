package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

public class GradientStrokeContent extends BaseStrokeContent {

    /* renamed from: b */
    private static final int f1244b = 32;

    /* renamed from: c */
    private final String f1245c;

    /* renamed from: d */
    private final boolean f1246d;

    /* renamed from: e */
    private final LongSparseArray<LinearGradient> f1247e = new LongSparseArray<>();

    /* renamed from: f */
    private final LongSparseArray<RadialGradient> f1248f = new LongSparseArray<>();

    /* renamed from: g */
    private final RectF f1249g = new RectF();

    /* renamed from: h */
    private final GradientType f1250h;

    /* renamed from: i */
    private final int f1251i;

    /* renamed from: j */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f1252j;

    /* renamed from: k */
    private final BaseKeyframeAnimation<PointF, PointF> f1253k;

    /* renamed from: l */
    private final BaseKeyframeAnimation<PointF, PointF> f1254l;

    /* renamed from: m */
    private ValueCallbackKeyframeAnimation f1255m;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.getCapType().toPaintCap(), gradientStroke.getJoinType().toPaintJoin(), gradientStroke.getMiterLimit(), gradientStroke.getOpacity(), gradientStroke.getWidth(), gradientStroke.getLineDashPattern(), gradientStroke.getDashOffset());
        this.f1245c = gradientStroke.getName();
        this.f1250h = gradientStroke.getGradientType();
        this.f1246d = gradientStroke.isHidden();
        this.f1251i = (int) (lottieDrawable.getComposition().getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientStroke.getGradientColor().createAnimation();
        this.f1252j = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(this.f1252j);
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = gradientStroke.getStartPoint().createAnimation();
        this.f1253k = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(this.f1253k);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientStroke.getEndPoint().createAnimation();
        this.f1254l = createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(this.f1254l);
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        if (!this.f1246d) {
            getBounds(this.f1249g, matrix, false);
            if (this.f1250h == GradientType.LINEAR) {
                shader = m1272a();
            } else {
                shader = m1274b();
            }
            shader.setLocalMatrix(matrix);
            this.f1181a.setShader(shader);
            super.draw(canvas, matrix, i);
        }
    }

    public String getName() {
        return this.f1245c;
    }

    /* renamed from: a */
    private LinearGradient m1272a() {
        long c = (long) m1275c();
        LinearGradient linearGradient = this.f1247e.get(c);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF value = this.f1253k.getValue();
        PointF value2 = this.f1254l.getValue();
        GradientColor value3 = this.f1252j.getValue();
        LinearGradient linearGradient2 = new LinearGradient(value.x, value.y, value2.x, value2.y, m1273a(value3.getColors()), value3.getPositions(), Shader.TileMode.CLAMP);
        this.f1247e.put(c, linearGradient2);
        return linearGradient2;
    }

    /* renamed from: b */
    private RadialGradient m1274b() {
        long c = (long) m1275c();
        RadialGradient radialGradient = this.f1248f.get(c);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF value = this.f1253k.getValue();
        PointF value2 = this.f1254l.getValue();
        GradientColor value3 = this.f1252j.getValue();
        int[] a = m1273a(value3.getColors());
        float[] positions = value3.getPositions();
        float f = value.x;
        float f2 = value.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot((double) (value2.x - f), (double) (value2.y - f2)), a, positions, Shader.TileMode.CLAMP);
        this.f1248f.put(c, radialGradient2);
        return radialGradient2;
    }

    /* renamed from: c */
    private int m1275c() {
        int round = Math.round(this.f1253k.getProgress() * ((float) this.f1251i));
        int round2 = Math.round(this.f1254l.getProgress() * ((float) this.f1251i));
        int round3 = Math.round(this.f1252j.getProgress() * ((float) this.f1251i));
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    /* renamed from: a */
    private int[] m1273a(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f1255m;
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

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.GRADIENT_COLOR) {
            if (this.f1255m != null) {
                this.layer.removeAnimation(this.f1255m);
            }
            if (lottieValueCallback == null) {
                this.f1255m = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f1255m = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.f1255m);
        }
    }
}
