package com.didi.hawaii.mapsdkv2.common.evaluator;

import android.animation.TypeEvaluator;

public class AngleEvaluator implements TypeEvaluator<Number> {
    public static final AngleEvaluator INSTANCE = new AngleEvaluator();

    private AngleEvaluator() {
    }

    public Float evaluate(float f, Number number, Number number2) {
        float floatValue = number.floatValue();
        float floatValue2 = number2.floatValue() - floatValue;
        if (floatValue2 > 180.0f) {
            floatValue2 -= 360.0f;
        } else if (floatValue2 < -180.0f) {
            floatValue2 += 360.0f;
        }
        return Float.valueOf((floatValue + (f * floatValue2)) % 360.0f);
    }
}
