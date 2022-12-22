package com.didichuxing.sofa.animation;

import android.animation.TypeEvaluator;
import android.view.View;
import android.view.animation.Interpolator;

public abstract class AnimatorBuilder implements C16459e, C16464j<AnimatorBuilder>, C16466l<AnimatorBuilder> {

    /* renamed from: a */
    C16472s f49077a;

    /* renamed from: b */
    Animator f49078b;

    public abstract AnimatorBuilder accelerate();

    public abstract AnimatorBuilder accelerateDecelerate();

    public abstract AnimatorBuilder anticipate();

    public abstract AnimatorBuilder anticipateOvershoot();

    public abstract AnimatorBuilder bounce();

    public abstract AnimatorBuilder decelerate();

    public abstract AnimatorBuilder duration(int i);

    public abstract AnimatorBuilder evaluator(TypeEvaluator typeEvaluator);

    public abstract AnimatorBuilder interpolator(Interpolator interpolator);

    public abstract AnimatorBuilder overshoot();

    public abstract AnimatorBuilder repeatCount(int i);

    public abstract AnimatorBuilder repeatInfinite();

    public abstract AnimatorBuilder repeatRestart();

    public abstract AnimatorBuilder repeatReverse();

    public abstract AnimatorBuilder startDelay(long j);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C16472s mo121028a(View view) {
        return new C16472s(view);
    }

    public AnimatorBuilder play(View view) {
        C16472s a = mo121028a(view);
        this.f49078b.mo121015a(a);
        this.f49077a = a;
        return this;
    }

    public AnimatorBuilder with(View view) {
        C16472s a = mo121028a(view);
        this.f49078b.mo121017b(a);
        this.f49077a = a;
        return this;
    }

    public AnimatorBuilder before(View view) {
        C16472s a = mo121028a(view);
        this.f49078b.mo121019c(a);
        this.f49077a = a;
        return this;
    }

    public AnimatorBuilder after(View view) {
        C16472s a = mo121028a(view);
        this.f49078b.mo121020d(a);
        this.f49077a = a;
        return this;
    }

    /* renamed from: x */
    public AnimatorBuilder mo121072x(float... fArr) {
        this.f49077a.mo121118a(fArr);
        return this;
    }

    /* renamed from: y */
    public AnimatorBuilder mo121073y(float... fArr) {
        this.f49077a.mo121125b(fArr);
        return this;
    }

    public AnimatorBuilder translateX(float... fArr) {
        this.f49077a.mo121127c(fArr);
        return this;
    }

    public AnimatorBuilder translateY(float... fArr) {
        this.f49077a.mo121130d(fArr);
        return this;
    }

    public AnimatorBuilder rotate(float... fArr) {
        this.f49077a.mo121132e(fArr);
        return this;
    }

    public AnimatorBuilder scale(float... fArr) {
        this.f49077a.mo121134f(fArr);
        this.f49077a.mo121136g(fArr);
        return this;
    }

    public AnimatorBuilder scaleX(float... fArr) {
        this.f49077a.mo121134f(fArr);
        return this;
    }

    public AnimatorBuilder scaleY(float... fArr) {
        this.f49077a.mo121136g(fArr);
        return this;
    }

    public AnimatorBuilder alpha(float... fArr) {
        this.f49077a.mo121138h(fArr);
        return this;
    }

    public AnimatorBuilder property(String str, float... fArr) {
        this.f49077a.mo121117a(str, fArr);
        return this;
    }

    public AnimatorBuilder withListener(AnimatorListener animatorListener) {
        this.f49077a.mo121104a(animatorListener);
        return this;
    }

    public Animator build() {
        this.f49078b.mo121013a();
        return this.f49078b;
    }

    public Animator buildWithListener(AnimatorListener animatorListener) {
        this.f49078b.mo121104a(animatorListener);
        return build();
    }

    public View getTarget() {
        return this.f49077a.mo121124b();
    }

    public AnimatorBuilder fadeIn() {
        return C16465k.m35327a(this);
    }

    public AnimatorBuilder fadeOut() {
        return C16465k.m35329b(this);
    }

    public AnimatorBuilder translateInFromTop() {
        return C16465k.m35331c(this);
    }

    public AnimatorBuilder translateOutToTop() {
        return C16465k.m35333d(this);
    }

    public AnimatorBuilder translateInFromBottom() {
        return C16465k.m35335e(this);
    }

    public AnimatorBuilder translateOutToBottom() {
        return C16465k.m35337f(this);
    }

    public AnimatorBuilder scaleIn() {
        return C16465k.m35339g(this);
    }

    public AnimatorBuilder scaleOut() {
        return C16465k.m35341h(this);
    }

    public AnimatorBuilder rotateCW() {
        return C16465k.m35343i(this);
    }

    public AnimatorBuilder rotateCCW() {
        return C16465k.m35344j(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AnimatorBuilder mo121027a(Runnable runnable) {
        this.f49078b.mo121016a(new C16473t(this.f49077a.mo121124b(), runnable));
        return this;
    }

    public Animator playTogether(Animator... animatorArr) {
        return this.f49078b.playTogether(animatorArr);
    }

    public Animator playSequentially(Animator... animatorArr) {
        return this.f49078b.playSequentially(animatorArr);
    }
}
