package com.didi.entrega.billmap.datasore;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.bill.datastore.p110op.EntityOperation;
import com.didi.entrega.billmap.model.BillMapInfoModel;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.ReceiverPoi;
import com.didi.entrega.customer.foundation.rpc.entity.SenderPoi;
import com.didi.entrega.customer.foundation.rpc.entity.TopMapInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/billmap/datasore/BillMapInfoOperation;", "Lcom/didi/entrega/bill/datastore/op/EntityOperation;", "Lcom/didi/entrega/billmap/model/BillMapInfoModel;", "context", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "getContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "operate", "repo", "Lcom/didi/entrega/bill/datastore/BillRepo;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillMapInfoOperation.kt */
public final class BillMapInfoOperation extends EntityOperation<BillMapInfoModel> {

    /* renamed from: a */
    private final ScopeContext f19624a;

    public BillMapInfoOperation(ScopeContext scopeContext) {
        this.f19624a = scopeContext;
    }

    public final ScopeContext getContext() {
        return this.f19624a;
    }

    public BillMapInfoModel operate(BillRepo billRepo, BillEntity billEntity) {
        ReceiverPoi receiverPoi;
        SenderPoi senderPoi;
        Intrinsics.checkNotNullParameter(billRepo, "repo");
        Intrinsics.checkNotNullParameter(billEntity, "entity");
        BillMapInfoModel billMapInfoModel = new BillMapInfoModel();
        TopMapInfo topMapInfo = billEntity.getTopMapInfo();
        if (!(topMapInfo == null || (senderPoi = topMapInfo.getSenderPoi()) == null)) {
            billMapInfoModel.setSenderLatLng(new LatLng(senderPoi.getLat(), senderPoi.getLng()));
            billMapInfoModel.setSenderDisplayName(senderPoi.getDisplayName());
        }
        TopMapInfo topMapInfo2 = billEntity.getTopMapInfo();
        if (!(topMapInfo2 == null || (receiverPoi = topMapInfo2.getReceiverPoi()) == null)) {
            billMapInfoModel.setReceiverLatLng(new LatLng(receiverPoi.getLat(), receiverPoi.getLng()));
            billMapInfoModel.setReceiverDisplayName(receiverPoi.getDisplayName());
        }
        TopMapInfo topMapInfo3 = billEntity.getTopMapInfo();
        billMapInfoModel.setEtaTips(topMapInfo3 == null ? null : topMapInfo3.getEtaTips());
        return billMapInfoModel;
    }
}
