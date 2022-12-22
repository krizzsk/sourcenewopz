package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: com.didichuxing.sofa.animation.d */
/* compiled from: AnimatorListenerWrapper */
class C16458d extends AnimatorListenerAdapter {

    /* renamed from: a */
    private Animator f49096a;

    /* renamed from: b */
    private C16472s f49097b;

    /* renamed from: c */
    private AnimatorListener f49098c;

    C16458d(Animator animator, C16472s sVar, AnimatorListener animatorListener) {
        this.f49096a = animator;
        this.f49097b = sVar;
        this.f49098c = animatorListener;
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        AnimatorListener animatorListener = this.f49098c;
        if (animatorListener != null) {
            animatorListener.onAnimationStart(this.f49096a, this.f49097b.mo121124b());
        }
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        animator.removeListener(this);
        AnimatorListener animatorListener = this.f49098c;
        if (animatorListener != null) {
            animatorListener.onAnimationEnd(this.f49096a, this.f49097b.mo121124b());
        }
    }
}
