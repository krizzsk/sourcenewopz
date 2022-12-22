package com.didi.soda.order.component.contact;

import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderListEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.DialogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/order/component/contact/OrderContactUtil$Companion$requestOrderInfoById$rpc$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderListEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "orderListEntity", "code", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderContactUtil.kt */
public final class OrderContactUtil$Companion$requestOrderInfoById$rpc$1 extends CustomerRpcCallback<OrderListEntity> {
    final /* synthetic */ Function1<OrderInfoEntity, Unit> $action;

    OrderContactUtil$Companion$requestOrderInfoById$rpc$1(Function1<? super OrderInfoEntity, Unit> function1) {
        this.$action = function1;
    }

    public void onRpcSuccess(OrderListEntity orderListEntity, long j) {
        List<OrderInfoEntity> list;
        DialogUtil.hideLoadingDialog();
        Function1<OrderInfoEntity, Unit> function1 = this.$action;
        OrderInfoEntity orderInfoEntity = null;
        if (!(orderListEntity == null || (list = orderListEntity.mOrderDetailEntityList) == null)) {
            orderInfoEntity = list.get(0);
        }
        function1.invoke(orderInfoEntity);
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        super.onRpcFailure(sFRpcException);
        DialogUtil.hideLoadingDialog();
        this.$action.invoke(null);
    }
}
