package com.didi.soda.customer.foundation.rpc.entity.order;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/UnevaluatedPopupEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "orderId", "", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "rider", "Lcom/didi/soda/customer/foundation/rpc/entity/order/RiderEvaluationEntity;", "getRider", "()Lcom/didi/soda/customer/foundation/rpc/entity/order/RiderEvaluationEntity;", "setRider", "(Lcom/didi/soda/customer/foundation/rpc/entity/order/RiderEvaluationEntity;)V", "riderId", "getRiderId", "setRiderId", "shop", "Lcom/didi/soda/customer/foundation/rpc/entity/order/ShopEvaluationEntity;", "getShop", "()Lcom/didi/soda/customer/foundation/rpc/entity/order/ShopEvaluationEntity;", "setShop", "(Lcom/didi/soda/customer/foundation/rpc/entity/order/ShopEvaluationEntity;)V", "shopId", "getShopId", "setShopId", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderHistoryEntity.kt */
public final class UnevaluatedPopupEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -3487698325099787942L;
    private String orderId;
    private RiderEvaluationEntity rider;
    private String riderId;
    private ShopEvaluationEntity shop;
    private String shopId;
    private Integer type;

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final void setShopId(String str) {
        this.shopId = str;
    }

    public final String getRiderId() {
        return this.riderId;
    }

    public final void setRiderId(String str) {
        this.riderId = str;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final ShopEvaluationEntity getShop() {
        return this.shop;
    }

    public final void setShop(ShopEvaluationEntity shopEvaluationEntity) {
        this.shop = shopEvaluationEntity;
    }

    public final RiderEvaluationEntity getRider() {
        return this.rider;
    }

    public final void setRider(RiderEvaluationEntity riderEvaluationEntity) {
        this.rider = riderEvaluationEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/UnevaluatedPopupEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderHistoryEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
