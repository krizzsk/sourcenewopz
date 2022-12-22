package com.koushikdutta.async.future;

import java.util.concurrent.ExecutorService;

public class FutureThread<T> extends SimpleFuture<T> {
    public FutureThread(FutureRunnable<T> futureRunnable) {
        this(futureRunnable, "FutureThread");
    }

    public FutureThread(ExecutorService executorService, final FutureRunnable<T> futureRunnable) {
        executorService.submit(new Runnable() {
            public void run() {
                try {
                    FutureThread.this.setComplete(futureRunnable.run());
                } catch (Exception e) {
                    FutureThread.this.setComplete(e);
                }
            }
        });
    }

    public FutureThread(final FutureRunnable<T> futureRunnable, String str) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    FutureThread.this.setComplete(futureRunnable.run());
                } catch (Exception e) {
                    FutureThread.this.setComplete(e);
                }
            }
        }, str).start();
    }
}
