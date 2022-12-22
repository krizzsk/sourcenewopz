package p242io.reactivex.internal.operators.observable;

import p242io.reactivex.Maybe;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.Observable;
import p242io.reactivex.ObservableSource;
import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.fuseable.FuseToObservable;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableElementAtMaybe */
public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {

    /* renamed from: a */
    final ObservableSource<T> f58805a;

    /* renamed from: b */
    final long f58806b;

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j) {
        this.f58805a = observableSource;
        this.f58806b = j;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f58805a.subscribe(new ElementAtObserver(maybeObserver, this.f58806b));
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.f58805a, this.f58806b, null, false));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableElementAtMaybe$ElementAtObserver */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        long count;
        boolean done;
        final MaybeObserver<? super T> downstream;
        final long index;
        Disposable upstream;

        ElementAtObserver(MaybeObserver<? super T> maybeObserver, long j) {
            this.downstream = maybeObserver;
            this.index = j;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onNext(T t) {
            if (!this.done) {
                long j = this.count;
                if (j == this.index) {
                    this.done = true;
                    this.upstream.dispose();
                    this.downstream.onSuccess(t);
                    return;
                }
                this.count = j + 1;
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }
    }
}
