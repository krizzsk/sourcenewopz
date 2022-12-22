package p242io.reactivex.android;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import p242io.reactivex.android.schedulers.AndroidSchedulers;
import p242io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.android.MainThreadDisposable */
public abstract class MainThreadDisposable implements Disposable {

    /* renamed from: a */
    private final AtomicBoolean f58025a = new AtomicBoolean();

    /* access modifiers changed from: protected */
    public abstract void onDispose();

    public static void verifyMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
        }
    }

    public final boolean isDisposed() {
        return this.f58025a.get();
    }

    public final void dispose() {
        if (!this.f58025a.compareAndSet(false, true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            onDispose();
        } else {
            AndroidSchedulers.mainThread().scheduleDirect(new Runnable() {
                public void run() {
                    MainThreadDisposable.this.onDispose();
                }
            });
        }
    }
}
