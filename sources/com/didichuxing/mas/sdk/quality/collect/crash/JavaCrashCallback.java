package com.didichuxing.mas.sdk.quality.collect.crash;

public interface JavaCrashCallback {
    void onCrash(Thread thread, Throwable th);
}
