package p242io.reactivex.internal.operators.maybe;

import p242io.reactivex.MaybeObserver;
import p242io.reactivex.MaybeOperator;
import p242io.reactivex.MaybeSource;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeLift */
public final class MaybeLift<T, R> extends C21209a<T, R> {

    /* renamed from: a */
    final MaybeOperator<? extends R, ? super T> f58606a;

    public MaybeLift(MaybeSource<T> maybeSource, MaybeOperator<? extends R, ? super T> maybeOperator) {
        super(maybeSource);
        this.f58606a = maybeOperator;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        try {
            this.source.subscribe((MaybeObserver) ObjectHelper.requireNonNull(this.f58606a.apply(maybeObserver), "The operator returned a null MaybeObserver"));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (MaybeObserver<?>) maybeObserver);
        }
    }
}
