package com.didi.payment.pix.transfer.fragment;

import com.didi.payment.base.tracker.FinOmegaSDK;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
final class PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PixTransferAmountEditFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$1(PixTransferAmountEditFragment pixTransferAmountEditFragment) {
        super(0);
        this.this$0 = pixTransferAmountEditFragment;
    }

    public final void invoke() {
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_amount_recharge_balance_ck", this.this$0.f31235a);
        this.this$0.gotoTopupBalance();
    }
}
