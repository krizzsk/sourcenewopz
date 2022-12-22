package com.didi.hawaii.mapsdkv2.adapter.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.hawaii.mapsdkv2.common.evaluator.LatLngEvaluator;
import com.didi.hawaii.mapsdkv2.common.evaluator.PointFEvaluator;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.animation.AlphaAnimation;
import com.didi.map.outer.model.animation.Animation;
import com.didi.map.outer.model.animation.AnimationSet;
import com.didi.map.outer.model.animation.RotateAnimation;
import com.didi.map.outer.model.animation.ScaleAnimation;
import com.didi.map.outer.model.animation.TranslateAnimation;
import com.didi.soda.customer.blocks.BlocksConst;

public final class GLViewAnimationFactory {

    /* renamed from: a */
    private static Interpolator f23759a = new LinearInterpolator();

    /* renamed from: b */
    private static final long f23760b = 1500;

    private GLViewAnimationFactory() {
    }

    public static Animator convertToAnimator(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return m16902e(animation);
        }
        if (animation instanceof RotateAnimation) {
            return m16901d(animation);
        }
        if (animation instanceof ScaleAnimation) {
            return m16900c(animation);
        }
        if (animation instanceof TranslateAnimation) {
            return m16899b(animation);
        }
        if (animation instanceof AnimationSet) {
            return m16897a(animation);
        }
        return null;
    }

    /* renamed from: a */
    private static Animator m16897a(Animation animation) {
        AnimationSet animationSet = (AnimationSet) animation;
        long duration = animationSet.getDuration();
        boolean isShareInterpolator = animationSet.isShareInterpolator();
        Interpolator interpolator = animationSet.getInterpolator();
        AnimatorSet animatorSet = new AnimatorSet();
        if (duration <= 0) {
            duration = 1500;
        }
        animatorSet.setDuration(duration);
        if (isShareInterpolator) {
            if (interpolator == null) {
                interpolator = f23759a;
            }
            animatorSet.setInterpolator(interpolator);
        }
        for (Animation convertToAnimator : animationSet.getAnimationList()) {
            Animator convertToAnimator2 = convertToAnimator(convertToAnimator);
            if (isShareInterpolator) {
                convertToAnimator2.setInterpolator((TimeInterpolator) null);
            }
            animatorSet.play(convertToAnimator2);
        }
        return animatorSet;
    }

    /* renamed from: b */
    private static Animator m16899b(Animation animation) {
        TranslateAnimation translateAnimation = (TranslateAnimation) animation;
        return createTranslateAnimator(translateAnimation.getLatLngFrom(), translateAnimation.getLatLngTo(), animation.getDuration(), animation.getInterpolator());
    }

    /* renamed from: c */
    private static Animator m16900c(Animation animation) {
        ScaleAnimation scaleAnimation = (ScaleAnimation) animation;
        return createScaleAnimator(scaleAnimation.getFromX(), scaleAnimation.getToX(), scaleAnimation.getFromY(), scaleAnimation.getToY(), animation.getDuration(), animation.getInterpolator());
    }

    /* renamed from: d */
    private static Animator m16901d(Animation animation) {
        RotateAnimation rotateAnimation = (RotateAnimation) animation;
        return createRotateAnimator(rotateAnimation.getFromAngle(), rotateAnimation.getToAngle(), animation.getDuration(), animation.getInterpolator());
    }

    /* renamed from: e */
    private static Animator m16902e(Animation animation) {
        AlphaAnimation alphaAnimation = (AlphaAnimation) animation;
        return createAlphaAnimator(alphaAnimation.getFromAlpha(), alphaAnimation.getToAlpha(), animation.getDuration(), animation.getInterpolator());
    }

    public static Animator createAlphaAnimator(float f, float f2, long j) {
        return createFloatValuesAnimator("alpha", f, f2, j, f23759a);
    }

    public static Animator createAlphaAnimator(float f, float f2, long j, Interpolator interpolator) {
        return createFloatValuesAnimator("alpha", f, f2, j, interpolator);
    }

    public static Animator createRotateAnimator(float f, float f2, long j) {
        return createFloatValuesAnimator(BlocksConst.WIDGET_PARAMS_ANGLE, f, f2, j, f23759a);
    }

    public static Animator createRotateAnimator(float f, float f2, long j, Interpolator interpolator) {
        return createFloatValuesAnimator(BlocksConst.WIDGET_PARAMS_ANGLE, f, f2, j, interpolator);
    }

    public static Animator createScaleAnimator(float f, float f2, float f3, float f4, long j) {
        return createScaleAnimator(NNGestureClassfy.SCALE_LABLE, f, f2, f3, f4, j, f23759a);
    }

    public static Animator createScaleAnimator(float f, float f2, float f3, float f4, long j, Interpolator interpolator) {
        return createScaleAnimator(NNGestureClassfy.SCALE_LABLE, f, f2, f3, f4, j, interpolator);
    }

    public static Animator createScaleAnimator(String str, float f, float f2, float f3, float f4, long j, Interpolator interpolator) {
        ObjectAnimator a = m16898a(str, j, interpolator);
        a.setObjectValues(new Object[]{new PointF(f, f3), new PointF(f2, f4)});
        a.setEvaluator(new PointFEvaluator());
        return a;
    }

    public static Animator createTranslateAnimator(LatLng latLng, LatLng latLng2, long j) {
        return createTranslateAnimator("position", latLng, latLng2, j, f23759a);
    }

    public static Animator createTranslateAnimator(LatLng latLng, LatLng latLng2, long j, Interpolator interpolator) {
        return createTranslateAnimator("position", latLng, latLng2, j, interpolator);
    }

    public static Animator createTranslateAnimator(String str, LatLng latLng, LatLng latLng2, long j, Interpolator interpolator) {
        ObjectAnimator a = m16898a(str, j, interpolator);
        a.setObjectValues(new Object[]{latLng, latLng2});
        a.setEvaluator(new LatLngEvaluator());
        return a;
    }

    /* renamed from: a */
    private static ObjectAnimator m16898a(String str, long j, Interpolator interpolator) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setInterpolator(interpolator);
        if (j <= 0) {
            j = 1500;
        }
        objectAnimator.setDuration(j);
        objectAnimator.setPropertyName(str);
        return objectAnimator;
    }

    public static Animator createFloatValuesAnimator(String str, float f, float f2, long j, Interpolator interpolator) {
        ObjectAnimator a = m16898a(str, j, interpolator);
        a.setFloatValues(new float[]{f, f2});
        return a;
    }
}
