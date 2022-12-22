package com.didi.rfusion.widget.textfield;

import android.animation.ValueAnimator;

class RFClearTextEndIconDelegate$7 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C11577a this$0;

    RFClearTextEndIconDelegate$7(C11577a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.f33885k.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
