package com.didi.soda.bill.repo;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/bill/repo/BillMessageRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "clearMessages", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillMessageRepo.kt */
public final class BillMessageRepo extends Repo<IEntity> {
    public final void clearMessages() {
        setValue(null);
    }
}
