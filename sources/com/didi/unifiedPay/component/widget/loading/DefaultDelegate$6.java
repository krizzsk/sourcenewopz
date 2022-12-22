package com.didi.unifiedPay.component.widget.loading;

import android.animation.ValueAnimator;

class DefaultDelegate$6 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C14472a this$0;

    DefaultDelegate$6(C14472a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.m31614d(1.0f - C14478g.m31645a(valueAnimator));
    }
}
