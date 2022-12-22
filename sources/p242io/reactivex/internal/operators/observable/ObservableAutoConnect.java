package p242io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import p242io.reactivex.Observable;
import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.functions.Consumer;
import p242io.reactivex.observables.ConnectableObservable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableAutoConnect */
public final class ObservableAutoConnect<T> extends Observable<T> {

    /* renamed from: a */
    final ConnectableObservable<? extends T> f58716a;

    /* renamed from: b */
    final int f58717b;

    /* renamed from: c */
    final Consumer<? super Disposable> f58718c;

    /* renamed from: d */
    final AtomicInteger f58719d = new AtomicInteger();

    public ObservableAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i, Consumer<? super Disposable> consumer) {
        this.f58716a = connectableObservable;
        this.f58717b = i;
        this.f58718c = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f58716a.subscribe(observer);
        if (this.f58719d.incrementAndGet() == this.f58717b) {
            this.f58716a.connect(this.f58718c);
        }
    }
}
