package com.didi.soda.bill.manager;

import android.os.Bundle;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcCallBackWithTraceId;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/soda/bill/manager/CreateOrderDispatcher$createOrder$1", "Lcom/didi/soda/customer/foundation/rpc/net/CRpcCallBackWithTraceId;", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "order", "time", "", "traceId", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderDispatcher.kt */
public final class CreateOrderDispatcher$createOrder$1 extends CRpcCallBackWithTraceId<OrderInfoEntity> {
    final /* synthetic */ CreateOrderState $orderState;
    final /* synthetic */ CreateOrderDispatcher this$0;

    CreateOrderDispatcher$createOrder$1(CreateOrderState createOrderState, CreateOrderDispatcher createOrderDispatcher) {
        this.$orderState = createOrderState;
        this.this$0 = createOrderDispatcher;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Bundle bundle = new Bundle();
        bundle.putString("preOrderId", this.$orderState.getPreOrderId());
        bundle.putSerializable("exception", sFRpcException);
        this.this$0.dispatch(CreateOrderDispatcher.Companion.createOrderError(bundle));
    }

    public void onRpcSuccess(OrderInfoEntity orderInfoEntity, long j, String str) {
        Intrinsics.checkNotNullParameter(str, "traceId");
        if (orderInfoEntity != null) {
            CreateOrderState createOrderState = this.$orderState;
            CreateOrderDispatcher createOrderDispatcher = this.this$0;
            orderInfoEntity.preOrderId = createOrderState.getPreOrderId();
            createOrderState.setTraceId(str);
            createOrderDispatcher.dispatch(CreateOrderDispatcher.Companion.createOrderSuccess(orderInfoEntity));
        }
    }
}
