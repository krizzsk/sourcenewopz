package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.a */
final class C18611a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f53415a;

    /* renamed from: b */
    final /* synthetic */ C18612b f53416b;

    C18611a(C18612b bVar, Task task) {
        this.f53416b = bVar;
        this.f53415a = task;
    }

    public final void run() {
        synchronized (this.f53416b.f53418b) {
            if (this.f53416b.f53419c != null) {
                this.f53416b.f53419c.onComplete(this.f53415a);
            }
        }
    }
}
