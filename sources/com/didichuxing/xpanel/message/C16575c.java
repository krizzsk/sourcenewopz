package com.didichuxing.xpanel.message;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* renamed from: com.didichuxing.xpanel.message.c */
/* compiled from: MessageAnimatorProxyImpl */
class C16575c extends C16574b {
    C16575c(View view) {
        super(view);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.f49571a == null ? null : (View) this.f49571a.get();
        if (view != null) {
            if ((view instanceof ViewGroup) && XPanelMessageLayout.f49549a) {
                view = ((ViewGroup) view).getChildAt(0);
            }
            if (view != null) {
                ViewCompat.setTranslationY(view, ((float) view.getMeasuredHeight()) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }
}
