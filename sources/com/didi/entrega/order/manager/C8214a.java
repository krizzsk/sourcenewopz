package com.didi.entrega.order.manager;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcService;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderData;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListEntity;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.order.pool.OrderLimitQueue;
import com.didi.entrega.order.pool.OrderMixService;
import com.didichuxing.foundation.rpc.Rpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.entrega.order.manager.a */
/* compiled from: BatchOrderRepo */
class C8214a extends Repo<CustomerResource<List<OrderInfoEntity>>> {

    /* renamed from: b */
    private static final String f20890b = "EntregaBatchOrderRepo";

    /* renamed from: a */
    public CustomerRpcService f20891a = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private final OrderLimitQueue f20892c = new OrderLimitQueue();

    /* renamed from: d */
    private final List<BatchOrderListener> f20893d = new ArrayList();

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f20893d.clear();
        this.f20892c.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62411a(BatchOrderListener batchOrderListener) {
        if (!this.f20893d.contains(batchOrderListener)) {
            this.f20893d.add(batchOrderListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo62415b(BatchOrderListener batchOrderListener) {
        this.f20893d.remove(batchOrderListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62412a(String str, int i, OnceOrderListener onceOrderListener) {
        if (!TextUtils.isEmpty(str)) {
            mo62409a(i);
            m15304a(str, (ScopeContext) null, onceOrderListener, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62410a(ScopeContext scopeContext, String str, int i, OnceOrderListener onceOrderListener) {
        if (!TextUtils.isEmpty(str)) {
            mo62409a(i);
            m15304a(str, scopeContext, onceOrderListener, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62408a() {
        this.f20892c.clear();
        OrderMixService.getInstance().reset();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public OrderInfoEntity mo62407a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f20892c.getOrderById(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public OrderInfoEntity mo62413b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator iterator = this.f20892c.getIterator();
        while (iterator.hasNext()) {
            OrderInfoEntity orderInfoEntity = (OrderInfoEntity) ((Map.Entry) iterator.next()).getValue();
            if (orderInfoEntity != null && orderInfoEntity.getOrderData() != null && str.equals(orderInfoEntity.getOrderData().getPreOrderId())) {
                return orderInfoEntity;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo62414b() {
        return this.f20892c.getOrderIds();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo62409a(int i) {
        LogUtil.m14765i(f20890b, "trackScene:" + i);
    }

    /* renamed from: a */
    private C8214a m15304a(String str, ScopeContext scopeContext, OnceOrderListener onceOrderListener, int i) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        LogUtil.m14765i(f20890b, "request orderIds:" + str);
        Rpc orderDetailBatch = this.f20891a.getOrderDetailBatch(str, new BatchOrderRepo$1(this, scopeContext, onceOrderListener, i));
        if (scopeContext != null) {
            autoRelease(scopeContext, orderDetailBatch);
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15308a(SFRpcException sFRpcException, ScopeContext scopeContext, OnceOrderListener onceOrderListener) {
        if (!scopeContext.getLiveHandler().isDestroyed()) {
            m15316d();
            m15312a((List<OrderInfoEntity>) null);
            if (onceOrderListener != null) {
                onceOrderListener.onOnceOrderListener((OrderInfoEntity) null, sFRpcException.getCode());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15307a(OrderListEntity orderListEntity, OrderInfoEntity orderInfoEntity, ScopeContext scopeContext, OnceOrderListener onceOrderListener) {
        if (scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
            m15306a(orderListEntity);
            if (orderInfoEntity == null) {
                m15312a((List<OrderInfoEntity>) null);
            }
            if (onceOrderListener != null) {
                onceOrderListener.onOnceOrderListener(orderInfoEntity, 0);
            }
        }
    }

    /* renamed from: a */
    private void m15305a(OrderInfoEntity orderInfoEntity) {
        if (orderInfoEntity != null) {
            LogUtil.m14765i(f20890b, "addOrderEntity:" + orderInfoEntity);
            this.f20892c.add(orderInfoEntity);
            m15315c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15312a(List<OrderInfoEntity> list) {
        LogUtil.m14765i(f20890b, "addOrderEntitys:" + list);
        if (!CollectionsUtil.isEmpty(list)) {
            for (OrderInfoEntity add : list) {
                this.f20892c.add(add);
            }
        }
        m15315c();
    }

    /* renamed from: c */
    private void m15315c() {
        List list = this.f20892c.getList();
        for (BatchOrderListener onBatchOrderListener : this.f20893d) {
            onBatchOrderListener.onBatchOrderListener(list);
        }
        synchronized (this.f20892c) {
            this.f20892c.onChange();
            List list2 = this.f20892c.getList();
            if (m15313a((List<OrderInfoEntity>) list, (List<OrderInfoEntity>) list2)) {
                setValue(CustomerResource.change(list2));
            }
            LogUtil.m14765i(f20890b, "onChange =" + list2);
        }
    }

    /* renamed from: a */
    private boolean m15313a(List<OrderInfoEntity> list, List<OrderInfoEntity> list2) {
        if (list.size() != list2.size()) {
            return true;
        }
        Iterator<OrderInfoEntity> it = list2.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                return false;
            }
            OrderData orderData = it.next().getOrderData();
            if (orderData != null && !TextUtils.isEmpty(orderData.getOrderId())) {
                String orderId = orderData.getOrderId();
                int status = orderData.getStatus();
                for (OrderInfoEntity orderData2 : list) {
                    OrderData orderData3 = orderData2.getOrderData();
                    if (orderData3 != null && !TextUtils.isEmpty(orderData3.getOrderId())) {
                        String orderId2 = orderData3.getOrderId();
                        int status2 = orderData3.getStatus();
                        if (orderId != null && orderId.equals(orderId2)) {
                            if (status2 < 1800 && status >= 1800) {
                                return true;
                            }
                            z = true;
                        }
                    }
                }
                if (!z) {
                    return true;
                }
            }
        }
    }

    /* renamed from: d */
    private void m15316d() {
        RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f20890b).setMessage("requestOrderInfoById-->onRpcFailure").build().info();
    }

    /* renamed from: a */
    private void m15306a(OrderListEntity orderListEntity) {
        RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f20890b).setMessage("requestOrderInfoById-->onRpcSuccess").setOtherParam("data", orderListEntity.toString()).build().info();
    }

    /* renamed from: b */
    private void m15314b(OrderInfoEntity orderInfoEntity) {
        int i;
        String str;
        if (orderInfoEntity == null || orderInfoEntity.getOrderData() == null) {
            str = null;
            i = Const.OrderStatus.DEFAULT;
        } else {
            str = orderInfoEntity.getOrderData().getOrderId();
            i = orderInfoEntity.getOrderData().getStatus();
        }
        RecordTracker.Builder tag = RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f20890b);
        tag.setMessage("updatePushOrderData" + str + "order status" + i).build().info();
    }
}
