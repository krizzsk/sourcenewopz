package com.didichuxing.alpha.lag;

import java.util.concurrent.ThreadFactory;

final class SingleThreadFactory implements ThreadFactory {
    private final String threadName;

    SingleThreadFactory(String str) {
        this.threadName = "BlockCanary-" + str;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.threadName);
    }
}
