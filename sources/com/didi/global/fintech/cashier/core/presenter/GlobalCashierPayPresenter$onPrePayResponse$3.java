package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.core.api.ICashierPrepayProcessor;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import com.didi.global.fintech.cashier.model.strategy.SyncStatusStrategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPayPresenter.kt */
final class GlobalCashierPayPresenter$onPrePayResponse$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PrepayResponse $response;
    final /* synthetic */ GlobalCashierPayPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPayPresenter$onPrePayResponse$3(GlobalCashierPayPresenter globalCashierPayPresenter, PrepayResponse prepayResponse) {
        super(0);
        this.this$0 = globalCashierPayPresenter;
        this.$response = prepayResponse;
    }

    public final void invoke() {
        ICashierPrepayProcessor iCashierPrepayProcessor = (ICashierPrepayProcessor) this.this$0.m15739a(ICashierPrepayProcessor.class);
        if (iCashierPrepayProcessor != null) {
            iCashierPrepayProcessor.onPrePaySuccess(this.$response);
        }
        GlobalCashierPayPresenter globalCashierPayPresenter = this.this$0;
        if (!Intrinsics.areEqual((Object) this.$response.getNeedPollingResult(), (Object) true)) {
            globalCashierPayPresenter = null;
        }
        if (globalCashierPayPresenter != null) {
            PrepayResponse prepayResponse = this.$response;
            Integer pollingTimes = prepayResponse.getPollingTimes();
            int intValue = pollingTimes == null ? 10 : pollingTimes.intValue();
            Integer pollingFrequency = prepayResponse.getPollingFrequency();
            globalCashierPayPresenter.startSyncPayResult(new SyncStatusStrategy(intValue, pollingFrequency == null ? 3 : pollingFrequency.intValue(), SyncStatusStrategy.Companion.getNormal()));
        }
    }
}
