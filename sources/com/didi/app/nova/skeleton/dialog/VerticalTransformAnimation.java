package com.didi.app.nova.skeleton.dialog;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class VerticalTransformAnimation extends AnimatorTransformAnimation {
    public void resetFromView(View view) {
    }

    public VerticalTransformAnimation() {
    }

    public VerticalTransformAnimation(boolean z) {
        this(-1, z);
    }

    public VerticalTransformAnimation(int i, boolean z) {
        super(i, z);
    }

    public TransformAnimation copy() {
        return new VerticalTransformAnimation(getAnimationDuration(), removeFromViewOnEnter());
    }

    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z && view2 != null) {
            arrayList.add(ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{(float) view2.getHeight(), 0.0f}));
        } else if (!z && view != null) {
            arrayList.add(ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{(float) view.getHeight()}));
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }
}
