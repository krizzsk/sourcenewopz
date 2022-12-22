package com.didi.entrega.bill.component.bill;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.bill.model.RequestFlowModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/bill/component/bill/BillPresenter$subscribeRequestFlowChanged$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/entrega/bill/model/RequestFlowModel;", "call", "", "flow", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillPresenter.kt */
public final class BillPresenter$subscribeRequestFlowChanged$1 implements Action1<RequestFlowModel> {
    final /* synthetic */ BillPresenter this$0;

    BillPresenter$subscribeRequestFlowChanged$1(BillPresenter billPresenter) {
        this.this$0 = billPresenter;
    }

    public void call(RequestFlowModel requestFlowModel) {
        if (requestFlowModel != null) {
            this.this$0.m14579a(requestFlowModel);
        }
    }
}
