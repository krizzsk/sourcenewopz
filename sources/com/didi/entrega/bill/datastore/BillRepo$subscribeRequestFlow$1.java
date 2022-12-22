package com.didi.entrega.bill.datastore;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.bill.model.RequestFlowModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/entrega/bill/datastore/BillRepo$subscribeRequestFlow$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "", "", "call", "", "t", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillRepo.kt */
public final class BillRepo$subscribeRequestFlow$1 implements Action1<List<? extends Integer>> {
    final /* synthetic */ Action1<RequestFlowModel> $action;
    final /* synthetic */ C7998a<RequestFlowModel> $opModel;

    BillRepo$subscribeRequestFlow$1(C7998a<RequestFlowModel> aVar, Action1<RequestFlowModel> action1) {
        this.$opModel = aVar;
        this.$action = action1;
    }

    public void call(List<Integer> list) {
        boolean z = false;
        if (list != null && list.contains(Integer.valueOf(this.$opModel.mo59346c()))) {
            z = true;
        }
        if (z) {
            this.$action.call(this.$opModel.mo59345b());
        }
    }
}
