package com.didi.sdk.async;

import com.didi.sdk.async.AsyncLayoutInflaterPlus;
import java.util.concurrent.Future;

public class AsyncLayoutTask {
    public Future<?> future;
    public AsyncLayoutInflaterPlus.InflateRunnable runnable;

    public AsyncLayoutTask(Future<?> future2, AsyncLayoutInflaterPlus.InflateRunnable inflateRunnable) {
        this.future = future2;
        this.runnable = inflateRunnable;
    }

    public boolean isRunning() {
        AsyncLayoutInflaterPlus.InflateRunnable inflateRunnable = this.runnable;
        if (inflateRunnable != null) {
            return inflateRunnable.isRunning();
        }
        return false;
    }

    public boolean cancel() {
        Future<?> future2 = this.future;
        if (future2 != null) {
            return future2.cancel(false);
        }
        return false;
    }
}
