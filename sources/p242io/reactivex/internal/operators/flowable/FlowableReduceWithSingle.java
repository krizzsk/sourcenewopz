package p242io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.BiFunction;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableReduceWithSingle */
public final class FlowableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: a */
    final Publisher<T> f58401a;

    /* renamed from: b */
    final Callable<R> f58402b;

    /* renamed from: c */
    final BiFunction<R, ? super T, R> f58403c;

    public FlowableReduceWithSingle(Publisher<T> publisher, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f58401a = publisher;
        this.f58402b = callable;
        this.f58403c = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f58401a.subscribe(new FlowableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f58403c, ObjectHelper.requireNonNull(this.f58402b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
