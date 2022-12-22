package com.didi.app.nova.skeleton.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

public class HorizontalTransformAnimation extends AnimatorTransformAnimation {
    public HorizontalTransformAnimation() {
    }

    public HorizontalTransformAnimation(boolean z) {
        this(-1, z);
    }

    public HorizontalTransformAnimation(int i, boolean z) {
        super(i, z);
    }

    public TransformAnimation copy() {
        return new HorizontalTransformAnimation(getAnimationDuration(), removeFromViewOnEnter());
    }

    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            if (view != null) {
                animatorSet.play(ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{(float) (-view.getWidth())}));
            }
            if (view2 != null) {
                animatorSet.play(ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{(float) view2.getWidth(), 0.0f}));
            }
        } else {
            if (view != null) {
                animatorSet.play(ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{(float) view.getWidth()}));
            }
            if (view2 != null) {
                animatorSet.play(ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{(view != null ? view.getTranslationX() : 0.0f) - ((float) view2.getWidth()), 0.0f}));
            }
        }
        return animatorSet;
    }

    public void resetFromView(View view) {
        view.setTranslationX(0.0f);
    }
}
