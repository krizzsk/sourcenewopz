package com.didi.entrega.manager.base;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.order.manager.BatchOrderListener;
import com.didi.entrega.order.manager.OnceOrderListener;
import java.util.List;

public class ICustomerOrderManagerDefault implements ICustomerOrderManager {
    public void clearAllOrdersInMonitor() {
    }

    public String getManagerName() {
        return null;
    }

    public OrderInfoEntity getOrderInfoById(String str) {
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void registerBatchOrderListener(BatchOrderListener batchOrderListener) {
    }

    public void requestOrderInfoById(ScopeContext scopeContext, String str, int i, OnceOrderListener onceOrderListener) {
    }

    public void requestOrderInfoById(String str, int i) {
    }

    public void requestOrderInfoById(String str, int i, OnceOrderListener onceOrderListener) {
    }

    public void subscribe(ScopeContext scopeContext, Action1<CustomerResource<List<OrderInfoEntity>>> action1) {
    }

    public void unregisterBatchOrderListener(BatchOrderListener batchOrderListener) {
    }

    public void updateAllOrdersInMonitor() {
    }
}
