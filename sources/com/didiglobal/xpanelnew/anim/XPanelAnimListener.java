package com.didiglobal.xpanelnew.anim;

import android.animation.Animator;

public abstract class XPanelAnimListener implements Animator.AnimatorListener {
    public void onAnimationCancel(Animator animator) {
    }

    public abstract void onAnimationEnd(Animator animator);

    public void onAnimationRepeat(Animator animator) {
    }

    public abstract void onAnimationStart(Animator animator);
}
