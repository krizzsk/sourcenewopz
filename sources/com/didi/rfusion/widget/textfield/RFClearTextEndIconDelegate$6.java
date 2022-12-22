package com.didi.rfusion.widget.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class RFClearTextEndIconDelegate$6 extends AnimatorListenerAdapter {
    final /* synthetic */ C11577a this$0;

    RFClearTextEndIconDelegate$6(C11577a aVar) {
        this.this$0 = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.f33886a.setClearIconVisible(false);
    }
}
