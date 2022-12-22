package com.appsflyer;

import android.net.TrafficStats;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AFExecutor {

    /* renamed from: ι */
    private static AFExecutor f1750;

    /* renamed from: ı */
    final ThreadFactory f1751 = new ThreadFactory() {
        public final Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() {
                public final void run() {
                    TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
                    runnable.run();
                }
            });
        }
    };

    /* renamed from: ǃ */
    ScheduledExecutorService f1752;

    /* renamed from: ɩ */
    ScheduledExecutorService f1753;

    /* renamed from: Ι */
    Executor f1754;

    private AFExecutor() {
    }

    public static AFExecutor getInstance() {
        if (f1750 == null) {
            f1750 = new AFExecutor();
        }
        return f1750;
    }

    public Executor getThreadPoolExecutor() {
        Executor executor = this.f1754;
        if (executor == null || ((executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).isShutdown() || ((ThreadPoolExecutor) this.f1754).isTerminated() || ((ThreadPoolExecutor) this.f1754).isTerminating()))) {
            this.f1754 = Executors.newFixedThreadPool(2, this.f1751);
        }
        return this.f1754;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ι */
    public final ScheduledThreadPoolExecutor mo15930() {
        ScheduledExecutorService scheduledExecutorService = this.f1753;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || this.f1753.isTerminated()) {
            this.f1753 = Executors.newScheduledThreadPool(2, this.f1751);
        }
        return (ScheduledThreadPoolExecutor) this.f1753;
    }

    /* renamed from: ɩ */
    static void m1499(ExecutorService executorService) {
        try {
            AFLogger.afRDLog("shut downing executor ...");
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            AFLogger.afRDLog("InterruptedException!!!");
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (Throwable th) {
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
            throw th;
        }
    }
}
