package com.didi.sdk.event;

/* renamed from: com.didi.sdk.event.a */
/* compiled from: AsyncPoster */
class C12181a implements Runnable {

    /* renamed from: a */
    private final C12185e f35854a = new C12185e();

    /* renamed from: b */
    private final EventDispatcherImpl f35855b;

    C12181a(EventDispatcherImpl eventDispatcherImpl) {
        this.f35855b = eventDispatcherImpl;
    }

    /* renamed from: a */
    public void mo91612a(C12188h hVar, Event event) {
        this.f35854a.mo91624a(C12184d.m25404a(hVar, event));
        EventDispatcherImpl.f35841a.execute(this);
    }

    public void run() {
        C12184d a = this.f35854a.mo91622a();
        if (a != null) {
            this.f35855b.mo91596a(a);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
