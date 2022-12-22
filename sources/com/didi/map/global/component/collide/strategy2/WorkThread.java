package com.didi.map.global.component.collide.strategy2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkThread {

    /* renamed from: a */
    private static final String f24832a = "WorkThread";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ExecutorService f24833b = new ThreadPoolExecutor(1, 1, 3, TimeUnit.SECONDS, this.f24834c, new ExecutionHandlerPolicy());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final LinkedBlockingQueue<Runnable> f24834c = new LinkedBlockingQueue<>(1);

    public void executeTask(Runnable runnable) {
        ExecutorService executorService = this.f24833b;
        if (executorService != null && !executorService.isShutdown() && runnable != null) {
            this.f24833b.execute(runnable);
        }
    }

    public void destroy() {
        ExecutorService executorService = this.f24833b;
        if (executorService != null && !executorService.isShutdown()) {
            this.f24833b.shutdownNow();
            this.f24833b = null;
        }
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = this.f24834c;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
        }
    }

    private class ExecutionHandlerPolicy implements RejectedExecutionHandler {
        private ExecutionHandlerPolicy() {
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (WorkThread.this.f24834c != null) {
                WorkThread.this.f24834c.clear();
            }
            if (WorkThread.this.f24833b != null) {
                WorkThread.this.f24833b.execute(runnable);
            }
        }
    }
}
