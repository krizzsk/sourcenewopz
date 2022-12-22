package com.didi.unifiedPay.component.widget.loading;

import android.animation.ValueAnimator;

class DefaultDelegate$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C14472a this$0;

    DefaultDelegate$1(C14472a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.mo111593a(C14478g.m31645a(valueAnimator) * 360.0f);
    }
}
