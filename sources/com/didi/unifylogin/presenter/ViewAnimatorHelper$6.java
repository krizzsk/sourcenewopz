package com.didi.unifylogin.presenter;

import android.animation.ValueAnimator;

class ViewAnimatorHelper$6 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C14638a this$0;

    ViewAnimatorHelper$6(C14638a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.m32172a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
