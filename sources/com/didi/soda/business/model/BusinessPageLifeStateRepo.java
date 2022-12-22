package com.didi.soda.business.model;

import com.didi.app.nova.skeleton.repo.Repo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/business/model/BusinessPageLifeStateRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/business/model/BusinessPageLifeState;", "()V", "getValue", "setState", "", "state", "", "setValue", "businessPageLifeState", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessPageLifeStateRepo.kt */
public final class BusinessPageLifeStateRepo extends Repo<BusinessPageLifeState> {
    public BusinessPageLifeState getValue() {
        Object value = super.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "super.getValue()");
        return (BusinessPageLifeState) value;
    }

    public void setValue(BusinessPageLifeState businessPageLifeState) {
        Intrinsics.checkNotNullParameter(businessPageLifeState, "businessPageLifeState");
        super.setValue(businessPageLifeState);
    }

    public final void setState(int i) {
        setValue(new BusinessPageLifeState(i));
    }
}
