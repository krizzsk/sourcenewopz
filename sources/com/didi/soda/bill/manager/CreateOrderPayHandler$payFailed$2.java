package com.didi.soda.bill.manager;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.OrderCancelEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.manager.base.ICustomerPayManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/bill/manager/CreateOrderPayHandler$payFailed$2", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderCancelEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "var1", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderPayHandler.kt */
public final class CreateOrderPayHandler$payFailed$2 extends CustomerRpcCallback<OrderCancelEntity> {
    final /* synthetic */ OrderInfoEntity $order;
    final /* synthetic */ CreateOrderState $outerState;
    final /* synthetic */ SceneParamsEntity $sceneParam;
    final /* synthetic */ CreateOrderPayHandler this$0;

    CreateOrderPayHandler$payFailed$2(CreateOrderPayHandler createOrderPayHandler, CreateOrderState createOrderState, OrderInfoEntity orderInfoEntity, SceneParamsEntity sceneParamsEntity) {
        this.this$0 = createOrderPayHandler;
        this.$outerState = createOrderState;
        this.$order = orderInfoEntity;
        this.$sceneParam = sceneParamsEntity;
    }

    public void onRpcSuccess(OrderCancelEntity orderCancelEntity, long j) {
        LogUtil.m29104i(CreateOrderPayHandler.TAG, "payFailed -> cancelOrder success");
        this.this$0.m27739a(this.$outerState.getShopId());
        Object object = this.this$0.f39018c.getObject("bill_pay_callback");
        if (object != null) {
            String str = this.$order.orderId;
            Intrinsics.checkNotNullExpressionValue(str, "order.orderId");
            ((ICustomerPayManager.BillPayCallback) object).recoverBill(str, 100, this.$sceneParam);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.BillPayCallback");
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        LogUtil.m29104i(CreateOrderPayHandler.TAG, "payFailed -> cancelOrder failure");
        this.this$0.m27739a(this.$outerState.getShopId());
        Object object = this.this$0.f39018c.getObject("bill_pay_callback");
        if (object != null) {
            String str = this.$order.orderId;
            Intrinsics.checkNotNullExpressionValue(str, "order.orderId");
            ((ICustomerPayManager.BillPayCallback) object).recoverBill(str, 100, this.$sceneParam);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.BillPayCallback");
    }
}
