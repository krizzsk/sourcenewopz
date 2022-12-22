package com.didi.map.sdk.departure.internal.util;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ThreadManager {
    public static final int THREAD_BACKGROUND = 1;
    public static final int THREAD_UI = 0;

    /* renamed from: a */
    private static final String[] f28249a;

    /* renamed from: b */
    private static final Handler[] f28250b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final ConcurrentLinkedQueue<Runnable> f28251c = new ConcurrentLinkedQueue<>();

    /* renamed from: d */
    private static final MessageQueue.IdleHandler f28252d = new MessageQueue.IdleHandler() {
        public boolean queueIdle() {
            while (!ThreadManager.f28251c.isEmpty()) {
                Runnable runnable = (Runnable) ThreadManager.f28251c.poll();
                if (runnable != null) {
                    try {
                        runnable.run();
                    } catch (Exception unused) {
                    }
                }
            }
            return true;
        }
    };

    public static void postIdleRunnable(Runnable runnable) {
    }

    public static void removeIdleRunnable(Runnable runnable) {
    }

    static {
        String[] strArr = {"THREAD_UI", "THREAD_BACKGROUND"};
        f28249a = strArr;
        f28250b = new Handler[strArr.length];
    }

    private ThreadManager() {
    }

    /* renamed from: a */
    static void m20060a() {
        synchronized (f28250b) {
            f28250b[0] = new Handler(Looper.getMainLooper());
        }
    }

    public static void post(int i, Runnable runnable) {
        postDelayed(i, runnable, 0);
    }

    public static void postDelayed(int i, Runnable runnable, long j) {
        getHandler(i).postDelayed(runnable, j);
    }

    public static void removeCallbacks(int i, Runnable runnable) {
        if (runnable != null && i < f28249a.length) {
            getHandler(i).removeCallbacks(runnable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r3 != 0) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        r0 = new android.os.Handler(android.os.Looper.getMainLooper());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        r0 = new android.os.HandlerThread(f28249a[r3]);
        r0.setPriority(10);
        r0.start();
        r0 = new android.os.Handler(r0.getLooper());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        r1 = f28250b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        f28250b[r3] = r0;
        r3 = f28250b[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Handler getHandler(int r3) {
        /*
            if (r3 < 0) goto L_0x0051
            java.lang.String[] r0 = f28249a
            int r0 = r0.length
            if (r3 >= r0) goto L_0x0051
            android.os.Handler[] r0 = f28250b
            monitor-enter(r0)
            android.os.Handler[] r1 = f28250b     // Catch:{ all -> 0x004e }
            r1 = r1[r3]     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0016
            android.os.Handler[] r1 = f28250b     // Catch:{ all -> 0x004e }
            r3 = r1[r3]     // Catch:{ all -> 0x004e }
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            if (r3 != 0) goto L_0x0023
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            goto L_0x003e
        L_0x0023:
            android.os.HandlerThread r0 = new android.os.HandlerThread
            java.lang.String[] r1 = f28249a
            r1 = r1[r3]
            r0.<init>(r1)
            r1 = 10
            r0.setPriority(r1)
            r0.start()
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r0 = r0.getLooper()
            r1.<init>(r0)
            r0 = r1
        L_0x003e:
            android.os.Handler[] r1 = f28250b
            monitor-enter(r1)
            android.os.Handler[] r2 = f28250b     // Catch:{ all -> 0x004b }
            r2[r3] = r0     // Catch:{ all -> 0x004b }
            android.os.Handler[] r0 = f28250b     // Catch:{ all -> 0x004b }
            r3 = r0[r3]     // Catch:{ all -> 0x004b }
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            return r3
        L_0x004b:
            r3 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            throw r3
        L_0x004e:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r3
        L_0x0051:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Index "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = " is invalid"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.departure.internal.util.ThreadManager.getHandler(int):android.os.Handler");
    }

    public static boolean runningOn(int i) {
        return getHandler(i).getLooper() == Looper.myLooper();
    }

    public static void currentlyOn(int i) {
        if (Thread.currentThread().getId() != getHandler(i).getLooper().getThread().getId()) {
            throw new RuntimeException("The current thread is out of line with expectations!");
        }
    }

    public static void terminate() {
        f28251c.clear();
        synchronized (f28250b) {
            for (Handler handler : f28250b) {
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                }
            }
        }
    }
}
