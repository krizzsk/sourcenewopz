package p242io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.observers.ResumeSingleObserver */
public final class ResumeSingleObserver<T> implements SingleObserver<T> {

    /* renamed from: a */
    final AtomicReference<Disposable> f58071a;

    /* renamed from: b */
    final SingleObserver<? super T> f58072b;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.f58071a = atomicReference;
        this.f58072b = singleObserver;
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f58071a, disposable);
    }

    public void onSuccess(T t) {
        this.f58072b.onSuccess(t);
    }

    public void onError(Throwable th) {
        this.f58072b.onError(th);
    }
}
