package com.didi.soda.customer.foundation.rpc.entity.order;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderHistoryItemEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "buttons", "", "Lcom/didi/soda/customer/foundation/rpc/entity/order/ButtonEntity;", "getButtons", "()Ljava/util/List;", "setButtons", "(Ljava/util/List;)V", "itemInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/order/ItemInfoEntity;", "getItemInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/order/ItemInfoEntity;", "setItemInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/order/ItemInfoEntity;)V", "orderInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderInfoEntity;", "getOrderInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderInfoEntity;", "setOrderInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderInfoEntity;)V", "shopInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/order/ShopInfoEntity;", "getShopInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/order/ShopInfoEntity;", "setShopInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/order/ShopInfoEntity;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderHistoryEntity.kt */
public final class OrderHistoryItemEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 6060087576082004354L;
    private List<ButtonEntity> buttons;
    private ItemInfoEntity itemInfo;
    private OrderInfoEntity orderInfo;
    private ShopInfoEntity shopInfo;

    public final ShopInfoEntity getShopInfo() {
        return this.shopInfo;
    }

    public final void setShopInfo(ShopInfoEntity shopInfoEntity) {
        this.shopInfo = shopInfoEntity;
    }

    public final ItemInfoEntity getItemInfo() {
        return this.itemInfo;
    }

    public final void setItemInfo(ItemInfoEntity itemInfoEntity) {
        this.itemInfo = itemInfoEntity;
    }

    public final List<ButtonEntity> getButtons() {
        return this.buttons;
    }

    public final void setButtons(List<ButtonEntity> list) {
        this.buttons = list;
    }

    public final OrderInfoEntity getOrderInfo() {
        return this.orderInfo;
    }

    public final void setOrderInfo(OrderInfoEntity orderInfoEntity) {
        this.orderInfo = orderInfoEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderHistoryItemEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderHistoryEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
