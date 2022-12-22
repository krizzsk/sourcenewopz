package com.didi.drouter.store;

import com.didi.drouter.router.IRouterHandler;

public class RouterRegister implements IRegister {

    /* renamed from: a */
    private RouterKey f19252a;

    /* renamed from: b */
    private IRouterHandler f19253b;

    /* renamed from: c */
    private ServiceKey<?> f19254c;

    /* renamed from: d */
    private Object f19255d;

    /* renamed from: e */
    private final boolean f19256e;

    public RouterRegister(RouterKey routerKey, IRouterHandler iRouterHandler, boolean z) {
        this.f19252a = routerKey;
        this.f19253b = iRouterHandler;
        this.f19256e = z;
    }

    public RouterRegister(ServiceKey<?> serviceKey, Object obj, boolean z) {
        this.f19254c = serviceKey;
        this.f19255d = obj;
        this.f19256e = z;
    }

    public void unregister() {
        if (this.f19256e) {
            RouterStore.m14396a(this.f19252a, this.f19253b);
            RouterStore.unregister(this.f19254c, this.f19255d);
        }
    }

    public boolean isSuccess() {
        return this.f19256e;
    }
}
