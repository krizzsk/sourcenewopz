package com.airbnb.lottie.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class BaseLottieAnimator extends ValueAnimator {

    /* renamed from: a */
    private final Set<ValueAnimator.AnimatorUpdateListener> f1680a = new CopyOnWriteArraySet();

    /* renamed from: b */
    private final Set<Animator.AnimatorListener> f1681b = new CopyOnWriteArraySet();

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1680a.add(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1680a.remove(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.f1680a.clear();
    }

    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f1681b.add(animatorListener);
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f1681b.remove(animatorListener);
    }

    public void removeAllListeners() {
        this.f1681b.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo15530a(boolean z) {
        for (Animator.AnimatorListener next : this.f1681b) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationStart(this, z);
            } else {
                next.onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo15529a() {
        for (Animator.AnimatorListener onAnimationRepeat : this.f1681b) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo15534b(boolean z) {
        for (Animator.AnimatorListener next : this.f1681b) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationEnd(this, z);
            } else {
                next.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo15533b() {
        for (Animator.AnimatorListener onAnimationCancel : this.f1681b) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo15535c() {
        for (ValueAnimator.AnimatorUpdateListener onAnimationUpdate : this.f1680a) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }
}
