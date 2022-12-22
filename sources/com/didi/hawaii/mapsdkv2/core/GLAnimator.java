package com.didi.hawaii.mapsdkv2.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

public class GLAnimator extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: d */
    private static final int f23824d = 16;

    /* renamed from: a */
    private long f23825a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ValueAnimator.AnimatorUpdateListener f23826b;

    /* renamed from: c */
    private int f23827c = 16;

    public GLAnimator() {
        addListener(new AnimatorListener());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo69773a(int i) {
        this.f23827c = i * 16;
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        super.addUpdateListener(this);
        this.f23826b = animatorUpdateListener;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.f23826b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f23825a >= ((long) this.f23827c)) {
                this.f23826b.onAnimationUpdate(valueAnimator);
                this.f23825a = currentTimeMillis;
            }
        }
    }

    private class AnimatorListener extends AnimatorListenerAdapter {
        private AnimatorListener() {
        }

        public void onAnimationEnd(Animator animator) {
            if (GLAnimator.this.f23826b != null) {
                GLAnimator.this.f23826b.onAnimationUpdate(GLAnimator.this);
            }
        }
    }
}
