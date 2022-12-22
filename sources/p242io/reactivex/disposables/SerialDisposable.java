package p242io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.disposables.SerialDisposable */
public final class SerialDisposable implements Disposable {

    /* renamed from: a */
    final AtomicReference<Disposable> f58034a;

    public SerialDisposable() {
        this.f58034a = new AtomicReference<>();
    }

    public SerialDisposable(Disposable disposable) {
        this.f58034a = new AtomicReference<>(disposable);
    }

    public boolean set(Disposable disposable) {
        return DisposableHelper.set(this.f58034a, disposable);
    }

    public boolean replace(Disposable disposable) {
        return DisposableHelper.replace(this.f58034a, disposable);
    }

    public Disposable get() {
        Disposable disposable = this.f58034a.get();
        return disposable == DisposableHelper.DISPOSED ? Disposables.disposed() : disposable;
    }

    public void dispose() {
        DisposableHelper.dispose(this.f58034a);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f58034a.get());
    }
}
