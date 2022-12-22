package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0001 BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ShopInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "shopId", "", "name", "wineConfirm", "", "wineConfirmDesc", "businessType", "url", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getBusinessType", "()I", "getName", "()Ljava/lang/String;", "getShopId", "getUrl", "getWineConfirm", "getWineConfirmDesc", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class ShopInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 4711810639017400596L;
    private final int businessType;
    private final String name;
    private final String shopId;
    private final String url;
    private final int wineConfirm;
    private final String wineConfirmDesc;

    public ShopInfo() {
        this((String) null, (String) null, 0, (String) null, 0, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopInfo copy$default(ShopInfo shopInfo, String str, String str2, int i, String str3, int i2, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = shopInfo.shopId;
        }
        if ((i3 & 2) != 0) {
            str2 = shopInfo.name;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            i = shopInfo.wineConfirm;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            str3 = shopInfo.wineConfirmDesc;
        }
        String str6 = str3;
        if ((i3 & 16) != 0) {
            i2 = shopInfo.businessType;
        }
        int i5 = i2;
        if ((i3 & 32) != 0) {
            str4 = shopInfo.url;
        }
        return shopInfo.copy(str, str5, i4, str6, i5, str4);
    }

    public final String component1() {
        return this.shopId;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.wineConfirm;
    }

    public final String component4() {
        return this.wineConfirmDesc;
    }

    public final int component5() {
        return this.businessType;
    }

    public final String component6() {
        return this.url;
    }

    public final ShopInfo copy(String str, String str2, int i, String str3, int i2, String str4) {
        return new ShopInfo(str, str2, i, str3, i2, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopInfo)) {
            return false;
        }
        ShopInfo shopInfo = (ShopInfo) obj;
        return Intrinsics.areEqual((Object) this.shopId, (Object) shopInfo.shopId) && Intrinsics.areEqual((Object) this.name, (Object) shopInfo.name) && this.wineConfirm == shopInfo.wineConfirm && Intrinsics.areEqual((Object) this.wineConfirmDesc, (Object) shopInfo.wineConfirmDesc) && this.businessType == shopInfo.businessType && Intrinsics.areEqual((Object) this.url, (Object) shopInfo.url);
    }

    public int hashCode() {
        String str = this.shopId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.wineConfirm) * 31;
        String str3 = this.wineConfirmDesc;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.businessType) * 31;
        String str4 = this.url;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ShopInfo(shopId=" + this.shopId + ", name=" + this.name + ", wineConfirm=" + this.wineConfirm + ", wineConfirmDesc=" + this.wineConfirmDesc + ", businessType=" + this.businessType + ", url=" + this.url + VersionRange.RIGHT_OPEN;
    }

    public ShopInfo(String str, String str2, int i, String str3, int i2, String str4) {
        this.shopId = str;
        this.name = str2;
        this.wineConfirm = i;
        this.wineConfirmDesc = str3;
        this.businessType = i2;
        this.url = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopInfo(java.lang.String r6, java.lang.String r7, int r8, java.lang.String r9, int r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0016
            r8 = 0
            r2 = 0
            goto L_0x0017
        L_0x0016:
            r2 = r8
        L_0x0017:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r9
        L_0x001e:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0025
            r10 = 1
            r4 = 1
            goto L_0x0026
        L_0x0025:
            r4 = r10
        L_0x0026:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002c
            r12 = r0
            goto L_0x002d
        L_0x002c:
            r12 = r11
        L_0x002d:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.ShopInfo.<init>(java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getName() {
        return this.name;
    }

    public final int getWineConfirm() {
        return this.wineConfirm;
    }

    public final String getWineConfirmDesc() {
        return this.wineConfirmDesc;
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    public final String getUrl() {
        return this.url;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ShopInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
