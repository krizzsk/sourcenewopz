package com.didi.zxing.barcodescanner.executor;

import android.content.Context;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.executor.BalanceRunnable;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BalanceExecutor<T extends BalanceRunnable> implements C14951a<T> {
    private static final int BALANCE_INTERVAL = 3000;
    private static final String TAG = "BalanceExecutor";
    private Queue<T> cache = new LinkedBlockingDeque(5);
    private long costTime;
    private CpuMonitor cpuMonitor;
    private int executeCount;
    private RejectedExecutionHandler executionHandler = new RejectedExecutionHandler() {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            BalanceExecutor.this.cache((BalanceRunnable) runnable);
            long unused = BalanceExecutor.this.lastExecuteTime = 0;
        }
    };
    private ExecutorService executorService;
    private long initInterval;
    private boolean inited;
    private long lastBalanceTime;
    /* access modifiers changed from: private */
    public long lastExecuteTime;
    private Lock lock = new ReentrantLock();
    private int maxPoolSize;
    private int minPoolSize;
    private final boolean needBalance;
    private volatile int poolSize;

    enum ResStatus {
        FULL,
        LOW,
        NORMAL
    }

    public BalanceExecutor(Context context, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        this.minPoolSize = i5;
        this.maxPoolSize = i6;
        this.poolSize = i7;
        this.initInterval = (long) i4;
        if (i6 == i7 && i5 == i7) {
            this.needBalance = false;
        } else {
            this.needBalance = true;
        }
        this.lastBalanceTime = SystemClock.elapsedRealtime();
        C149482 r8 = new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("dqr");
                thread.setPriority(1);
                return thread;
            }
        };
        int i8 = i3;
        int i9 = i2;
        this.executorService = new ThreadPoolExecutor(i8, i9, 10, TimeUnit.SECONDS, new SynchronousQueue(), r8, this.executionHandler);
        this.cpuMonitor = new CpuMonitor(context.getApplicationContext());
    }

    public void execute(T t) {
        if (!this.inited) {
            this.cpuMonitor.mo113767b();
            this.inited = true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.needBalance) {
            this.lock.lock();
            balancePoolSize();
            this.lock.unlock();
        }
        if (elapsedRealtime - this.lastExecuteTime > this.initInterval) {
            this.lastExecuteTime = elapsedRealtime;
            t.setExecutorCallback(this);
            this.executorService.execute(t);
            return;
        }
        cache(t);
    }

    private void balancePoolSize() {
        int i;
        if (SystemClock.elapsedRealtime() - this.lastBalanceTime > 3000) {
            this.lastBalanceTime = SystemClock.elapsedRealtime();
            int i2 = C149493.f45398xe77815bb[getResStatus().ordinal()];
            if (i2 == 1) {
                int i3 = this.poolSize;
                if (i3 < this.maxPoolSize) {
                    this.poolSize = i3 + 1;
                    this.initInterval = (this.costTime / ((long) this.executeCount)) / ((long) this.poolSize);
                }
            } else if (i2 == 2 && (i = this.poolSize) > this.minPoolSize) {
                this.poolSize = i - 1;
                this.initInterval = (this.costTime / ((long) this.executeCount)) / ((long) this.poolSize);
            }
            SystemUtils.log(3, TAG, "poolSize = " + this.poolSize + " initInterval = " + this.initInterval, (Throwable) null, "com.didi.zxing.barcodescanner.executor.BalanceExecutor", 139);
        }
    }

    /* renamed from: com.didi.zxing.barcodescanner.executor.BalanceExecutor$3 */
    static /* synthetic */ class C149493 {

        /* renamed from: $SwitchMap$com$didi$zxing$barcodescanner$executor$BalanceExecutor$ResStatus */
        static final /* synthetic */ int[] f45398xe77815bb;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.zxing.barcodescanner.executor.BalanceExecutor$ResStatus[] r0 = com.didi.zxing.barcodescanner.executor.BalanceExecutor.ResStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f45398xe77815bb = r0
                com.didi.zxing.barcodescanner.executor.BalanceExecutor$ResStatus r1 = com.didi.zxing.barcodescanner.executor.BalanceExecutor.ResStatus.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f45398xe77815bb     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.zxing.barcodescanner.executor.BalanceExecutor$ResStatus r1 = com.didi.zxing.barcodescanner.executor.BalanceExecutor.ResStatus.FULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.zxing.barcodescanner.executor.BalanceExecutor.C149493.<clinit>():void");
        }
    }

    private ResStatus getResStatus() {
        double freeMemory = (((double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())) / ((double) Runtime.getRuntime().maxMemory())) * 100.0d;
        double d = (double) this.cpuMonitor.mo113769d();
        if (freeMemory > 80.0d || d > 80.0d) {
            return ResStatus.FULL;
        }
        if (freeMemory >= 60.0d || d >= 60.0d) {
            return ResStatus.NORMAL;
        }
        return ResStatus.LOW;
    }

    public void onFinish(T t, long j) {
        this.lock.lock();
        int i = this.executeCount + 1;
        this.executeCount = i;
        long j2 = this.costTime + j;
        this.costTime = j2;
        this.initInterval = (j2 / ((long) i)) / ((long) this.poolSize);
        this.lock.unlock();
        cache(t);
    }

    /* access modifiers changed from: private */
    public void cache(T t) {
        t.clear();
        this.cache.offer(t);
    }

    public T obtain() {
        return (BalanceRunnable) this.cache.poll();
    }

    public void destroy() {
        this.executorService.shutdown();
        this.cache.clear();
        this.inited = false;
        this.cpuMonitor.mo113766a();
    }

    public int getPoolSize() {
        return this.poolSize;
    }

    public long getInitInterval() {
        return this.initInterval;
    }
}
