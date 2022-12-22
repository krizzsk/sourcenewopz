package com.didiglobal.travel.biz.ride.trip;

import androidx.core.util.Supplier;
import com.didiglobal.travel.biz.ride.strategy.WaitRspBehaviorStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didiglobal/travel/biz/ride/strategy/WaitRspBehaviorStrategy;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TripBehaviorController.kt */
final class TripBehaviorController$getOrPutRspBehavior$2$1 extends Lambda implements Function0<WaitRspBehaviorStrategy> {
    final /* synthetic */ Supplier<WaitRspBehaviorStrategy> $supplier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TripBehaviorController$getOrPutRspBehavior$2$1(Supplier<WaitRspBehaviorStrategy> supplier) {
        super(0);
        this.$supplier = supplier;
    }

    public final WaitRspBehaviorStrategy invoke() {
        WaitRspBehaviorStrategy waitRspBehaviorStrategy = this.$supplier.get();
        Intrinsics.checkNotNullExpressionValue(waitRspBehaviorStrategy, "supplier.get()");
        return waitRspBehaviorStrategy;
    }
}
