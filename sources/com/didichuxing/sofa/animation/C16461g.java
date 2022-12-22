package com.didichuxing.sofa.animation;

import android.animation.ValueAnimator;

/* renamed from: com.didichuxing.sofa.animation.g */
/* compiled from: AnimatorUpdateListenerWrapper */
class C16461g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    private Animator f49101a;

    /* renamed from: b */
    private AnimatorUpdateListener f49102b;

    C16461g(Animator animator, AnimatorUpdateListener animatorUpdateListener) {
        this.f49101a = animator;
        this.f49102b = animatorUpdateListener;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        AnimatorUpdateListener animatorUpdateListener = this.f49102b;
        if (animatorUpdateListener != null) {
            animatorUpdateListener.onAnimationUpdate(this.f49101a, valueAnimator.getAnimatedValue());
        }
    }
}
