package com.didi.entrega.orderlist.component;

import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.orderlist.binder.OrderListItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/orderlist/component/OrderListPresenter$refreshOrderInfoById$callback$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderListItemEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "var2", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListPresenter.kt */
public final class OrderListPresenter$refreshOrderInfoById$callback$1 extends CustomerRpcCallback<OrderListItemEntity> {
    final /* synthetic */ OrderListPresenter this$0;

    OrderListPresenter$refreshOrderInfoById$callback$1(OrderListPresenter orderListPresenter) {
        this.this$0 = orderListPresenter;
    }

    public void onRpcSuccess(OrderListItemEntity orderListItemEntity, long j) {
        String str;
        OrderListItemEntity data;
        HistoryOrderInfoEntity orderInfo;
        ChildDataListManager access$getListManager$p = this.this$0.f20980a;
        if (access$getListManager$p != null) {
            if (!(!this.this$0.f20982c)) {
                access$getListManager$p = null;
            }
            if (access$getListManager$p != null) {
                OrderListPresenter orderListPresenter = this.this$0;
                int i = 0;
                int count = access$getListManager$p.getCount();
                if (count > 0) {
                    while (true) {
                        int i2 = i + 1;
                        OrderListItemModel orderListItemModel = (OrderListItemModel) access$getListManager$p.get(i);
                        if (orderListItemModel == null || (data = orderListItemModel.getData()) == null || (orderInfo = data.getOrderInfo()) == null) {
                            str = null;
                        } else {
                            str = orderInfo.getOrderId();
                        }
                        if (Intrinsics.areEqual((Object) str, (Object) orderListPresenter.f20983d.getOrderId())) {
                            if (orderListItemModel != null) {
                                orderListItemModel.setData(orderListItemEntity);
                            }
                            access$getListManager$p.set(i, orderListItemModel);
                        } else if (i2 >= count) {
                            break;
                        } else {
                            i = i2;
                        }
                    }
                }
            }
        }
        this.this$0.m15360d();
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        LogUtil.m14765i("OrderListPresenter", "fetchOrderInfo onRpcFailure");
        super.onRpcFailure(sFRpcException);
        this.this$0.m15360d();
    }
}
