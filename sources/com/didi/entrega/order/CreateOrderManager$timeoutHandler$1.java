package com.didi.entrega.order;

import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/entrega/order/CreateOrderManager$timeoutHandler$1", "Lcom/didi/entrega/order/PayTimeoutHandler;", "run", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderManager.kt */
public final class CreateOrderManager$timeoutHandler$1 extends PayTimeoutHandler {
    final /* synthetic */ CreateOrderManager this$0;

    CreateOrderManager$timeoutHandler$1(CreateOrderManager createOrderManager) {
        this.this$0 = createOrderManager;
    }

    public void run() {
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_CART_PAY_TIMEOUT).addParam("event_type", Integer.valueOf(this.this$0.createOrderStatus > 100 ? 2 : 1)).addModuleName("bill").build().trackError();
        this.this$0.gotoOrderPage(getOrderId());
    }
}
