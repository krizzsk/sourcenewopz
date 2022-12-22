package p242io.reactivex.internal.operators.single;

import java.util.concurrent.Callable;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleError */
public final class SingleError<T> extends Single<T> {

    /* renamed from: a */
    final Callable<? extends Throwable> f59131a;

    public SingleError(Callable<? extends Throwable> callable) {
        this.f59131a = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f59131a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
    }
}
