package com.didi.soda.customer.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.dialog.AnimatorTransformAnimation;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.app.nova.skeleton.dialog.VerticalTransformAnimation;
import java.util.ArrayList;

public class CustomerVerticalTransformAnimation extends AnimatorTransformAnimation {

    /* renamed from: b */
    private TimeInterpolator f40289b;

    public void resetFromView(View view) {
    }

    public CustomerVerticalTransformAnimation() {
    }

    public CustomerVerticalTransformAnimation(boolean z) {
        this(-1, z);
    }

    public CustomerVerticalTransformAnimation(int i, boolean z) {
        super(i, z);
    }

    public CustomerVerticalTransformAnimation(int i, boolean z, TimeInterpolator timeInterpolator) {
        super(i, z);
        this.f40289b = timeInterpolator;
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
        TimeInterpolator timeInterpolator = this.f40289b;
        if (timeInterpolator != null) {
            animatorSet.setInterpolator(timeInterpolator);
        }
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }
}
