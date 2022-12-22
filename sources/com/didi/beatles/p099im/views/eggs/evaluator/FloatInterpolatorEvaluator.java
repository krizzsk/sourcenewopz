package com.didi.beatles.p099im.views.eggs.evaluator;

import android.animation.TimeInterpolator;

/* renamed from: com.didi.beatles.im.views.eggs.evaluator.FloatInterpolatorEvaluator */
public class FloatInterpolatorEvaluator extends TypeInterpolatorEvaluator<Float> {

    /* renamed from: a */
    private static final String f10207a = FloatInterpolatorEvaluator.class.getSimpleName();

    public FloatInterpolatorEvaluator() {
    }

    public FloatInterpolatorEvaluator(TimeInterpolator timeInterpolator) {
        super(timeInterpolator);
    }

    public Float evaluate(float f, Float f2, Float f3) {
        if (this.timeInterpolator != null) {
            f = this.timeInterpolator.getInterpolation(f);
        }
        return Float.valueOf(f2.floatValue() + (f * (f3.floatValue() - f2.floatValue())));
    }
}
