package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ViewAnimator$1 extends AnimatorListenerAdapter {
    final /* synthetic */ C16476w this$0;
    final /* synthetic */ C16472s val$builder;

    ViewAnimator$1(C16476w wVar, C16472s sVar) {
        this.this$0 = wVar;
        this.val$builder = sVar;
    }

    public void onAnimationStart(Animator animator) {
        C16476w wVar = this.this$0;
        wVar.m35404a("onAnimationStart animation: " + animator);
        super.onAnimationStart(animator);
        View b = this.val$builder.mo121124b();
        if (b == null) {
            LoggerUtil.m35315e("ViewAnimator", "onAnimationStart error: target is null!!");
        } else {
            b.setVisibility(0);
        }
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        animator.removeListener(this);
        C16476w wVar = this.this$0;
        wVar.m35404a("onAnimationEnd animation.getListeners(): " + animator.getListeners());
    }
}
