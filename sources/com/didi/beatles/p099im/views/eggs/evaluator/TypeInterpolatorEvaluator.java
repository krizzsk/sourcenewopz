package com.didi.beatles.p099im.views.eggs.evaluator;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;

/* renamed from: com.didi.beatles.im.views.eggs.evaluator.TypeInterpolatorEvaluator */
public abstract class TypeInterpolatorEvaluator<T> implements TypeEvaluator<T> {
    protected TimeInterpolator timeInterpolator;

    public TypeInterpolatorEvaluator() {
    }

    public TypeInterpolatorEvaluator(TimeInterpolator timeInterpolator2) {
        this.timeInterpolator = timeInterpolator2;
    }
}
