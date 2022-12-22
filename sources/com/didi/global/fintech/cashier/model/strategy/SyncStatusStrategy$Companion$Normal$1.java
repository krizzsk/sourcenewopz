package com.didi.global.fintech.cashier.model.strategy;

import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.strategy.BaseStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, mo175978d2 = {"<no name provided>", "Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy$Result;", "strategy", "Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "response", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SyncStatusStrategy.kt */
final class SyncStatusStrategy$Companion$Normal$1 extends Lambda implements Function2<SyncStatusStrategy, PayStatusResponse, BaseStrategy.Result> {
    public static final SyncStatusStrategy$Companion$Normal$1 INSTANCE = new SyncStatusStrategy$Companion$Normal$1();

    SyncStatusStrategy$Companion$Normal$1() {
        super(2);
    }

    public final BaseStrategy.Result invoke(SyncStatusStrategy syncStatusStrategy, PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(syncStatusStrategy, "strategy");
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
        syncStatusStrategy.setSyncTimes(syncStatusStrategy.getSyncTimes() - 1);
        if (Intrinsics.areEqual((Object) payStatusResponse.getPayStatus(), (Object) "success")) {
            return BaseStrategy.Result.SUCCESS;
        }
        if (syncStatusStrategy.getSyncTimes() <= 0 || Intrinsics.areEqual((Object) payStatusResponse.getPayStatus(), (Object) "failed")) {
            return BaseStrategy.Result.FAILED;
        }
        if (Intrinsics.areEqual((Object) payStatusResponse.getPayStatus(), (Object) "pending")) {
            return BaseStrategy.Result.CONTINUE;
        }
        return BaseStrategy.Result.CONTINUE;
    }
}
