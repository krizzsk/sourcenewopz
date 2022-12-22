package com.didi.entrega.bill.datastore.p110op;

import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/entrega/bill/datastore/op/EntityOperation;", "T", "", "()V", "operate", "repo", "Lcom/didi/entrega/bill/datastore/BillRepo;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "(Lcom/didi/entrega/bill/datastore/BillRepo;Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;)Ljava/lang/Object;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.entrega.bill.datastore.op.EntityOperation */
/* compiled from: Operation.kt */
public abstract class EntityOperation<T> {
    public abstract T operate(BillRepo billRepo, BillEntity billEntity);
}
