package com.didichuxing.xpanel.message;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* renamed from: com.didichuxing.xpanel.message.d */
/* compiled from: MessageScaleAnimator */
class C16576d extends C16574b {
    C16576d(View view) {
        super(view);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.f49571a == null ? null : (View) this.f49571a.get();
        if (view != null) {
            if ((view instanceof ViewGroup) && XPanelMessageLayout.f49549a) {
                view = ((ViewGroup) view).getChildAt(0);
            }
            if (view != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewCompat.setScaleX(view, floatValue);
                ViewCompat.setScaleY(view, floatValue);
            }
        }
    }
}
