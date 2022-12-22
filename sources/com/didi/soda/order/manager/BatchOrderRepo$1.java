package com.didi.soda.order.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderListEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.order.omega.OrderOmegaHelper;

class BatchOrderRepo$1 extends CustomerRpcCallback<OrderListEntity> {
    final /* synthetic */ C14139a this$0;
    final /* synthetic */ OnceOrderListener val$listener;
    final /* synthetic */ int val$scene;
    final /* synthetic */ ScopeContext val$tag;

    BatchOrderRepo$1(C14139a aVar, ScopeContext scopeContext, OnceOrderListener onceOrderListener, int i) {
        this.this$0 = aVar;
        this.val$tag = scopeContext;
        this.val$listener = onceOrderListener;
        this.val$scene = i;
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        if (this.val$tag != null) {
            super.onRpcFailure(sFRpcException);
            this.this$0.m30840a(sFRpcException, this.val$tag, this.val$listener, this.val$scene);
        } else {
            this.this$0.setValue(CustomerResource.error(sFRpcException.getMessage()));
        }
        OrderOmegaHelper.Companion.trackGetOrderDetailError(ErrorConst.ErrorName.SAILING_C_ORDER_API_ERROR, sFRpcException.getMessage(), sFRpcException.getCode());
        LogUtil.m29104i("BatchOrderRepo", "requestBatchOrders request orderIds: onRpcFailure");
    }

    public void onRpcSuccess(OrderListEntity orderListEntity, long j) {
        OrderInfoEntity orderInfoEntity;
        if (orderListEntity == null || CollectionsUtil.isEmpty(orderListEntity.mOrderDetailEntityList)) {
            orderInfoEntity = null;
        } else {
            orderInfoEntity = orderListEntity.mOrderDetailEntityList.get(0);
            this.this$0.mo108561a(this.val$scene);
            this.this$0.m30848b(orderListEntity.mOrderDetailEntityList, this.val$scene);
            this.this$0.m30837a(orderInfoEntity);
        }
        this.this$0.m30839a(orderListEntity, orderInfoEntity, this.val$tag, this.val$listener, this.val$scene);
    }
}
