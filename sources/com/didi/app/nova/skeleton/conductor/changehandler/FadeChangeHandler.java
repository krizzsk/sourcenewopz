package com.didi.app.nova.skeleton.conductor.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;

public class FadeChangeHandler extends AnimatorChangeHandler {
    public FadeChangeHandler() {
    }

    public FadeChangeHandler(boolean z) {
        super(z);
    }

    public FadeChangeHandler(long j) {
        super(j);
    }

    public FadeChangeHandler(long j, boolean z) {
        super(j, z);
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        float f;
        AnimatorSet animatorSet = new AnimatorSet();
        if (view2 != null) {
            if (z2) {
                f = 0.0f;
            } else {
                f = view2.getAlpha();
            }
            animatorSet.play(ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{f, 1.0f}));
        }
        if (view != null && (!z || removesFromViewOnPush())) {
            animatorSet.play(ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f}));
        }
        return animatorSet;
    }

    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
        view.setAlpha(1.0f);
    }

    public ControllerChangeHandler copy() {
        return new FadeChangeHandler(getAnimationDuration(), removesFromViewOnPush());
    }
}
