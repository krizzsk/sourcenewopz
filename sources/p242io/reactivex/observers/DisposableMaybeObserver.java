package p242io.reactivex.observers;

import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.observers.DisposableMaybeObserver */
public abstract class DisposableMaybeObserver<T> implements MaybeObserver<T>, Disposable {

    /* renamed from: a */
    final AtomicReference<Disposable> f59303a = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f59303a, disposable, getClass())) {
            onStart();
        }
    }

    public final boolean isDisposed() {
        return this.f59303a.get() == DisposableHelper.DISPOSED;
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f59303a);
    }
}
