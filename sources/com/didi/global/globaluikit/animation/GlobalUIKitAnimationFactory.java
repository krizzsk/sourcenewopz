package com.didi.global.globaluikit.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import androidx.core.view.animation.PathInterpolatorCompat;

public class GlobalUIKitAnimationFactory {

    public enum InterpolatorType {
        EASY_OUT,
        EASY_IN,
        CUBIC_OUT,
        CUBIC_IN,
        CUBIC_BOTH
    }

    public static Animation getAnimation(Animation animation, InterpolatorType interpolatorType, Animation.AnimationListener animationListener) {
        animation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        animation.setAnimationListener(animationListener);
        return animation;
    }

    public static Animation getAnimation(Animation animation, InterpolatorType interpolatorType, boolean z, boolean z2, long j, int i, int i2, Animation.AnimationListener animationListener) {
        animation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        animation.setDuration(j);
        animation.setFillAfter(z);
        animation.setFillBefore(z2);
        animation.setRepeatMode(i);
        animation.setRepeatCount(i2);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    public static AlphaAnimation getAlphaAnimation(float f, float f2, InterpolatorType interpolatorType, boolean z, boolean z2, long j, int i, int i2, Animation.AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        alphaAnimation.setDuration(j);
        alphaAnimation.setFillAfter(z);
        alphaAnimation.setFillBefore(z2);
        alphaAnimation.setRepeatMode(i);
        alphaAnimation.setRepeatCount(i2);
        alphaAnimation.setAnimationListener(animationListener);
        return alphaAnimation;
    }

    public static ScaleAnimation getScaleAnimation(float f, float f2, float f3, float f4, InterpolatorType interpolatorType, boolean z, boolean z2, long j, int i, int i2, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f3, f4);
        scaleAnimation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        scaleAnimation.setDuration(j);
        scaleAnimation.setFillAfter(z);
        scaleAnimation.setFillBefore(z2);
        scaleAnimation.setRepeatMode(i);
        scaleAnimation.setRepeatCount(i2);
        scaleAnimation.setAnimationListener(animationListener);
        return scaleAnimation;
    }

