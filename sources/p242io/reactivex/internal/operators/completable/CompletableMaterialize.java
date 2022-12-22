package p242io.reactivex.internal.operators.completable;

import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.Notification;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* renamed from: io.reactivex.internal.operators.completable.CompletableMaterialize */
public final class CompletableMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: a */
    final Completable f58126a;

    public CompletableMaterialize(Completable completable) {
        this.f58126a = completable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f58126a.subscribe((CompletableObserver) new MaterializeSingleObserver(singleObserver));
    }
}
