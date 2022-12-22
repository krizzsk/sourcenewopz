package p242io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.functions.Functions;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.schedulers.b */
/* compiled from: InstantPeriodicTask */
final class C21216b implements Disposable, Callable<Void> {

    /* renamed from: f */
    static final FutureTask<Void> f59249f = new FutureTask<>(Functions.EMPTY_RUNNABLE, (Object) null);

    /* renamed from: a */
    final Runnable f59250a;

    /* renamed from: b */
    final AtomicReference<Future<?>> f59251b = new AtomicReference<>();

    /* renamed from: c */
    final AtomicReference<Future<?>> f59252c = new AtomicReference<>();

    /* renamed from: d */
    final ExecutorService f59253d;

    /* renamed from: e */
    Thread f59254e;

    C21216b(Runnable runnable, ExecutorService executorService) {
        this.f59250a = runnable;
        this.f59253d = executorService;
    }

    /* renamed from: a */
    public Void call() throws Exception {
        this.f59254e = Thread.currentThread();
        try {
            this.f59250a.run();
            mo175176b(this.f59253d.submit(this));
            this.f59254e = null;
        } catch (Throwable th) {
            this.f59254e = null;
            RxJavaPlugins.onError(th);
        }
        return null;
    }

    public void dispose() {
        Future andSet = this.f59252c.getAndSet(f59249f);
        boolean z = true;
        if (!(andSet == null || andSet == f59249f)) {
            andSet.cancel(this.f59254e != Thread.currentThread());
        }
        Future andSet2 = this.f59251b.getAndSet(f59249f);
        if (andSet2 != null && andSet2 != f59249f) {
            if (this.f59254e == Thread.currentThread()) {
                z = false;
            }
            andSet2.cancel(z);
        }
    }

    public boolean isDisposed() {
        return this.f59252c.get() == f59249f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175175a(Future<?> future) {
        Future future2;
        do {
            future2 = this.f59252c.get();
            if (future2 == f59249f) {
                future.cancel(this.f59254e != Thread.currentThread());
                return;
            }
        } while (!this.f59252c.compareAndSet(future2, future));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175176b(Future<?> future) {
        Future future2;
        do {
            future2 = this.f59251b.get();
            if (future2 == f59249f) {
                future.cancel(this.f59254e != Thread.currentThread());
                return;
            }
        } while (!this.f59251b.compareAndSet(future2, future));
    }
}
