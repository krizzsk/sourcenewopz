package com.didi.unifiedPay.component.widget.loading;

import android.animation.ValueAnimator;

class DefaultDelegate$4 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ C14472a this$0;

    DefaultDelegate$4(C14472a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float a = C14478g.m31645a(valueAnimator);
        C14472a aVar = this.this$0;
        aVar.mo111598b(((float) aVar.f44503B) - (a * ((float) (this.this$0.f44503B - this.this$0.f44502A))));
        float currentPlayTime = ((float) valueAnimator.getCurrentPlayTime()) / ((float) valueAnimator.getDuration());
        if (this.this$0.f44527x.length > 1 && currentPlayTime > 0.7f) {
            this.this$0.f44508G.getCurrentPaint().setColor(((Integer) C14472a.f44496c.evaluate((currentPlayTime - 0.7f) / 0.3f, Integer.valueOf(this.this$0.f44518o), Integer.valueOf(this.this$0.f44527x[(this.this$0.f44519p + 1) % this.this$0.f44527x.length]))).intValue());
        }
    }
}
