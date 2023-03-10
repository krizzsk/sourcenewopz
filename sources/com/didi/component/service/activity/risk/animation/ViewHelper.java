package com.didi.component.service.activity.risk.animation;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

public final class ViewHelper {
    public static void clear(View view) {
        ViewCompat.setAlpha(view, 1.0f);
        ViewCompat.setScaleY(view, 1.0f);
        ViewCompat.setScaleX(view, 1.0f);
        ViewCompat.setTranslationY(view, 0.0f);
        ViewCompat.setTranslationX(view, 0.0f);
        ViewCompat.setRotation(view, 0.0f);
        ViewCompat.setRotationY(view, 0.0f);
        ViewCompat.setRotationX(view, 0.0f);
        ViewCompat.setPivotY(view, (float) (view.getMeasuredHeight() / 2));
        ViewCompat.setPivotX(view, (float) (view.getMeasuredWidth() / 2));
        ViewCompat.animate(view).setInterpolator((Interpolator) null).setStartDelay(0);
    }
}
