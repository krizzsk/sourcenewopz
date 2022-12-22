package com.didi.global.fintech.cashier.model.strategy;

import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.strategy.BaseStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, mo175978d2 = {"<no name provided>", "Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy$Result;", "strategy", "Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "response", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayInfoStrategy.kt */
final class PayInfoStrategy$Companion$Pix$1 extends Lambda implements Function2<PayInfoStrategy, PayInfoResponse, BaseStrategy.Result> {
    public static final PayInfoStrategy$Companion$Pix$1 INSTANCE = new PayInfoStrategy$Companion$Pix$1();

    PayInfoStrategy$Companion$Pix$1() {
        super(2);
    }

    public final BaseStrategy.Result invoke(PayInfoStrategy payInfoStrategy, PayInfoResponse payInfoResponse) {
        Intrinsics.checkNotNullParameter(payInfoStrategy, "strategy");
        Intrinsics.checkNotNullParameter(payInfoResponse, "response");
        payInfoStrategy.setSyncTimes(payInfoStrategy.getSyncTimes() - 1);
        if (payInfoResponse.pix()) {
            return BaseStrategy.Result.SUCCESS;
        }
        if (payInfoStrategy.getSyncTimes() <= 0) {
            return BaseStrategy.Result.FAILED;
        }
        return BaseStrategy.Result.CONTINUE;
    }
}
