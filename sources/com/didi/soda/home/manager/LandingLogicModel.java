package com.didi.soda.home.manager;

import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import com.didi.soda.customer.repo.model.LogicBaseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/home/manager/LandingLogicModel;", "Lcom/didi/soda/customer/repo/model/LogicBaseModel;", "type", "", "(Ljava/lang/String;)V", "tabInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "getTabInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "setTabInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LandingLogicRepo.kt */
public final class LandingLogicModel extends LogicBaseModel {

    /* renamed from: a */
    private TabInfoEntity f42681a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LandingLogicModel(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public final TabInfoEntity getTabInfo() {
        return this.f42681a;
    }

    public final void setTabInfo(TabInfoEntity tabInfoEntity) {
        this.f42681a = tabInfoEntity;
    }
}
