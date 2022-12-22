package com.didi.addressnew.framework.widget;

import android.animation.Animator;

/* renamed from: com.didi.addressnew.framework.widget.a */
/* compiled from: AnimationRepeater */
class C3299a implements Animator.AnimatorListener {

    /* renamed from: a */
    private boolean f7428a = false;

    /* renamed from: b */
    private C3300b f7429b;

    /* renamed from: c */
    private Integer[] f7430c;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    C3299a(C3300b bVar, Integer[] numArr) {
        this.f7429b = bVar;
        this.f7430c = numArr;
    }

    public void onAnimationRepeat(Animator animator) {
        if (this.f7428a) {
            this.f7429b.f7437g.setObjectValues(new Object[]{this.f7430c[this.f7429b.f7431a], this.f7430c[(this.f7429b.f7431a + 1) % this.f7430c.length]});
            this.f7429b.f7437g.start();
            this.f7428a = false;
            return;
        }
        this.f7428a = true;
    }
}
