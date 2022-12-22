package com.didi.soda.order.manager;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.biz.order.OrderLimitQueue;
import com.didi.soda.customer.biz.order.OrderMixService;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderListEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didichuxing.foundation.rpc.Rpc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.soda.order.manager.a */
/* compiled from: BatchOrderRepo */
class C14139a extends Repo<CustomerResource<List<OrderInfoEntity>>> {

    /* renamed from: b */
    private static final String f43510b = "BatchOrderRepo";

    /* renamed from: a */
    public CustomerRpcService f43511a = CustomerRpcManagerProxy.get();

    /* renamed from: c */
    private OrderLimitQueue f43512c = new OrderLimitQueue();

    /* renamed from: d */
    private ArrayList<String> f43513d = new ArrayList<>();

    /* renamed from: e */
    private List<BatchOrderListener> f43514e = new ArrayList();

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f43513d.clear();
        this.f43514e.clear();
        this.f43512c.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108563a(BatchOrderListener batchOrderListener) {
        if (!this.f43514e.contains(batchOrderListener)) {
            this.f43514e.add(batchOrderListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo108570b(BatchOrderListener batchOrderListener) {
        this.f43514e.remove(batchOrderListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108565a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            mo108564a(str);
            m30836a(str, (ScopeContext) null, (OnceOrderListener) null, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108566a(String str, ScopeContext scopeContext, OnceOrderListener onceOrderListener) {
        if (!TextUtils.isEmpty(str)) {
            m30836a(str, scopeContext, onceOrderListener, 5);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108564a(String str) {
        String[] split;
        if (str != null && !TextUtils.isEmpty(str) && (split = str.replace(" ", "").split(",")) != null && split.length != 0) {
            for (String str2 : split) {
                if (!this.f43513d.contains(str2)) {
                    this.f43513d.add(str2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108562a(OrderInfoEntity orderInfoEntity, int i) {
        if (i == 3) {
            m30846b(orderInfoEntity);
        }
        mo108561a(i);
        m30847b(orderInfoEntity, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108567a(List<OrderInfoEntity> list, int i) {
        mo108561a(i);
        m30848b(list, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108560a() {
        this.f43513d.clear();
        this.f43512c.clear();
        OrderMixService.getInstance().reset();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public OrderInfoEntity mo108568b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f43512c.getOrderById(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public OrderInfoEntity mo108571c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator iterator = this.f43512c.getIterator();
        while (iterator.hasNext()) {
            OrderInfoEntity orderInfoEntity = (OrderInfoEntity) ((Map.Entry) iterator.next()).getValue();
            if (orderInfoEntity != null && str.equals(orderInfoEntity.preOrderId)) {
                return orderInfoEntity;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo108569b() {
        return this.f43512c.getOrderIds(this.f43513d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108561a(int i) {
        LogUtil.m29104i(f43510b, "trackScene:" + i);
    }

    /* renamed from: a */
    private C14139a m30836a(String str, ScopeContext scopeContext, OnceOrderListener onceOrderListener, int i) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        LogUtil.m29104i(f43510b, "request orderIds:" + str);
        Rpc orderDetailBatch = this.f43511a.getOrderDetailBatch(str, new BatchOrderRepo$1(this, scopeContext, onceOrderListener, i));
        if (scopeContext != null) {
            autoRelease(scopeContext, orderDetailBatch);
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30840a(SFRpcException sFRpcException, ScopeContext scopeContext, OnceOrderListener onceOrderListener, int i) {
        if (!scopeContext.getLiveHandler().isDestroyed()) {
            m30849c();
            m30848b((List<OrderInfoEntity>) null, i);
            if (onceOrderListener != null) {
                onceOrderListener.onOnceOrderListener((OrderInfoEntity) null, sFRpcException.getCode());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30839a(OrderListEntity orderListEntity, OrderInfoEntity orderInfoEntity, ScopeContext scopeContext, OnceOrderListener onceOrderListener, int i) {
        if (scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
            m30838a(orderListEntity);
            if (orderInfoEntity == null) {
                m30848b((List<OrderInfoEntity>) null, i);
            }
            if (onceOrderListener != null) {
                onceOrderListener.onOnceOrderListener(orderInfoEntity, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30837a(OrderInfoEntity orderInfoEntity) {
        if (orderInfoEntity != null && orderInfoEntity.orderId != null) {
            this.f43513d.remove(orderInfoEntity.orderId);
        }
    }

    /* renamed from: b */
    private void m30847b(OrderInfoEntity orderInfoEntity, int i) {
        if (orderInfoEntity != null) {
            LogUtil.m29104i(f43510b, "addOrderEntity:" + orderInfoEntity);
            this.f43512c.add(orderInfoEntity);
            m30845b(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30848b(List<OrderInfoEntity> list, int i) {
        LogUtil.m29104i(f43510b, "addOrderEntitys:" + list);
        if (!CollectionsUtil.isEmpty(list)) {
            for (OrderInfoEntity add : list) {
                this.f43512c.add(add);
            }
        }
        m30845b(i);
    }

    /* renamed from: b */
    private void m30845b(int i) {
        List list = this.f43512c.getList();
        for (BatchOrderListener onBatchOrderListener : this.f43514e) {
            onBatchOrderListener.onBatchOrderListener(list);
        }
        if (!(i == 1 || i == 5)) {
            ((BatchOrderLayoutRepo) RepoFactory.getRepo(BatchOrderLayoutRepo.class)).requestOrderLayouts(mo108569b());
        }
        synchronized (this.f43512c) {
            this.f43512c.resort();
            List list2 = this.f43512c.getList();
            setValue(CustomerResource.change(list2));
            LogUtil.m29104i(f43510b, "onChange =" + list2);
        }
    }

    /* renamed from: c */
    private void m30849c() {
        RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f43510b).setMessage("requestOrderInfoById-->onRpcFailure").build().info();
    }

    /* renamed from: a */
    private void m30838a(OrderListEntity orderListEntity) {
        RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f43510b).setMessage("requestOrderInfoById-->onRpcSuccess").setOtherParam("data", orderListEntity.toString()).build().info();
    }

    /* renamed from: b */
    private void m30846b(OrderInfoEntity orderInfoEntity) {
        RecordTracker.Builder tag = RecordTracker.Builder.create().setLogModule("m-odr|").setLogCategory("c-data|").setTag(f43510b);
        tag.setMessage("updatePushOrderData" + orderInfoEntity.orderId + "order status" + orderInfoEntity.status).build().info();
    }
}
