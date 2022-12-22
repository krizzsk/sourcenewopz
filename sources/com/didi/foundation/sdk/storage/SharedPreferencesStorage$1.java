package com.didi.foundation.sdk.storage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class SharedPreferencesStorage$1 implements ThreadFactory {
    private final AtomicInteger mCounter = new AtomicInteger(1);

    SharedPreferencesStorage$1() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SharedPreferencesRepository#" + this.mCounter.getAndIncrement());
    }
}
