package p242io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Scheduler;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.SingleSource;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.disposables.SequentialDisposable;

/* renamed from: io.reactivex.internal.operators.single.SingleSubscribeOn */
public final class SingleSubscribeOn<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<? extends T> f59164a;

    /* renamed from: b */
    final Scheduler f59165b;

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler) {
        this.f59164a = singleSource;
        this.f59165b = scheduler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(singleObserver, this.f59164a);
        singleObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.replace(this.f59165b.scheduleDirect(subscribeOnObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleSubscribeOn$SubscribeOnObserver */
    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final SingleObserver<? super T> downstream;
        final SingleSource<? extends T> source;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.downstream = singleObserver;
            this.source = singleSource;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void run() {
            this.source.subscribe(this);
        }
    }
}
