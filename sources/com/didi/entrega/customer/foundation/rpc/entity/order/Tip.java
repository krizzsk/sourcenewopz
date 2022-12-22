package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/Tip;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "statusDesc", "", "subStatusDesc", "countDown", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getCountDown", "()J", "getStatusDesc", "()Ljava/lang/String;", "getSubStatusDesc", "setSubStatusDesc", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class Tip implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 5836210155820559613L;
    private final long countDown;
    private final String statusDesc;
    private String subStatusDesc;

    public Tip() {
        this((String) null, (String) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Tip copy$default(Tip tip, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tip.statusDesc;
        }
        if ((i & 2) != 0) {
            str2 = tip.subStatusDesc;
        }
        if ((i & 4) != 0) {
            j = tip.countDown;
        }
        return tip.copy(str, str2, j);
    }

    public final String component1() {
        return this.statusDesc;
    }

    public final String component2() {
        return this.subStatusDesc;
    }

    public final long component3() {
        return this.countDown;
    }

    public final Tip copy(String str, String str2, long j) {
        return new Tip(str, str2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tip)) {
            return false;
        }
        Tip tip = (Tip) obj;
        return Intrinsics.areEqual((Object) this.statusDesc, (Object) tip.statusDesc) && Intrinsics.areEqual((Object) this.subStatusDesc, (Object) tip.subStatusDesc) && this.countDown == tip.countDown;
    }

    public int hashCode() {
        String str = this.statusDesc;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subStatusDesc;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.countDown);
    }

    public String toString() {
        return "Tip(statusDesc=" + this.statusDesc + ", subStatusDesc=" + this.subStatusDesc + ", countDown=" + this.countDown + VersionRange.RIGHT_OPEN;
    }

    public Tip(String str, String str2, long j) {
        this.statusDesc = str;
        this.subStatusDesc = str2;
        this.countDown = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Tip(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? 0 : j);
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final String getSubStatusDesc() {
        return this.subStatusDesc;
    }

    public final void setSubStatusDesc(String str) {
        this.subStatusDesc = str;
    }

    public final long getCountDown() {
        return this.countDown;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/Tip$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
