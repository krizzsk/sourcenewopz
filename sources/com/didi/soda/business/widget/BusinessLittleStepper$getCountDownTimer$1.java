package com.didi.soda.business.widget;

import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/business/widget/BusinessLittleStepper$getCountDownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "l", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessLittleStepper.kt */
public final class BusinessLittleStepper$getCountDownTimer$1 extends CountDownTimer {
    final /* synthetic */ BusinessLittleStepper this$0;

    public void onTick(long j) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessLittleStepper$getCountDownTimer$1(BusinessLittleStepper businessLittleStepper, long j, long j2) {
        super(j, j2);
        this.this$0 = businessLittleStepper;
    }

    public void onFinish() {
        this.this$0.recovery();
    }
}
