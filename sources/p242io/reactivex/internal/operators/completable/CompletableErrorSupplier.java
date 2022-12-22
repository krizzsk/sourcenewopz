package p242io.reactivex.internal.operators.completable;

import java.util.concurrent.Callable;
import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableErrorSupplier */
public final class CompletableErrorSupplier extends Completable {

    /* renamed from: a */
    final Callable<? extends Throwable> f58113a;

    public CompletableErrorSupplier(Callable<? extends Throwable> callable) {
        this.f58113a = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f58113a.call(), "The error returned is null");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, completableObserver);
    }
}
