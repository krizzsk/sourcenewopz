package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: com.didichuxing.sofa.animation.f */
/* compiled from: AnimatorSetListenerWrapper */
class C16460f extends AnimatorListenerAdapter {

    /* renamed from: a */
    private Animator f49099a;

    /* renamed from: b */
    private AnimatorListener f49100b;

    C16460f(Animator animator, AnimatorListener animatorListener) {
        this.f49099a = animator;
        this.f49100b = animatorListener;
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        AnimatorListener animatorListener = this.f49100b;
        if (animatorListener != null) {
            animatorListener.onAnimationStart(this.f49099a, (View) null);
        }
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        animator.removeListener(this);
        AnimatorListener animatorListener = this.f49100b;
        if (animatorListener != null) {
            animatorListener.onAnimationEnd(this.f49099a, (View) null);
        }
    }
}
