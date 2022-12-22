package com.didichuxing.sofa.animation;

import android.animation.TypeEvaluator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.util.ArrayList;
import java.util.List;

public class ValueAnimatorBuilder implements C16459e, C16466l<ValueAnimatorBuilder> {

    /* renamed from: a */
    float[] f49080a = {0.0f, 1.0f};

    /* renamed from: b */
    int f49081b = 1000;

    /* renamed from: c */
    int f49082c = 0;

    /* renamed from: d */
    int f49083d = 1;

    /* renamed from: e */
    Interpolator f49084e = new LinearInterpolator();

    /* renamed from: f */
    long f49085f = 0;

    /* renamed from: g */
    TypeEvaluator f49086g = null;

    /* renamed from: h */
    List<AnimatorUpdateListener> f49087h = new ArrayList();

    /* renamed from: i */
    private final int f49088i = 1000;

    /* renamed from: j */
    private final long f49089j = 0;

    /* renamed from: k */
    private C16475v f49090k = new C16475v();

    ValueAnimatorBuilder() {
    }

    public ValueAnimatorBuilder values(float... fArr) {
        this.f49080a = fArr;
        return this;
    }

    public ValueAnimatorBuilder repeatCount(int i) {
        this.f49082c = i;
        return this;
    }

    public ValueAnimatorBuilder repeatInfinite() {
        this.f49082c = -1;
        return this;
    }

    public ValueAnimatorBuilder repeatRestart() {
        this.f49083d = 1;
        return this;
    }

    public ValueAnimatorBuilder repeatReverse() {
        this.f49083d = 2;
        return this;
    }

    public ValueAnimatorBuilder duration(int i) {
        this.f49081b = i;
        return this;
    }

    public ValueAnimatorBuilder accelerateDecelerate() {
        this.f49084e = new AccelerateDecelerateInterpolator();
        return this;
    }

    public ValueAnimatorBuilder accelerate() {
        this.f49084e = new AccelerateInterpolator();
        return this;
    }

    public ValueAnimatorBuilder bounce() {
        this.f49084e = new BounceInterpolator();
        return this;
    }

    public ValueAnimatorBuilder decelerate() {
        this.f49084e = new DecelerateInterpolator();
        return this;
    }

    public ValueAnimatorBuilder overshoot() {
        this.f49084e = new OvershootInterpolator();
        return this;
    }

    public ValueAnimatorBuilder anticipate() {
        this.f49084e = new AnticipateInterpolator();
        return this;
    }

    public ValueAnimatorBuilder anticipateOvershoot() {
        this.f49084e = new AnticipateOvershootInterpolator();
        return this;
    }

    public ValueAnimatorBuilder interpolator(Interpolator interpolator) {
        this.f49084e = interpolator;
        return this;
    }

    public ValueAnimatorBuilder evaluator(TypeEvaluator typeEvaluator) {
        this.f49086g = typeEvaluator;
        return this;
    }

    public ValueAnimatorBuilder startDelay(long j) {
        this.f49085f = j;
        return this;
    }

    public ValueAnimatorBuilder withListener(AnimatorUpdateListener animatorUpdateListener) {
        if (animatorUpdateListener != null) {
            this.f49087h.add(animatorUpdateListener);
        }
        return this;
    }

    public ValueAnimatorBuilder bounceEaseOut() {
        this.f49086g = new C16463i(0.0f);
        return this;
    }

    public ValueAnimatorBuilder elasticEaseOut() {
        this.f49086g = new C16467m(0.0f);
        return this;
    }

    public Animator playTogether(Animator... animatorArr) {
        this.f49090k.playTogether(animatorArr);
        return this.f49090k;
    }

    public Animator playSequentially(Animator... animatorArr) {
        this.f49090k.playSequentially(animatorArr);
        return this.f49090k;
    }

    public Animator build() {
        if (!this.f49087h.isEmpty()) {
            this.f49090k.mo121144a(this);
            return this.f49090k;
        }
        throw new IllegalStateException("Value animator must have one AnimatorUpdateListener at least, do you forget it? ");
    }
}
