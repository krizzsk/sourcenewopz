package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.TitleInfoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/TitleInfoModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "leftHintColor", "", "", "getLeftHintColor", "()Ljava/util/List;", "setLeftHintColor", "(Ljava/util/List;)V", "leftPicUrl", "getLeftPicUrl", "()Ljava/lang/String;", "setLeftPicUrl", "(Ljava/lang/String;)V", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TitleInfoModel.kt */
public final class TitleInfoModel extends ComponentAbsModel {

    /* renamed from: a */
    private List<String> f39140a;

    /* renamed from: b */
    private String f39141b;

    public final List<String> getLeftHintColor() {
        return this.f39140a;
    }

    public final void setLeftHintColor(List<String> list) {
        this.f39140a = list;
    }

    public final String getLeftPicUrl() {
        return this.f39141b;
    }

    public final void setLeftPicUrl(String str) {
        this.f39141b = str;
    }

    public TitleInfoModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        TitleInfoEntity titleInfo = billComponentDataEntity.getTitleInfo();
        if (titleInfo != null) {
            setLeftHintColor(titleInfo.getLeftHintColor());
            setLeftPicUrl(titleInfo.getLeftPicUrl());
        }
        return this;
    }
}
