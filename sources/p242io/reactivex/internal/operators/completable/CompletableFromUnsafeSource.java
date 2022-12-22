package p242io.reactivex.internal.operators.completable;

import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.CompletableSource;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromUnsafeSource */
public final class CompletableFromUnsafeSource extends Completable {

    /* renamed from: a */
    final CompletableSource f58122a;

    public CompletableFromUnsafeSource(CompletableSource completableSource) {
        this.f58122a = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f58122a.subscribe(completableObserver);
    }
}
