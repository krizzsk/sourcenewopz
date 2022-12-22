package com.didi.component.common.helper;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolHelper {

    /* renamed from: b */
    private static final int f11635b = 4;

    /* renamed from: c */
    private static final int f11636c = 12;

    /* renamed from: e */
    private static volatile ThreadPoolHelper f11637e;

    /* renamed from: f */
    private static ThreadPoolExecutor f11638f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f11639a = LoggerFactory.getLogger("ThreadPoolHelper");
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f11640d = 0;

    /* renamed from: c */
    static /* synthetic */ int m7870c(ThreadPoolHelper threadPoolHelper) {
        int i = threadPoolHelper.f11640d;
        threadPoolHelper.f11640d = i + 1;
        return i;
    }

    private ThreadPoolHelper() {
        m7868a();
    }

    /* renamed from: a */
    private void m7868a() {
        f11638f = new ThreadPoolExecutor(4, 12, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(128), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Logger b = ThreadPoolHelper.this.f11639a;
                b.info("create a new thread,num is " + ThreadPoolHelper.this.f11640d, new Object[0]);
                return new Thread(runnable, "global_ride_common_thread_" + ThreadPoolHelper.m7870c(ThreadPoolHelper.this));
            }
        }, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Logger b = ThreadPoolHelper.this.f11639a;
                b.error("rejected exception is appeared, the runnable will be cast away : " + runnable.toString(), new Object[0]);
            }
        });
    }

    public static ThreadPoolHelper getInstance() {
        if (f11637e == null) {
            synchronized (ThreadPoolHelper.class) {
                if (f11637e == null) {
                    f11637e = new ThreadPoolHelper();
                }
            }
        }
        return f11637e;
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            if (f11638f == null) {
                m7868a();
            }
            Logger logger = this.f11639a;
            logger.info("runnable " + runnable.toString() + "  will be executed", new Object[0]);
            f11638f.execute(runnable);
        }
    }
}
