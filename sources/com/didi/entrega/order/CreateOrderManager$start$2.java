package com.didi.entrega.order;

import com.didi.entrega.bill.BillOmegaHelper;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.foundation.rpc.entity.OrderCreateEntity;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderManager.kt */
final class CreateOrderManager$start$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CreateOrderManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateOrderManager$start$2(CreateOrderManager createOrderManager) {
        super(0);
        this.this$0 = createOrderManager;
    }

    public final void invoke() {
        final CreateOrderManager createOrderManager = this.this$0;
        createOrderManager.createOrderFunction = new CreateOrderCallBack<OrderCreateEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                createOrderManager.createOrderStatus = 102;
                createOrderManager.consumeCreateFailed(getPreOrderId(), sFRpcException);
            }

            public void onRpcSuccess(OrderCreateEntity orderCreateEntity, long j) {
                Intrinsics.checkNotNullParameter(orderCreateEntity, "order");
                createOrderManager.createOrderStatus = 101;
                LogUtil.m14765i("CreateOrderManager", "consumeCreateSuccess " + createOrderManager.getBillEntity().getCartId() + " order=" + orderCreateEntity.getOrderId() + " isSkipPay=" + orderCreateEntity.getSkipPaymentPoll());
                BillOmegaHelper.tracePayResult$default(BillOmegaHelper.INSTANCE, createOrderManager.getBillEntity().getCartId(), 1, orderCreateEntity.getOrderId(), (Integer) null, (String) null, 24, (Object) null);
                String orderId = orderCreateEntity.getOrderId();
                if (orderId != null) {
                    CreateOrderManager createOrderManager = createOrderManager;
                    ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).requestOrderInfoById(orderCreateEntity.getOrderId(), 1);
                    createOrderManager.timeoutHandler.setOrderId(orderId);
                    if (orderCreateEntity.getSkipPaymentPoll()) {
                        createOrderManager.gotoOrderPage(orderId);
                    } else {
                        createOrderManager.doPay(orderCreateEntity, new CreateOrderManager$start$2$1$onRpcSuccess$1$1(createOrderManager, orderId), new CreateOrderManager$start$2$1$onRpcSuccess$1$2(createOrderManager, orderId));
                    }
                }
            }
        };
        CreateOrderManager createOrderManager2 = this.this$0;
        CreateOrderCallBack access$getCreateOrderFunction$p = createOrderManager2.createOrderFunction;
        if (access$getCreateOrderFunction$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createOrderFunction");
            access$getCreateOrderFunction$p = null;
        }
        CreateOrderManager.createOrder$default(createOrderManager2, 0, access$getCreateOrderFunction$p, 1, (Object) null);
    }
}
