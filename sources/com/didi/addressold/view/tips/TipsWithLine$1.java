package com.didi.addressold.view.tips;

import android.view.ViewTreeObserver;

class TipsWithLine$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ C3538c this$0;

    TipsWithLine$1(C3538c cVar) {
        this.this$0 = cVar;
    }

    public void onGlobalLayout() {
        if (this.this$0.f8030l) {
            this.this$0.m5207d();
        } else if (!this.this$0.f8032n && this.this$0.f8038t != null && !this.this$0.f8030l) {
            this.this$0.m5208e();
            boolean unused = this.this$0.f8031m = false;
        }
    }
}
