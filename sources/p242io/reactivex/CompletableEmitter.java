package p242io.reactivex;

import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.functions.Cancellable;

/* renamed from: io.reactivex.CompletableEmitter */
public interface CompletableEmitter {
    boolean isDisposed();

    void onComplete();

    void onError(Throwable th);

    void setCancellable(Cancellable cancellable);

    void setDisposable(Disposable disposable);

    boolean tryOnError(Throwable th);
}
