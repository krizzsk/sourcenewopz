package com.didi.sdk.logging.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private final Object f36653a = new Object();

    /* renamed from: b */
    private ExecutorService f36654b = Executors.newCachedThreadPool(new ThreadFactory() {
        AtomicLong mCount = new AtomicLong(0);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "LoggerTask #" + this.mCount.getAndIncrement());
        }
    });

    /* renamed from: c */
    private volatile Handler f36655c;

    public void executeOnDiskIO(Runnable runnable) {
        this.f36654b.execute(runnable);
    }

    public void postToMainThread(Runnable runnable) {
        if (this.f36655c == null) {
            synchronized (this.f36653a) {
                if (this.f36655c == null) {
                    this.f36655c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f36655c.post(runnable);
    }

    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
