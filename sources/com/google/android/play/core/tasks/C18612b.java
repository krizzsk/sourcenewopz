package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.b */
final class C18612b<ResultT> implements C18617g<ResultT> {

    /* renamed from: a */
    private final Executor f53417a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f53418b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnCompleteListener<ResultT> f53419c;

    public C18612b(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f53417a = executor;
        this.f53419c = onCompleteListener;
    }

    /* renamed from: a */
    public final void mo149333a(Task<ResultT> task) {
        synchronized (this.f53418b) {
            if (this.f53419c != null) {
                this.f53417a.execute(new C18611a(this, task));
            }
        }
    }
}
