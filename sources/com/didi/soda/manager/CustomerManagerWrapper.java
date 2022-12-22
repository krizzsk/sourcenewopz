package com.didi.soda.manager;

import com.didi.soda.manager.base.ICustomerManager;

public class CustomerManagerWrapper {

    /* renamed from: a */
    ICustomerManager f43361a;

    /* renamed from: b */
    ManagerState f43362b = ManagerState.INITIALIZE;

    enum ManagerState {
        INITIALIZE,
        CREATE,
        START,
        STOP,
        DESTROY
    }

    public CustomerManagerWrapper(ICustomerManager iCustomerManager) {
        this.f43361a = iCustomerManager;
    }

    public void create() {
        if (this.f43361a != null && this.f43362b == ManagerState.INITIALIZE) {
            this.f43361a.onCreate();
            this.f43362b = ManagerState.CREATE;
        }
    }

    public void destroy() {
        if (this.f43361a != null && this.f43362b != ManagerState.DESTROY) {
            this.f43361a.onDestroy();
            this.f43362b = ManagerState.DESTROY;
        }
    }

    public ICustomerManager getInnerManager() {
        return this.f43361a;
    }

    public void start() {
        if (this.f43361a == null) {
            return;
        }
        if (this.f43362b == ManagerState.CREATE || this.f43362b == ManagerState.STOP) {
            this.f43361a.onStart();
            this.f43362b = ManagerState.START;
        }
    }

    public void stop() {
        if (this.f43361a != null && this.f43362b == ManagerState.START) {
            this.f43361a.onStop();
            this.f43362b = ManagerState.STOP;
        }
    }
}
