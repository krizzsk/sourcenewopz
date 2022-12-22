package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierNetPresenter.kt */
final class GlobalCashierNetPresenter$payStatusCallback$2 extends Lambda implements Function0<CashierNetCallback<PayStatusResponse>> {
    final /* synthetic */ GlobalCashierNetPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierNetPresenter$payStatusCallback$2(GlobalCashierNetPresenter globalCashierNetPresenter) {
        super(0);
        this.this$0 = globalCashierNetPresenter;
    }

    public final CashierNetCallback<PayStatusResponse> invoke() {
        GlobalCashierNetPresenter globalCashierNetPresenter = this.this$0;
        return globalCashierNetPresenter.m15729a(new Function1<PayStatusResponse, Unit>(globalCashierNetPresenter) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PayStatusResponse) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PayStatusResponse payStatusResponse) {
                Intrinsics.checkNotNullParameter(payStatusResponse, "p0");
                ((GlobalCashierNetPresenter) this.receiver).onPayStatusResponse(payStatusResponse);
            }
        }, IGlobalCashierNetPresenter.API.GET_PAY_STATUS);
    }
}
