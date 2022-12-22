package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/IsValidationEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "fullNameSwitch", "", "getFullNameSwitch", "()I", "setFullNameSwitch", "(I)V", "isShowCpfValidation", "setShowCpfValidation", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IsValidationEntity.kt */
public final class IsValidationEntity implements IEntity {
    private int fullNameSwitch;
    private int isShowCpfValidation;

    public final int isShowCpfValidation() {
        return this.isShowCpfValidation;
    }

    public final void setShowCpfValidation(int i) {
        this.isShowCpfValidation = i;
    }

    public final int getFullNameSwitch() {
        return this.fullNameSwitch;
    }

    public final void setFullNameSwitch(int i) {
        this.fullNameSwitch = i;
    }
}
