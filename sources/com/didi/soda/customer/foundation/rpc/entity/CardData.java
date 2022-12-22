package com.didi.soda.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0001>B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006?"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/CardData;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "orderServerSubject", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderServerSubject;", "orderServerStatus", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderStatusServer;", "orderFAQ", "Lcom/didi/soda/customer/foundation/rpc/entity/Faq;", "orderPickInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderPickInfo;", "orderBranchInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderBranchInfo;", "orderAbnormalInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderAbnormalInfo;", "orderItem", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderItem;", "orderBaseInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderBaseInfo;", "orderComment", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderComment;", "orderBanner", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderBanner;", "(Lcom/didi/soda/customer/foundation/rpc/entity/OrderServerSubject;Lcom/didi/soda/customer/foundation/rpc/entity/OrderStatusServer;Lcom/didi/soda/customer/foundation/rpc/entity/Faq;Lcom/didi/soda/customer/foundation/rpc/entity/OrderPickInfo;Lcom/didi/soda/customer/foundation/rpc/entity/OrderBranchInfo;Lcom/didi/soda/customer/foundation/rpc/entity/OrderAbnormalInfo;Lcom/didi/soda/customer/foundation/rpc/entity/OrderItem;Lcom/didi/soda/customer/foundation/rpc/entity/OrderBaseInfo;Lcom/didi/soda/customer/foundation/rpc/entity/OrderComment;Lcom/didi/soda/customer/foundation/rpc/entity/OrderBanner;)V", "getOrderAbnormalInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderAbnormalInfo;", "getOrderBanner", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderBanner;", "getOrderBaseInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderBaseInfo;", "getOrderBranchInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderBranchInfo;", "getOrderComment", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderComment;", "getOrderFAQ", "()Lcom/didi/soda/customer/foundation/rpc/entity/Faq;", "getOrderItem", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderItem;", "getOrderPickInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderPickInfo;", "getOrderServerStatus", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderStatusServer;", "getOrderServerSubject", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderServerSubject;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class CardData implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -2797618850103073988L;
    private final OrderAbnormalInfo orderAbnormalInfo;
    private final OrderBanner orderBanner;
    private final OrderBaseInfo orderBaseInfo;
    private final OrderBranchInfo orderBranchInfo;
    private final OrderComment orderComment;
    private final Faq orderFAQ;
    private final OrderItem orderItem;
    private final OrderPickInfo orderPickInfo;
    private final OrderStatusServer orderServerStatus;
    private final OrderServerSubject orderServerSubject;

    public CardData() {
        this((OrderServerSubject) null, (OrderStatusServer) null, (Faq) null, (OrderPickInfo) null, (OrderBranchInfo) null, (OrderAbnormalInfo) null, (OrderItem) null, (OrderBaseInfo) null, (OrderComment) null, (OrderBanner) null, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CardData copy$default(CardData cardData, OrderServerSubject orderServerSubject2, OrderStatusServer orderStatusServer, Faq faq, OrderPickInfo orderPickInfo2, OrderBranchInfo orderBranchInfo2, OrderAbnormalInfo orderAbnormalInfo2, OrderItem orderItem2, OrderBaseInfo orderBaseInfo2, OrderComment orderComment2, OrderBanner orderBanner2, int i, Object obj) {
        CardData cardData2 = cardData;
        int i2 = i;
        return cardData.copy((i2 & 1) != 0 ? cardData2.orderServerSubject : orderServerSubject2, (i2 & 2) != 0 ? cardData2.orderServerStatus : orderStatusServer, (i2 & 4) != 0 ? cardData2.orderFAQ : faq, (i2 & 8) != 0 ? cardData2.orderPickInfo : orderPickInfo2, (i2 & 16) != 0 ? cardData2.orderBranchInfo : orderBranchInfo2, (i2 & 32) != 0 ? cardData2.orderAbnormalInfo : orderAbnormalInfo2, (i2 & 64) != 0 ? cardData2.orderItem : orderItem2, (i2 & 128) != 0 ? cardData2.orderBaseInfo : orderBaseInfo2, (i2 & 256) != 0 ? cardData2.orderComment : orderComment2, (i2 & 512) != 0 ? cardData2.orderBanner : orderBanner2);
    }

    public final OrderServerSubject component1() {
        return this.orderServerSubject;
    }

    public final OrderBanner component10() {
        return this.orderBanner;
    }

    public final OrderStatusServer component2() {
        return this.orderServerStatus;
    }

    public final Faq component3() {
        return this.orderFAQ;
    }

    public final OrderPickInfo component4() {
        return this.orderPickInfo;
    }

    public final OrderBranchInfo component5() {
        return this.orderBranchInfo;
    }

    public final OrderAbnormalInfo component6() {
        return this.orderAbnormalInfo;
    }

    public final OrderItem component7() {
        return this.orderItem;
    }

    public final OrderBaseInfo component8() {
        return this.orderBaseInfo;
    }

    public final OrderComment component9() {
        return this.orderComment;
    }

    public final CardData copy(OrderServerSubject orderServerSubject2, OrderStatusServer orderStatusServer, Faq faq, OrderPickInfo orderPickInfo2, OrderBranchInfo orderBranchInfo2, OrderAbnormalInfo orderAbnormalInfo2, OrderItem orderItem2, OrderBaseInfo orderBaseInfo2, OrderComment orderComment2, OrderBanner orderBanner2) {
        return new CardData(orderServerSubject2, orderStatusServer, faq, orderPickInfo2, orderBranchInfo2, orderAbnormalInfo2, orderItem2, orderBaseInfo2, orderComment2, orderBanner2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardData)) {
            return false;
        }
        CardData cardData = (CardData) obj;
        return Intrinsics.areEqual((Object) this.orderServerSubject, (Object) cardData.orderServerSubject) && Intrinsics.areEqual((Object) this.orderServerStatus, (Object) cardData.orderServerStatus) && Intrinsics.areEqual((Object) this.orderFAQ, (Object) cardData.orderFAQ) && Intrinsics.areEqual((Object) this.orderPickInfo, (Object) cardData.orderPickInfo) && Intrinsics.areEqual((Object) this.orderBranchInfo, (Object) cardData.orderBranchInfo) && Intrinsics.areEqual((Object) this.orderAbnormalInfo, (Object) cardData.orderAbnormalInfo) && Intrinsics.areEqual((Object) this.orderItem, (Object) cardData.orderItem) && Intrinsics.areEqual((Object) this.orderBaseInfo, (Object) cardData.orderBaseInfo) && Intrinsics.areEqual((Object) this.orderComment, (Object) cardData.orderComment) && Intrinsics.areEqual((Object) this.orderBanner, (Object) cardData.orderBanner);
    }

    public int hashCode() {
        OrderServerSubject orderServerSubject2 = this.orderServerSubject;
        int i = 0;
        int hashCode = (orderServerSubject2 == null ? 0 : orderServerSubject2.hashCode()) * 31;
        OrderStatusServer orderStatusServer = this.orderServerStatus;
        int hashCode2 = (hashCode + (orderStatusServer == null ? 0 : orderStatusServer.hashCode())) * 31;
        Faq faq = this.orderFAQ;
        int hashCode3 = (hashCode2 + (faq == null ? 0 : faq.hashCode())) * 31;
        OrderPickInfo orderPickInfo2 = this.orderPickInfo;
        int hashCode4 = (hashCode3 + (orderPickInfo2 == null ? 0 : orderPickInfo2.hashCode())) * 31;
        OrderBranchInfo orderBranchInfo2 = this.orderBranchInfo;
        int hashCode5 = (hashCode4 + (orderBranchInfo2 == null ? 0 : orderBranchInfo2.hashCode())) * 31;
        OrderAbnormalInfo orderAbnormalInfo2 = this.orderAbnormalInfo;
        int hashCode6 = (hashCode5 + (orderAbnormalInfo2 == null ? 0 : orderAbnormalInfo2.hashCode())) * 31;
        OrderItem orderItem2 = this.orderItem;
        int hashCode7 = (hashCode6 + (orderItem2 == null ? 0 : orderItem2.hashCode())) * 31;
        OrderBaseInfo orderBaseInfo2 = this.orderBaseInfo;
        int hashCode8 = (hashCode7 + (orderBaseInfo2 == null ? 0 : orderBaseInfo2.hashCode())) * 31;
        OrderComment orderComment2 = this.orderComment;
        int hashCode9 = (hashCode8 + (orderComment2 == null ? 0 : orderComment2.hashCode())) * 31;
        OrderBanner orderBanner2 = this.orderBanner;
        if (orderBanner2 != null) {
            i = orderBanner2.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "CardData(orderServerSubject=" + this.orderServerSubject + ", orderServerStatus=" + this.orderServerStatus + ", orderFAQ=" + this.orderFAQ + ", orderPickInfo=" + this.orderPickInfo + ", orderBranchInfo=" + this.orderBranchInfo + ", orderAbnormalInfo=" + this.orderAbnormalInfo + ", orderItem=" + this.orderItem + ", orderBaseInfo=" + this.orderBaseInfo + ", orderComment=" + this.orderComment + ", orderBanner=" + this.orderBanner + VersionRange.RIGHT_OPEN;
    }

    public CardData(OrderServerSubject orderServerSubject2, OrderStatusServer orderStatusServer, Faq faq, OrderPickInfo orderPickInfo2, OrderBranchInfo orderBranchInfo2, OrderAbnormalInfo orderAbnormalInfo2, OrderItem orderItem2, OrderBaseInfo orderBaseInfo2, OrderComment orderComment2, OrderBanner orderBanner2) {
        this.orderServerSubject = orderServerSubject2;
        this.orderServerStatus = orderStatusServer;
        this.orderFAQ = faq;
        this.orderPickInfo = orderPickInfo2;
        this.orderBranchInfo = orderBranchInfo2;
        this.orderAbnormalInfo = orderAbnormalInfo2;
        this.orderItem = orderItem2;
        this.orderBaseInfo = orderBaseInfo2;
        this.orderComment = orderComment2;
        this.orderBanner = orderBanner2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardData(com.didi.soda.customer.foundation.rpc.entity.OrderServerSubject r12, com.didi.soda.customer.foundation.rpc.entity.OrderStatusServer r13, com.didi.soda.customer.foundation.rpc.entity.Faq r14, com.didi.soda.customer.foundation.rpc.entity.OrderPickInfo r15, com.didi.soda.customer.foundation.rpc.entity.OrderBranchInfo r16, com.didi.soda.customer.foundation.rpc.entity.OrderAbnormalInfo r17, com.didi.soda.customer.foundation.rpc.entity.OrderItem r18, com.didi.soda.customer.foundation.rpc.entity.OrderBaseInfo r19, com.didi.soda.customer.foundation.rpc.entity.OrderComment r20, com.didi.soda.customer.foundation.rpc.entity.OrderBanner r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r2
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r2
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r2 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.CardData.<init>(com.didi.soda.customer.foundation.rpc.entity.OrderServerSubject, com.didi.soda.customer.foundation.rpc.entity.OrderStatusServer, com.didi.soda.customer.foundation.rpc.entity.Faq, com.didi.soda.customer.foundation.rpc.entity.OrderPickInfo, com.didi.soda.customer.foundation.rpc.entity.OrderBranchInfo, com.didi.soda.customer.foundation.rpc.entity.OrderAbnormalInfo, com.didi.soda.customer.foundation.rpc.entity.OrderItem, com.didi.soda.customer.foundation.rpc.entity.OrderBaseInfo, com.didi.soda.customer.foundation.rpc.entity.OrderComment, com.didi.soda.customer.foundation.rpc.entity.OrderBanner, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final OrderServerSubject getOrderServerSubject() {
        return this.orderServerSubject;
    }

    public final OrderStatusServer getOrderServerStatus() {
        return this.orderServerStatus;
    }

    public final Faq getOrderFAQ() {
        return this.orderFAQ;
    }

    public final OrderPickInfo getOrderPickInfo() {
        return this.orderPickInfo;
    }

    public final OrderBranchInfo getOrderBranchInfo() {
        return this.orderBranchInfo;
    }

    public final OrderAbnormalInfo getOrderAbnormalInfo() {
        return this.orderAbnormalInfo;
    }

    public final OrderItem getOrderItem() {
        return this.orderItem;
    }

    public final OrderBaseInfo getOrderBaseInfo() {
        return this.orderBaseInfo;
    }

    public final OrderComment getOrderComment() {
        return this.orderComment;
    }

    public final OrderBanner getOrderBanner() {
        return this.orderBanner;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/CardData$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
