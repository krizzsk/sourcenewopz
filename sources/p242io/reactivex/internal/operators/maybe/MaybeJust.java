package p242io.reactivex.internal.operators.maybe;

import p242io.reactivex.Maybe;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.disposables.Disposables;
import p242io.reactivex.internal.fuseable.ScalarCallable;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeJust */
public final class MaybeJust<T> extends Maybe<T> implements ScalarCallable<T> {

    /* renamed from: a */
    final T f58605a;

    public MaybeJust(T t) {
        this.f58605a = t;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.disposed());
        maybeObserver.onSuccess(this.f58605a);
    }

    public T call() {
        return this.f58605a;
    }
}
