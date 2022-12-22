package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierNetPresenter.kt */
final class GlobalCashierNetPresenter$changePayInfoCallback$2 extends Lambda implements Function0<CashierNetCallback<PayInfoResponse>> {
    final /* synthetic */ GlobalCashierNetPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierNetPresenter$changePayInfoCallback$2(GlobalCashierNetPresenter globalCashierNetPresenter) {
        super(0);
        this.this$0 = globalCashierNetPresenter;
    }

    public final CashierNetCallback<PayInfoResponse> invoke() {
        GlobalCashierNetPresenter globalCashierNetPresenter = this.this$0;
        return globalCashierNetPresenter.m15730a(new Function2<PayInfoResponse, IGlobalCashierNetPresenter.API, Unit>(globalCashierNetPresenter) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PayInfoResponse) obj, (IGlobalCashierNetPresenter.API) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api) {
                Intrinsics.checkNotNullParameter(payInfoResponse, "p0");
                Intrinsics.checkNotNullParameter(api, "p1");
                ((GlobalCashierNetPresenter) this.receiver).onPayInfoResponse(payInfoResponse, api);
            }
        }, IGlobalCashierNetPresenter.API.CHANGE_PAY_INFO);
    }
}
