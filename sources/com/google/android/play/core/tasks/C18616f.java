package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.f */
final class C18616f<ResultT> implements C18617g<ResultT> {

    /* renamed from: a */
    private final Executor f53427a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f53428b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnSuccessListener<? super ResultT> f53429c;

    public C18616f(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f53427a = executor;
        this.f53429c = onSuccessListener;
    }

    /* renamed from: a */
    public final void mo149333a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            synchronized (this.f53428b) {
                if (this.f53429c != null) {
                    this.f53427a.execute(new C18615e(this, task));
                }
            }
        }
    }
}
