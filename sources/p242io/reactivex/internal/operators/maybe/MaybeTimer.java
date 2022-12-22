package p242io.reactivex.internal.operators.maybe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Maybe;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.Scheduler;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeTimer */
public final class MaybeTimer extends Maybe<Long> {

    /* renamed from: a */
    final long f58631a;

    /* renamed from: b */
    final TimeUnit f58632b;

    /* renamed from: c */
    final Scheduler f58633c;

    public MaybeTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f58631a = j;
        this.f58632b = timeUnit;
        this.f58633c = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super Long> maybeObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(maybeObserver);
        maybeObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.f58633c.scheduleDirect(timerDisposable, this.f58631a, this.f58632b));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeTimer$TimerDisposable */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;
        final MaybeObserver<? super Long> downstream;

        TimerDisposable(MaybeObserver<? super Long> maybeObserver) {
            this.downstream = maybeObserver;
        }

        public void run() {
            this.downstream.onSuccess(0L);
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
