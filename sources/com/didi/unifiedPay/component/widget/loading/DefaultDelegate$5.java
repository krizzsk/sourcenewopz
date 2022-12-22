package com.didi.unifiedPay.component.widget.loading;

import android.animation.Animator;

class DefaultDelegate$5 extends C14477f {
    final /* synthetic */ C14472a this$0;

    DefaultDelegate$5(C14472a aVar) {
        this.this$0 = aVar;
    }

    /* access modifiers changed from: protected */
    public void onPreAnimationEnd(Animator animator) {
        if (isStartedAndNotCancelled()) {
            this.this$0.m31623h();
            C14472a aVar = this.this$0;
            int unused = aVar.f44519p = (aVar.f44519p + 1) % this.this$0.f44527x.length;
            C14472a aVar2 = this.this$0;
            int unused2 = aVar2.f44518o = aVar2.f44527x[this.this$0.f44519p];
            this.this$0.f44508G.getCurrentPaint().setColor(this.this$0.f44518o);
            this.this$0.f44512i.start();
        }
    }
}
