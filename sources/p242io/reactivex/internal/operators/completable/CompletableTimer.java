package p242io.reactivex.internal.operators.completable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.Scheduler;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableTimer */
public final class CompletableTimer extends Completable {

    /* renamed from: a */
    final long f58156a;

    /* renamed from: b */
    final TimeUnit f58157b;

    /* renamed from: c */
    final Scheduler f58158c;

    public CompletableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f58156a = j;
        this.f58157b = timeUnit;
        this.f58158c = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.f58158c.scheduleDirect(timerDisposable, this.f58156a, this.f58157b));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableTimer$TimerDisposable */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final CompletableObserver downstream;

        TimerDisposable(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public void run() {
            this.downstream.onComplete();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        /* access modifiers changed from: package-private */
        public void setFuture(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }
}
