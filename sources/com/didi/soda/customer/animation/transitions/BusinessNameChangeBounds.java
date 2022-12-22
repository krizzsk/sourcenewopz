package com.didi.soda.customer.animation.transitions;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.util.DisplayUtils;

public class BusinessNameChangeBounds extends ChangeBounds {

    /* renamed from: a */
    private boolean f40294a;

    /* renamed from: b */
    private int f40295b = -1;

    /* renamed from: c */
    private int f40296c = -1;

    public BusinessNameChangeBounds(boolean z) {
        this.f40294a = z;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        this.f40296c = transitionValues.view.getPaddingLeft();
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        this.f40295b = transitionValues.view.getPaddingLeft();
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        final ValueAnimator valueAnimator;
        Animator createAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
        if (!(createAnimator == null || transitionValues == null || transitionValues2 == null)) {
            final View view = transitionValues.view;
            final View view2 = transitionValues2.view;
            if (!(view == null || view2 == null)) {
                int dip2px = DisplayUtils.dip2px(view.getContext(), 8.0f);
                final ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                final ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                view.setAlpha(1.0f);
                view2.setAlpha(0.0f);
                if (this.f40294a) {
                    valueAnimator = ValueAnimator.ofInt(new int[]{dip2px, this.f40296c});
                    view2.setPadding(dip2px, view2.getPaddingTop(), view2.getPaddingRight(), view2.getPaddingBottom());
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            View view = view2;
                            view.setPadding(intValue, view.getPaddingTop(), view2.getPaddingRight(), view2.getPaddingBottom());
                        }
                    });
                } else {
                    valueAnimator = ValueAnimator.ofInt(new int[]{this.f40295b, dip2px});
                    view.setPadding(this.f40295b, view2.getPaddingTop(), view2.getPaddingRight(), view2.getPaddingBottom());
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            View view = view;
                            view.setPadding(intValue, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                        }
                    });
                }
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat2.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        view.setAlpha(1.0f);
                    }

                    public void onAnimationEnd(Animator animator) {
                        view.setAlpha(1.0f);
                    }
                });
                ofFloat.setDuration(getDuration() / 2);
                ofFloat2.setDuration(getDuration() / 2);
                valueAnimator.setDuration(getDuration());
                ofFloat.setStartDelay(getStartDelay());
                ofFloat2.setStartDelay(getStartDelay());
                valueAnimator.setStartDelay(getStartDelay());
                createAnimator.addListener(new Animator.AnimatorListener() {
                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        ofFloat.start();
                        ofFloat2.start();
                        valueAnimator.start();
                    }

                    public void onAnimationEnd(Animator animator) {
                        ofFloat.end();
                        ofFloat2.end();
                        valueAnimator.end();
                    }

                    public void onAnimationCancel(Animator animator) {
                        ofFloat.cancel();
                        ofFloat2.cancel();
                        valueAnimator.cancel();
                    }
                });
            }
        }
        return createAnimator;
    }
}
