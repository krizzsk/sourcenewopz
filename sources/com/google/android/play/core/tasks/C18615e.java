package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.e */
final class C18615e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f53425a;

    /* renamed from: b */
    final /* synthetic */ C18616f f53426b;

    C18615e(C18616f fVar, Task task) {
        this.f53426b = fVar;
        this.f53425a = task;
    }

    public final void run() {
        synchronized (this.f53426b.f53428b) {
            if (this.f53426b.f53429c != null) {
                this.f53426b.f53429c.onSuccess(this.f53425a.getResult());
            }
        }
    }
}
