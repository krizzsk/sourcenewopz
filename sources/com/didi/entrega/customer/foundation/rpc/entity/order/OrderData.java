package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 =2\u00020\u0001:\u0001=B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J¥\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0006HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006>"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderData;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "orderId", "", "preOrderId", "status", "", "subStatus", "isShowMap", "statusDesc", "mapData", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/MapData;", "debtData", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/DebtData;", "completeTime", "realComplete", "receiverPhoneCountryId", "receiverCallingCode", "orderTipBar", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderTipBar;", "brandName", "(Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Lcom/didi/entrega/customer/foundation/rpc/entity/order/MapData;Lcom/didi/entrega/customer/foundation/rpc/entity/order/DebtData;IIILjava/lang/String;Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderTipBar;Ljava/lang/String;)V", "getBrandName", "()Ljava/lang/String;", "getCompleteTime", "()I", "getDebtData", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/DebtData;", "getMapData", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/MapData;", "getOrderId", "getOrderTipBar", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderTipBar;", "getPreOrderId", "getRealComplete", "getReceiverCallingCode", "getReceiverPhoneCountryId", "getStatus", "getStatusDesc", "getSubStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class OrderData implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -6178992196885820662L;
    private final String brandName;
    private final int completeTime;
    private final DebtData debtData;
    private final int isShowMap;
    private final MapData mapData;
    private final String orderId;
    private final OrderTipBar orderTipBar;
    private final String preOrderId;
    private final int realComplete;
    private final String receiverCallingCode;
    private final int receiverPhoneCountryId;
    private final int status;
    private final String statusDesc;
    private final int subStatus;

    public OrderData() {
        this((String) null, (String) null, 0, 0, 0, (String) null, (MapData) null, (DebtData) null, 0, 0, 0, (String) null, (OrderTipBar) null, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderData copy$default(OrderData orderData, String str, String str2, int i, int i2, int i3, String str3, MapData mapData2, DebtData debtData2, int i4, int i5, int i6, String str4, OrderTipBar orderTipBar2, String str5, int i7, Object obj) {
        OrderData orderData2 = orderData;
        int i8 = i7;
        return orderData.copy((i8 & 1) != 0 ? orderData2.orderId : str, (i8 & 2) != 0 ? orderData2.preOrderId : str2, (i8 & 4) != 0 ? orderData2.status : i, (i8 & 8) != 0 ? orderData2.subStatus : i2, (i8 & 16) != 0 ? orderData2.isShowMap : i3, (i8 & 32) != 0 ? orderData2.statusDesc : str3, (i8 & 64) != 0 ? orderData2.mapData : mapData2, (i8 & 128) != 0 ? orderData2.debtData : debtData2, (i8 & 256) != 0 ? orderData2.completeTime : i4, (i8 & 512) != 0 ? orderData2.realComplete : i5, (i8 & 1024) != 0 ? orderData2.receiverPhoneCountryId : i6, (i8 & 2048) != 0 ? orderData2.receiverCallingCode : str4, (i8 & 4096) != 0 ? orderData2.orderTipBar : orderTipBar2, (i8 & 8192) != 0 ? orderData2.brandName : str5);
    }

    public final String component1() {
        return this.orderId;
    }

    public final int component10() {
        return this.realComplete;
    }

    public final int component11() {
        return this.receiverPhoneCountryId;
    }

    public final String component12() {
        return this.receiverCallingCode;
    }

    public final OrderTipBar component13() {
        return this.orderTipBar;
    }

    public final String component14() {
        return this.brandName;
    }

    public final String component2() {
        return this.preOrderId;
    }

    public final int component3() {
        return this.status;
    }

    public final int component4() {
        return this.subStatus;
    }

    public final int component5() {
        return this.isShowMap;
    }

    public final String component6() {
        return this.statusDesc;
    }

    public final MapData component7() {
        return this.mapData;
    }

    public final DebtData component8() {
        return this.debtData;
    }

    public final int component9() {
        return this.completeTime;
    }

    public final OrderData copy(String str, String str2, int i, int i2, int i3, String str3, MapData mapData2, DebtData debtData2, int i4, int i5, int i6, String str4, OrderTipBar orderTipBar2, String str5) {
        return new OrderData(str, str2, i, i2, i3, str3, mapData2, debtData2, i4, i5, i6, str4, orderTipBar2, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderData)) {
            return false;
        }
        OrderData orderData = (OrderData) obj;
        return Intrinsics.areEqual((Object) this.orderId, (Object) orderData.orderId) && Intrinsics.areEqual((Object) this.preOrderId, (Object) orderData.preOrderId) && this.status == orderData.status && this.subStatus == orderData.subStatus && this.isShowMap == orderData.isShowMap && Intrinsics.areEqual((Object) this.statusDesc, (Object) orderData.statusDesc) && Intrinsics.areEqual((Object) this.mapData, (Object) orderData.mapData) && Intrinsics.areEqual((Object) this.debtData, (Object) orderData.debtData) && this.completeTime == orderData.completeTime && this.realComplete == orderData.realComplete && this.receiverPhoneCountryId == orderData.receiverPhoneCountryId && Intrinsics.areEqual((Object) this.receiverCallingCode, (Object) orderData.receiverCallingCode) && Intrinsics.areEqual((Object) this.orderTipBar, (Object) orderData.orderTipBar) && Intrinsics.areEqual((Object) this.brandName, (Object) orderData.brandName);
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.preOrderId;
        int hashCode2 = (((((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.status) * 31) + this.subStatus) * 31) + this.isShowMap) * 31;
        String str3 = this.statusDesc;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MapData mapData2 = this.mapData;
        int hashCode4 = (hashCode3 + (mapData2 == null ? 0 : mapData2.hashCode())) * 31;
        DebtData debtData2 = this.debtData;
        int hashCode5 = (((((((hashCode4 + (debtData2 == null ? 0 : debtData2.hashCode())) * 31) + this.completeTime) * 31) + this.realComplete) * 31) + this.receiverPhoneCountryId) * 31;
        String str4 = this.receiverCallingCode;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        OrderTipBar orderTipBar2 = this.orderTipBar;
        int hashCode7 = (hashCode6 + (orderTipBar2 == null ? 0 : orderTipBar2.hashCode())) * 31;
        String str5 = this.brandName;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "OrderData(orderId=" + this.orderId + ", preOrderId=" + this.preOrderId + ", status=" + this.status + ", subStatus=" + this.subStatus + ", isShowMap=" + this.isShowMap + ", statusDesc=" + this.statusDesc + ", mapData=" + this.mapData + ", debtData=" + this.debtData + ", completeTime=" + this.completeTime + ", realComplete=" + this.realComplete + ", receiverPhoneCountryId=" + this.receiverPhoneCountryId + ", receiverCallingCode=" + this.receiverCallingCode + ", orderTipBar=" + this.orderTipBar + ", brandName=" + this.brandName + VersionRange.RIGHT_OPEN;
    }

    public OrderData(String str, String str2, int i, int i2, int i3, String str3, MapData mapData2, DebtData debtData2, int i4, int i5, int i6, String str4, OrderTipBar orderTipBar2, String str5) {
        this.orderId = str;
        this.preOrderId = str2;
        this.status = i;
        this.subStatus = i2;
        this.isShowMap = i3;
        this.statusDesc = str3;
        this.mapData = mapData2;
        this.debtData = debtData2;
        this.completeTime = i4;
        this.realComplete = i5;
        this.receiverPhoneCountryId = i6;
        this.receiverCallingCode = str4;
        this.orderTipBar = orderTipBar2;
        this.brandName = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderData(java.lang.String r16, java.lang.String r17, int r18, int r19, int r20, java.lang.String r21, com.didi.entrega.customer.foundation.rpc.entity.order.MapData r22, com.didi.entrega.customer.foundation.rpc.entity.order.DebtData r23, int r24, int r25, int r26, java.lang.String r27, com.didi.entrega.customer.foundation.rpc.entity.order.OrderTipBar r28, java.lang.String r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001a
            r4 = 0
            goto L_0x001c
        L_0x001a:
            r4 = r18
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = 0
            goto L_0x0024
        L_0x0022:
            r6 = r19
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r20
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r2
            goto L_0x0034
        L_0x0032:
            r8 = r21
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = r2
            goto L_0x003c
        L_0x003a:
            r9 = r22
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r2
            goto L_0x0044
        L_0x0042:
            r10 = r23
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = 0
            goto L_0x004c
        L_0x004a:
            r11 = r24
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = 0
            goto L_0x0054
        L_0x0052:
            r12 = r25
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r5 = r26
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r27
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r28
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r29
        L_0x0072:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r5
            r28 = r13
            r29 = r14
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.entity.order.OrderData.<init>(java.lang.String, java.lang.String, int, int, int, java.lang.String, com.didi.entrega.customer.foundation.rpc.entity.order.MapData, com.didi.entrega.customer.foundation.rpc.entity.order.DebtData, int, int, int, java.lang.String, com.didi.entrega.customer.foundation.rpc.entity.order.OrderTipBar, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPreOrderId() {
        return this.preOrderId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getSubStatus() {
        return this.subStatus;
    }

    public final int isShowMap() {
        return this.isShowMap;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final MapData getMapData() {
        return this.mapData;
    }

    public final DebtData getDebtData() {
        return this.debtData;
    }

    public final int getCompleteTime() {
        return this.completeTime;
    }

    public final int getRealComplete() {
        return this.realComplete;
    }

    public final int getReceiverPhoneCountryId() {
        return this.receiverPhoneCountryId;
    }

    public final String getReceiverCallingCode() {
        return this.receiverCallingCode;
    }

    public final OrderTipBar getOrderTipBar() {
        return this.orderTipBar;
    }

    public final String getBrandName() {
        return this.brandName;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderData$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
