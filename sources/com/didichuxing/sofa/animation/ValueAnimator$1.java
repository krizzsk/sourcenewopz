package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

class ValueAnimator$1 extends AnimatorListenerAdapter {
    final /* synthetic */ C16475v this$0;
    final /* synthetic */ ValueAnimator val$valueAnimator;

    ValueAnimator$1(C16475v vVar, ValueAnimator valueAnimator) {
        this.this$0 = vVar;
        this.val$valueAnimator = valueAnimator;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.val$valueAnimator.removeAllUpdateListeners();
        animator.removeListener(this);
    }
}
