package com.didi.entrega.customer.base.pages.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;

public class CustomerHorizontalChangeHandler extends AnimatorChangeHandler {

    /* renamed from: a */
    private static final float f19819a = 0.5f;

    public CustomerHorizontalChangeHandler() {
    }

    public CustomerHorizontalChangeHandler(long j) {
        super(j);
    }

    public CustomerHorizontalChangeHandler(long j, boolean z) {
        super(j, z);
    }

    public ControllerChangeHandler copy() {
        return new CustomerHorizontalChangeHandler(getAnimationDuration(), removesFromViewOnPush());
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            if (view != null) {
                animatorSet.play(ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{((float) (-view.getWidth())) * 0.5f}));
            }
            if (view2 != null) {
                animatorSet.play(ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{(float) view2.getWidth(), 0.0f}));
            }
        } else {
            if (view != null) {
                animatorSet.play(ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{(float) view.getWidth()}));
            }
            if (view2 != null) {
                animatorSet.play(ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{(view != null ? view.getTranslationX() : 0.0f) - (((float) view2.getWidth()) * 0.5f), 0.0f}));
            }
        }
        return animatorSet;
    }

    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
        view.setTranslationX(0.0f);
    }
}
