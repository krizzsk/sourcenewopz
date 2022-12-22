package com.didi.sdk.view.tips;

import android.os.CountDownTimer;

class TipsWithLine$5 extends CountDownTimer {
    final /* synthetic */ C13276c this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TipsWithLine$5(C13276c cVar, long j, long j2) {
        super(j, j2);
        this.this$0 = cVar;
    }

    public void onTick(long j) {
        if (this.this$0.f38276a != null) {
            C13276c cVar = this.this$0;
            cVar.m27064b("" + (j / 1000));
        }
    }

    public void onFinish() {
        this.this$0.m27064b("0");
        this.this$0.mo97888b();
    }
}
