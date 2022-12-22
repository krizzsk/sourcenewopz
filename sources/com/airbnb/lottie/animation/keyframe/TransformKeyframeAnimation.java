package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

public class TransformKeyframeAnimation {

    /* renamed from: a */
    private final Matrix f1341a = new Matrix();

    /* renamed from: b */
    private final Matrix f1342b;

    /* renamed from: c */
    private final Matrix f1343c;

    /* renamed from: d */
    private final Matrix f1344d;

    /* renamed from: e */
    private final float[] f1345e;

    /* renamed from: f */
    private BaseKeyframeAnimation<PointF, PointF> f1346f;

    /* renamed from: g */
    private BaseKeyframeAnimation<?, PointF> f1347g;

    /* renamed from: h */
    private BaseKeyframeAnimation<ScaleXY, ScaleXY> f1348h;

    /* renamed from: i */
    private BaseKeyframeAnimation<Float, Float> f1349i;

    /* renamed from: j */
    private BaseKeyframeAnimation<Integer, Integer> f1350j;

    /* renamed from: k */
    private FloatKeyframeAnimation f1351k;

    /* renamed from: l */
    private FloatKeyframeAnimation f1352l;

    /* renamed from: m */
    private BaseKeyframeAnimation<?, Float> f1353m;

    /* renamed from: n */
    private BaseKeyframeAnimation<?, Float> f1354n;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        this.f1346f = animatableTransform.getAnchorPoint() == null ? null : animatableTransform.getAnchorPoint().createAnimation();
        this.f1347g = animatableTransform.getPosition() == null ? null : animatableTransform.getPosition().createAnimation();
        this.f1348h = animatableTransform.getScale() == null ? null : animatableTransform.getScale().createAnimation();
        this.f1349i = animatableTransform.getRotation() == null ? null : animatableTransform.getRotation().createAnimation();
        FloatKeyframeAnimation floatKeyframeAnimation = animatableTransform.getSkew() == null ? null : (FloatKeyframeAnimation) animatableTransform.getSkew().createAnimation();
        this.f1351k = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.f1342b = new Matrix();
            this.f1343c = new Matrix();
            this.f1344d = new Matrix();
            this.f1345e = new float[9];
        } else {
            this.f1342b = null;
            this.f1343c = null;
            this.f1344d = null;
            this.f1345e = null;
        }
        this.f1352l = animatableTransform.getSkewAngle() == null ? null : (FloatKeyframeAnimation) animatableTransform.getSkewAngle().createAnimation();
        if (animatableTransform.getOpacity() != null) {
            this.f1350j = animatableTransform.getOpacity().createAnimation();
        }
        if (animatableTransform.getStartOpacity() != null) {
            this.f1353m = animatableTransform.getStartOpacity().createAnimation();
        } else {
            this.f1353m = null;
        }
        if (animatableTransform.getEndOpacity() != null) {
            this.f1354n = animatableTransform.getEndOpacity().createAnimation();
        } else {
            this.f1354n = null;
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        baseLayer.addAnimation(this.f1350j);
        baseLayer.addAnimation(this.f1353m);
        baseLayer.addAnimation(this.f1354n);
        baseLayer.addAnimation(this.f1346f);
        baseLayer.addAnimation(this.f1347g);
        baseLayer.addAnimation(this.f1348h);
        baseLayer.addAnimation(this.f1349i);
        baseLayer.addAnimation(this.f1351k);
        baseLayer.addAnimation(this.f1352l);
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f1350j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f1353m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f1354n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f1346f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f1347g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.f1348h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f1349i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f1351k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f1352l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.addUpdateListener(animationListener);
        }
    }

    public void setProgress(float f) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f1350j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.setProgress(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f1353m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.setProgress(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f1354n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.setProgress(f);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f1346f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.setProgress(f);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f1347g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.setProgress(f);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.f1348h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.setProgress(f);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f1349i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f1351k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f1352l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.setProgress(f);
        }
    }

    public BaseKeyframeAnimation<?, Integer> getOpacity() {
        return this.f1350j;
    }

    public BaseKeyframeAnimation<?, Float> getStartOpacity() {
        return this.f1353m;
    }

    public BaseKeyframeAnimation<?, Float> getEndOpacity() {
        return this.f1354n;
    }

    public Matrix getMatrix() {
        float f;
        this.f1341a.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f1347g;
        if (baseKeyframeAnimation != null) {
            PointF value = baseKeyframeAnimation.getValue();
            if (!(value.x == 0.0f && value.y == 0.0f)) {
                this.f1341a.preTranslate(value.x, value.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f1349i;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation) {
                f = baseKeyframeAnimation2.getValue().floatValue();
            } else {
                f = ((FloatKeyframeAnimation) baseKeyframeAnimation2).getFloatValue();
            }
            if (f != 0.0f) {
                this.f1341a.preRotate(f);
            }
        }
        if (this.f1351k != null) {
            FloatKeyframeAnimation floatKeyframeAnimation = this.f1352l;
            float cos = floatKeyframeAnimation == null ? 0.0f : (float) Math.cos(Math.toRadians((double) ((-floatKeyframeAnimation.getFloatValue()) + 90.0f)));
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.f1352l;
            float sin = floatKeyframeAnimation2 == null ? 1.0f : (float) Math.sin(Math.toRadians((double) ((-floatKeyframeAnimation2.getFloatValue()) + 90.0f)));
            m1298a();
            float[] fArr = this.f1345e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f1342b.setValues(fArr);
            m1298a();
            float[] fArr2 = this.f1345e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians((double) this.f1351k.getFloatValue()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f1343c.setValues(fArr2);
            m1298a();
            float[] fArr3 = this.f1345e;
            fArr3[0] = cos;
            fArr3[1] = f2;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f1344d.setValues(fArr3);
            this.f1343c.preConcat(this.f1342b);
            this.f1344d.preConcat(this.f1343c);
            this.f1341a.preConcat(this.f1344d);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.f1348h;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY value2 = baseKeyframeAnimation3.getValue();
            if (!(value2.getScaleX() == 1.0f && value2.getScaleY() == 1.0f)) {
                this.f1341a.preScale(value2.getScaleX(), value2.getScaleY());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f1346f;
        if (baseKeyframeAnimation4 != null) {
            PointF value3 = baseKeyframeAnimation4.getValue();
            if (!(value3.x == 0.0f && value3.y == 0.0f)) {
                this.f1341a.preTranslate(-value3.x, -value3.y);
            }
        }
        return this.f1341a;
    }

    /* renamed from: a */
    private void m1298a() {
        for (int i = 0; i < 9; i++) {
            this.f1345e[i] = 0.0f;
        }
    }

    public Matrix getMatrixForRepeater(float f) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f1347g;
        PointF pointF = null;
        PointF value = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.getValue();
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.f1348h;
        ScaleXY value2 = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.getValue();
        this.f1341a.reset();
        if (value != null) {
            this.f1341a.preTranslate(value.x * f, value.y * f);
        }
        if (value2 != null) {
            double d = (double) f;
            this.f1341a.preScale((float) Math.pow((double) value2.getScaleX(), d), (float) Math.pow((double) value2.getScaleY(), d));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f1349i;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.getValue().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f1346f;
            if (baseKeyframeAnimation4 != null) {
                pointF = baseKeyframeAnimation4.getValue();
            }
            Matrix matrix = this.f1341a;
            float f2 = floatValue * f;
            float f3 = 0.0f;
            float f4 = pointF == null ? 0.0f : pointF.x;
            if (pointF != null) {
                f3 = pointF.y;
            }
            matrix.preRotate(f2, f4, f3);
        }
        return this.f1341a;
    }

    public <T> boolean applyValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.f1346f;
            if (baseKeyframeAnimation3 == null) {
                this.f1346f = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation3.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_POSITION) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.f1347g;
            if (baseKeyframeAnimation4 == null) {
                this.f1347g = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation4.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_SCALE) {
            BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.f1348h;
            if (baseKeyframeAnimation5 == null) {
                this.f1348h = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                return true;
            }
            baseKeyframeAnimation5.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_ROTATION) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.f1349i;
            if (baseKeyframeAnimation6 == null) {
                this.f1349i = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                return true;
            }
            baseKeyframeAnimation6.setValueCallback(lottieValueCallback);
            return true;
        } else if (t == LottieProperty.TRANSFORM_OPACITY) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.f1350j;
            if (baseKeyframeAnimation7 == null) {
                this.f1350j = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation7.setValueCallback(lottieValueCallback);
            return true;
        } else if (t != LottieProperty.TRANSFORM_START_OPACITY || (baseKeyframeAnimation2 = this.f1353m) == null) {
            if (t != LottieProperty.TRANSFORM_END_OPACITY || (baseKeyframeAnimation = this.f1354n) == null) {
                if (t == LottieProperty.TRANSFORM_SKEW && (floatKeyframeAnimation2 = this.f1351k) != null) {
                    if (floatKeyframeAnimation2 == null) {
                        this.f1351k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                    }
                    this.f1351k.setValueCallback(lottieValueCallback);
                    return true;
                } else if (t != LottieProperty.TRANSFORM_SKEW_ANGLE || (floatKeyframeAnimation = this.f1352l) == null) {
                    return false;
                } else {
                    if (floatKeyframeAnimation == null) {
                        this.f1352l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                    }
                    this.f1352l.setValueCallback(lottieValueCallback);
                    return true;
                }
            } else if (baseKeyframeAnimation == null) {
                this.f1354n = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            } else {
                baseKeyframeAnimation.setValueCallback(lottieValueCallback);
                return true;
            }
        } else if (baseKeyframeAnimation2 == null) {
            this.f1353m = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
            return true;
        } else {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return true;
        }
    }
}
