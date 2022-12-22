package p242io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p242io.reactivex.Observable;
import p242io.reactivex.Observer;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableError */
public final class ObservableError<T> extends Observable<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f58810a;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.f58810a = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f58810a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, (Observer<?>) observer);
    }
}
