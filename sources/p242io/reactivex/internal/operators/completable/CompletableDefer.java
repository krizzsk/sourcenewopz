package p242io.reactivex.internal.operators.completable;

import java.util.concurrent.Callable;
import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.CompletableSource;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableDefer */
public final class CompletableDefer extends Completable {

    /* renamed from: a */
    final Callable<? extends CompletableSource> f58099a;

    public CompletableDefer(Callable<? extends CompletableSource> callable) {
        this.f58099a = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            ((CompletableSource) ObjectHelper.requireNonNull(this.f58099a.call(), "The completableSupplier returned a null CompletableSource")).subscribe(completableObserver);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, completableObserver);
        }
    }
}
