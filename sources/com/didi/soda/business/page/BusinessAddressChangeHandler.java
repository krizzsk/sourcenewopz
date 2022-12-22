package com.didi.soda.business.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler;
import com.taxis99.R;

public class BusinessAddressChangeHandler extends AnimatorChangeHandler {
    public BusinessAddressChangeHandler() {
    }

    public BusinessAddressChangeHandler(boolean z) {
        super(z);
    }

    public BusinessAddressChangeHandler(long j) {
        super(j);
    }

    public BusinessAddressChangeHandler(long j, boolean z) {
        super(j, z);
    }

    public ControllerChangeHandler copy() {
        return new BusinessAddressChangeHandler(getAnimationDuration(), removesFromViewOnPush());
    }

    /* access modifiers changed from: protected */
    public Animator getAnimator(final ViewGroup viewGroup, View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            m28303a(viewGroup, 8);
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
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    BusinessAddressChangeHandler.this.m28303a(viewGroup, 0);
                }
            });
        }
        return animatorSet;
    }

    /* access modifiers changed from: protected */
    public void resetFromView(View view) {
        view.setTranslationX(0.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28303a(View view, int i) {
        if (view != null) {
            View findViewById = view.findViewById(R.id.customer_cl_business_parent);
            if (findViewById != null) {
                findViewById.setVisibility(i);
            }
            View findViewById2 = view.findViewById(R.id.customer_fl_order_root_container);
            if (findViewById2 != null) {
                findViewById2.setVisibility(i);
            }
        }
    }
}
