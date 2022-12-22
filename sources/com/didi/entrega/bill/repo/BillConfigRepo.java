package com.didi.entrega.bill.repo;

import com.didi.app.nova.skeleton.repo.Repo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/bill/repo/BillConfigRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/entrega/bill/repo/BillConfig;", "()V", "getValue", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillConfigRepo.kt */
public final class BillConfigRepo extends Repo<BillConfig> {
    public BillConfig getValue() {
        if (super.getValue() == null) {
            return new BillConfig();
        }
        Object value = super.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "super.getValue()");
        return (BillConfig) value;
    }
}
