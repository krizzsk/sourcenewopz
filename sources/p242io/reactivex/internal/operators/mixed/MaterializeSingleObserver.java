package p242io.reactivex.internal.operators.mixed;

import p242io.reactivex.CompletableObserver;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.Notification;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.mixed.MaterializeSingleObserver */
public final class MaterializeSingleObserver<T> implements CompletableObserver, MaybeObserver<T>, SingleObserver<T>, Disposable {

    /* renamed from: a */
    final SingleObserver<? super Notification<T>> f58673a;

    /* renamed from: b */
    Disposable f58674b;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.f58673a = singleObserver;
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f58674b, disposable)) {
            this.f58674b = disposable;
            this.f58673a.onSubscribe(this);
        }
    }

    public void onComplete() {
        this.f58673a.onSuccess(Notification.createOnComplete());
    }

    public void onSuccess(T t) {
        this.f58673a.onSuccess(Notification.createOnNext(t));
    }

    public void onError(Throwable th) {
        this.f58673a.onSuccess(Notification.createOnError(th));
    }

    public boolean isDisposed() {
        return this.f58674b.isDisposed();
    }

    public void dispose() {
        this.f58674b.dispose();
    }
}
