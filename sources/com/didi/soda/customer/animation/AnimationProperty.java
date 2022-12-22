package com.didi.soda.customer.animation;

import android.util.Property;
import android.widget.TextView;

public final class AnimationProperty {
    public static final Property<TextView, Float> TEXT_SIZE = new Property<TextView, Float>(Float.class, "textSize") {
        public Float get(TextView textView) {
            return Float.valueOf(textView.getTextSize());
        }

        public void set(TextView textView, Float f) {
            textView.setTextSize(0, f.floatValue());
        }
    };

    private AnimationProperty() {
    }
}
