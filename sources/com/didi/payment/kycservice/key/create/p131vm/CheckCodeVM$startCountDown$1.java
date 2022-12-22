package com.didi.payment.kycservice.key.create.p131vm;

import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/payment/kycservice/key/create/vm/CheckCodeVM$startCountDown$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.kycservice.key.create.vm.CheckCodeVM$startCountDown$1 */
/* compiled from: CheckCodeVM.kt */
public final class CheckCodeVM$startCountDown$1 extends CountDownTimer {
    final /* synthetic */ CheckCodeVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckCodeVM$startCountDown$1(CheckCodeVM checkCodeVM) {
        super(60000, 1000);
        this.this$0 = checkCodeVM;
    }

    public void onTick(long j) {
        this.this$0.getLeftTimeLD().setValue(Long.valueOf(j / ((long) 1000)));
    }

    public void onFinish() {
        this.this$0.getLeftTimeLD().setValue(0L);
    }
}
