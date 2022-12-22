package com.didi.entrega.manager;

import com.didi.entrega.manager.base.ICustomerManager;

public class CustomerManagerWrapper {

    /* renamed from: a */
    ICustomerManager f20826a;

    /* renamed from: b */
    ManagerState f20827b = ManagerState.INITIALIZE;

    enum ManagerState {
        INITIALIZE,
        CREATE,
        START,
        STOP,
        DESTROY
    }

    public CustomerManagerWrapper(ICustomerManager iCustomerManager) {
        this.f20826a = iCustomerManager;
    }

    public void create() {
        if (this.f20826a != null && this.f20827b == ManagerState.INITIALIZE) {
            this.f20826a.onCreate();
            this.f20827b = ManagerState.CREATE;
        }
    }

    public void destroy() {
        if (this.f20826a != null && this.f20827b != ManagerState.DESTROY) {
            this.f20826a.onDestroy();
            this.f20827b = ManagerState.DESTROY;
        }
    }

    public ICustomerManager getInnerManager() {
        return this.f20826a;
    }

    public void start() {
        if (this.f20826a == null) {
            return;
        }
        if (this.f20827b == ManagerState.CREATE || this.f20827b == ManagerState.STOP) {
            this.f20826a.onStart();
            this.f20827b = ManagerState.START;
        }
    }

    public void stop() {
        if (this.f20826a != null && this.f20827b == ManagerState.START) {
            this.f20826a.onStop();
            this.f20827b = ManagerState.STOP;
        }
    }
}
