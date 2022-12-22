package com.didi.soda.order.flutterpage;

import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.soda.customer.foundation.rpc.entity.OrderData;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.order.manager.OnceOrderLayoutsListener;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/order/flutterpage/OrderPage$updateOrderInfo$1", "Lcom/didi/soda/order/manager/OnceOrderLayoutsListener;", "onOnceOrderListener", "", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity;", "code", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderPage.kt */
public final class OrderPage$updateOrderInfo$1 implements OnceOrderLayoutsListener {
    final /* synthetic */ OnPluginResultListener $resultListener;
    final /* synthetic */ OrderPage this$0;

    OrderPage$updateOrderInfo$1(OnPluginResultListener onPluginResultListener, OrderPage orderPage) {
        this.$resultListener = onPluginResultListener;
        this.this$0 = orderPage;
    }

    public void onOnceOrderListener(OrderLayoutEntity orderLayoutEntity, int i) {
        OrderData orderData;
        String evaluateSchema;
        OnPluginResultListener onPluginResultListener = this.$resultListener;
        if (onPluginResultListener != null) {
            onPluginResultListener.onResult(orderLayoutEntity);
        }
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateOrder2Monitor(this.this$0.f43477a, 5);
        if (orderLayoutEntity != null && (orderData = orderLayoutEntity.getOrderData()) != null && (evaluateSchema = orderData.getEvaluateSchema()) != null) {
            this.this$0.f43494r = 0;
            SchemeHelper.dispatchMsg(evaluateSchema);
        }
    }
}
