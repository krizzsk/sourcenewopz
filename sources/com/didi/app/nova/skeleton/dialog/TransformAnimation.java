package com.didi.app.nova.skeleton.dialog;

import android.view.View;
import android.view.ViewGroup;

public abstract class TransformAnimation {

    /* renamed from: a */
    boolean f8435a;

    /* renamed from: b */
    private boolean f8436b;

    public interface TransformAnimationListener {
        void onAnimationCompleted();
    }

    public abstract void completeAnimationImmediately();

    public abstract TransformAnimation copy();

    public abstract void onAbortPush();

    public abstract void performChange(ViewGroup viewGroup, View view, View view2, boolean z, TransformAnimationListener transformAnimationListener);

    public TransformAnimation() {
        this(true);
    }

    public TransformAnimation(boolean z) {
        this.f8436b = true;
        this.f8435a = false;
        this.f8436b = z;
    }

    public boolean removeFromViewOnEnter() {
        return this.f8436b;
    }
}
