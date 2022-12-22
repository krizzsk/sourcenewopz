package com.google.p217ar.core;

import android.animation.ValueAnimator;

/* renamed from: com.google.ar.core.n */
/* compiled from: InstallActivity */
final class C18671n implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    private final /* synthetic */ int f53546a;

    /* renamed from: b */
    private final /* synthetic */ int f53547b;

    /* renamed from: c */
    private final /* synthetic */ int f53548c;

    /* renamed from: d */
    private final /* synthetic */ InstallActivity f53549d;

    C18671n(InstallActivity installActivity, int i, int i2, int i3) {
        this.f53549d = installActivity;
        this.f53546a = i;
        this.f53547b = i2;
        this.f53548c = i3;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        int i = this.f53547b;
        this.f53549d.getWindow().setLayout((int) ((((float) this.f53546a) * animatedFraction) + (((float) i) * animatedFraction2)), (int) ((((float) this.f53548c) * animatedFraction) + (((float) i) * animatedFraction2)));
        this.f53549d.getWindow().getDecorView().refreshDrawableState();
    }
}
