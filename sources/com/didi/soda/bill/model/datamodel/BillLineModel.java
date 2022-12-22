package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillLineInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/BillLineModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "downGap", "", "getDownGap", "()I", "setDownGap", "(I)V", "upGap", "getUpGap", "setUpGap", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillLineModel.kt */
public final class BillLineModel extends ComponentAbsModel {

    /* renamed from: a */
    private int f39095a;

    /* renamed from: b */
    private int f39096b;

    /* renamed from: c */
    private String f39097c;

    public final int getUpGap() {
        return this.f39095a;
    }

    public final void setUpGap(int i) {
        this.f39095a = i;
    }

    public final int getDownGap() {
        return this.f39096b;
    }

    public final void setDownGap(int i) {
        this.f39096b = i;
    }

    public final String getColor() {
        return this.f39097c;
    }

    public final void setColor(String str) {
        this.f39097c = str;
    }

    public BillLineModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        BillLineInfoEntity lineInfo = billComponentDataEntity.getLineInfo();
        if (lineInfo != null) {
            setUpGap(lineInfo.getUpGap());
            setDownGap(lineInfo.getDownGap());
            setColor(lineInfo.getColor());
        }
        return this;
    }
}
