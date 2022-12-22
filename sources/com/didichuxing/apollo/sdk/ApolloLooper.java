package com.didichuxing.apollo.sdk;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ApolloLooper {

    /* renamed from: a */
    private static final long f45590a = 900000;

    /* renamed from: b */
    private static final long f45591b = 5000;

    /* renamed from: c */
    private static volatile ApolloLooper f45592c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C15050a f45593d;

    /* renamed from: e */
    private long f45594e = 900000;

    /* renamed from: f */
    private Timer f45595f;

    /* renamed from: g */
    private TimerTask f45596g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f45597h = false;

    /* renamed from: i */
    private ScheduledThreadPoolExecutor f45598i;

    public static ApolloLooper getInstance(C15050a aVar) {
        if (f45592c == null) {
            synchronized (ApolloLooper.class) {
                if (f45592c == null) {
                    f45592c = new ApolloLooper(aVar);
                }
            }
        }
        return f45592c;
    }

    private ApolloLooper(C15050a aVar) {
        this.f45593d = aVar;
    }

    /* renamed from: a */
    private synchronized void m32678a() {
        if (!this.f45597h) {
            if (this.f45595f == null) {
                this.f45595f = new Timer();
            }
            C150481 r2 = new TimerTask() {
                public void run() {
                    if (ApolloLooper.this.f45597h && ApolloLooper.this.f45593d != null) {
                        ApolloLooper.this.f45593d.checkUpdate();
                    }
                }
            };
            this.f45596g = r2;
            this.f45595f.schedule(r2, this.f45594e, this.f45594e);
            this.f45597h = true;
        }
    }

    /* renamed from: b */
    private synchronized void m32681b() {
        this.f45597h = false;
        if (this.f45596g != null) {
            this.f45596g.cancel();
        }
    }

    public synchronized void startup() {
        if (!this.f45597h) {
            if (this.f45598i != null && !this.f45598i.isShutdown()) {
                this.f45598i.shutdownNow();
            }
            this.f45598i = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(5);
            this.f45598i.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    if (ApolloLooper.this.f45597h && ApolloLooper.this.f45593d != null) {
                        ApolloLooper.this.f45593d.checkUpdate();
                    }
                }
            }, this.f45594e, this.f45594e, TimeUnit.MILLISECONDS);
            this.f45597h = true;
        }
    }

    public synchronized void shutdown() {
        this.f45597h = false;
        if (this.f45598i != null) {
            this.f45598i.shutdownNow();
        }
    }

    public void setInterval(long j) {
        if (j < 5000) {
            j = 5000;
        }
        this.f45594e = j;
    }
}
