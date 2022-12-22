package com.didi.soda.order.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutListEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.order.omega.OrderOmegaHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/order/manager/BatchOrderLayoutRepo$requestBatchOrders$rpc$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutListEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "data", "serviceTime", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BatchOrderLayoutRepo.kt */
public final class BatchOrderLayoutRepo$requestBatchOrders$rpc$1 extends CustomerRpcCallback<OrderLayoutListEntity> {
    final /* synthetic */ OnceOrderLayoutsListener $listener;
    final /* synthetic */ int $scene;
    final /* synthetic */ ScopeContext $tag;
    final /* synthetic */ BatchOrderLayoutRepo this$0;

    BatchOrderLayoutRepo$requestBatchOrders$rpc$1(ScopeContext scopeContext, BatchOrderLayoutRepo batchOrderLayoutRepo, OnceOrderLayoutsListener onceOrderLayoutsListener, int i) {
        this.$tag = scopeContext;
        this.this$0 = batchOrderLayoutRepo;
        this.$listener = onceOrderLayoutsListener;
        this.$scene = i;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        if (this.$tag != null) {
            super.onRpcFailure(sFRpcException);
            this.this$0.m30833a(sFRpcException, this.$tag, this.$listener);
        } else {
            this.this$0.setValue(CustomerResource.error(sFRpcException.getMessage()));
        }
        OrderOmegaHelper.Companion.trackGetOrderDetailError(ErrorConst.ErrorName.SAILING_C_ORDER_API_ERROR_NEW, sFRpcException.getMessage(), sFRpcException.getCode());
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
        this.this$0.m30832a(orderLayoutEntity, this.$tag, this.$listener);
    }
}
