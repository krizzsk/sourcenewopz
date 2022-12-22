package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillNotifyEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "alertInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillNotifyEntity$AlertInfo;", "shopInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/ShopInfo;", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillNotifyEntity$AlertInfo;Lcom/didi/soda/customer/foundation/rpc/entity/bill/ShopInfo;)V", "getAlertInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillNotifyEntity$AlertInfo;", "getShopInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/ShopInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "AlertInfo", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillNotifyEntity.kt */
public final class BillNotifyEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -220071501967691601L;
    private final AlertInfo alertInfo;
    private final ShopInfo shopInfo;

    public static /* synthetic */ BillNotifyEntity copy$default(BillNotifyEntity billNotifyEntity, AlertInfo alertInfo2, ShopInfo shopInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            alertInfo2 = billNotifyEntity.alertInfo;
        }
        if ((i & 2) != 0) {
            shopInfo2 = billNotifyEntity.shopInfo;
        }
        return billNotifyEntity.copy(alertInfo2, shopInfo2);
    }

    public final AlertInfo component1() {
        return this.alertInfo;
    }

    public final ShopInfo component2() {
        return this.shopInfo;
    }

    public final BillNotifyEntity copy(AlertInfo alertInfo2, ShopInfo shopInfo2) {
        Intrinsics.checkNotNullParameter(alertInfo2, "alertInfo");
        Intrinsics.checkNotNullParameter(shopInfo2, "shopInfo");
        return new BillNotifyEntity(alertInfo2, shopInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillNotifyEntity)) {
            return false;
        }
        BillNotifyEntity billNotifyEntity = (BillNotifyEntity) obj;
        return Intrinsics.areEqual((Object) this.alertInfo, (Object) billNotifyEntity.alertInfo) && Intrinsics.areEqual((Object) this.shopInfo, (Object) billNotifyEntity.shopInfo);
    }

    public int hashCode() {
        return (this.alertInfo.hashCode() * 31) + this.shopInfo.hashCode();
    }

    public String toString() {
        return "BillNotifyEntity(alertInfo=" + this.alertInfo + ", shopInfo=" + this.shopInfo + VersionRange.RIGHT_OPEN;
    }

    public BillNotifyEntity(AlertInfo alertInfo2, ShopInfo shopInfo2) {
        Intrinsics.checkNotNullParameter(alertInfo2, "alertInfo");
        Intrinsics.checkNotNullParameter(shopInfo2, "shopInfo");
        this.alertInfo = alertInfo2;
        this.shopInfo = shopInfo2;
    }

    public final AlertInfo getAlertInfo() {
        return this.alertInfo;
    }

    public final ShopInfo getShopInfo() {
        return this.shopInfo;
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillNotifyEntity$AlertInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "content", "", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillNotifyEntity.kt */
    public static final class AlertInfo implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -8489428732362968514L;
        private final String content;

        public static /* synthetic */ AlertInfo copy$default(AlertInfo alertInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = alertInfo.content;
            }
            return alertInfo.copy(str);
        }

        public final String component1() {
            return this.content;
        }

        public final AlertInfo copy(String str) {
            Intrinsics.checkNotNullParameter(str, "content");
            return new AlertInfo(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AlertInfo) && Intrinsics.areEqual((Object) this.content, (Object) ((AlertInfo) obj).content);
        }

        public int hashCode() {
            return this.content.hashCode();
        }

        public String toString() {
            return "AlertInfo(content=" + this.content + VersionRange.RIGHT_OPEN;
        }

        public AlertInfo(String str) {
            Intrinsics.checkNotNullParameter(str, "content");
            this.content = str;
        }

        public final String getContent() {
            return this.content;
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillNotifyEntity$AlertInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: BillNotifyEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillNotifyEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillNotifyEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
