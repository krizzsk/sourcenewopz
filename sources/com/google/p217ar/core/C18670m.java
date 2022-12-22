package com.google.p217ar.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: com.google.ar.core.m */
/* compiled from: InstallActivity */
final class C18670m extends AnimatorListenerAdapter {

    /* renamed from: a */
    private final /* synthetic */ InstallActivity f53545a;

    C18670m(InstallActivity installActivity) {
        this.f53545a = installActivity;
    }

    public final void onAnimationEnd(Animator animator) {
        this.f53545a.showSpinner();
    }
}
