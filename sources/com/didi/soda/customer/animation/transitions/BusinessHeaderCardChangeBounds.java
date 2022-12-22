package com.didi.soda.customer.animation.transitions;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.util.DisplayUtils;
import com.taxis99.R;

public class BusinessHeaderCardChangeBounds extends ChangeBounds {

    /* renamed from: a */
    private boolean f40293a;

    public BusinessHeaderCardChangeBounds(boolean z) {
        this.f40293a = z;
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        final ValueAnimator valueAnimator;
        final ValueAnimator valueAnimator2;
        Animator createAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
        if (!(createAnimator == null || transitionValues == null || transitionValues2 == null)) {
            if (this.f40293a) {
                final View view = transitionValues2.view;
                valueAnimator2 = ValueAnimator.ofInt(new int[]{0, DisplayUtils.dip2px(view.getContext(), 16.0f)});
                view.setPadding(0, 0, 0, 0);
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        view.setPadding(intValue, intValue, intValue, intValue);
                    }
                });
                View view2 = transitionValues.view;
                final View findViewById = view2.findViewById(R.id.customer_tv_cate_tips);
                final View findViewById2 = view2.findViewById(R.id.ll_delivery_info_container);
                final View findViewById3 = view2.findViewById(R.id.customer_view_tag_flow);
                valueAnimator = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById)) {
                            findViewById.setAlpha(floatValue);
                        }
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById2)) {
                            findViewById2.setAlpha(floatValue);
                        }
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById3)) {
                            findViewById3.setAlpha(floatValue);
                        }
                    }
                });
                valueAnimator.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById)) {
                            findViewById.setAlpha(1.0f);
                        }
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById2)) {
                            findViewById2.setAlpha(1.0f);
                        }
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById3)) {
                            findViewById3.setAlpha(1.0f);
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById)) {
                            findViewById.setAlpha(1.0f);
                        }
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById2)) {
                            findViewById2.setAlpha(1.0f);
                        }
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById3)) {
                            findViewById3.setAlpha(1.0f);
                        }
                    }
                });
            } else {
                final View view3 = transitionValues.view;
                int dip2px = DisplayUtils.dip2px(view3.getContext(), 16.0f);
                view3.setPadding(dip2px, dip2px, dip2px, dip2px);
                valueAnimator2 = ValueAnimator.ofInt(new int[]{DisplayUtils.dip2px(view3.getContext(), 16.0f), 0});
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        view3.setPadding(intValue, intValue, intValue, intValue);
                    }
                });
                View view4 = transitionValues2.view;
                final View findViewById4 = view4.findViewById(R.id.customer_tv_cate_tips);
                final View findViewById5 = view4.findViewById(R.id.ll_delivery_info_container);
                final View findViewById6 = view4.findViewById(R.id.customer_view_tag_flow);
                valueAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById4)) {
                            findViewById4.setAlpha(floatValue);
                        }
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById5)) {
                            findViewById5.setAlpha(floatValue);
                        }
                        if (BusinessHeaderCardChangeBounds.this.m28568a(findViewById6)) {
                            findViewById6.setAlpha(floatValue);
                        }
                    }
                });
            }
            valueAnimator2.setDuration(getDuration());
            valueAnimator2.setStartDelay(getStartDelay());
            valueAnimator.setDuration(getDuration());
            valueAnimator.setStartDelay(getStartDelay());
            createAnimator.addListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationCancel(Animator animator) {
                    valueAnimator2.cancel();
                    valueAnimator.cancel();
                }

                public void onAnimationEnd(Animator animator) {
                    valueAnimator2.end();
                    valueAnimator.end();
                }

                public void onAnimationStart(Animator animator) {
                    valueAnimator2.start();
                    valueAnimator.start();
                }
            });
        }
        return createAnimator;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m28568a(View view) {
        return view != null && view.getVisibility() == 0;
    }
}
