package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/CPFInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "status", "", "getStatus", "()I", "setStatus", "(I)V", "statusDesc", "", "getStatusDesc", "()Ljava/lang/String;", "setStatusDesc", "(Ljava/lang/String;)V", "timesDesc", "getTimesDesc", "setTimesDesc", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CPFInfoEntity.kt */
public final class CPFInfoEntity implements IEntity {
    private int status;
    private String statusDesc;
    private String timesDesc;

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final void setStatusDesc(String str) {
        this.statusDesc = str;
    }

    public final String getTimesDesc() {
        return this.timesDesc;
    }

    public final void setTimesDesc(String str) {
        this.timesDesc = str;
    }
}
