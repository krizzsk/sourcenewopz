package p242io.reactivex.internal.operators.single;

import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.SingleSource;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Action;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.single.SingleDoAfterTerminate */
public final class SingleDoAfterTerminate<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<T> f59115a;

    /* renamed from: b */
    final Action f59116b;

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.f59115a = singleSource;
        this.f59116b = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f59115a.subscribe(new DoAfterTerminateObserver(singleObserver, this.f59116b));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDoAfterTerminate$DoAfterTerminateObserver */
    static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> downstream;
        final Action onAfterTerminate;
        Disposable upstream;

        DoAfterTerminateObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.downstream = singleObserver;
            this.onAfterTerminate = action;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
            onAfterTerminate();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
            onAfterTerminate();
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        private void onAfterTerminate() {
            try {
                this.onAfterTerminate.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }
}
