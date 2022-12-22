package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.C18448aw;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.m */
final class C18623m<ResultT> extends Task<ResultT> {

    /* renamed from: a */
    private final Object f53435a = new Object();

    /* renamed from: b */
    private final C18618h<ResultT> f53436b = new C18618h<>();

    /* renamed from: c */
    private boolean f53437c;

    /* renamed from: d */
    private ResultT f53438d;

    /* renamed from: e */
    private Exception f53439e;

    C18623m() {
    }

    /* renamed from: a */
    private final void m38241a() {
        C18448aw.m37798a(this.f53437c, (Object) "Task is not yet complete");
    }

    /* renamed from: b */
    private final void m38242b() {
        C18448aw.m37798a(!this.f53437c, (Object) "Task is already complete");
    }

    /* renamed from: c */
    private final void m38243c() {
        synchronized (this.f53435a) {
            if (this.f53437c) {
                this.f53436b.mo149336a(this);
            }
        }
    }

    /* renamed from: a */
    public final void mo149345a(Exception exc) {
        synchronized (this.f53435a) {
            m38242b();
            this.f53437c = true;
            this.f53439e = exc;
        }
        this.f53436b.mo149336a(this);
    }

    /* renamed from: a */
    public final void mo149346a(ResultT resultt) {
        synchronized (this.f53435a) {
            m38242b();
            this.f53437c = true;
            this.f53438d = resultt;
        }
        this.f53436b.mo149336a(this);
    }

    public final Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        this.f53436b.mo149337a(new C18612b(TaskExecutors.MAIN_THREAD, onCompleteListener));
        m38243c();
        return this;
    }

    public final Task<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f53436b.mo149337a(new C18612b(executor, onCompleteListener));
        m38243c();
        return this;
    }

    public final Task<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    public final Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f53436b.mo149337a(new C18614d(executor, onFailureListener));
        m38243c();
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f53436b.mo149337a(new C18616f(executor, onSuccessListener));
        m38243c();
        return this;
    }

    /* renamed from: b */
    public final boolean mo149347b(Exception exc) {
        synchronized (this.f53435a) {
            if (this.f53437c) {
                return false;
            }
            this.f53437c = true;
            this.f53439e = exc;
            this.f53436b.mo149336a(this);
            return true;
        }
    }

    /* renamed from: b */
    public final boolean mo149348b(ResultT resultt) {
        synchronized (this.f53435a) {
            if (this.f53437c) {
                return false;
            }
            this.f53437c = true;
            this.f53438d = resultt;
            this.f53436b.mo149336a(this);
            return true;
        }
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.f53435a) {
            exc = this.f53439e;
        }
        return exc;
    }

    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.f53435a) {
            m38241a();
            Exception exc = this.f53439e;
            if (exc == null) {
                resultt = this.f53438d;
            } else {
                throw new RuntimeExecutionException(exc);
            }
        }
        return resultt;
    }

    public final <X extends Throwable> ResultT getResult(Class<X> cls) throws Throwable {
        ResultT resultt;
        synchronized (this.f53435a) {
            m38241a();
            if (!cls.isInstance(this.f53439e)) {
                Exception exc = this.f53439e;
                if (exc == null) {
                    resultt = this.f53438d;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } else {
                throw ((Throwable) cls.cast(this.f53439e));
            }
        }
        return resultt;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.f53435a) {
            z = this.f53437c;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f53435a) {
            z = false;
            if (this.f53437c && this.f53439e == null) {
                z = true;
            }
        }
        return z;
    }
}
