package com.didi.entrega.order.page;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.order.manager.BatchOrderListener;
import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.order.GLEUniOrderDataService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/entrega/order/page/OrderPage$mBatchOrderListener$1", "Lcom/didi/entrega/order/manager/BatchOrderListener;", "onBatchOrderListener", "", "data", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderInfoEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderPage.kt */
public final class OrderPage$mBatchOrderListener$1 extends BatchOrderListener {
    final /* synthetic */ OrderPage this$0;

    OrderPage$mBatchOrderListener$1(OrderPage orderPage) {
        this.this$0 = orderPage;
    }

    public void onBatchOrderListener(List<OrderInfoEntity> list) {
        OrderInfoEntity orderInfoById = this.this$0.f20903i.getOrderInfoById(this.this$0.f20895a);
        if (orderInfoById != null) {
            ((GLEUniOrderDataService) UniAPI.get(GLEUniOrderDataService.class)).updateOrderData(GsonUtil.toJson(orderInfoById), new OrderPage$mBatchOrderListener$1$onBatchOrderListener$1());
            this.this$0.m15334b(orderInfoById);
            LogUtil.m14765i("EntregaOrderPage", Intrinsics.stringPlus("BatchOrderListener receive ", this.this$0.f20895a));
        }
    }
}
