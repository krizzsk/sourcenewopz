package com.didi.sdk.event;

import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.sdk.event.b */
/* compiled from: BackgroundPoster */
final class C12182b implements Runnable {

    /* renamed from: a */
    private final C12185e f35856a = new C12185e();

    /* renamed from: b */
    private volatile boolean f35857b;

    /* renamed from: c */
    private final EventDispatcherImpl f35858c;

    C12182b(EventDispatcherImpl eventDispatcherImpl) {
        this.f35858c = eventDispatcherImpl;
    }

    /* renamed from: a */
    public void mo91614a(C12188h hVar, Event event) {
        C12184d a = C12184d.m25404a(hVar, event);
        synchronized (this) {
            this.f35856a.mo91624a(a);
            if (!this.f35857b) {
                this.f35857b = true;
                EventDispatcherImpl.f35841a.execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                C12184d a = this.f35856a.mo91623a(1000);
                if (a == null) {
                    synchronized (this) {
                        a = this.f35856a.mo91622a();
                        if (a == null) {
                            this.f35857b = false;
                            this.f35857b = false;
                            return;
                        }
                    }
                }
                this.f35858c.mo91596a(a);
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
                try {
                    SystemUtils.log(5, "Event", Thread.currentThread().getName() + " was interruppted", interruptedException, "com.didi.sdk.event.BackgroundPoster", 47);
                    return;
                } finally {
                    this.f35857b = false;
                }
            }
        }
    }
}
