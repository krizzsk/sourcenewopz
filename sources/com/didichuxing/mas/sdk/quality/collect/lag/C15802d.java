package com.didichuxing.mas.sdk.quality.collect.lag;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.lag.d */
/* compiled from: SingleThreadFactory */
final class C15802d implements ThreadFactory {

    /* renamed from: a */
    private final String f48137a;

    C15802d(String str) {
        this.f48137a = "BlockCanary-" + str;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f48137a);
    }
}
