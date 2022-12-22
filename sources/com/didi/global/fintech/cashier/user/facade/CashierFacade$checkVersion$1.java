package com.didi.global.fintech.cashier.user.facade;

import com.didi.global.fintech.cashier.user.spi.IGlobalCashierProcessor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/global/fintech/cashier/user/facade/CashierFacade$checkVersion$1", "Lcom/didi/global/fintech/cashier/user/spi/IGlobalCashierProcessor$Callback;", "onResult", "", "result", "", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierFacade.kt */
public final class CashierFacade$checkVersion$1 implements IGlobalCashierProcessor.Callback {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ CashierFacade this$0;

    CashierFacade$checkVersion$1(CashierFacade cashierFacade, Function1<? super Boolean, Unit> function1) {
        this.this$0 = cashierFacade;
        this.$callback = function1;
    }

    public void onResult(boolean z) {
        IGlobalCashierProcessor access$getCashierProcessor$p = this.this$0.f22022b;
        if (access$getCashierProcessor$p != null) {
            access$getCashierProcessor$p.dismissLoading();
        }
        this.$callback.invoke(Boolean.valueOf(z));
    }
}
