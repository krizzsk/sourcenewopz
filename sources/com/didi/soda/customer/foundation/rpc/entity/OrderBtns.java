package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0001 BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderBtns;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "name", "", "disable", "", "action", "alert", "url", "type", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)V", "getAction", "()I", "getAlert", "()Ljava/lang/String;", "getDisable", "getName", "getType", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class OrderBtns implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 5533207934875551774L;
    private final int action;
    private final String alert;
    private final int disable;
    private final String name;
    private final int type;
    private final String url;

    public OrderBtns() {
        this((String) null, 0, 0, (String) null, (String) null, 0, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderBtns copy$default(OrderBtns orderBtns, String str, int i, int i2, String str2, String str3, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = orderBtns.name;
        }
        if ((i4 & 2) != 0) {
            i = orderBtns.disable;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = orderBtns.action;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            str2 = orderBtns.alert;
        }
        String str4 = str2;
        if ((i4 & 16) != 0) {
            str3 = orderBtns.url;
        }
        String str5 = str3;
        if ((i4 & 32) != 0) {
            i3 = orderBtns.type;
        }
        return orderBtns.copy(str, i5, i6, str4, str5, i3);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.disable;
    }

    public final int component3() {
        return this.action;
    }

    public final String component4() {
        return this.alert;
    }

    public final String component5() {
        return this.url;
    }

    public final int component6() {
        return this.type;
    }

    public final OrderBtns copy(String str, int i, int i2, String str2, String str3, int i3) {
        return new OrderBtns(str, i, i2, str2, str3, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderBtns)) {
            return false;
        }
        OrderBtns orderBtns = (OrderBtns) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) orderBtns.name) && this.disable == orderBtns.disable && this.action == orderBtns.action && Intrinsics.areEqual((Object) this.alert, (Object) orderBtns.alert) && Intrinsics.areEqual((Object) this.url, (Object) orderBtns.url) && this.type == orderBtns.type;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.disable) * 31) + this.action) * 31;
        String str2 = this.alert;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.type;
    }

    public String toString() {
        return "OrderBtns(name=" + this.name + ", disable=" + this.disable + ", action=" + this.action + ", alert=" + this.alert + ", url=" + this.url + ", type=" + this.type + VersionRange.RIGHT_OPEN;
    }

    public OrderBtns(String str, int i, int i2, String str2, String str3, int i3) {
        this.name = str;
        this.disable = i;
        this.action = i2;
        this.alert = str2;
        this.url = str3;
        this.type = i3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderBtns(java.lang.String r6, int r7, int r8, java.lang.String r9, java.lang.String r10, int r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
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
            r1 = 0
            if (r6 == 0) goto L_0x000f
            r2 = 0
            goto L_0x0010
        L_0x000f:
            r2 = r7
        L_0x0010:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0016
            r3 = 0
            goto L_0x0017
        L_0x0016:
            r3 = r8
        L_0x0017:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001d
            r4 = r0
            goto L_0x001e
        L_0x001d:
            r4 = r9
        L_0x001e:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = 0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r2
            r9 = r3
            r10 = r4
            r11 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.OrderBtns.<init>(java.lang.String, int, int, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getName() {
        return this.name;
    }

    public final int getDisable() {
        return this.disable;
    }

    public final int getAction() {
        return this.action;
    }

    public final String getAlert() {
        return this.alert;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getType() {
        return this.type;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderBtns$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
