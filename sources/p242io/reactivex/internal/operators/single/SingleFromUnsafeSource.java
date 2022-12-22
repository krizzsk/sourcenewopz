package p242io.reactivex.internal.operators.single;

import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.SingleSource;

/* renamed from: io.reactivex.internal.operators.single.SingleFromUnsafeSource */
public final class SingleFromUnsafeSource<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<T> f59148a;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.f59148a = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f59148a.subscribe(singleObserver);
    }
}
