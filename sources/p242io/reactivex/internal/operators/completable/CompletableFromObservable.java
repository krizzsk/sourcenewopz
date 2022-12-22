package p242io.reactivex.internal.operators.completable;

import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.ObservableSource;
import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromObservable */
public final class CompletableFromObservable<T> extends Completable {

    /* renamed from: a */
    final ObservableSource<T> f58116a;

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.f58116a = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f58116a.subscribe(new CompletableFromObservableObserver(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableFromObservable$CompletableFromObservableObserver */
    static final class CompletableFromObservableObserver<T> implements Observer<T> {

        /* renamed from: co */
        final CompletableObserver f58117co;

        public void onNext(T t) {
        }

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f58117co = completableObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f58117co.onSubscribe(disposable);
        }

        public void onError(Throwable th) {
            this.f58117co.onError(th);
        }

        public void onComplete() {
            this.f58117co.onComplete();
        }
    }
}
