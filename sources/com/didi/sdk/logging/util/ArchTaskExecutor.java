package com.didi.sdk.logging.util;

import java.util.concurrent.Executor;

public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: a */
    private static volatile ArchTaskExecutor f36644a;

    /* renamed from: d */
    private static final Executor f36645d = new Executor() {
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().postToMainThread(runnable);
        }
    };

    /* renamed from: e */
    private static final Executor f36646e = new Executor() {
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
        }
    };

    /* renamed from: b */
    private TaskExecutor f36647b;

    /* renamed from: c */
    private TaskExecutor f36648c;

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.f36648c = defaultTaskExecutor;
        this.f36647b = defaultTaskExecutor;
    }

    public static ArchTaskExecutor getInstance() {
        if (f36644a != null) {
            return f36644a;
        }
        synchronized (ArchTaskExecutor.class) {
            if (f36644a == null) {
                f36644a = new ArchTaskExecutor();
            }
        }
        return f36644a;
    }

    public void setDelegate(TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.f36648c;
        }
        this.f36647b = taskExecutor;
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.f36647b.executeOnDiskIO(runnable);
    }

    public void postToMainThread(Runnable runnable) {
        this.f36647b.postToMainThread(runnable);
    }

    public static Executor getMainThreadExecutor() {
        return f36645d;
    }

    public static Executor getIOThreadExecutor() {
        return f36646e;
    }

    public boolean isMainThread() {
        return this.f36647b.isMainThread();
    }
}
