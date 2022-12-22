package com.didi.sdk.connectivity;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.sdk.connectivity.e */
/* compiled from: NamedThreadFactory */
class C12169e implements ThreadFactory {

    /* renamed from: a */
    static AtomicInteger f35764a = new AtomicInteger(0);

    /* renamed from: b */
    private String f35765b;

    /* renamed from: c */
    private boolean f35766c;

    public C12169e(String str, boolean z) {
        this.f35765b = str;
        this.f35766c = z;
    }

    public Thread newThread(Runnable runnable) {
        NamedThreadFactory$1 namedThreadFactory$1 = new NamedThreadFactory$1(this, this.f35765b + f35764a.getAndIncrement(), runnable);
        namedThreadFactory$1.setDaemon(this.f35766c);
        return namedThreadFactory$1;
    }
}
