package com.didi.beatles.p099im.net;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didi.beatles.im.net.IMThreadHelper */
public class IMThreadHelper {

    /* renamed from: a */
    private static IMThreadHelper f9342a;

    /* renamed from: b */
    private static final int f9343b;

    /* renamed from: c */
    private static final int f9344c;

    /* renamed from: d */
    private static final int f9345d;

    /* renamed from: e */
    private static ThreadPoolExecutor f9346e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f9343b = availableProcessors;
        f9344c = availableProcessors + 2;
        f9345d = (availableProcessors * 2) + 2;
    }

    public static IMThreadHelper getInstance() {
        if (f9342a == null) {
            f9342a = new IMThreadHelper();
        }
        return f9342a;
    }

    private IMThreadHelper() {
        f9346e = new ThreadPoolExecutor(f9344c, f9345d, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                new Thread(runnable).start();
            }
        });
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            f9346e.execute(runnable);
        }
    }
}
