package com.didi.map.global.sdk.movement.sensor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkThread {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ExecutorService f27772a = new ThreadPoolExecutor(1, 1, 3, TimeUnit.SECONDS, this.f27773b, new ExecutionHandlerPolicy());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LinkedBlockingQueue<Runnable> f27773b = new LinkedBlockingQueue<>(5);

    public void executeTask(Runnable runnable) {
        ExecutorService executorService = this.f27772a;
        if (executorService != null && !executorService.isShutdown() && runnable != null) {
            this.f27772a.execute(runnable);
        }
    }

    public void destroy() {
        ExecutorService executorService = this.f27772a;
        if (executorService != null && !executorService.isShutdown()) {
            this.f27772a.shutdownNow();
            this.f27772a = null;
        }
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = this.f27773b;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.f27773b = null;
        }
    }

    private class ExecutionHandlerPolicy implements RejectedExecutionHandler {
        private ExecutionHandlerPolicy() {
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (WorkThread.this.f27773b != null) {
                WorkThread.this.f27773b.clear();
            }
            if (WorkThread.this.f27772a != null) {
                WorkThread.this.f27772a.execute(runnable);
            }
        }
    }
}
