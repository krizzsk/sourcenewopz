package com.didi.payment.pix.refund.p140vm;

import android.os.CountDownTimer;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/payment/pix/refund/vm/PixOrderRefundDetailVM$loopQueryOrderDetail$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.pix.refund.vm.PixOrderRefundDetailVM$loopQueryOrderDetail$1 */
/* compiled from: PixOrderRefundDetailVM.kt */
public final class PixOrderRefundDetailVM$loopQueryOrderDetail$1 extends CountDownTimer {
    final /* synthetic */ String $orderId;
    final /* synthetic */ PixOrderRefundDetailVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PixOrderRefundDetailVM$loopQueryOrderDetail$1(PixOrderRefundDetailVM pixOrderRefundDetailVM, String str, long j, long j2) {
        super(j, j2);
        this.this$0 = pixOrderRefundDetailVM;
        this.$orderId = str;
    }

    public void onTick(long j) {
        SystemUtils.log(3, "hgl", Intrinsics.stringPlus("onTick query refund detail...", Long.valueOf(j)), (Throwable) null, "com.didi.payment.pix.refund.vm.PixOrderRefundDetailVM$loopQueryOrderDetail$1", 107);
        this.this$0.queryOrderDetail(this.$orderId, false);
    }

    public void onFinish() {
        this.this$0.queryOrderDetail(this.$orderId, true);
    }
}
