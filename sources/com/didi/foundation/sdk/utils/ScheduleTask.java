package com.didi.foundation.sdk.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ScheduleTask {

    /* renamed from: a */
    private ExecutorService f21397a;

    private ScheduleTask() {
        this.f21397a = Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ScheduleTask");
            }
        });
    }

    public static ScheduleTask getInstance() {
        return Holder.INSTANCE;
    }

    public void schedule(Runnable runnable) {
        this.f21397a.execute(runnable);
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final ScheduleTask INSTANCE = new ScheduleTask();

        private Holder() {
        }
    }
}
