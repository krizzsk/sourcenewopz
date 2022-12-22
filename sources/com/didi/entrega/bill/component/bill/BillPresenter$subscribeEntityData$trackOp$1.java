package com.didi.entrega.bill.component.bill;

import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.bill.datastore.p110op.EntityOperation;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/entrega/bill/component/bill/BillPresenter$subscribeEntityData$trackOp$1", "Lcom/didi/entrega/bill/datastore/op/EntityOperation;", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "operate", "repo", "Lcom/didi/entrega/bill/datastore/BillRepo;", "entity", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillPresenter.kt */
public final class BillPresenter$subscribeEntityData$trackOp$1 extends EntityOperation<BillEntity> {
    public BillEntity operate(BillRepo billRepo, BillEntity billEntity) {
        Intrinsics.checkNotNullParameter(billRepo, "repo");
        Intrinsics.checkNotNullParameter(billEntity, "entity");
        return billEntity;
    }

    BillPresenter$subscribeEntityData$trackOp$1() {
    }
}
