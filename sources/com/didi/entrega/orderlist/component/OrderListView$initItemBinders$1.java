package com.didi.entrega.orderlist.component;

import com.didi.entrega.customer.foundation.rpc.entity.order.ButtonEntity;
import com.didi.entrega.orderlist.binder.OrderListItemBinder;
import com.didi.entrega.orderlist.binder.OrderListItemModel;
import com.didi.entrega.orderlist.component.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/entrega/orderlist/component/OrderListView$initItemBinders$1", "Lcom/didi/entrega/orderlist/binder/OrderListItemBinder;", "buttonGroupClick", "", "buttonEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/ButtonEntity;", "itemModel", "Lcom/didi/entrega/orderlist/binder/OrderListItemModel;", "goOrderPage", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListView.kt */
public final class OrderListView$initItemBinders$1 extends OrderListItemBinder {
    final /* synthetic */ OrderListView this$0;

    OrderListView$initItemBinders$1(OrderListView orderListView) {
        this.this$0 = orderListView;
    }

    public void buttonGroupClick(ButtonEntity buttonEntity, OrderListItemModel orderListItemModel) {
        Intrinsics.checkNotNullParameter(orderListItemModel, "itemModel");
        ((Contract.IOrderListPresenter) this.this$0.getPresenter()).buttonGroupClick(buttonEntity, orderListItemModel);
    }

    public void goOrderPage(OrderListItemModel orderListItemModel) {
        Intrinsics.checkNotNullParameter(orderListItemModel, "itemModel");
        ((Contract.IOrderListPresenter) this.this$0.getPresenter()).goOrderPage(orderListItemModel);
    }
}
