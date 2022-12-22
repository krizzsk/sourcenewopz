package com.didi.soda.customer.animation.transitions;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.soda.customer.animation.AnimationProperty;

public class TextSizeTransition extends Transition {

    /* renamed from: a */
    private static final String f40301a = "sodaglobaldidifood:transition:textsize";

    /* renamed from: b */
    private static final String[] f40302b = {f40301a};

    /* renamed from: c */
    private static final Property<TextView, Float> f40303c = AnimationProperty.TEXT_SIZE;

    public void captureEndValues(TransitionValues transitionValues) {
        m28572a(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        m28572a(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Float f = (Float) transitionValues.values.get(f40301a);
        Float f2 = (Float) transitionValues2.values.get(f40301a);
        if (f == null || f2 == null || f.floatValue() == f2.floatValue()) {
            return null;
        }
        TextView textView = (TextView) transitionValues2.view;
        textView.setTextSize(0, f.floatValue());
        return ObjectAnimator.ofFloat(textView, f40303c, new float[]{f.floatValue(), f2.floatValue()});
    }

    public String[] getTransitionProperties() {
        return f40302b;
    }

    /* renamed from: a */
    private void m28572a(TransitionValues transitionValues) {
        if (transitionValues.view instanceof TextView) {
            transitionValues.values.put(f40301a, Float.valueOf(((TextView) transitionValues.view).getTextSize()));
        }
    }
}
