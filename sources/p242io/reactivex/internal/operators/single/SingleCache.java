package p242io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.SingleSource;
import p242io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.single.SingleCache */
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: a */
    static final CacheDisposable[] f59083a = new CacheDisposable[0];

    /* renamed from: b */
    static final CacheDisposable[] f59084b = new CacheDisposable[0];

    /* renamed from: c */
    final SingleSource<? extends T> f59085c;

    /* renamed from: d */
    final AtomicInteger f59086d = new AtomicInteger();

    /* renamed from: e */
    final AtomicReference<CacheDisposable<T>[]> f59087e = new AtomicReference<>(f59083a);

    /* renamed from: f */
    T f59088f;

    /* renamed from: g */
    Throwable f59089g;

    public void onSubscribe(Disposable disposable) {
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.f59085c = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(singleObserver, this);
        singleObserver.onSubscribe(cacheDisposable);
        if (mo175083a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                mo175084b(cacheDisposable);
            }
            if (this.f59086d.getAndIncrement() == 0) {
                this.f59085c.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.f59089g;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess(this.f59088f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo175083a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f59087e.get();
            if (cacheDisposableArr == f59084b) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f59087e.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175084b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f59087e.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (cacheDisposableArr[i2] == cacheDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = f59083a;
                    } else {
                        CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                        System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                        cacheDisposableArr2 = cacheDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f59087e.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    public void onSuccess(T t) {
        this.f59088f = t;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f59087e.getAndSet(f59084b)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    public void onError(Throwable th) {
        this.f59089g = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f59087e.getAndSet(f59084b)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleCache$CacheDisposable */
    static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;
        final SingleObserver<? super T> downstream;
        final SingleCache<T> parent;

        CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.downstream = singleObserver;
            this.parent = singleCache;
        }

        public boolean isDisposed() {
            return get();
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.mo175084b(this);
            }
        }
    }
}