    public static ScaleAnimation getScaleAnimation(float f, float f2, float f3, float f4, float f5, float f6, InterpolatorType interpolatorType, boolean z, boolean z2, long j, int i, int i2, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f3, f4, f5, f6);
        scaleAnimation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        scaleAnimation.setDuration(j);
        boolean z3 = z;
        scaleAnimation.setFillAfter(z);
        scaleAnimation.setFillBefore(z2);
        scaleAnimation.setRepeatMode(i);
        scaleAnimation.setRepeatCount(i2);
        scaleAnimation.setAnimationListener(animationListener);
        return scaleAnimation;
    }

    public static ScaleAnimation getScaleAnimation(float f, float f2, float f3, float f4, int i, float f5, int i2, float f6, InterpolatorType interpolatorType, boolean z, boolean z2, long j, int i3, int i4, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f3, f4, i, f5, i2, f6);
        scaleAnimation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        scaleAnimation.setDuration(j);
        scaleAnimation.setFillAfter(z);
        scaleAnimation.setFillBefore(z2);
        scaleAnimation.setRepeatMode(i3);
        scaleAnimation.setRepeatCount(i4);
        scaleAnimation.setAnimationListener(animationListener);
        return scaleAnimation;
    }

    public static TranslateAnimation getTranslateAnimation(float f, float f2, float f3, float f4, InterpolatorType interpolatorType, boolean z, boolean z2, long j, int i, int i2, Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(f, f2, f3, f4);
        translateAnimation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(z);
        translateAnimation.setFillBefore(z2);
        translateAnimation.setRepeatMode(i);
        translateAnimation.setRepeatCount(i2);
        translateAnimation.setAnimationListener(animationListener);
        return translateAnimation;
    }

    public static TranslateAnimation getTranslateAnimation(int i, float f, int i2, float f2, int i3, float f3, int i4, float f4, InterpolatorType interpolatorType, boolean z, boolean z2, long j, int i5, int i6, Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(i, f, i2, f2, i3, f3, i4, f4);
        translateAnimation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(z);
        translateAnimation.setFillBefore(z2);
        translateAnimation.setRepeatMode(i5);
        translateAnimation.setRepeatCount(i6);
        translateAnimation.setAnimationListener(animationListener);
        return translateAnimation;
    }

    public static RotateAnimation getRotateAnimation(float f, float f2, InterpolatorType interpolatorType, boolean z, boolean z2, long j, int i, int i2, Animation.AnimationListener animationListener) {
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2);
        rotateAnimation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        rotateAnimation.setDuration(j);
        rotateAnimation.setFillAfter(z);
        rotateAnimation.setFillBefore(z2);
        rotateAnimation.setRepeatMode(i);
        rotateAnimation.setRepeatCount(i2);
        rotateAnimation.setAnimationListener(animationListener);
        return rotateAnimation;
    }

    public static RotateAnimation getRotateAnimation(float f, float f2, float f3, float f4, InterpolatorType interpolatorType, boolean z, boolean z2, long j, int i, int i2, Animation.AnimationListener animationListener) {
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, f3, f4);
        rotateAnimation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        rotateAnimation.setDuration(j);
        rotateAnimation.setFillAfter(z);
        rotateAnimation.setFillBefore(z2);
        rotateAnimation.setRepeatMode(i);
        rotateAnimation.setRepeatCount(i2);
        rotateAnimation.setAnimationListener(animationListener);
        return rotateAnimation;
    }

    public static RotateAnimation getRotateAnimation(float f, float f2, int i, float f3, int i2, float f4, InterpolatorType interpolatorType, boolean z, boolean z2, long j, int i3, int i4, Animation.AnimationListener animationListener) {
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, i, f3, i2, f4);
        rotateAnimation.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        rotateAnimation.setDuration(j);
        boolean z3 = z;
        rotateAnimation.setFillAfter(z);
        rotateAnimation.setFillBefore(z2);
        rotateAnimation.setRepeatMode(i3);
        rotateAnimation.setRepeatCount(i4);
        rotateAnimation.setAnimationListener(animationListener);
        return rotateAnimation;
    }

    public static AnimationSet getAnimationSet(InterpolatorType interpolatorType, boolean z, Animation.AnimationListener animationListener, Animation... animationArr) {
        AnimationSet animationSet = new AnimationSet(z);
        animationSet.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        animationSet.setAnimationListener(animationListener);
        if (animationArr != null && animationArr.length > 0) {
            for (Animation addAnimation : animationArr) {
                animationSet.addAnimation(addAnimation);
            }
        }
        return animationSet;
    }

    public static ObjectAnimator getObjectAnimator(ObjectAnimator objectAnimator, InterpolatorType interpolatorType, long j, Animator.AnimatorListener animatorListener) {
        objectAnimator.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        objectAnimator.setDuration(j);
        objectAnimator.addListener(animatorListener);
        return objectAnimator;
    }

    public static ValueAnimator getValueAnimator(ValueAnimator valueAnimator, InterpolatorType interpolatorType, long j, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        valueAnimator.setInterpolator(GlobalUIKitInterpolatorFactory.getInterpolator(interpolatorType));
        valueAnimator.setDuration(j);
        valueAnimator.addUpdateListener(animatorUpdateListener);
        return valueAnimator;
    }

    /* renamed from: com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$1 */
    static /* synthetic */ class C86231 {

        /* renamed from: $SwitchMap$com$didi$global$globaluikit$animation$GlobalUIKitAnimationFactory$InterpolatorType */
        static final /* synthetic */ int[] f22346x2a8a98cf;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType[] r0 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22346x2a8a98cf = r0
                com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType r1 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22346x2a8a98cf     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType r1 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.EASY_IN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22346x2a8a98cf     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType r1 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.CUBIC_OUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22346x2a8a98cf     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType r1 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.CUBIC_IN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22346x2a8a98cf     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType r1 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.CUBIC_BOTH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.C86231.<clinit>():void");
        }
    }

    public static class GlobalUIKitInterpolatorFactory {
        public static Interpolator getInterpolator(InterpolatorType interpolatorType) {
            int i = C86231.f22346x2a8a98cf[interpolatorType.ordinal()];
            if (i == 1) {
                return PathInterpolatorCompat.create(0.3f, 0.2f, 0.1f, 1.0f);
            }
            if (i == 2) {
                return PathInterpolatorCompat.create(0.9f, 0.0f, 0.7f, 0.8f);
            }
            if (i == 3) {
                return PathInterpolatorCompat.create(0.28f, 0.96f, 0.3f, 1.0f);
            }
            if (i == 4) {
                return PathInterpolatorCompat.create(0.7f, 0.0f, 0.72f, 0.04f);
            }
            if (i != 5) {
                return null;
            }
            return PathInterpolatorCompat.create(0.7f, 0.0f, 0.3f, 1.0f);
        }
    }
}
