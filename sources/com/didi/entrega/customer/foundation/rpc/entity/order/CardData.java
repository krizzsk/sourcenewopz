package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 92\u00020\u0001:\u00019Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0013HÆ\u0003Ju\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u000208HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006:"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/CardData;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "flashAbnormalStatus", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderAbnormalInfo;", "flashAbnormalTips", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderAbnormalTip;", "flashPickCode", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderPickInfo;", "flashPaymentGuide", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderPaymentGuide;", "flashOrderDescription", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderDescription;", "flashRiderInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderRiderInfo;", "flashFAQ", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/Faq;", "flashDeliveryInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderDeliveryInfo;", "flashOrderInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderBaseInfo;", "(Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderAbnormalInfo;Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderAbnormalTip;Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderPickInfo;Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderPaymentGuide;Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderDescription;Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderRiderInfo;Lcom/didi/entrega/customer/foundation/rpc/entity/order/Faq;Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderDeliveryInfo;Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderBaseInfo;)V", "getFlashAbnormalStatus", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderAbnormalInfo;", "getFlashAbnormalTips", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderAbnormalTip;", "getFlashDeliveryInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderDeliveryInfo;", "getFlashFAQ", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/Faq;", "getFlashOrderDescription", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderDescription;", "getFlashOrderInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderBaseInfo;", "getFlashPaymentGuide", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderPaymentGuide;", "getFlashPickCode", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderPickInfo;", "getFlashRiderInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderRiderInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class CardData implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -1293489427968527873L;
    private final OrderAbnormalInfo flashAbnormalStatus;
    private final OrderAbnormalTip flashAbnormalTips;
    private final OrderDeliveryInfo flashDeliveryInfo;
    private final Faq flashFAQ;
    private final OrderDescription flashOrderDescription;
    private final OrderBaseInfo flashOrderInfo;
    private final OrderPaymentGuide flashPaymentGuide;
    private final OrderPickInfo flashPickCode;
    private final OrderRiderInfo flashRiderInfo;

    public CardData() {
        this((OrderAbnormalInfo) null, (OrderAbnormalTip) null, (OrderPickInfo) null, (OrderPaymentGuide) null, (OrderDescription) null, (OrderRiderInfo) null, (Faq) null, (OrderDeliveryInfo) null, (OrderBaseInfo) null, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CardData copy$default(CardData cardData, OrderAbnormalInfo orderAbnormalInfo, OrderAbnormalTip orderAbnormalTip, OrderPickInfo orderPickInfo, OrderPaymentGuide orderPaymentGuide, OrderDescription orderDescription, OrderRiderInfo orderRiderInfo, Faq faq, OrderDeliveryInfo orderDeliveryInfo, OrderBaseInfo orderBaseInfo, int i, Object obj) {
        CardData cardData2 = cardData;
        int i2 = i;
        return cardData.copy((i2 & 1) != 0 ? cardData2.flashAbnormalStatus : orderAbnormalInfo, (i2 & 2) != 0 ? cardData2.flashAbnormalTips : orderAbnormalTip, (i2 & 4) != 0 ? cardData2.flashPickCode : orderPickInfo, (i2 & 8) != 0 ? cardData2.flashPaymentGuide : orderPaymentGuide, (i2 & 16) != 0 ? cardData2.flashOrderDescription : orderDescription, (i2 & 32) != 0 ? cardData2.flashRiderInfo : orderRiderInfo, (i2 & 64) != 0 ? cardData2.flashFAQ : faq, (i2 & 128) != 0 ? cardData2.flashDeliveryInfo : orderDeliveryInfo, (i2 & 256) != 0 ? cardData2.flashOrderInfo : orderBaseInfo);
    }

    public final OrderAbnormalInfo component1() {
        return this.flashAbnormalStatus;
    }

    public final OrderAbnormalTip component2() {
        return this.flashAbnormalTips;
    }

    public final OrderPickInfo component3() {
        return this.flashPickCode;
    }

    public final OrderPaymentGuide component4() {
        return this.flashPaymentGuide;
    }

    public final OrderDescription component5() {
        return this.flashOrderDescription;
    }

    public final OrderRiderInfo component6() {
        return this.flashRiderInfo;
    }

    public final Faq component7() {
        return this.flashFAQ;
    }

    public final OrderDeliveryInfo component8() {
        return this.flashDeliveryInfo;
    }

    public final OrderBaseInfo component9() {
        return this.flashOrderInfo;
    }

    public final CardData copy(OrderAbnormalInfo orderAbnormalInfo, OrderAbnormalTip orderAbnormalTip, OrderPickInfo orderPickInfo, OrderPaymentGuide orderPaymentGuide, OrderDescription orderDescription, OrderRiderInfo orderRiderInfo, Faq faq, OrderDeliveryInfo orderDeliveryInfo, OrderBaseInfo orderBaseInfo) {
        return new CardData(orderAbnormalInfo, orderAbnormalTip, orderPickInfo, orderPaymentGuide, orderDescription, orderRiderInfo, faq, orderDeliveryInfo, orderBaseInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardData)) {
            return false;
        }
        CardData cardData = (CardData) obj;
        return Intrinsics.areEqual((Object) this.flashAbnormalStatus, (Object) cardData.flashAbnormalStatus) && Intrinsics.areEqual((Object) this.flashAbnormalTips, (Object) cardData.flashAbnormalTips) && Intrinsics.areEqual((Object) this.flashPickCode, (Object) cardData.flashPickCode) && Intrinsics.areEqual((Object) this.flashPaymentGuide, (Object) cardData.flashPaymentGuide) && Intrinsics.areEqual((Object) this.flashOrderDescription, (Object) cardData.flashOrderDescription) && Intrinsics.areEqual((Object) this.flashRiderInfo, (Object) cardData.flashRiderInfo) && Intrinsics.areEqual((Object) this.flashFAQ, (Object) cardData.flashFAQ) && Intrinsics.areEqual((Object) this.flashDeliveryInfo, (Object) cardData.flashDeliveryInfo) && Intrinsics.areEqual((Object) this.flashOrderInfo, (Object) cardData.flashOrderInfo);
    }

    public int hashCode() {
        OrderAbnormalInfo orderAbnormalInfo = this.flashAbnormalStatus;
        int i = 0;
        int hashCode = (orderAbnormalInfo == null ? 0 : orderAbnormalInfo.hashCode()) * 31;
        OrderAbnormalTip orderAbnormalTip = this.flashAbnormalTips;
        int hashCode2 = (hashCode + (orderAbnormalTip == null ? 0 : orderAbnormalTip.hashCode())) * 31;
        OrderPickInfo orderPickInfo = this.flashPickCode;
        int hashCode3 = (hashCode2 + (orderPickInfo == null ? 0 : orderPickInfo.hashCode())) * 31;
        OrderPaymentGuide orderPaymentGuide = this.flashPaymentGuide;
        int hashCode4 = (hashCode3 + (orderPaymentGuide == null ? 0 : orderPaymentGuide.hashCode())) * 31;
        OrderDescription orderDescription = this.flashOrderDescription;
        int hashCode5 = (hashCode4 + (orderDescription == null ? 0 : orderDescription.hashCode())) * 31;
        OrderRiderInfo orderRiderInfo = this.flashRiderInfo;
        int hashCode6 = (hashCode5 + (orderRiderInfo == null ? 0 : orderRiderInfo.hashCode())) * 31;
        Faq faq = this.flashFAQ;
        int hashCode7 = (hashCode6 + (faq == null ? 0 : faq.hashCode())) * 31;
        OrderDeliveryInfo orderDeliveryInfo = this.flashDeliveryInfo;
        int hashCode8 = (hashCode7 + (orderDeliveryInfo == null ? 0 : orderDeliveryInfo.hashCode())) * 31;
        OrderBaseInfo orderBaseInfo = this.flashOrderInfo;
        if (orderBaseInfo != null) {
            i = orderBaseInfo.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "CardData(flashAbnormalStatus=" + this.flashAbnormalStatus + ", flashAbnormalTips=" + this.flashAbnormalTips + ", flashPickCode=" + this.flashPickCode + ", flashPaymentGuide=" + this.flashPaymentGuide + ", flashOrderDescription=" + this.flashOrderDescription + ", flashRiderInfo=" + this.flashRiderInfo + ", flashFAQ=" + this.flashFAQ + ", flashDeliveryInfo=" + this.flashDeliveryInfo + ", flashOrderInfo=" + this.flashOrderInfo + VersionRange.RIGHT_OPEN;
    }

    public CardData(OrderAbnormalInfo orderAbnormalInfo, OrderAbnormalTip orderAbnormalTip, OrderPickInfo orderPickInfo, OrderPaymentGuide orderPaymentGuide, OrderDescription orderDescription, OrderRiderInfo orderRiderInfo, Faq faq, OrderDeliveryInfo orderDeliveryInfo, OrderBaseInfo orderBaseInfo) {
        this.flashAbnormalStatus = orderAbnormalInfo;
        this.flashAbnormalTips = orderAbnormalTip;
        this.flashPickCode = orderPickInfo;
        this.flashPaymentGuide = orderPaymentGuide;
        this.flashOrderDescription = orderDescription;
        this.flashRiderInfo = orderRiderInfo;
        this.flashFAQ = faq;
        this.flashDeliveryInfo = orderDeliveryInfo;
        this.flashOrderInfo = orderBaseInfo;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardData(com.didi.entrega.customer.foundation.rpc.entity.order.OrderAbnormalInfo r11, com.didi.entrega.customer.foundation.rpc.entity.order.OrderAbnormalTip r12, com.didi.entrega.customer.foundation.rpc.entity.order.OrderPickInfo r13, com.didi.entrega.customer.foundation.rpc.entity.order.OrderPaymentGuide r14, com.didi.entrega.customer.foundation.rpc.entity.order.OrderDescription r15, com.didi.entrega.customer.foundation.rpc.entity.order.OrderRiderInfo r16, com.didi.entrega.customer.foundation.rpc.entity.order.Faq r17, com.didi.entrega.customer.foundation.rpc.entity.order.OrderDeliveryInfo r18, com.didi.entrega.customer.foundation.rpc.entity.order.OrderBaseInfo r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.entity.order.CardData.<init>(com.didi.entrega.customer.foundation.rpc.entity.order.OrderAbnormalInfo, com.didi.entrega.customer.foundation.rpc.entity.order.OrderAbnormalTip, com.didi.entrega.customer.foundation.rpc.entity.order.OrderPickInfo, com.didi.entrega.customer.foundation.rpc.entity.order.OrderPaymentGuide, com.didi.entrega.customer.foundation.rpc.entity.order.OrderDescription, com.didi.entrega.customer.foundation.rpc.entity.order.OrderRiderInfo, com.didi.entrega.customer.foundation.rpc.entity.order.Faq, com.didi.entrega.customer.foundation.rpc.entity.order.OrderDeliveryInfo, com.didi.entrega.customer.foundation.rpc.entity.order.OrderBaseInfo, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final OrderAbnormalInfo getFlashAbnormalStatus() {
        return this.flashAbnormalStatus;
    }

    public final OrderAbnormalTip getFlashAbnormalTips() {
        return this.flashAbnormalTips;
    }

    public final OrderPickInfo getFlashPickCode() {
        return this.flashPickCode;
    }

    public final OrderPaymentGuide getFlashPaymentGuide() {
        return this.flashPaymentGuide;
    }

    public final OrderDescription getFlashOrderDescription() {
        return this.flashOrderDescription;
    }

    public final OrderRiderInfo getFlashRiderInfo() {
        return this.flashRiderInfo;
    }

    public final Faq getFlashFAQ() {
        return this.flashFAQ;
    }

    public final OrderDeliveryInfo getFlashDeliveryInfo() {
        return this.flashDeliveryInfo;
    }

    public final OrderBaseInfo getFlashOrderInfo() {
        return this.flashOrderInfo;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/CardData$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
