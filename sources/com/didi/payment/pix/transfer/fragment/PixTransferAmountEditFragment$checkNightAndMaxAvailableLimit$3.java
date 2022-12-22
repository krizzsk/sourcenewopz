package com.didi.payment.pix.transfer.fragment;

import com.didi.payment.base.tracker.PayTracker;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
final class PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$3(long j) {
        super(0);
        this.$value = j;
    }

    public final void invoke() {
        Map hashMap = new HashMap();
        hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, "pix_transfer_page_id");
        hashMap.put("beyond_limit_amount", Long.valueOf(this.$value));
        PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_pix_page_bt", hashMap);
    }
}
