package com.didi.component.business.xengine.lifecycle;

public class XEngineLifeCycle {

    /* renamed from: a */
    private static volatile XEngineLifeCycle f11411a;

    /* renamed from: b */
    private boolean f11412b;

    private XEngineLifeCycle() {
    }

    public static XEngineLifeCycle getInstance() {
        if (f11411a == null) {
            synchronized (XEngineLifeCycle.class) {
                if (f11411a == null) {
                    f11411a = new XEngineLifeCycle();
                }
            }
        }
        return f11411a;
    }

    public boolean isServiceEngineActive() {
        return this.f11412b;
    }

    public void setServiceEngineActive(boolean z) {
        this.f11412b = z;
    }
}
