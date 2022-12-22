package com.didi.dimina.container.mina;

import android.os.Handler;
import android.os.HandlerThread;
import com.didi.dimina.container.util.LogUtil;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/dimina/container/mina/DMThreadPool;", "", "()V", "CORE_POOL_SIZE", "", "CPU_COUNT", "KEEP_ALIVE", "MAX_POOL_SIZE", "TAG", "", "executor", "Lcom/didi/dimina/container/mina/DMThreadPool$DmThreadPoolExecutor;", "executor$annotations", "getExecutor", "()Lcom/didi/dimina/container/mina/DMThreadPool$DmThreadPoolExecutor;", "mExecutor", "mHandlerThread", "Landroid/os/HandlerThread;", "mWorkHandler", "Landroid/os/Handler;", "threadNum", "post2HandlerThread", "", "runnable", "Ljava/lang/Runnable;", "DmThreadPoolExecutor", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DMThreadPool.kt */
public final class DMThreadPool {
    public static final DMThreadPool INSTANCE = new DMThreadPool();
    public static final String TAG = "Dimina-PM DMThreadPool";

    /* renamed from: a */
    private static final int f16940a;

    /* renamed from: b */
    private static final int f16941b;

    /* renamed from: c */
    private static final int f16942c;

    /* renamed from: d */
    private static final int f16943d = 3;

    /* renamed from: e */
    private static DmThreadPoolExecutor f16944e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static int f16945f;

    /* renamed from: g */
    private static HandlerThread f16946g;

    /* renamed from: h */
    private static volatile Handler f16947h;

    @JvmStatic
    public static /* synthetic */ void executor$annotations() {
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f16940a = availableProcessors;
        f16941b = availableProcessors + 1;
        f16942c = (availableProcessors * 5) + 1;
    }

    private DMThreadPool() {
    }

    public static final synchronized DmThreadPoolExecutor getExecutor() {
        DmThreadPoolExecutor dmThreadPoolExecutor;
        synchronized (DMThreadPool.class) {
            if (f16944e == null) {
                int i = f16941b;
                int i2 = 24;
                if (f16942c <= 24) {
                    i2 = f16942c;
                }
                DmThreadPoolExecutor dmThreadPoolExecutor2 = new DmThreadPoolExecutor(i, i2, (long) 3, TimeUnit.SECONDS, new LinkedBlockingDeque());
                f16944e = dmThreadPoolExecutor2;
                if (dmThreadPoolExecutor2 == null) {
                    Intrinsics.throwNpe();
                }
                dmThreadPoolExecutor2.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
                DmThreadPoolExecutor dmThreadPoolExecutor3 = f16944e;
                if (dmThreadPoolExecutor3 == null) {
                    Intrinsics.throwNpe();
                }
                dmThreadPoolExecutor3.setThreadFactory(DMThreadPool$executor$1.INSTANCE);
                LogUtil.iRelease(TAG, "线程池创建");
                DmThreadPoolExecutor dmThreadPoolExecutor4 = f16944e;
                if (dmThreadPoolExecutor4 == null) {
                    Intrinsics.throwNpe();
                }
                dmThreadPoolExecutor4.prestartAllCoreThreads();
                DmThreadPoolExecutor dmThreadPoolExecutor5 = f16944e;
                if (dmThreadPoolExecutor5 == null) {
                    Intrinsics.throwNpe();
                }
                dmThreadPoolExecutor5.allowCoreThreadTimeOut(true);
            }
            dmThreadPoolExecutor = f16944e;
        }
        return dmThreadPoolExecutor;
    }

    @JvmStatic
    public static final void post2HandlerThread(Runnable runnable) {
        if (f16947h == null) {
            synchronized (DMThreadPool.class) {
                if (f16947h == null) {
                    HandlerThread handlerThread = new HandlerThread("DiminaHandlerThread");
                    f16946g = handlerThread;
                    if (handlerThread == null) {
                        Intrinsics.throwNpe();
                    }
                    handlerThread.start();
                    HandlerThread handlerThread2 = f16946g;
                    if (handlerThread2 == null) {
                        Intrinsics.throwNpe();
                    }
                    f16947h = new Handler(handlerThread2.getLooper());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        Handler handler = f16947h;
        if (handler == null) {
            Intrinsics.throwNpe();
        }
        if (runnable == null) {
            Intrinsics.throwNpe();
        }
        handler.post(runnable);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fBE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012BO\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0016¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/dimina/container/mina/DMThreadPool$DmThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "corePoolSize", "", "maximumPoolSize", "keepAliveTime", "", "unit", "Ljava/util/concurrent/TimeUnit;", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V", "handler", "Ljava/util/concurrent/RejectedExecutionHandler;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/RejectedExecutionHandler;)V", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;Ljava/util/concurrent/RejectedExecutionHandler;)V", "execute", "", "command", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DMThreadPool.kt */
    public static final class DmThreadPoolExecutor extends ThreadPoolExecutor {
        public DmThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
            super(i, i2, j, timeUnit, blockingQueue);
        }

        public DmThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        }

        public DmThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, rejectedExecutionHandler);
        }

        public DmThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        }

        public void execute(Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(runnable, "command");
            super.execute(new DMThreadPool$DmThreadPoolExecutor$execute$1(runnable));
        }
    }
}
