package com.didichuxing.sofa.animation;

import android.animation.TypeEvaluator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

/* renamed from: com.didichuxing.sofa.animation.x */
/* compiled from: ViewAnimatorBuilder */
class C16477x extends AnimatorBuilder {
    C16477x() {
        this.f49078b = new C16476w();
    }

    public AnimatorBuilder repeatCount(int i) {
        this.f49077a.mo121128c(i);
        return this;
    }

    public AnimatorBuilder repeatInfinite() {
        this.f49077a.mo121128c(-1);
        return this;
    }

    public AnimatorBuilder repeatRestart() {
        this.f49077a.mo121126b(1);
        return this;
    }

    public AnimatorBuilder repeatReverse() {
        this.f49077a.mo121126b(2);
        return this;
    }

    public AnimatorBuilder duration(int i) {
        this.f49077a.mo121120a(i);
        return this;
    }

    public AnimatorBuilder accelerateDecelerate() {
        this.f49077a.mo121123a((Interpolator) new AccelerateDecelerateInterpolator());
        return this;
    }

    public AnimatorBuilder accelerate() {
        this.f49077a.mo121123a((Interpolator) new AccelerateInterpolator());
        return this;
    }

    public AnimatorBuilder bounce() {
        this.f49077a.mo121123a((Interpolator) new BounceInterpolator());
        return this;
    }

    public AnimatorBuilder decelerate() {
        this.f49077a.mo121123a((Interpolator) new DecelerateInterpolator());
        return this;
    }

    public AnimatorBuilder overshoot() {
        this.f49077a.mo121123a((Interpolator) new OvershootInterpolator());
        return this;
    }

    public AnimatorBuilder anticipate() {
        this.f49077a.mo121123a((Interpolator) new AnticipateInterpolator());
        return this;
    }

    public AnimatorBuilder anticipateOvershoot() {
        this.f49077a.mo121123a((Interpolator) new AnticipateOvershootInterpolator());
        return this;
    }

    public AnimatorBuilder interpolator(Interpolator interpolator) {
        this.f49077a.mo121123a(interpolator);
        return this;
    }

    public AnimatorBuilder evaluator(TypeEvaluator typeEvaluator) {
        this.f49077a.mo121122a(typeEvaluator);
        return this;
    }

    public AnimatorBuilder startDelay(long j) {
        this.f49077a.mo121121a(j);
        return this;
    }

    /* renamed from: a */
    public AnimatorBuilder bounceEaseOut() {
        this.f49077a.mo121122a((TypeEvaluator) new C16463i(0.0f));
        return this;
    }

    /* renamed from: b */
    public AnimatorBuilder elasticEaseOut() {
        this.f49077a.mo121122a((TypeEvaluator) new C16467m(0.0f));
        return this;
    }
}
