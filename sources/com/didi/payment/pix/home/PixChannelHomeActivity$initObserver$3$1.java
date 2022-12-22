package com.didi.payment.pix.home;

import com.didi.payment.kycservice.utils.KycRegisterUtils;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/payment/pix/home/PixChannelHomeActivity$initObserver$3$1", "Lcom/didi/payment/kycservice/utils/KycRegisterUtils$RouterListener;", "callback", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixChannelHomeActivity.kt */
public final class PixChannelHomeActivity$initObserver$3$1 implements KycRegisterUtils.RouterListener {
    final /* synthetic */ PixChannelHomeActivity this$0;

    PixChannelHomeActivity$initObserver$3$1(PixChannelHomeActivity pixChannelHomeActivity) {
        this.this$0 = pixChannelHomeActivity;
    }

    public void callback() {
        PixChannelHomeActivity.access$getVm(this.this$0).refreshData(true);
    }
}
