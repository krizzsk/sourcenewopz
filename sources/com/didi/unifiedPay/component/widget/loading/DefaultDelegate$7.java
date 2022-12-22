package com.didi.unifiedPay.component.widget.loading;

import android.animation.Animator;
import com.didi.unifiedPay.component.widget.loading.CircularProgressDrawable;

class DefaultDelegate$7 extends C14477f {
    final /* synthetic */ C14472a this$0;

    DefaultDelegate$7(C14472a aVar) {
        this.this$0 = aVar;
    }

    public void onPreAnimationEnd(Animator animator) {
        this.this$0.f44515l.removeListener(this);
        CircularProgressDrawable.OnEndListener m = this.this$0.f44509H;
        CircularProgressDrawable.OnEndListener unused = this.this$0.f44509H = null;
        if (isStartedAndNotCancelled()) {
            this.this$0.m31614d(0.0f);
            this.this$0.f44508G.stop();
            if (m != null) {
                m.onEnd(this.this$0.f44508G);
            }
        }
    }
}
