package p242io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Scheduler;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.SingleSource;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleObserveOn */
public final class SingleObserveOn<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<T> f59157a;

    /* renamed from: b */
    final Scheduler f59158b;

    public SingleObserveOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f59157a = singleSource;
        this.f59158b = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f59157a.subscribe(new ObserveOnSingleObserver(singleObserver, this.f59158b));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleObserveOn$ObserveOnSingleObserver */
    static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final SingleObserver<? super T> downstream;
        Throwable error;
        final Scheduler scheduler;
        T value;

        ObserveOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler2) {
            this.downstream = singleObserver;
            this.scheduler = scheduler2;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.value = t;
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.downstream.onError(th);
            } else {
                this.downstream.onSuccess(this.value);
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }
    }
}
