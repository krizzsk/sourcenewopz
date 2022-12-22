package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.d */
final class C18614d<ResultT> implements C18617g<ResultT> {

    /* renamed from: a */
    private final Executor f53422a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f53423b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnFailureListener f53424c;

    public C18614d(Executor executor, OnFailureListener onFailureListener) {
        this.f53422a = executor;
        this.f53424c = onFailureListener;
    }

    /* renamed from: a */
    public final void mo149333a(Task<ResultT> task) {
        if (!task.isSuccessful()) {
            synchronized (this.f53423b) {
                if (this.f53424c != null) {
                    this.f53422a.execute(new C18613c(this, task));
                }
            }
        }
    }
}
