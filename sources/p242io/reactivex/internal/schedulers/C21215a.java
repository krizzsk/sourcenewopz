package p242io.reactivex.internal.schedulers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p242io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.schedulers.a */
/* compiled from: DisposeOnCancel */
final class C21215a implements Future<Object> {

    /* renamed from: a */
    final Disposable f59248a;

    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    public Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    C21215a(Disposable disposable) {
        this.f59248a = disposable;
    }

    public boolean cancel(boolean z) {
        this.f59248a.dispose();
        return false;
    }
}
