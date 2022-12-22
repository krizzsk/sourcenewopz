package p242io.reactivex.internal.operators.maybe;

import p242io.reactivex.Maybe;
import p242io.reactivex.Notification;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeMaterialize */
public final class MaybeMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: a */
    final Maybe<T> f58608a;

    public MaybeMaterialize(Maybe<T> maybe) {
        this.f58608a = maybe;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f58608a.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
