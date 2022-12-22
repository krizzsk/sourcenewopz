package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.sofa.animation.v */
/* compiled from: ValueAnimator */
class C16475v extends Animator {

    /* renamed from: a */
    private static final String f49134a = "ValueAnimator";

    /* renamed from: b */
    private AnimatorSet f49135b;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121013a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121015a(C16472s sVar) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo121017b(C16472s sVar) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo121019c(C16472s sVar) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo121020d(C16472s sVar) {
    }

    C16475v() {
    }

    /* renamed from: d */
    private AnimatorSet m35394d() {
        return this.f49135b;
    }

    /* renamed from: a */
    private List<Animator> m35392a(Animator... animatorArr) {
        ArrayList arrayList = new ArrayList();
        for (C16475v vVar : animatorArr) {
            if (vVar instanceof C16475v) {
                arrayList.add(vVar.m35394d());
            } else {
                LoggerUtil.m35315e(f49134a, "collectAnimators: unsupported Animator type: " + vVar.getClass().getSimpleName());
            }
        }
        return arrayList;
    }

    public Animator playTogether(Animator... animatorArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f49135b = animatorSet;
        animatorSet.playTogether(m35392a(animatorArr));
        return this;
    }

    public Animator playSequentially(Animator... animatorArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f49135b = animatorSet;
        animatorSet.playSequentially(m35392a(animatorArr));
        return this;
    }

    public Animator start() {
        this.f49135b.start();
        return this;
    }

    public void stop() {
        this.f49135b.end();
    }

    public boolean isRunning() {
        AnimatorSet animatorSet = this.f49135b;
        return animatorSet != null && animatorSet.isRunning();
    }

    public boolean isStarted() {
        AnimatorSet animatorSet = this.f49135b;
        return animatorSet != null && animatorSet.isStarted();
    }

    /* renamed from: a */
    public void mo121144a(ValueAnimatorBuilder valueAnimatorBuilder) {
        if (this.f49135b != null) {
            LoggerUtil.m35314d(f49134a, "Please do not build animator repeatedly!");
            return;
        }
        this.f49135b = new AnimatorSet();
        this.f49135b.play(m35393b(valueAnimatorBuilder));
    }

    /* renamed from: b */
    private ValueAnimator m35393b(ValueAnimatorBuilder valueAnimatorBuilder) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(valueAnimatorBuilder.f49080a);
        ofFloat.setDuration((long) valueAnimatorBuilder.f49081b);
        ofFloat.setRepeatCount(valueAnimatorBuilder.f49082c);
        ofFloat.setRepeatMode(valueAnimatorBuilder.f49083d);
        ofFloat.setStartDelay(valueAnimatorBuilder.f49085f);
        ofFloat.setInterpolator(valueAnimatorBuilder.f49084e);
        ofFloat.setEvaluator(valueAnimatorBuilder.f49086g);
        for (AnimatorUpdateListener gVar : valueAnimatorBuilder.f49087h) {
            ofFloat.addUpdateListener(new C16461g(this, gVar));
        }
        ofFloat.addListener(new ValueAnimator$1(this, ofFloat));
        return ofFloat;
    }
}
