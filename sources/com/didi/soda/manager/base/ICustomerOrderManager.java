package com.didi.soda.manager.base;

import android.content.Context;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.order.manager.BatchOrderLayoutListener;
import com.didi.soda.order.manager.BatchOrderListener;
import com.didi.soda.order.manager.OnceOrderLayoutsListener;
import com.didi.soda.order.manager.OnceOrderListener;
import java.util.List;

public interface ICustomerOrderManager extends ICustomerManager {
    void addOrderEntity2Monitor(OrderInfoEntity orderInfoEntity, int i);

    void addOrderEntity2Monitor(List<OrderInfoEntity> list, int i);

    void clearAllOrdersInMonitor();

    OrderInfoEntity getOrderInfoById(String str);

    OrderInfoEntity getOrderInfoByPreId(String str);

    OrderLayoutEntity getOrderLayoutById(String str);

    OrderLayoutEntity getOrderLayoutByPreId(String str);

    void onJsContactAction(Context context, ScopeContext scopeContext, String str, int i, int i2);

    void registerBatchOrderLayoutListener(BatchOrderLayoutListener batchOrderLayoutListener);

    void registerBatchOrderListener(BatchOrderListener batchOrderListener);

    void requestOrderInfoById(ScopeContext scopeContext, String str, OnceOrderListener onceOrderListener);

    void requestOrderLayoutById(ScopeContext scopeContext, String str, int i, OnceOrderLayoutsListener onceOrderLayoutsListener);

    void requestOrderLayoutById(String str, int i, OnceOrderLayoutsListener onceOrderLayoutsListener);

    void subscribe(ScopeContext scopeContext, Action1<CustomerResource<List<OrderInfoEntity>>> action1);

    void unregisterBatchOrderLayoutListener(BatchOrderLayoutListener batchOrderLayoutListener);

    void unregisterBatchOrderListener(BatchOrderListener batchOrderListener);

    void updateAllOrdersInMonitor();

    void updateOrder2Monitor(String str);

    void updateOrder2Monitor(String str, int i);
}
