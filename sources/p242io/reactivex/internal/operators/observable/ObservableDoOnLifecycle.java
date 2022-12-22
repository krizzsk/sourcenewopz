package p242io.reactivex.internal.operators.observable;

import p242io.reactivex.Observable;
import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.functions.Action;
import p242io.reactivex.functions.Consumer;
import p242io.reactivex.internal.observers.DisposableLambdaObserver;

/* renamed from: io.reactivex.internal.operators.observable.ObservableDoOnLifecycle */
public final class ObservableDoOnLifecycle<T> extends C21211a<T, T> {

    /* renamed from: a */
    private final Consumer<? super Disposable> f58800a;

    /* renamed from: b */
    private final Action f58801b;

    public ObservableDoOnLifecycle(Observable<T> observable, Consumer<? super Disposable> consumer, Action action) {
        super(observable);
        this.f58800a = consumer;
        this.f58801b = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DisposableLambdaObserver(observer, this.f58800a, this.f58801b));
    }
}
