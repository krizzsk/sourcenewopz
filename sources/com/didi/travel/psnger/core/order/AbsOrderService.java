package com.didi.travel.psnger.core.order;

import com.didi.travel.psnger.core.listener.IDiDiCoreCallback;
import com.didi.travel.psnger.core.listener.IDiDiMatchInfoCallback;

public abstract class AbsOrderService implements OrderService {

    /* renamed from: a */
    private OrderPollingManager f44177a;

    /* renamed from: b */
    private OrderPushManager f44178b;

    /* access modifiers changed from: protected */
    public abstract long pollingIntervalMills();

    public void setMatchInfoCallback(IDiDiMatchInfoCallback iDiDiMatchInfoCallback) {
    }

    public AbsOrderService() {
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        if (this.f44177a == null) {
            this.f44177a = createPollingManager();
        }
        if (this.f44178b == null) {
            this.f44178b = new OrderPushManager();
        }
    }

    /* access modifiers changed from: protected */
    public OrderPollingManager createPollingManager() {
        return new OrderPollingManager(this);
    }

    public void addOrderServiceCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        OrderPollingManager orderPollingManager = this.f44177a;
        if (orderPollingManager != null) {
            orderPollingManager.addCoreCallback(iDiDiCoreCallback);
        }
    }

    public void addOrderPushCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        OrderPushManager orderPushManager = this.f44178b;
        if (orderPushManager != null) {
            orderPushManager.addCoreCallback(iDiDiCoreCallback);
        }
    }

    public void removeOrderServiceCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        OrderPollingManager orderPollingManager = this.f44177a;
        if (orderPollingManager != null) {
            orderPollingManager.removeCoreCallback(iDiDiCoreCallback);
        }
    }

    public void removeOrderPushCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        OrderPushManager orderPushManager = this.f44178b;
        if (orderPushManager != null) {
            orderPushManager.removeCoreCallback(iDiDiCoreCallback);
        }
    }

    public void startOrderService(boolean z) {
        OrderPollingManager orderPollingManager = this.f44177a;
        if (orderPollingManager != null) {
            orderPollingManager.start(z, pollingIntervalMills());
        }
    }

    public void stopOrderService() {
        OrderPollingManager orderPollingManager = this.f44177a;
        if (orderPollingManager != null) {
            orderPollingManager.stopOrderStatusPoll();
        }
    }

    public void registerPush() {
        OrderPollingManager orderPollingManager = this.f44177a;
        if (orderPollingManager != null) {
            orderPollingManager.registerOrderStatusPush();
        }
        OrderPushManager orderPushManager = this.f44178b;
        if (orderPushManager != null) {
            orderPushManager.registerPushListener();
        }
    }

    public void unregisterPush() {
        OrderPushManager orderPushManager = this.f44178b;
        if (orderPushManager != null) {
            orderPushManager.unregisterPushListener();
        }
        OrderPollingManager orderPollingManager = this.f44177a;
        if (orderPollingManager != null) {
            orderPollingManager.unregisterOrderStatusPush();
        }
    }

    public OrderPollingManager getOrderPollingManager() {
        return this.f44177a;
    }
}
