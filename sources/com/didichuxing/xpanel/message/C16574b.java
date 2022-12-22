package com.didichuxing.xpanel.message;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: com.didichuxing.xpanel.message.b */
/* compiled from: MessageAnimatorProxy */
abstract class C16574b implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    protected WeakReference<View> f49571a;

    /* renamed from: b */
    protected boolean f49572b = true;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    C16574b(View view) {
        this.f49571a = new WeakReference<>(view);
    }

    /* renamed from: a */
    public void mo121664a(boolean z) {
        this.f49572b = z;
    }

    public void onAnimationEnd(Animator animator) {
        animator.removeAllListeners();
        if (animator instanceof ValueAnimator) {
            ((ValueAnimator) animator).removeAllUpdateListeners();
        }
    }
}
