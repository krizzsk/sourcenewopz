package com.didiglobal.common.common.xengine;

public class XEngineLifeCycle {

    /* renamed from: a */
    private static volatile XEngineLifeCycle f49746a;

    /* renamed from: b */
    private boolean f49747b;

    private XEngineLifeCycle() {
    }

    public static XEngineLifeCycle getInstance() {
        if (f49746a == null) {
            synchronized (XEngineLifeCycle.class) {
                if (f49746a == null) {
                    f49746a = new XEngineLifeCycle();
                }
            }
        }
        return f49746a;
    }

    public boolean isServiceEngineActive() {
        return this.f49747b;
    }

    public void setServiceEngineActive(boolean z) {
        this.f49747b = z;
    }
}
