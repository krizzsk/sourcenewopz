package p242io.reactivex.internal.operators.single;

import p242io.reactivex.Notification;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* renamed from: io.reactivex.internal.operators.single.SingleMaterialize */
public final class SingleMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: a */
    final Single<T> f59156a;

    public SingleMaterialize(Single<T> single) {
        this.f59156a = single;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f59156a.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
