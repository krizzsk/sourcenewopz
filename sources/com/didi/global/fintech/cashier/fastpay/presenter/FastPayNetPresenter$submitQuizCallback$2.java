package com.didi.global.fintech.cashier.fastpay.presenter;

import com.didi.global.fintech.cashier.fastpay.contract.IFastPayNetPresenter;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPaySubmitQuizResponse;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPaySubmitQuizResponse;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayNetPresenter.kt */
final class FastPayNetPresenter$submitQuizCallback$2 extends Lambda implements Function0<CashierNetCallback<FastPaySubmitQuizResponse>> {
    final /* synthetic */ FastPayNetPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FastPayNetPresenter$submitQuizCallback$2(FastPayNetPresenter fastPayNetPresenter) {
        super(0);
        this.this$0 = fastPayNetPresenter;
    }

    public final CashierNetCallback<FastPaySubmitQuizResponse> invoke() {
        FastPayNetPresenter fastPayNetPresenter = this.this$0;
        return fastPayNetPresenter.m15781a(new Function1<FastPaySubmitQuizResponse, Unit>(fastPayNetPresenter) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FastPaySubmitQuizResponse) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(FastPaySubmitQuizResponse fastPaySubmitQuizResponse) {
                Intrinsics.checkNotNullParameter(fastPaySubmitQuizResponse, "p0");
                ((FastPayNetPresenter) this.receiver).onSubmitQuizResponse(fastPaySubmitQuizResponse);
            }
        }, IFastPayNetPresenter.API.SUBMIT_QUIZ);
    }
}
