package com.didi.unifiedPay.component.widget.loading;

import android.animation.Animator;

class DefaultDelegate$3 extends C14477f {
    final /* synthetic */ C14472a this$0;

    DefaultDelegate$3(C14472a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        boolean unused = this.this$0.f44516m = true;
    }

    /* access modifiers changed from: protected */
    public void onPreAnimationEnd(Animator animator) {
        if (isStartedAndNotCancelled()) {
            boolean unused = this.this$0.f44524u = false;
            this.this$0.m31625i();
            this.this$0.f44513j.start();
        }
    }
}
