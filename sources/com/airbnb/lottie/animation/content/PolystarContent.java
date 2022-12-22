package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PolystarContent implements KeyPathElementContent, C1479b, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a */
    private static final float f1263a = 0.47829f;

    /* renamed from: b */
    private static final float f1264b = 0.25f;

    /* renamed from: c */
    private final Path f1265c = new Path();

    /* renamed from: d */
    private final String f1266d;

    /* renamed from: e */
    private final LottieDrawable f1267e;

    /* renamed from: f */
    private final PolystarShape.Type f1268f;

    /* renamed from: g */
    private final boolean f1269g;

    /* renamed from: h */
    private final BaseKeyframeAnimation<?, Float> f1270h;

    /* renamed from: i */
    private final BaseKeyframeAnimation<?, PointF> f1271i;

    /* renamed from: j */
    private final BaseKeyframeAnimation<?, Float> f1272j;

    /* renamed from: k */
    private final BaseKeyframeAnimation<?, Float> f1273k;

    /* renamed from: l */
    private final BaseKeyframeAnimation<?, Float> f1274l;

    /* renamed from: m */
    private final BaseKeyframeAnimation<?, Float> f1275m;

    /* renamed from: n */
    private final BaseKeyframeAnimation<?, Float> f1276n;

    /* renamed from: o */
    private CompoundTrimPathContent f1277o = new CompoundTrimPathContent();

    /* renamed from: p */
    private boolean f1278p;

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.f1267e = lottieDrawable;
        this.f1266d = polystarShape.getName();
        this.f1268f = polystarShape.getType();
        this.f1269g = polystarShape.isHidden();
        this.f1270h = polystarShape.getPoints().createAnimation();
        this.f1271i = polystarShape.getPosition().createAnimation();
        this.f1272j = polystarShape.getRotation().createAnimation();
        this.f1274l = polystarShape.getOuterRadius().createAnimation();
        this.f1276n = polystarShape.getOuterRoundedness().createAnimation();
        if (this.f1268f == PolystarShape.Type.STAR) {
            this.f1273k = polystarShape.getInnerRadius().createAnimation();
            this.f1275m = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.f1273k = null;
            this.f1275m = null;
        }
        baseLayer.addAnimation(this.f1270h);
        baseLayer.addAnimation(this.f1271i);
        baseLayer.addAnimation(this.f1272j);
        baseLayer.addAnimation(this.f1274l);
        baseLayer.addAnimation(this.f1276n);
        if (this.f1268f == PolystarShape.Type.STAR) {
            baseLayer.addAnimation(this.f1273k);
            baseLayer.addAnimation(this.f1275m);
        }
        this.f1270h.addUpdateListener(this);
        this.f1271i.addUpdateListener(this);
        this.f1272j.addUpdateListener(this);
        this.f1274l.addUpdateListener(this);
        this.f1276n.addUpdateListener(this);
        if (this.f1268f == PolystarShape.Type.STAR) {
            this.f1273k.addUpdateListener(this);
            this.f1275m.addUpdateListener(this);
        }
    }

    public void onValueChanged() {
        m1278a();
    }

    /* renamed from: a */
    private void m1278a() {
        this.f1278p = false;
        this.f1267e.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.mo15218a() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f1277o.mo15211a(trimPathContent);
                    trimPathContent.mo15219a(this);
                }
            }
        }
    }

    public Path getPath() {
        if (this.f1278p) {
            return this.f1265c;
        }
        this.f1265c.reset();
        if (this.f1269g) {
            this.f1278p = true;
            return this.f1265c;
        }
        int i = C14771.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.f1268f.ordinal()];
        if (i == 1) {
            m1279b();
        } else if (i == 2) {
            m1280c();
        }
        this.f1265c.close();
        this.f1277o.apply(this.f1265c);
        this.f1278p = true;
        return this.f1265c;
    }

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1 */
    static /* synthetic */ class C14771 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.content.PolystarShape$Type[] r0 = com.airbnb.lottie.model.content.PolystarShape.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = r0
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.STAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.POLYGON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.PolystarContent.C14771.<clinit>():void");
        }
    }

    public String getName() {
        return this.f1266d;
    }

    /* renamed from: b */
    private void m1279b() {
        double d;
        int i;
        float f;
        float f2;
        float f3;
        double d2;
        float f4;
        float f5;
        double d3;
        float f6;
        float f7;
        float f8;
        float f9;
        float floatValue = this.f1270h.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f1272j;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.getValue().floatValue()) - 90.0d);
        double d4 = (double) floatValue;
        float f10 = (float) (6.283185307179586d / d4);
        float f11 = f10 / 2.0f;
        float f12 = floatValue - ((float) ((int) floatValue));
        int i2 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (double) ((1.0f - f12) * f11);
        }
        float floatValue2 = this.f1274l.getValue().floatValue();
        float floatValue3 = this.f1273k.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f1275m;
        float floatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f1276n;
        float floatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.getValue().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f = ((floatValue2 - floatValue3) * f12) + floatValue3;
            i = i2;
            double d5 = (double) f;
            d = d4;
            f3 = (float) (d5 * Math.cos(radians));
            f2 = (float) (d5 * Math.sin(radians));
            this.f1265c.moveTo(f3, f2);
            d2 = radians + ((double) ((f10 * f12) / 2.0f));
        } else {
            d = d4;
            i = i2;
            double d6 = (double) floatValue2;
            float cos = (float) (Math.cos(radians) * d6);
            float sin = (float) (d6 * Math.sin(radians));
            this.f1265c.moveTo(cos, sin);
            d2 = radians + ((double) f11);
            f3 = cos;
            f2 = sin;
            f = 0.0f;
        }
        double ceil = Math.ceil(d) * 2.0d;
        float f13 = floatValue2;
        float f14 = floatValue3;
        int i3 = 0;
        boolean z = false;
        while (true) {
            double d7 = (double) i3;
            if (d7 < ceil) {
                float f15 = z ? f13 : f14;
                int i4 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i4 == 0 || d7 != ceil - 2.0d) {
                    f4 = f10;
                    f5 = f11;
                } else {
                    f4 = f10;
                    f5 = (f10 * f12) / 2.0f;
                }
                if (i4 == 0 || d7 != ceil - 1.0d) {
                    f6 = f11;
                    d3 = d7;
                    f7 = f15;
                } else {
                    f6 = f11;
                    d3 = d7;
                    f7 = f;
                }
                double d8 = (double) f7;
                double d9 = ceil;
                float cos2 = (float) (d8 * Math.cos(d2));
                float sin2 = (float) (d8 * Math.sin(d2));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.f1265c.lineTo(cos2, sin2);
                    f9 = floatValue4;
                    f8 = f;
                } else {
                    f9 = floatValue4;
                    f8 = f;
                    double atan2 = (double) ((float) (Math.atan2((double) f2, (double) f3) - 1.5707963267948966d));
                    float sin3 = (float) Math.sin(atan2);
                    float cos3 = (float) Math.cos(atan2);
                    double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f16 = z ? f9 : floatValue5;
                    float f17 = z ? floatValue5 : f9;
                    float f18 = z ? f14 : f13;
                    float f19 = z ? f13 : f14;
                    float f20 = f18 * f16 * f1263a;
                    float f21 = cos3 * f20;
                    float f22 = f20 * sin3;
                    float f23 = f19 * f17 * f1263a;
                    float f24 = cos4 * f23;
                    float f25 = f23 * sin4;
                    if (i != 0) {
                        if (i3 == 0) {
                            f21 *= f12;
                            f22 *= f12;
                        } else if (d3 == d9 - 1.0d) {
                            f24 *= f12;
                            f25 *= f12;
                        }
                    }
                    this.f1265c.cubicTo(f3 - f21, f2 - f22, cos2 + f24, sin2 + f25, cos2, sin2);
                }
                d2 += (double) f5;
                z = !z;
                i3++;
                f3 = cos2;
                f2 = sin2;
                floatValue4 = f9;
                f = f8;
                f11 = f6;
                f10 = f4;
                ceil = d9;
            } else {
                PointF value = this.f1271i.getValue();
                this.f1265c.offset(value.x, value.y);
                this.f1265c.close();
                return;
            }
        }
    }

    /* renamed from: c */
    private void m1280c() {
        double d;
        double d2;
        double d3;
        int i;
        int floor = (int) Math.floor((double) this.f1270h.getValue().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f1272j;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.getValue().floatValue()) - 90.0d);
        double d4 = (double) floor;
        float floatValue = this.f1276n.getValue().floatValue() / 100.0f;
        float floatValue2 = this.f1274l.getValue().floatValue();
        double d5 = (double) floatValue2;
        float cos = (float) (Math.cos(radians) * d5);
        float sin = (float) (Math.sin(radians) * d5);
        this.f1265c.moveTo(cos, sin);
        double d6 = (double) ((float) (6.283185307179586d / d4));
        double d7 = radians + d6;
        double ceil = Math.ceil(d4);
        int i2 = 0;
        while (((double) i2) < ceil) {
            float cos2 = (float) (Math.cos(d7) * d5);
            double d8 = ceil;
            float sin2 = (float) (d5 * Math.sin(d7));
            if (floatValue != 0.0f) {
                d3 = d5;
                i = i2;
                d2 = d7;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                float cos3 = (float) Math.cos(atan2);
                d = d6;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f = floatValue2 * floatValue * f1264b;
                this.f1265c.cubicTo(cos - (cos3 * f), sin - (((float) Math.sin(atan2)) * f), cos2 + (((float) Math.cos(atan22)) * f), sin2 + (f * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d2 = d7;
                d3 = d5;
                d = d6;
                i = i2;
                this.f1265c.lineTo(cos2, sin2);
            }
            d7 = d2 + d;
            i2 = i + 1;
            sin = sin2;
            cos = cos2;
            ceil = d8;
            d5 = d3;
            d6 = d;
        }
        PointF value = this.f1271i.getValue();
        this.f1265c.offset(value.x, value.y);
        this.f1265c.close();
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            this.f1270h.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_ROTATION) {
            this.f1272j.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POSITION) {
            this.f1271i.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.f1273k) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.f1274l.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.f1275m) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.f1276n.setValueCallback(lottieValueCallback);
        }
    }
}
