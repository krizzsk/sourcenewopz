package com.didi.app.nova.skeleton.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

public class FadeTransformAnimation extends AnimatorTransformAnimation {
    public FadeTransformAnimation() {
    }

    public FadeTransformAnimation(boolean z) {
        this(-1, z);
    }

    public FadeTransformAnimation(int i, boolean z) {
        super(i, z);
    }

    public TransformAnimation copy() {
        return new FadeTransformAnimation(getAnimationDuration(), removeFromViewOnEnter());
    }

    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (view2 != null) {
            float alpha = view2.getAlpha();
            animatorSet.play(ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{alpha, 1.0f}));
        }
        if (view != null && (!z || removeFromViewOnEnter())) {
            animatorSet.play(ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f}));
        }
        return animatorSet;
    }

    public void resetFromView(View view) {
        view.setAlpha(1.0f);
    }
}
