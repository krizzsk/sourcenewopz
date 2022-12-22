package com.didi.sdk.apm;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.didi.sdk.apm.c */
/* compiled from: MainThreadWatcher */
class C11887c implements Runnable {

    /* renamed from: a */
    public static final String f34976a = "WATCHER_LOG";

    /* renamed from: b */
    public static final int f34977b = 3000;

    /* renamed from: c */
    public static final int f34978c = 5500;

    /* renamed from: d */
    private static C11887c f34979d;

    /* renamed from: e */
    private Handler f34980e = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AtomicBoolean f34981f = new AtomicBoolean(false);

    /* renamed from: g */
    private AtomicBoolean f34982g = new AtomicBoolean(false);

    /* renamed from: h */
    private AtomicBoolean f34983h = new AtomicBoolean(false);

    /* renamed from: i */
    private AtomicBoolean f34984i = new AtomicBoolean(false);

    /* renamed from: j */
    private int f34985j = 3000;

    /* renamed from: k */
    private Thread f34986k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f34987l;

    /* renamed from: m */
    private Runnable f34988m = new MainThreadWatcher$2(this);

    private C11887c() {
    }

    /* renamed from: a */
    public static C11887c m24738a() {
        if (f34979d == null) {
            synchronized (C11887c.class) {
                if (f34979d == null) {
                    f34979d = new C11887c();
                }
            }
        }
        return f34979d;
    }

    /* renamed from: a */
    public C11887c mo90312a(int i) {
        this.f34985j = i;
        return this;
    }

    /* renamed from: b */
    public C11887c mo90313b() {
        if (Debug.isDebuggerConnected() || this.f34984i.get()) {
            return this;
        }
        this.f34984i.set(true);
        Thread thread = new Thread(this, "MainThreadWatcher");
        this.f34986k = thread;
        thread.start();
        this.f34980e.postAtFrontOfQueue(new MainThreadWatcher$1(this));
        return this;
    }

    public final void run() {
        if (this.f34984i.get()) {
            Process.setThreadPriority(10);
            while (!this.f34982g.get()) {
                if (!this.f34983h.get()) {
                    this.f34981f.set(false);
                    this.f34987l = SystemClock.uptimeMillis();
                    this.f34980e.post(this.f34988m);
                }
                try {
                    Thread.sleep(this.f34983h.get() ? Long.MAX_VALUE : (long) this.f34985j);
                    if (this.f34982g.get()) {
                        break;
                    }
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f34987l;
                    AtomicReference atomicReference = new AtomicReference();
                    AtomicLong atomicLong = new AtomicLong();
                    if (!this.f34981f.get()) {
                        Log.e(f34976a, ">>> Blocked in Main Thread for " + uptimeMillis + "ms <<< ");
                        try {
                            Looper.getMainLooper().dump(new MainThreadWatcher$3(this, atomicLong, atomicReference), "");
                        } catch (Exception unused) {
                        }
                        Log.e(f34976a, "Ignore the remaining message...  ");
                        Log.e(f34976a, (String) atomicReference.get());
                        this.f34980e.removeCallbacks(this.f34988m);
                    }
                } catch (InterruptedException unused2) {
                }
            }
            this.f34980e.removeCallbacksAndMessages((Object) null);
        }
    }

    /* renamed from: c */
    public C11887c mo90314c() {
        Log.i(f34976a, "pause: ");
        if (!this.f34984i.get()) {
            return this;
        }
        this.f34983h.set(true);
        return this;
    }

    /* renamed from: d */
    public C11887c mo90315d() {
        Log.i(f34976a, "resume: ");
        if (!this.f34984i.get()) {
            return this;
        }
        this.f34983h.set(false);
        this.f34986k.interrupt();
        return this;
    }

    /* renamed from: e */
    public C11887c mo90316e() {
        Log.i(f34976a, "stop: ");
        if (!this.f34984i.get()) {
            return this;
        }
        this.f34982g.set(true);
        this.f34986k.interrupt();
        this.f34984i.set(false);
        return this;
    }
}
