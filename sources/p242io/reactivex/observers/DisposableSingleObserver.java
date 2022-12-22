package p242io.reactivex.observers;

import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.observers.DisposableSingleObserver */
public abstract class DisposableSingleObserver<T> implements SingleObserver<T>, Disposable {

    /* renamed from: a */
    final AtomicReference<Disposable> f59304a = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f59304a, disposable, getClass())) {
            onStart();
        }
    }

    public final boolean isDisposed() {
        return this.f59304a.get() == DisposableHelper.DISPOSED;
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f59304a);
    }
}
