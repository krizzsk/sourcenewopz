package com.didi.sdk.event;

/* renamed from: com.didi.sdk.event.e */
/* compiled from: PendingPostQueue */
final class C12185e {

    /* renamed from: a */
    private C12184d f35868a;

    /* renamed from: b */
    private C12184d f35869b;

    C12185e() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo91624a(C12184d dVar) {
        if (dVar != null) {
            try {
                if (this.f35869b != null) {
                    this.f35869b.f35867c = dVar;
                    this.f35869b = dVar;
                } else if (this.f35868a == null) {
                    this.f35869b = dVar;
                    this.f35868a = dVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C12184d mo91622a() {
        C12184d dVar;
        dVar = this.f35868a;
        if (this.f35868a != null) {
            C12184d dVar2 = this.f35868a.f35867c;
            this.f35868a = dVar2;
            if (dVar2 == null) {
                this.f35869b = null;
            }
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C12184d mo91623a(int i) throws InterruptedException {
        if (this.f35868a == null) {
            wait((long) i);
        }
        return mo91622a();
    }
}
