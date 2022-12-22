package com.didi.sdk.common;

import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;

public class ThreadPoolTask implements Comparable<ThreadPoolTask>, Runnable {
    public static final int PRIORITY_HIGH = 4;
    public static final int PRIORITY_LOW = 6;
    public static final int PRIORITY_NORMAL = 5;

    /* renamed from: a */
    private static final String f35633a = "ThreadPoolTask";

    /* renamed from: b */
    private static final long f35634b = 5000;

    /* renamed from: c */
    private Runnable f35635c;

    /* renamed from: d */
    private int f35636d = 5;

    /* renamed from: e */
    private long f35637e;

    /* renamed from: f */
    private boolean f35638f;

    public ThreadPoolTask(Runnable runnable, boolean z) {
        this.f35635c = runnable;
        this.f35638f = z;
    }

    public ThreadPoolTask(Runnable runnable, boolean z, int i) {
        this.f35635c = runnable;
        this.f35636d = i;
        this.f35638f = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Runnable mo91320a() {
        return this.f35635c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo91322b() {
        return this.f35636d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91321a(long j) {
        this.f35637e = j;
    }

    public void run() {
        SystemUtils.setProcessThreadPriority(10);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f35635c.run();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (this.f35638f && elapsedRealtime2 > 5000) {
            SystemUtils.log(6, f35633a, "heavy UI task found: " + elapsedRealtime2, (Throwable) null, "com.didi.sdk.common.ThreadPoolTask", 61);
            SystemUtils.log(5, f35633a, m25238c(), (Throwable) null, "com.didi.sdk.common.ThreadPoolTask", 62);
        }
        this.f35635c = null;
    }

    /* renamed from: c */
    private static String m25238c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append("Thread name: ");
        sb.append(Thread.currentThread().getName());
        sb.append(10);
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\tat ");
            sb.append(stackTraceElement.toString());
            sb.append(10);
        }
        return sb.toString();
    }

    public int compareTo(ThreadPoolTask threadPoolTask) {
        int i = this.f35636d;
        int i2 = threadPoolTask.f35636d;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        long j = this.f35637e;
        long j2 = threadPoolTask.f35637e;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        return 0;
    }
}
