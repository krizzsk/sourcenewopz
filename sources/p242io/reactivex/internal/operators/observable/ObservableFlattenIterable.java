package p242io.reactivex.internal.operators.observable;

import p242io.reactivex.ObservableSource;
import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Function;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableFlattenIterable */
public final class ObservableFlattenIterable<T, R> extends C21211a<T, R> {

    /* renamed from: a */
    final Function<? super T, ? extends Iterable<? extends R>> f58826a;

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.f58826a = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new FlattenIterableObserver(observer, this.f58826a));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableFlattenIterable$FlattenIterableObserver */
    static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super R> downstream;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        Disposable upstream;

        FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.downstream = observer;
            this.mapper = function;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (this.upstream != DisposableHelper.DISPOSED) {
                try {
                    Observer<? super R> observer = this.downstream;
                    for (Object requireNonNull : (Iterable) this.mapper.apply(t)) {
                        try {
                            try {
                                observer.onNext(ObjectHelper.requireNonNull(requireNonNull, "The iterator returned a null value"));
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.upstream.dispose();
                                onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.upstream.dispose();
                            onError(th2);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.upstream.dispose();
                    onError(th3);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.upstream == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (this.upstream != DisposableHelper.DISPOSED) {
                this.upstream = DisposableHelper.DISPOSED;
                this.downstream.onComplete();
            }
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }
    }
}
