package com.didi.app.nova.skeleton.conductor.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;

public class HorizontalChangeHandler extends AnimatorChangeHandler {
    public HorizontalChangeHandler() {
    }

    public HorizontalChangeHandler(boolean z) {
        super(z);
    }

    public HorizontalChangeHandler(long j) {
        super(j);
    }

    public HorizontalChangeHandler(long j, boolean z) {
        super(j, z);
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
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

    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
        view.setTranslationX(0.0f);
    }

    public ControllerChangeHandler copy() {
        return new HorizontalChangeHandler(getAnimationDuration(), removesFromViewOnPush());
    }
}
