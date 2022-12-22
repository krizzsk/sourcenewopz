package com.didi.soda.order.manager;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.order.component.contact.OrderContactUtil;
import java.util.List;

public class CustomerOrderManager implements ICustomerOrderManager {
    /* renamed from: a */
    private boolean m30835a(int i) {
        return i == 1 || i == 2;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public String getManagerName() {
        return CustomerOrderManager.class.getName();
    }

    public void addOrderEntity2Monitor(OrderInfoEntity orderInfoEntity, int i) {
        ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108562a(orderInfoEntity, i);
    }

    public void addOrderEntity2Monitor(List<OrderInfoEntity> list, int i) {
        ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108567a(list, i);
    }

    public void updateOrder2Monitor(String str) {
        ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108565a(str, 4);
    }

    public void updateOrder2Monitor(String str, int i) {
        ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108565a(str, i);
    }

    public void updateAllOrdersInMonitor() {
        ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108565a(((C14139a) RepoFactory.getRepo(C14139a.class)).mo108569b(), 4);
    }

    public void clearAllOrdersInMonitor() {
        ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108560a();
        ((BatchOrderLayoutRepo) RepoFactory.getRepo(BatchOrderLayoutRepo.class)).clearAllInMonitor();
    }

    public void requestOrderInfoById(ScopeContext scopeContext, String str, OnceOrderListener onceOrderListener) {
        if (!TextUtils.isEmpty(str)) {
            ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108566a(str, scopeContext, onceOrderListener);
        }
    }

    public OrderInfoEntity getOrderInfoById(String str) {
        return ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108568b(str);
    }

    public OrderInfoEntity getOrderInfoByPreId(String str) {
        return ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108571c(str);
    }

    public void subscribe(ScopeContext scopeContext, Action1<CustomerResource<List<OrderInfoEntity>>> action1) {
        if (scopeContext != null) {
            ((C14139a) RepoFactory.getRepo(C14139a.class)).subscribe(scopeContext, action1);
        }
    }

    public void registerBatchOrderListener(BatchOrderListener batchOrderListener) {
        if (batchOrderListener != null) {
            ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108563a(batchOrderListener);
        }
    }

    public void unregisterBatchOrderListener(BatchOrderListener batchOrderListener) {
        if (batchOrderListener != null) {
            ((C14139a) RepoFactory.getRepo(C14139a.class)).mo108570b(batchOrderListener);
        }
    }

    public void requestOrderLayoutById(ScopeContext scopeContext, String str, int i, OnceOrderLayoutsListener onceOrderLayoutsListener) {
        if (!TextUtils.isEmpty(str)) {
            ((BatchOrderLayoutRepo) RepoFactory.getRepo(BatchOrderLayoutRepo.class)).requestOrderLayoutsWithTag(str, i, scopeContext, onceOrderLayoutsListener);
        }
    }

    public void requestOrderLayoutById(String str, int i, OnceOrderLayoutsListener onceOrderLayoutsListener) {
        if (!TextUtils.isEmpty(str)) {
            ((BatchOrderLayoutRepo) RepoFactory.getRepo(BatchOrderLayoutRepo.class)).requestOrderLayouts(str, i, onceOrderLayoutsListener);
        }
    }

    public OrderLayoutEntity getOrderLayoutById(String str) {
        return ((BatchOrderLayoutRepo) RepoFactory.getRepo(BatchOrderLayoutRepo.class)).getOrderLayoutsById(str);
    }

    public OrderLayoutEntity getOrderLayoutByPreId(String str) {
        return ((BatchOrderLayoutRepo) RepoFactory.getRepo(BatchOrderLayoutRepo.class)).getOrderLayoutByPreId(str);
    }

    public void registerBatchOrderLayoutListener(BatchOrderLayoutListener batchOrderLayoutListener) {
        if (batchOrderLayoutListener != null) {
            ((BatchOrderLayoutRepo) RepoFactory.getRepo(BatchOrderLayoutRepo.class)).registerBatchOrderLayoutsListener(batchOrderLayoutListener);
        }
    }

    public void unregisterBatchOrderLayoutListener(BatchOrderLayoutListener batchOrderLayoutListener) {
        if (batchOrderLayoutListener != null) {
            ((BatchOrderLayoutRepo) RepoFactory.getRepo(BatchOrderLayoutRepo.class)).unregisterBatchOrderLayoutsListener(batchOrderLayoutListener);
        }
    }

    public void onJsContactAction(Context context, ScopeContext scopeContext, String str, int i, int i2) {
        if (!TextUtils.isEmpty(str) && m30835a(i2) && context != null) {
            OrderInfoEntity orderInfoById = getOrderInfoById(str);
            if (orderInfoById == null) {
                DialogUtil.showLoadingDialog(scopeContext, false);
                final Context context2 = context;
                final ScopeContext scopeContext2 = scopeContext;
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                requestOrderInfoById(scopeContext, str, new OnceOrderListener() {
                    public void onOnceOrderListener(OrderInfoEntity orderInfoEntity, int i) {
                        DialogUtil.hideLoadingDialog();
                        OrderContactUtil.Companion.doContact(context2, scopeContext2, str2, orderInfoEntity, i3, i4);
                    }
                });
                return;
            }
            OrderContactUtil.Companion.doContact(context, scopeContext, str, orderInfoById, i, i2);
        }
    }
}
