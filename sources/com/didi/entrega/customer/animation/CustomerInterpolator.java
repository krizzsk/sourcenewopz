package com.didi.entrega.customer.animation;

import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;

public final class CustomerInterpolator {
    private CustomerInterpolator() {
    }

    public static Interpolator newInstance() {
        return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
    }
}
