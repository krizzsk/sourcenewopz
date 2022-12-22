package com.didi.component.indriver;

import android.animation.TimeInterpolator;

public class MountainInterpolator implements TimeInterpolator {
    public float getInterpolation(float f) {
        if (f < 0.0f || f > 1.0f) {
            return 0.0f;
        }
        if ((0.0f >= f || f >= 0.8f) && Math.abs(f - 0.0f) >= 0.001f) {
            return (f - 0.8f) / 0.2f;
        }
        return 0.0f;
    }
}
