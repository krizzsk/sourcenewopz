package p242io.reactivex.internal.operators.observable;

import p242io.reactivex.ObservableSource;
import p242io.reactivex.Observer;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.BiFunction;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableReduceSeedSingle */
public final class ObservableReduceSeedSingle<T, R> extends Single<R> {

    /* renamed from: a */
    final ObservableSource<T> f58891a;

    /* renamed from: b */
    final R f58892b;

    /* renamed from: c */
    final BiFunction<R, ? super T, R> f58893c;

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r, BiFunction<R, ? super T, R> biFunction) {
        this.f58891a = observableSource;
        this.f58892b = r;
        this.f58893c = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f58891a.subscribe(new ReduceSeedObserver(singleObserver, this.f58893c, this.f58892b));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableReduceSeedSingle$ReduceSeedObserver */
    static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {
        final SingleObserver<? super R> downstream;
        final BiFunction<R, ? super T, R> reducer;
        Disposable upstream;
        R value;

        ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.downstream = singleObserver;
            this.value = r;
            this.reducer = biFunction;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            R r = this.value;
            if (r != null) {
                try {
                    this.value = ObjectHelper.requireNonNull(this.reducer.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.dispose();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.value != null) {
                this.value = null;
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            R r = this.value;
            if (r != null) {
                this.value = null;
                this.downstream.onSuccess(r);
            }
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }
}
