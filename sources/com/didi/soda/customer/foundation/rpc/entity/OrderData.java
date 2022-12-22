package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010!J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0007HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0007HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0007HÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0002\u0010W\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010[HÖ\u0003J\t\u0010\\\u001a\u00020\u0007HÖ\u0001J\t\u0010]\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0019\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0011\u0010\u001c\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010#R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010#R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0011\u0010\u001b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0011\u0010\u001e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010#¨\u0006_"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderData;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "orderId", "", "preOrderId", "shopId", "status", "", "statusDesc", "createTime", "orderFlows", "", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderFlow;", "mapData", "Lcom/didi/soda/customer/foundation/rpc/entity/MapData;", "debtData", "Lcom/didi/soda/customer/foundation/rpc/entity/DebtData;", "completeTime", "deliveryType", "businessMode", "clientPayType", "realComplete", "orderTipBar", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderTipBar;", "sailingBizLine", "ceta21AB", "showDeliveryStatus", "shopPrepareStatus", "isDelayMeal", "delayMealGrade", "tipsbarScene", "exceptionScene", "evaluateSchema", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/util/List;Lcom/didi/soda/customer/foundation/rpc/entity/MapData;Lcom/didi/soda/customer/foundation/rpc/entity/DebtData;IIIIILcom/didi/soda/customer/foundation/rpc/entity/OrderTipBar;IIIIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getBusinessMode", "()I", "getCeta21AB", "getClientPayType", "getCompleteTime", "getCreateTime", "getDebtData", "()Lcom/didi/soda/customer/foundation/rpc/entity/DebtData;", "getDelayMealGrade", "()Ljava/lang/String;", "getDeliveryType", "getEvaluateSchema", "getExceptionScene", "getMapData", "()Lcom/didi/soda/customer/foundation/rpc/entity/MapData;", "getOrderFlows", "()Ljava/util/List;", "getOrderId", "getOrderTipBar", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderTipBar;", "getPreOrderId", "getRealComplete", "getSailingBizLine", "getShopId", "getShopPrepareStatus", "getShowDeliveryStatus", "getStatus", "getStatusDesc", "getTipsbarScene", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class OrderData implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -5169402637122972093L;
    private final int businessMode;
    private final int ceta21AB;
    private final int clientPayType;
    private final int completeTime;
    private final int createTime;
    private final DebtData debtData;
    private final String delayMealGrade;
    private final int deliveryType;
    private final String evaluateSchema;
    private final String exceptionScene;
    private final int isDelayMeal;
    private final MapData mapData;
    private final List<OrderFlow> orderFlows;
    private final String orderId;
    private final OrderTipBar orderTipBar;
    private final String preOrderId;
    private final int realComplete;
    private final int sailingBizLine;
    private final String shopId;
    private final int shopPrepareStatus;
    private final int showDeliveryStatus;
    private final int status;
    private final String statusDesc;
    private final int tipsbarScene;

    public OrderData() {
        this((String) null, (String) null, (String) null, 0, (String) null, 0, (List) null, (MapData) null, (DebtData) null, 0, 0, 0, 0, 0, (OrderTipBar) null, 0, 0, 0, 0, 0, (String) null, 0, (String) null, (String) null, 16777215, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderData copy$default(OrderData orderData, String str, String str2, String str3, int i, String str4, int i2, List list, MapData mapData2, DebtData debtData2, int i3, int i4, int i5, int i6, int i7, OrderTipBar orderTipBar2, int i8, int i9, int i10, int i11, int i12, String str5, int i13, String str6, String str7, int i14, Object obj) {
        OrderData orderData2 = orderData;
        int i15 = i14;
        return orderData.copy((i15 & 1) != 0 ? orderData2.orderId : str, (i15 & 2) != 0 ? orderData2.preOrderId : str2, (i15 & 4) != 0 ? orderData2.shopId : str3, (i15 & 8) != 0 ? orderData2.status : i, (i15 & 16) != 0 ? orderData2.statusDesc : str4, (i15 & 32) != 0 ? orderData2.createTime : i2, (i15 & 64) != 0 ? orderData2.orderFlows : list, (i15 & 128) != 0 ? orderData2.mapData : mapData2, (i15 & 256) != 0 ? orderData2.debtData : debtData2, (i15 & 512) != 0 ? orderData2.completeTime : i3, (i15 & 1024) != 0 ? orderData2.deliveryType : i4, (i15 & 2048) != 0 ? orderData2.businessMode : i5, (i15 & 4096) != 0 ? orderData2.clientPayType : i6, (i15 & 8192) != 0 ? orderData2.realComplete : i7, (i15 & 16384) != 0 ? orderData2.orderTipBar : orderTipBar2, (i15 & 32768) != 0 ? orderData2.sailingBizLine : i8, (i15 & 65536) != 0 ? orderData2.ceta21AB : i9, (i15 & 131072) != 0 ? orderData2.showDeliveryStatus : i10, (i15 & 262144) != 0 ? orderData2.shopPrepareStatus : i11, (i15 & 524288) != 0 ? orderData2.isDelayMeal : i12, (i15 & 1048576) != 0 ? orderData2.delayMealGrade : str5, (i15 & 2097152) != 0 ? orderData2.tipsbarScene : i13, (i15 & 4194304) != 0 ? orderData2.exceptionScene : str6, (i15 & 8388608) != 0 ? orderData2.evaluateSchema : str7);
    }

    public final String component1() {
        return this.orderId;
    }

    public final int component10() {
        return this.completeTime;
    }

    public final int component11() {
        return this.deliveryType;
    }

    public final int component12() {
        return this.businessMode;
    }

    public final int component13() {
        return this.clientPayType;
    }

    public final int component14() {
        return this.realComplete;
    }

    public final OrderTipBar component15() {
        return this.orderTipBar;
    }

    public final int component16() {
        return this.sailingBizLine;
    }

    public final int component17() {
        return this.ceta21AB;
    }

    public final int component18() {
        return this.showDeliveryStatus;
    }

    public final int component19() {
        return this.shopPrepareStatus;
    }

    public final String component2() {
        return this.preOrderId;
    }

    public final int component20() {
        return this.isDelayMeal;
    }

    public final String component21() {
        return this.delayMealGrade;
    }

    public final int component22() {
        return this.tipsbarScene;
    }

    public final String component23() {
        return this.exceptionScene;
    }

    public final String component24() {
        return this.evaluateSchema;
    }

    public final String component3() {
        return this.shopId;
    }

    public final int component4() {
        return this.status;
    }

    public final String component5() {
        return this.statusDesc;
    }

    public final int component6() {
        return this.createTime;
    }

    public final List<OrderFlow> component7() {
        return this.orderFlows;
    }

    public final MapData component8() {
        return this.mapData;
    }

    public final DebtData component9() {
        return this.debtData;
    }

    public final OrderData copy(String str, String str2, String str3, int i, String str4, int i2, List<OrderFlow> list, MapData mapData2, DebtData debtData2, int i3, int i4, int i5, int i6, int i7, OrderTipBar orderTipBar2, int i8, int i9, int i10, int i11, int i12, String str5, int i13, String str6, String str7) {
        return new OrderData(str, str2, str3, i, str4, i2, list, mapData2, debtData2, i3, i4, i5, i6, i7, orderTipBar2, i8, i9, i10, i11, i12, str5, i13, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderData)) {
            return false;
        }
        OrderData orderData = (OrderData) obj;
        return Intrinsics.areEqual((Object) this.orderId, (Object) orderData.orderId) && Intrinsics.areEqual((Object) this.preOrderId, (Object) orderData.preOrderId) && Intrinsics.areEqual((Object) this.shopId, (Object) orderData.shopId) && this.status == orderData.status && Intrinsics.areEqual((Object) this.statusDesc, (Object) orderData.statusDesc) && this.createTime == orderData.createTime && Intrinsics.areEqual((Object) this.orderFlows, (Object) orderData.orderFlows) && Intrinsics.areEqual((Object) this.mapData, (Object) orderData.mapData) && Intrinsics.areEqual((Object) this.debtData, (Object) orderData.debtData) && this.completeTime == orderData.completeTime && this.deliveryType == orderData.deliveryType && this.businessMode == orderData.businessMode && this.clientPayType == orderData.clientPayType && this.realComplete == orderData.realComplete && Intrinsics.areEqual((Object) this.orderTipBar, (Object) orderData.orderTipBar) && this.sailingBizLine == orderData.sailingBizLine && this.ceta21AB == orderData.ceta21AB && this.showDeliveryStatus == orderData.showDeliveryStatus && this.shopPrepareStatus == orderData.shopPrepareStatus && this.isDelayMeal == orderData.isDelayMeal && Intrinsics.areEqual((Object) this.delayMealGrade, (Object) orderData.delayMealGrade) && this.tipsbarScene == orderData.tipsbarScene && Intrinsics.areEqual((Object) this.exceptionScene, (Object) orderData.exceptionScene) && Intrinsics.areEqual((Object) this.evaluateSchema, (Object) orderData.evaluateSchema);
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.preOrderId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.shopId;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.status) * 31;
        String str4 = this.statusDesc;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.createTime) * 31;
        List<OrderFlow> list = this.orderFlows;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        MapData mapData2 = this.mapData;
        int hashCode6 = (hashCode5 + (mapData2 == null ? 0 : mapData2.hashCode())) * 31;
        DebtData debtData2 = this.debtData;
        int hashCode7 = (((((((((((hashCode6 + (debtData2 == null ? 0 : debtData2.hashCode())) * 31) + this.completeTime) * 31) + this.deliveryType) * 31) + this.businessMode) * 31) + this.clientPayType) * 31) + this.realComplete) * 31;
        OrderTipBar orderTipBar2 = this.orderTipBar;
        int hashCode8 = (((((((((((hashCode7 + (orderTipBar2 == null ? 0 : orderTipBar2.hashCode())) * 31) + this.sailingBizLine) * 31) + this.ceta21AB) * 31) + this.showDeliveryStatus) * 31) + this.shopPrepareStatus) * 31) + this.isDelayMeal) * 31;
        String str5 = this.delayMealGrade;
        int hashCode9 = (((hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.tipsbarScene) * 31;
        String str6 = this.exceptionScene;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.evaluateSchema;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        return "OrderData(orderId=" + this.orderId + ", preOrderId=" + this.preOrderId + ", shopId=" + this.shopId + ", status=" + this.status + ", statusDesc=" + this.statusDesc + ", createTime=" + this.createTime + ", orderFlows=" + this.orderFlows + ", mapData=" + this.mapData + ", debtData=" + this.debtData + ", completeTime=" + this.completeTime + ", deliveryType=" + this.deliveryType + ", businessMode=" + this.businessMode + ", clientPayType=" + this.clientPayType + ", realComplete=" + this.realComplete + ", orderTipBar=" + this.orderTipBar + ", sailingBizLine=" + this.sailingBizLine + ", ceta21AB=" + this.ceta21AB + ", showDeliveryStatus=" + this.showDeliveryStatus + ", shopPrepareStatus=" + this.shopPrepareStatus + ", isDelayMeal=" + this.isDelayMeal + ", delayMealGrade=" + this.delayMealGrade + ", tipsbarScene=" + this.tipsbarScene + ", exceptionScene=" + this.exceptionScene + ", evaluateSchema=" + this.evaluateSchema + VersionRange.RIGHT_OPEN;
    }

    public OrderData(String str, String str2, String str3, int i, String str4, int i2, List<OrderFlow> list, MapData mapData2, DebtData debtData2, int i3, int i4, int i5, int i6, int i7, OrderTipBar orderTipBar2, int i8, int i9, int i10, int i11, int i12, String str5, int i13, String str6, String str7) {
        this.orderId = str;
        this.preOrderId = str2;
        this.shopId = str3;
        this.status = i;
        this.statusDesc = str4;
        this.createTime = i2;
        this.orderFlows = list;
        this.mapData = mapData2;
        this.debtData = debtData2;
        this.completeTime = i3;
        this.deliveryType = i4;
        this.businessMode = i5;
        this.clientPayType = i6;
        this.realComplete = i7;
        this.orderTipBar = orderTipBar2;
        this.sailingBizLine = i8;
        this.ceta21AB = i9;
        this.showDeliveryStatus = i10;
        this.shopPrepareStatus = i11;
        this.isDelayMeal = i12;
        this.delayMealGrade = str5;
        this.tipsbarScene = i13;
        this.exceptionScene = str6;
        this.evaluateSchema = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderData(java.lang.String r26, java.lang.String r27, java.lang.String r28, int r29, java.lang.String r30, int r31, java.util.List r32, com.didi.soda.customer.foundation.rpc.entity.MapData r33, com.didi.soda.customer.foundation.rpc.entity.DebtData r34, int r35, int r36, int r37, int r38, int r39, com.didi.soda.customer.foundation.rpc.entity.OrderTipBar r40, int r41, int r42, int r43, int r44, int r45, java.lang.String r46, int r47, java.lang.String r48, java.lang.String r49, int r50, kotlin.jvm.internal.DefaultConstructorMarker r51) {
        /*
            r25 = this;
            r0 = r50
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r26
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r27
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r28
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r29
        L_0x0022:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            r7 = 0
            goto L_0x002a
        L_0x0028:
            r7 = r30
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            r8 = 0
            goto L_0x0032
        L_0x0030:
            r8 = r31
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            r9 = 0
            goto L_0x003a
        L_0x0038:
            r9 = r32
        L_0x003a:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            r10 = 0
            goto L_0x0042
        L_0x0040:
            r10 = r33
        L_0x0042:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0048
            r11 = 0
            goto L_0x004a
        L_0x0048:
            r11 = r34
        L_0x004a:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0050
            r12 = 0
            goto L_0x0052
        L_0x0050:
            r12 = r35
        L_0x0052:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            r13 = 0
            goto L_0x005a
        L_0x0058:
            r13 = r36
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0060
            r14 = 0
            goto L_0x0062
        L_0x0060:
            r14 = r37
        L_0x0062:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0068
            r15 = 0
            goto L_0x006a
        L_0x0068:
            r15 = r38
        L_0x006a:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0072
        L_0x0070:
            r2 = r39
        L_0x0072:
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0078
            r6 = 0
            goto L_0x007a
        L_0x0078:
            r6 = r40
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            r17 = 1
            if (r16 == 0) goto L_0x0086
            r16 = 1
            goto L_0x0088
        L_0x0086:
            r16 = r41
        L_0x0088:
            r18 = 65536(0x10000, float:9.18355E-41)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r17 = r42
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r43
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r44
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r45
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r46
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r47
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r48
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r24
            if (r0 == 0) goto L_0x00db
            r0 = 0
            goto L_0x00dd
        L_0x00db:
            r0 = r49
        L_0x00dd:
            r26 = r25
            r27 = r1
            r28 = r3
            r29 = r4
            r30 = r5
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r10
            r35 = r11
            r36 = r12
            r37 = r13
            r38 = r14
            r39 = r15
            r40 = r2
            r41 = r6
            r42 = r16
            r43 = r17
            r44 = r18
            r45 = r19
            r46 = r20
            r47 = r21
            r48 = r22
            r49 = r23
            r50 = r0
            r26.<init>(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.OrderData.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, java.util.List, com.didi.soda.customer.foundation.rpc.entity.MapData, com.didi.soda.customer.foundation.rpc.entity.DebtData, int, int, int, int, int, com.didi.soda.customer.foundation.rpc.entity.OrderTipBar, int, int, int, int, int, java.lang.String, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPreOrderId() {
        return this.preOrderId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStatusDesc() {
        return this.statusDesc;
    }

    public final int getCreateTime() {
        return this.createTime;
    }

    public final List<OrderFlow> getOrderFlows() {
        return this.orderFlows;
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

    public final int getDeliveryType() {
        return this.deliveryType;
    }

    public final int getBusinessMode() {
        return this.businessMode;
    }

    public final int getClientPayType() {
        return this.clientPayType;
    }

    public final int getRealComplete() {
        return this.realComplete;
    }

    public final OrderTipBar getOrderTipBar() {
        return this.orderTipBar;
    }

    public final int getSailingBizLine() {
        return this.sailingBizLine;
    }

    public final int getCeta21AB() {
        return this.ceta21AB;
    }

    public final int getShowDeliveryStatus() {
        return this.showDeliveryStatus;
    }

    public final int getShopPrepareStatus() {
        return this.shopPrepareStatus;
    }

    public final int isDelayMeal() {
        return this.isDelayMeal;
    }

    public final String getDelayMealGrade() {
        return this.delayMealGrade;
    }

    public final int getTipsbarScene() {
        return this.tipsbarScene;
    }

    public final String getExceptionScene() {
        return this.exceptionScene;
    }

    public final String getEvaluateSchema() {
        return this.evaluateSchema;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderData$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
