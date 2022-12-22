package com.didi.sdk.view.tips;

import android.view.ViewTreeObserver;

class TipsWithLine$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ C13276c this$0;

    TipsWithLine$1(C13276c cVar) {
        this.this$0 = cVar;
    }

    public void onGlobalLayout() {
        if (this.this$0.f38287l) {
            this.this$0.m27071d();
        } else if (!this.this$0.f38289n && this.this$0.f38295t != null && !this.this$0.f38287l) {
            this.this$0.m27072e();
            boolean unused = this.this$0.f38288m = false;
        }
    }
}
