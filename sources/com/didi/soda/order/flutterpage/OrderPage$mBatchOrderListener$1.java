package com.didi.soda.order.flutterpage;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.OrderData;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.order.manager.BatchOrderLayoutListener;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/order/flutterpage/OrderPage$mBatchOrderListener$1", "Lcom/didi/soda/order/manager/BatchOrderLayoutListener;", "onBatchOrderLayout", "", "datas", "", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderPage.kt */
public final class OrderPage$mBatchOrderListener$1 extends BatchOrderLayoutListener {
    final /* synthetic */ OrderPage this$0;

    OrderPage$mBatchOrderListener$1(OrderPage orderPage) {
        this.this$0 = orderPage;
    }

    public void onBatchOrderLayout(List<OrderLayoutEntity> list) {
        OrderData orderData;
        OrderLayoutEntity orderLayoutById = ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).getOrderLayoutById(this.this$0.f43477a);
        if (orderLayoutById == null) {
            orderLayoutById = ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).getOrderLayoutByPreId(this.this$0.f43477a);
        }
        if (orderLayoutById != null) {
            PageRenderingTrackerNew.Companion.trackEndAndReportUtil(this.this$0.getScopeContext());
        }
        OrderServicePlugin access$getOrderServicePlugin$p = this.this$0.f43488l;
        if (access$getOrderServicePlugin$p != null) {
            access$getOrderServicePlugin$p.sendOrderInfo(orderLayoutById);
        }
        this.this$0.m30814b(orderLayoutById);
        if (this.this$0.f43493q) {
            if (orderLayoutById == null) {
                orderData = null;
            } else {
                orderData = orderLayoutById.getOrderData();
            }
            if (orderData != null && !TextUtils.isEmpty(orderData.getOrderId())) {
                this.this$0.m30812a(orderData.getShopId());
                this.this$0.f43493q = false;
            }
        }
    }
}
