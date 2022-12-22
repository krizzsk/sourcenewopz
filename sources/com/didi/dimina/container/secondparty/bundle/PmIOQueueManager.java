package com.didi.dimina.container.secondparty.bundle;

import com.didi.dimina.container.secondparty.bundle.chain.IPckInterceptor;
import com.didi.dimina.container.util.LogUtil;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class PmIOQueueManager {
    public static final String TAG = "Dimina-PM PmIOQueueManager";

    /* renamed from: a */
    private static volatile PmIOQueueManager f17049a;

    /* renamed from: b */
    private static final CopyOnWriteArrayList<IPckInterceptor> f17050b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    private static final AtomicBoolean f17051c = new AtomicBoolean(false);

    public static PmIOQueueManager getInstance() {
        if (f17049a == null) {
            synchronized (PmIOQueueManager.class) {
                if (f17049a == null) {
                    f17049a = new PmIOQueueManager();
                }
            }
        }
        return f17049a;
    }

    public void enqueue(IPckInterceptor iPckInterceptor) {
        f17050b.add(iPckInterceptor);
        LogUtil.iRelease(TAG, "enqueue() 入队:" + iPckInterceptor + "\t 入队后的队列:" + f17050b);
        exec();
    }

    public void enqueueHead(IPckInterceptor iPckInterceptor) {
        f17050b.add(0, iPckInterceptor);
        LogUtil.iRelease(TAG, "enqueueHead() 入队:" + iPckInterceptor + "\t 入队后的队列:" + f17050b);
        exec();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        r0 = f17050b.remove(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004f, code lost:
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
        com.didi.dimina.container.util.LogUtil.iRelease(TAG, "当前在主线程，启动子线程执行。  开始执行任务 : " + r0);
        com.didi.dimina.container.mina.DMThreadPool.getExecutor().execute(new com.didi.dimina.container.secondparty.bundle.$$Lambda$PmIOQueueManager$PeHCaEkG1yCrNfP65JCZcOusyI(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0074, code lost:
        com.didi.dimina.container.util.LogUtil.iRelease(TAG, "当前在子线程,不需要启动子线程。 开始执行任务 : " + r0);
        r0.intercept();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void exec() {
        /*
            r4 = this;
            java.lang.String r0 = "Dimina-PM PmIOQueueManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "exec() 当前状态:"
            r1.append(r2)
            java.util.concurrent.atomic.AtomicBoolean r2 = f17051c
            boolean r2 = r2.get()
            r1.append(r2)
            java.lang.String r2 = ", 任务队列:"
            r1.append(r2)
            java.util.concurrent.CopyOnWriteArrayList<com.didi.dimina.container.secondparty.bundle.chain.IPckInterceptor> r2 = f17050b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.didi.dimina.container.util.LogUtil.iRelease(r0, r1)
            java.lang.Class<com.didi.dimina.container.secondparty.bundle.PmIOQueueManager> r0 = com.didi.dimina.container.secondparty.bundle.PmIOQueueManager.class
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicBoolean r1 = f17051c     // Catch:{ all -> 0x0097 }
            boolean r1 = r1.get()     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x008e
            java.util.concurrent.CopyOnWriteArrayList<com.didi.dimina.container.secondparty.bundle.chain.IPckInterceptor> r1 = f17050b     // Catch:{ all -> 0x0097 }
            int r1 = r1.size()     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x003a
            goto L_0x008e
        L_0x003a:
            r4.setRunningStatusStart()     // Catch:{ all -> 0x0097 }
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            java.util.concurrent.CopyOnWriteArrayList<com.didi.dimina.container.secondparty.bundle.chain.IPckInterceptor> r0 = f17050b
            r1 = 0
            java.lang.Object r0 = r0.remove(r1)
            com.didi.dimina.container.secondparty.bundle.chain.IPckInterceptor r0 = (com.didi.dimina.container.secondparty.bundle.chain.IPckInterceptor) r0
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            if (r1 != r2) goto L_0x0074
            java.lang.String r1 = "Dimina-PM PmIOQueueManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "当前在主线程，启动子线程执行。  开始执行任务 : "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.didi.dimina.container.util.LogUtil.iRelease(r1, r2)
            com.didi.dimina.container.mina.DMThreadPool$DmThreadPoolExecutor r1 = com.didi.dimina.container.mina.DMThreadPool.getExecutor()
            com.didi.dimina.container.secondparty.bundle.-$$Lambda$PmIOQueueManager$PeHCaEkG1y-CrNfP65JCZcOusyI r2 = new com.didi.dimina.container.secondparty.bundle.-$$Lambda$PmIOQueueManager$PeHCaEkG1y-CrNfP65JCZcOusyI
            r2.<init>()
            r1.execute(r2)
            goto L_0x008d
        L_0x0074:
            java.lang.String r1 = "Dimina-PM PmIOQueueManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "当前在子线程,不需要启动子线程。 开始执行任务 : "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.didi.dimina.container.util.LogUtil.iRelease(r1, r2)
            r0.intercept()
        L_0x008d:
            return
        L_0x008e:
            java.lang.String r1 = "Dimina-PM PmIOQueueManager"
            java.lang.String r2 = "当前任务列表中没有任务了，或者正在执行任务。所以直接返回"
            com.didi.dimina.container.util.LogUtil.wRelease(r1, r2)     // Catch:{ all -> 0x0097 }
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            return
        L_0x0097:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0097 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.bundle.PmIOQueueManager.exec():void");
    }

    public void setRunningStatusOver() {
        if (!f17051c.get()) {
            LogUtil.eRelease(TAG, "setRunningStatusOver() 运行状态 不应该在设置前就是 false");
        }
        LogUtil.iRelease(TAG, "setRunningStatusOver() 设置运行状态为false");
        f17051c.set(false);
    }

    public void setRunningStatusStart() {
        if (f17051c.get()) {
            LogUtil.eRelease(TAG, "setRunningStatusStart() 运行状态 不应该为 true");
        }
        LogUtil.iRelease(TAG, "setRunningStatusStart() 设置运行状态为true");
        f17051c.set(true);
    }
}
