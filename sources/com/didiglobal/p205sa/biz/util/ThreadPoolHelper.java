package com.didiglobal.p205sa.biz.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didiglobal.sa.biz.util.ThreadPoolHelper */
public class ThreadPoolHelper {

    /* renamed from: b */
    private static final int f51264b = 4;

    /* renamed from: c */
    private static final int f51265c = 12;

    /* renamed from: e */
    private static volatile ThreadPoolHelper f51266e;

    /* renamed from: f */
    private static ThreadPoolExecutor f51267f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f51268a = LoggerFactory.getLogger("ThreadPoolHelper");
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f51269d = 0;

    /* renamed from: c */
    static /* synthetic */ int m36712c(ThreadPoolHelper threadPoolHelper) {
        int i = threadPoolHelper.f51269d;
        threadPoolHelper.f51269d = i + 1;
        return i;
    }

    private ThreadPoolHelper() {
        m36710a();
    }

    /* renamed from: a */
    private void m36710a() {
        f51267f = new ThreadPoolExecutor(4, 12, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(128), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Logger b = ThreadPoolHelper.this.f51268a;
                b.info("create a new thread,num is " + ThreadPoolHelper.this.f51269d, new Object[0]);
                return new Thread(runnable, "global_ride_common_thread_" + ThreadPoolHelper.m36712c(ThreadPoolHelper.this));
            }
        }, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Logger b = ThreadPoolHelper.this.f51268a;
                b.error("rejected exception is appeared, the runnable will be cast away : " + runnable.toString(), new Object[0]);
            }
        });
    }

    public static ThreadPoolHelper getInstance() {
        if (f51266e == null) {
            synchronized (ThreadPoolHelper.class) {
                if (f51266e == null) {
                    f51266e = new ThreadPoolHelper();
                }
            }
        }
        return f51266e;
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            if (f51267f == null) {
                m36710a();
            }
            Logger logger = this.f51268a;
            logger.info("runnable " + runnable.toString() + "  will be executed", new Object[0]);
            f51267f.execute(runnable);
        }
    }
}
