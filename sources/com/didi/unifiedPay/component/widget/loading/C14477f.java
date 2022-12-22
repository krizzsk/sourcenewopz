package com.didi.unifiedPay.component.widget.loading;

import android.animation.Animator;

/* renamed from: com.didi.unifiedPay.component.widget.loading.f */
/* compiled from: SimpleAnimatorListener */
abstract class C14477f implements Animator.AnimatorListener {
    private boolean mCancelled = false;
    private boolean mStarted = false;

    public void onAnimationRepeat(Animator animator) {
    }

    /* access modifiers changed from: protected */
    public void onPreAnimationEnd(Animator animator) {
    }

    C14477f() {
    }

    public void onAnimationStart(Animator animator) {
        this.mCancelled = false;
        this.mStarted = true;
    }

    public final void onAnimationEnd(Animator animator) {
        onPreAnimationEnd(animator);
        this.mStarted = false;
    }

    public void onAnimationCancel(Animator animator) {
        this.mCancelled = true;
    }

    public boolean isStartedAndNotCancelled() {
        return this.mStarted && !this.mCancelled;
    }
}
