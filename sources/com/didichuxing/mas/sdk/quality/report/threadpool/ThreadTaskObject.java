package com.didichuxing.mas.sdk.quality.report.threadpool;

import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolHelp;
import java.util.concurrent.ExecutorService;

public abstract class ThreadTaskObject implements Runnable {
    private static ExecutorService mExecutorService;

    public ThreadTaskObject() {
        init();
    }

    private static void init() {
        if (mExecutorService == null) {
            synchronized (ThreadTaskObject.class) {
                if (mExecutorService == null) {
                    mExecutorService = ThreadPoolHelp.Builder.fixed(3).builder();
                }
            }
        }
    }

    public void start() {
        mExecutorService.execute(this);
    }

    public static void execute(Runnable runnable) {
        init();
        if (runnable != null) {
            mExecutorService.execute(runnable);
        }
    }
}
