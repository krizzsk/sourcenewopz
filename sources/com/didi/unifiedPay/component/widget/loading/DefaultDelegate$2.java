package com.didi.unifiedPay.component.widget.loading;

import android.animation.ValueAnimator;

class DefaultDelegate$2 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C14472a this$0;

    DefaultDelegate$2(C14472a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f;
        float a = C14478g.m31645a(valueAnimator);
        if (this.this$0.f44524u) {
            f = a * ((float) this.this$0.f44503B);
        } else {
            f = (a * ((float) (this.this$0.f44503B - this.this$0.f44502A))) + ((float) this.this$0.f44502A);
        }
        this.this$0.mo111598b(f);
    }
}
