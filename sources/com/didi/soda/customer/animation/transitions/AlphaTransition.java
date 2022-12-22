package com.didi.soda.customer.animation.transitions;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

public class AlphaTransition extends Transition {

    /* renamed from: a */
    private static final String f40290a = "sodaglobaldidifood:transition:alpha";

    /* renamed from: b */
    private static final String[] f40291b = {f40290a};

    /* renamed from: c */
    private static final Property<View, Float> f40292c = View.ALPHA;

    public void captureEndValues(TransitionValues transitionValues) {
        m28567a(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        m28567a(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Float f = (Float) transitionValues.values.get(f40290a);
        Float f2 = (Float) transitionValues2.values.get(f40290a);
        if (f == null || f2 == null || f.equals(f2)) {
            return null;
        }
        View view = transitionValues2.view;
        view.setAlpha(f.floatValue());
        return ObjectAnimator.ofFloat(view, f40292c, new float[]{f.floatValue(), f2.floatValue()});
    }

    public String[] getTransitionProperties() {
        return f40291b;
    }

    /* renamed from: a */
    private void m28567a(TransitionValues transitionValues) {
        transitionValues.values.put(f40290a, Float.valueOf(transitionValues.view.getAlpha()));
    }
}
