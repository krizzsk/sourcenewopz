package com.didi.sdk.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: com.didi.sdk.event.c */
/* compiled from: HandlerPoster */
final class C12183c extends Handler {

    /* renamed from: a */
    private final C12185e f35859a = new C12185e();

    /* renamed from: b */
    private final int f35860b;

    /* renamed from: c */
    private final EventDispatcherImpl f35861c;

    /* renamed from: d */
    private boolean f35862d;

    C12183c(EventDispatcherImpl eventDispatcherImpl, Looper looper, int i) {
        super(looper);
        this.f35861c = eventDispatcherImpl;
        this.f35860b = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91616a(C12188h hVar, Event event) {
        C12184d a = C12184d.m25404a(hVar, event);
        synchronized (this) {
            this.f35859a.mo91624a(a);
            if (!this.f35862d) {
                this.f35862d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new StoreException("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                C12184d a = this.f35859a.mo91622a();
                if (a == null) {
                    synchronized (this) {
                        a = this.f35859a.mo91622a();
                        if (a == null) {
                            this.f35862d = false;
                            this.f35862d = false;
                            return;
                        }
                    }
                }
                this.f35861c.mo91596a(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f35860b));
            if (sendMessage(obtainMessage())) {
                this.f35862d = true;
                return;
            }
            throw new StoreException("Could not send handler message");
        } catch (Throwable th) {
            this.f35862d = false;
            throw th;
        }
    }
}
