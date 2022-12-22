package com.didi.entrega.bill.datastore;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.bill.datastore.p110op.EntityOperation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/entrega/bill/datastore/BillRepo$subscribe$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "", "", "call", "", "t", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillRepo.kt */
public final class BillRepo$subscribe$1 implements Action1<List<? extends Integer>> {
    final /* synthetic */ Action1<T> $action;
    final /* synthetic */ int $key;
    final /* synthetic */ EntityOperation<T> $op;
    final /* synthetic */ BillRepo this$0;

    BillRepo$subscribe$1(int i, BillRepo billRepo, Action1<T> action1, EntityOperation<T> entityOperation) {
        this.$key = i;
        this.this$0 = billRepo;
        this.$action = action1;
        this.$op = entityOperation;
    }

    public void call(List<Integer> list) {
        Object obj;
        Object obj2;
        boolean z = false;
        if (list != null && list.contains(Integer.valueOf(this.$key))) {
            z = true;
        }
        if (z) {
            EntityOperation<T> entityOperation = this.$op;
            Iterator it = this.this$0.f19497c.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (Intrinsics.areEqual((Object) ((C7998a) obj2).mo59342a(), (Object) entityOperation)) {
                    break;
                }
            }
            C7998a aVar = obj2 instanceof C7998a ? (C7998a) obj2 : null;
            Action1<T> action1 = this.$action;
            if (aVar != null) {
                obj = aVar.mo59345b();
            }
            action1.call(obj);
        }
    }
}
