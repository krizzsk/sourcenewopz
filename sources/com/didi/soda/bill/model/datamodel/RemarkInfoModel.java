package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.RemarkInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/RemarkInfoModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "disableRemark", "", "getDisableRemark", "()Ljava/lang/String;", "setDisableRemark", "(Ljava/lang/String;)V", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RemarkInfoModel.kt */
public final class RemarkInfoModel extends ComponentAbsModel {

    /* renamed from: a */
    private String f39130a = "";

    public final String getDisableRemark() {
        return this.f39130a;
    }

    public final void setDisableRemark(String str) {
        this.f39130a = str;
    }

    public RemarkInfoModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        RemarkInfoEntity remarkInfo = billComponentDataEntity.getRemarkInfo();
        if (remarkInfo == null) {
            return null;
        }
        RemarkInfoModel remarkInfoModel = new RemarkInfoModel();
        remarkInfoModel.setDisableRemark(remarkInfo.getDisableRemark());
        return remarkInfoModel;
    }
}
