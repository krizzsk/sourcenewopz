package com.didiglobal.domainprocessor;

import android.app.Application;

public class DomainProcessor {

    /* renamed from: b */
    private static volatile DomainProcessor f50022b;

    /* renamed from: a */
    private Application f50023a;

    public static DomainProcessor getInstance() {
        if (f50022b == null) {
            synchronized (DomainProcessor.class) {
                if (f50022b == null) {
                    f50022b = new DomainProcessor();
                }
            }
        }
        return f50022b;
    }

    public void init(Application application) {
        this.f50023a = application;
    }

    public Application getApplication() {
        return this.f50023a;
    }
}
