package com.didi.global.fintech.cashier.core.interceptor;

import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/interceptor/ResultRouterAdapter;", "Lcom/didi/global/fintech/cashier/core/interceptor/BaseRouterAdapter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "data", "(Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;)V", "open", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RouterOpenInterceptor.kt */
public final class ResultRouterAdapter extends BaseRouterAdapter<PayStatusResponse> {
    public ResultRouterAdapter(PayStatusResponse payStatusResponse) {
        super(payStatusResponse, "GlobalCashier://core/result");
    }

    public boolean open() {
        PayStatusResponse payStatusResponse = (PayStatusResponse) getData();
        if (payStatusResponse == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) payStatusResponse.getShowResultPage(), (Object) true);
    }
}
