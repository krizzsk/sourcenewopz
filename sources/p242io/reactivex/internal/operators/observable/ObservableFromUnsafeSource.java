package p242io.reactivex.internal.operators.observable;

import p242io.reactivex.Observable;
import p242io.reactivex.ObservableSource;
import p242io.reactivex.Observer;

/* renamed from: io.reactivex.internal.operators.observable.ObservableFromUnsafeSource */
public final class ObservableFromUnsafeSource<T> extends Observable<T> {

    /* renamed from: a */
    final ObservableSource<T> f58835a;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.f58835a = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f58835a.subscribe(observer);
    }
}
