package com.didi.entrega.manager.base;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.order.manager.BatchOrderListener;
import com.didi.entrega.order.manager.OnceOrderListener;
import java.util.List;

public interface ICustomerOrderManager extends ICustomerManager {
    void clearAllOrdersInMonitor();

    OrderInfoEntity getOrderInfoById(String str);

    void registerBatchOrderListener(BatchOrderListener batchOrderListener);

    void requestOrderInfoById(ScopeContext scopeContext, String str, int i, OnceOrderListener onceOrderListener);

    void requestOrderInfoById(String str, int i);

    void requestOrderInfoById(String str, int i, OnceOrderListener onceOrderListener);

    void subscribe(ScopeContext scopeContext, Action1<CustomerResource<List<OrderInfoEntity>>> action1);

    void unregisterBatchOrderListener(BatchOrderListener batchOrderListener);

    void updateAllOrdersInMonitor();
}
