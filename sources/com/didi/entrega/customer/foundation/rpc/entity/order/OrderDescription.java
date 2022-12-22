package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u0001:\u0001 BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006!"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderDescription;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "title", "", "subTitle", "replaceInfo", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/ReplaceInfo;", "btns", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderBtns;", "etaTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getBtns", "()Ljava/util/List;", "getEtaTime", "()Ljava/lang/String;", "getReplaceInfo", "getSubTitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class OrderDescription implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -1879076692297925114L;
    private final List<OrderBtns> btns;
    private final String etaTime;
    private final List<ReplaceInfo> replaceInfo;
    private final String subTitle;
    private final String title;

    public OrderDescription() {
        this((String) null, (String) null, (List) null, (List) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderDescription copy$default(OrderDescription orderDescription, String str, String str2, List<ReplaceInfo> list, List<OrderBtns> list2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderDescription.title;
        }
        if ((i & 2) != 0) {
            str2 = orderDescription.subTitle;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            list = orderDescription.replaceInfo;
        }
        List<ReplaceInfo> list3 = list;
        if ((i & 8) != 0) {
            list2 = orderDescription.btns;
        }
        List<OrderBtns> list4 = list2;
        if ((i & 16) != 0) {
            str3 = orderDescription.etaTime;
        }
        return orderDescription.copy(str, str4, list3, list4, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final List<ReplaceInfo> component3() {
        return this.replaceInfo;
    }

    public final List<OrderBtns> component4() {
        return this.btns;
    }

    public final String component5() {
        return this.etaTime;
    }

    public final OrderDescription copy(String str, String str2, List<ReplaceInfo> list, List<OrderBtns> list2, String str3) {
        return new OrderDescription(str, str2, list, list2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderDescription)) {
            return false;
        }
        OrderDescription orderDescription = (OrderDescription) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) orderDescription.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) orderDescription.subTitle) && Intrinsics.areEqual((Object) this.replaceInfo, (Object) orderDescription.replaceInfo) && Intrinsics.areEqual((Object) this.btns, (Object) orderDescription.btns) && Intrinsics.areEqual((Object) this.etaTime, (Object) orderDescription.etaTime);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ReplaceInfo> list = this.replaceInfo;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<OrderBtns> list2 = this.btns;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str3 = this.etaTime;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "OrderDescription(title=" + this.title + ", subTitle=" + this.subTitle + ", replaceInfo=" + this.replaceInfo + ", btns=" + this.btns + ", etaTime=" + this.etaTime + VersionRange.RIGHT_OPEN;
    }

    public OrderDescription(String str, String str2, List<ReplaceInfo> list, List<OrderBtns> list2, String str3) {
        this.title = str;
        this.subTitle = str2;
        this.replaceInfo = list;
        this.btns = list2;
        this.etaTime = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderDescription(java.lang.String r5, java.lang.String r6, java.util.List r7, java.util.List r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.entity.order.OrderDescription.<init>(java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final List<ReplaceInfo> getReplaceInfo() {
        return this.replaceInfo;
    }

    public final List<OrderBtns> getBtns() {
        return this.btns;
    }

    public final String getEtaTime() {
        return this.etaTime;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderDescription$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
