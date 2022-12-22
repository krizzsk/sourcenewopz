package com.didi.entrega.bill.datastore;

import com.didi.entrega.bill.model.RequestFlowModel;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo175977d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\f"}, mo175978d2 = {"com/didi/entrega/bill/datastore/BillRepo$buildCallback$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "var2", "", "requestEnd", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillRepo.kt */
public final class BillRepo$buildCallback$1 extends CustomerRpcCallback<BillEntity> {
    final /* synthetic */ BillRequest $request;
    final /* synthetic */ BillRepo this$0;

    BillRepo$buildCallback$1(BillRepo billRepo, BillRequest billRequest) {
        this.this$0 = billRepo;
        this.$request = billRequest;
    }

    public void onRpcSuccess(BillEntity billEntity, long j) {
        if (billEntity != null) {
            this.this$0.m14601a(this.$request.getRequestName(), billEntity);
            List arrayList = new ArrayList();
            BillRepo billRepo = this.this$0;
            for (C7998a aVar : this.this$0.f19497c) {
                aVar.mo59343a(billRepo, billEntity);
                arrayList.add(Integer.valueOf(aVar.mo59346c()));
            }
            this.this$0.setValue(arrayList);
            requestEnd$default(this, (SFRpcException) null, 1, (Object) null);
            return;
        }
        requestEnd(new SFRpcException(-1, ""));
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        requestEnd(sFRpcException);
    }

    public static /* synthetic */ void requestEnd$default(BillRepo$buildCallback$1 billRepo$buildCallback$1, SFRpcException sFRpcException, int i, Object obj) {
        if ((i & 1) != 0) {
            sFRpcException = null;
        }
        billRepo$buildCallback$1.requestEnd(sFRpcException);
    }

    public final void requestEnd(SFRpcException sFRpcException) {
        C7998a access$getFlowOp$p = this.this$0.f19498d;
        if (access$getFlowOp$p != null) {
            BillRequest billRequest = this.$request;
            BillRepo billRepo = this.this$0;
            access$getFlowOp$p.mo59344a(new RequestFlowModel(billRequest, 2, sFRpcException));
            billRepo.setValue(CollectionsKt.listOf(Integer.valueOf(access$getFlowOp$p.mo59346c())));
        }
    }
}
