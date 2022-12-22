package com.didi.soda.order.manager;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutListEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/order/manager/BatchOrderLayoutRepo$requestBatchOrders$2", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutListEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "data", "serviceTime", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BatchOrderLayoutRepo.kt */
public final class BatchOrderLayoutRepo$requestBatchOrders$2 extends CustomerRpcCallback<OrderLayoutListEntity> {
    final /* synthetic */ OnceOrderLayoutsListener $listener;
    final /* synthetic */ int $scene;
    final /* synthetic */ BatchOrderLayoutRepo this$0;

    BatchOrderLayoutRepo$requestBatchOrders$2(OnceOrderLayoutsListener onceOrderLayoutsListener, BatchOrderLayoutRepo batchOrderLayoutRepo, int i) {
        this.$listener = onceOrderLayoutsListener;
        this.this$0 = batchOrderLayoutRepo;
        this.$scene = i;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        super.onRpcFailure(sFRpcException);
        OnceOrderLayoutsListener onceOrderLayoutsListener = this.$listener;
        if (onceOrderLayoutsListener != null) {
            onceOrderLayoutsListener.onOnceOrderListener((OrderLayoutEntity) null, sFRpcException.getCode());
        }
        LogUtil.m29104i("BatchOrderLayoutsRepo", "requestBatchOrders request orderIds: onRpcFailure");
    }

    public void onRpcSuccess(OrderLayoutListEntity orderLayoutListEntity, long j) {
        OrderLayoutEntity orderLayoutEntity = null;
        if (orderLayoutListEntity != null) {
            BatchOrderLayoutRepo batchOrderLayoutRepo = this.this$0;
            int i = this.$scene;
            if (!CollectionsUtil.isEmpty(orderLayoutListEntity.getOrders())) {
                List<OrderLayoutEntity> orders = orderLayoutListEntity.getOrders();
                if (orders != null) {
                    orderLayoutEntity = orders.get(0);
                }
                batchOrderLayoutRepo.trackScene(i);
                batchOrderLayoutRepo.m30834a(orderLayoutListEntity.getOrders());
            }
        }
        OnceOrderLayoutsListener onceOrderLayoutsListener = this.$listener;
        if (onceOrderLayoutsListener != null) {
            onceOrderLayoutsListener.onOnceOrderListener(orderLayoutEntity, 0);
        }
    }
}
