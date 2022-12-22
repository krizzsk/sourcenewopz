package p242io.reactivex.internal.operators.observable;

import p242io.reactivex.Observable;
import p242io.reactivex.Observer;
import p242io.reactivex.internal.fuseable.ScalarCallable;
import p242io.reactivex.internal.operators.observable.ObservableScalarXMap;

/* renamed from: io.reactivex.internal.operators.observable.ObservableJust */
public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {

    /* renamed from: a */
    private final T f58863a;

    public ObservableJust(T t) {
        this.f58863a = t;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.f58863a);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }

    public T call() {
        return this.f58863a;
    }
}
