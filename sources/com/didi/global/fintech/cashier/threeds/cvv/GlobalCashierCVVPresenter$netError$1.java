package com.didi.global.fintech.cashier.threeds.cvv;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVPresenter.kt */
final class GlobalCashierCVVPresenter$netError$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GlobalCashierCVVPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierCVVPresenter$netError$1(GlobalCashierCVVPresenter globalCashierCVVPresenter) {
        super(0);
        this.this$0 = globalCashierCVVPresenter;
    }

    public final void invoke() {
        GlobalCashierCVVPresenter globalCashierCVVPresenter = this.this$0;
        globalCashierCVVPresenter.requestCVVInfo(globalCashierCVVPresenter.f21668c);
    }
}
