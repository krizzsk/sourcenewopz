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

public class ICustomerOrderManagerDefault implements ICustomerOrderManager {
    public void addOrderEntity2Monitor(OrderInfoEntity orderInfoEntity, int i) {
    }

    public void addOrderEntity2Monitor(List<OrderInfoEntity> list, int i) {
    }

    public void clearAllOrdersInMonitor() {
    }

    public String getManagerName() {
        return null;
    }

    public OrderInfoEntity getOrderInfoById(String str) {
        return null;
    }

    public OrderInfoEntity getOrderInfoByPreId(String str) {
        return null;
    }

    public OrderLayoutEntity getOrderLayoutById(String str) {
        return null;
    }

    public OrderLayoutEntity getOrderLayoutByPreId(String str) {
        return null;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onJsContactAction(Context context, ScopeContext scopeContext, String str, int i, int i2) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void registerBatchOrderLayoutListener(BatchOrderLayoutListener batchOrderLayoutListener) {
    }

    public void registerBatchOrderListener(BatchOrderListener batchOrderListener) {
    }

    public void requestOrderInfoById(ScopeContext scopeContext, String str, OnceOrderListener onceOrderListener) {
    }

    public void requestOrderLayoutById(ScopeContext scopeContext, String str, int i, OnceOrderLayoutsListener onceOrderLayoutsListener) {
    }

    public void requestOrderLayoutById(String str, int i, OnceOrderLayoutsListener onceOrderLayoutsListener) {
    }

    public void subscribe(ScopeContext scopeContext, Action1<CustomerResource<List<OrderInfoEntity>>> action1) {
    }

    public void unregisterBatchOrderLayoutListener(BatchOrderLayoutListener batchOrderLayoutListener) {
    }

    public void unregisterBatchOrderListener(BatchOrderListener batchOrderListener) {
    }

    public void updateAllOrdersInMonitor() {
    }

    public void updateOrder2Monitor(String str) {
    }

    public void updateOrder2Monitor(String str, int i) {
    }
}
