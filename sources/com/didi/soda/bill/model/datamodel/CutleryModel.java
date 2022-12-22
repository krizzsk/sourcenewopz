package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.CutleryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/CutleryModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "isNeeded", "", "()Z", "setNeeded", "(Z)V", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CutleryModel.kt */
public final class CutleryModel extends ComponentAbsModel {

    /* renamed from: a */
    private boolean f39102a;

    public final boolean isNeeded() {
        return this.f39102a;
    }

    public final void setNeeded(boolean z) {
        this.f39102a = z;
    }

    public CutleryModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        CutleryEntity cutlery = billComponentDataEntity.getCutlery();
        if (cutlery != null) {
            boolean z = true;
            if (cutlery.isNeeded != 1) {
                z = false;
            }
            setNeeded(z);
        }
        return this;
    }
}
