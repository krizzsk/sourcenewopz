package com.didi.rfusion.widget.textfield;

import android.animation.ValueAnimator;

class RFClearTextEndIconDelegate$8 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C11577a this$0;

    RFClearTextEndIconDelegate$8(C11577a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.this$0.f33885k.setScaleX(floatValue);
        this.this$0.f33885k.setScaleY(floatValue);
    }
}
