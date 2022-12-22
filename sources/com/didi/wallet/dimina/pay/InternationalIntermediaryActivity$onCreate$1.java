package com.didi.wallet.dimina.pay;

import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/wallet/dimina/pay/InternationalIntermediaryActivity$onCreate$1", "Lcom/didi/global/fintech/cashier/user/facade/CashierLaunchListener;", "onCashierLaunch", "", "result", "", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InternationalIntermediaryActivity.kt */
public final class InternationalIntermediaryActivity$onCreate$1 implements CashierLaunchListener {
    final /* synthetic */ InternationalIntermediaryActivity this$0;

    InternationalIntermediaryActivity$onCreate$1(InternationalIntermediaryActivity internationalIntermediaryActivity) {
        this.this$0 = internationalIntermediaryActivity;
    }

    public void onCashierLaunch(boolean z) {
        if (!z) {
            this.this$0.m32450a();
        }
    }
}
