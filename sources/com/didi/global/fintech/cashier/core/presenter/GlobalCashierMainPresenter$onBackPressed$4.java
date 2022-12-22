package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.p117ui.kts.ContextKtxKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierMainPresenter.kt */
final class GlobalCashierMainPresenter$onBackPressed$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GlobalCashierMainPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierMainPresenter$onBackPressed$4(GlobalCashierMainPresenter globalCashierMainPresenter) {
        super(0);
        this.this$0 = globalCashierMainPresenter;
    }

    public final void invoke() {
        GlobalCashierMainPresenter globalCashierMainPresenter = this.this$0;
        globalCashierMainPresenter.omegaCheckoutReturnPopupCk(ContextKtxKt.string(globalCashierMainPresenter.getContext(), R.string.GRider_notify_Continue_to_huzG));
    }
}
