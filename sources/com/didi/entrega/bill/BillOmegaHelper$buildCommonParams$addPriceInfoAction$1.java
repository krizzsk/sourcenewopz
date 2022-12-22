package com.didi.entrega.bill;

import com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillExtraData;
import com.didi.entrega.customer.foundation.rpc.entity.PriceInfo;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/entrega/customer/foundation/tracker/OmegaTracker$Builder;", "kotlin.jvm.PlatformType", "component", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillComponentEntity;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillOmegaHelper.kt */
final class BillOmegaHelper$buildCommonParams$addPriceInfoAction$1 extends Lambda implements Function1<BillComponentEntity, OmegaTracker.Builder> {
    final /* synthetic */ OmegaTracker.Builder $builder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillOmegaHelper$buildCommonParams$addPriceInfoAction$1(OmegaTracker.Builder builder) {
        super(1);
        this.$builder = builder;
    }

    public final OmegaTracker.Builder invoke(BillComponentEntity billComponentEntity) {
        Intrinsics.checkNotNullParameter(billComponentEntity, "component");
        BillExtraData data = billComponentEntity.getData();
        Integer num = null;
        PriceInfo priceInfo = data == null ? null : data.getPriceInfo();
        OmegaTracker.Builder builder = this.$builder;
        if (priceInfo != null) {
            num = Integer.valueOf(priceInfo.getPayPrice());
        }
        return builder.addEventParam(ParamConst.PARAM_ORI_PRICE, Integer.valueOf(BillExtKt.orZero(num)));
    }
}
