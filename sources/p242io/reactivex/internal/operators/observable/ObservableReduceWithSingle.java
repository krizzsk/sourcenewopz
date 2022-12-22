package p242io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p242io.reactivex.ObservableSource;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.BiFunction;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;

/* renamed from: io.reactivex.internal.operators.observable.ObservableReduceWithSingle */
public final class ObservableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: a */
    final ObservableSource<T> f58894a;

    /* renamed from: b */
    final Callable<R> f58895b;

    /* renamed from: c */
    final BiFunction<R, ? super T, R> f58896c;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f58894a = observableSource;
        this.f58895b = callable;
        this.f58896c = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f58894a.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f58896c, ObjectHelper.requireNonNull(this.f58895b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
