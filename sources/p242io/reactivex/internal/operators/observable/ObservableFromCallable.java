package p242io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p242io.reactivex.Observable;
import p242io.reactivex.Observer;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.observers.DeferredScalarDisposable;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableFromCallable */
public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {

    /* renamed from: a */
    final Callable<? extends T> f58828a;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.f58828a = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                deferredScalarDisposable.complete(ObjectHelper.requireNonNull(this.f58828a.call(), "Callable returned null"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    public T call() throws Exception {
        return ObjectHelper.requireNonNull(this.f58828a.call(), "The callable returned a null value");
    }
}
