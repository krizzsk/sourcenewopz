package p242io.reactivex.internal.operators.completable;

import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.CompletableOperator;
import p242io.reactivex.CompletableSource;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.completable.CompletableLift */
public final class CompletableLift extends Completable {

    /* renamed from: a */
    final CompletableSource f58124a;

    /* renamed from: b */
    final CompletableOperator f58125b;

    public CompletableLift(CompletableSource completableSource, CompletableOperator completableOperator) {
        this.f58124a = completableSource;
        this.f58125b = completableOperator;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            this.f58124a.subscribe(this.f58125b.apply(completableObserver));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }
}
