package p242io.reactivex.internal.operators.maybe;

import java.util.concurrent.Callable;
import p242io.reactivex.Maybe;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.disposables.Disposables;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeFromRunnable */
public final class MaybeFromRunnable<T> extends Maybe<T> implements Callable<T> {

    /* renamed from: a */
    final Runnable f58601a;

    public MaybeFromRunnable(Runnable runnable) {
        this.f58601a = runnable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                this.f58601a.run();
                if (!empty.isDisposed()) {
                    maybeObserver.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!empty.isDisposed()) {
                    maybeObserver.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    public T call() throws Exception {
        this.f58601a.run();
        return null;
    }
}
