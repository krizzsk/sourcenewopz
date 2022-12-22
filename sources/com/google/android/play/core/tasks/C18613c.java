package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.c */
final class C18613c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f53420a;

    /* renamed from: b */
    final /* synthetic */ C18614d f53421b;

    C18613c(C18614d dVar, Task task) {
        this.f53421b = dVar;
        this.f53420a = task;
    }

    public final void run() {
        synchronized (this.f53421b.f53423b) {
            if (this.f53421b.f53424c != null) {
                this.f53421b.f53424c.onFailure(this.f53420a.getException());
            }
        }
    }
}
