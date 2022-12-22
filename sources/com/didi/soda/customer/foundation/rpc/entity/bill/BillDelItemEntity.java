package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillDelItemEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "mduId", "", "(Ljava/lang/String;)V", "getMduId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillDelItemEntity.kt */
public final class BillDelItemEntity implements IEntity {
    private final String mduId;

    public static /* synthetic */ BillDelItemEntity copy$default(BillDelItemEntity billDelItemEntity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = billDelItemEntity.mduId;
        }
        return billDelItemEntity.copy(str);
    }

    public final String component1() {
        return this.mduId;
    }

    public final BillDelItemEntity copy(String str) {
        Intrinsics.checkNotNullParameter(str, "mduId");
        return new BillDelItemEntity(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BillDelItemEntity) && Intrinsics.areEqual((Object) this.mduId, (Object) ((BillDelItemEntity) obj).mduId);
    }

    public int hashCode() {
        return this.mduId.hashCode();
    }

    public String toString() {
        return "BillDelItemEntity(mduId=" + this.mduId + VersionRange.RIGHT_OPEN;
    }

    public BillDelItemEntity(String str) {
        Intrinsics.checkNotNullParameter(str, "mduId");
        this.mduId = str;
    }

    public final String getMduId() {
        return this.mduId;
    }
}
