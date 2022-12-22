package com.didi.soda.customer.base.pages.changehandler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;
import com.didi.soda.customer.animation.CustomerInterpolator;

public class CustomerVerticalChangeHandler extends AnimatorChangeHandler {

    /* renamed from: a */
    private static final long f40373a = 1;

    /* renamed from: b */
    private static final long f40374b = 400;

    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
    }

    public CustomerVerticalChangeHandler() {
    }

    public CustomerVerticalChangeHandler(boolean z) {
        super(z);
    }

    public ControllerChangeHandler copy() {
        return new CustomerVerticalChangeHandler();
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(ViewGroup viewGroup, View view, final View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            if (view2 != null) {
                ObjectAnimator duration = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{(float) view2.getHeight(), 0.0f}).setDuration(400);
                duration.setInterpolator(m28628c());
                animatorSet.play(duration);
                duration.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        View view = view2;
                        view.setTranslationY((float) view.getHeight());
                    }

                    public void onAnimationEnd(Animator animator) {
                        view2.setTranslationY(0.0f);
                    }
                });
            }
        } else if (view != null) {
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{0.0f, (float) view.getHeight()}).setDuration(400);
            duration2.setInterpolator(m28628c());
            animatorSet.play(duration2);
        }
        return animatorSet;
    }

    /* renamed from: c */
    private Interpolator m28628c() {
        return CustomerInterpolator.newInstance();
    }
}
