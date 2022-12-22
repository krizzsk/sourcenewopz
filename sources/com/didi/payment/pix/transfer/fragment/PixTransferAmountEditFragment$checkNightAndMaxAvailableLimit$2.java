package com.didi.payment.pix.transfer.fragment;

import android.content.Context;
import android.content.Intent;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
final class PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PixTransferAmountEditFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$2(PixTransferAmountEditFragment pixTransferAmountEditFragment) {
        super(0);
        this.this$0 = pixTransferAmountEditFragment;
    }

    public final void invoke() {
        Map hashMap = new HashMap();
        hashMap.put(OmegaUtilKt.ENTRANCE_PAGE_ID, "pix_transfer_page_id");
        hashMap.put("beyond_limit_amount", String.valueOf(this.this$0.getAmountInputEt().getText()));
        PayTracker.getTracker().trackEvent("ibt_cash_out_limit_setting_pix_page_ck", hashMap);
        GetNightlyLimitResp.NightlyLimitVo value = PixTransferAmountEditFragment.access$getVm(this.this$0).getNightlyLimitVo().getValue();
        CharSequence charSequence = value == null ? null : value.effectiveTime;
        if (charSequence == null || charSequence.length() == 0) {
            Context requireContext = this.this$0.requireContext();
            final PixTransferAmountEditFragment pixTransferAmountEditFragment = this.this$0;
            ((Request) DRouter.build("99pay://one/nightly_limit_setting").putExtra("pageFrom", "pix_transfer_page_id")).start(requireContext, new RouterCallback.ActivityCallback() {
                public void onActivityResult(int i, Intent intent) {
                    if (i == -1) {
                        PixTransferAmountEditFragment.access$getVm(pixTransferAmountEditFragment).loadData();
                    }
                }
            });
            return;
        }
        DRouter.build("99pay://one/nightly_limit_result").start(this.this$0.requireContext());
    }
}
