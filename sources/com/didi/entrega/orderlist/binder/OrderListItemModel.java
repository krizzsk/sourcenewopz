package com.didi.entrega.orderlist.binder;

import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/binder/OrderListItemModel;", "", "data", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderListItemEntity;", "(Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderListItemEntity;)V", "getData", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderListItemEntity;", "setData", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListItemBinder.kt */
public final class OrderListItemModel {

    /* renamed from: a */
    private OrderListItemEntity f20975a;

    public OrderListItemModel(OrderListItemEntity orderListItemEntity) {
        this.f20975a = orderListItemEntity;
    }

    public final OrderListItemEntity getData() {
        return this.f20975a;
    }

    public final void setData(OrderListItemEntity orderListItemEntity) {
        this.f20975a = orderListItemEntity;
    }
}
