package com.didi.soda.customer.base.pages.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;

public class CustomerResetChangeHandler extends AnimatorChangeHandler {
    public CustomerResetChangeHandler() {
    }

    public CustomerResetChangeHandler(boolean z) {
        super(0, z);
    }

    public ControllerChangeHandler copy() {
        return new CustomerResetChangeHandler(removesFromViewOnPush());
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        return new AnimatorSet();
    }

    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
        view.setTranslationX(0.0f);
    }
}
