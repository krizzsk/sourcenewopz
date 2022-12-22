package p242io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Maybe;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.MaybeSource;
import p242io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeCache */
public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {

    /* renamed from: a */
    static final CacheDisposable[] f58545a = new CacheDisposable[0];

    /* renamed from: b */
    static final CacheDisposable[] f58546b = new CacheDisposable[0];

    /* renamed from: c */
    final AtomicReference<MaybeSource<T>> f58547c;

    /* renamed from: d */
    final AtomicReference<CacheDisposable<T>[]> f58548d = new AtomicReference<>(f58545a);

    /* renamed from: e */
    T f58549e;

    /* renamed from: f */
    Throwable f58550f;

    public void onSubscribe(Disposable disposable) {
    }

    public MaybeCache(MaybeSource<T> maybeSource) {
        this.f58547c = new AtomicReference<>(maybeSource);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(maybeObserver, this);
        maybeObserver.onSubscribe(cacheDisposable);
        if (mo174642a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                mo174643b(cacheDisposable);
                return;
            }
            MaybeSource andSet = this.f58547c.getAndSet((Object) null);
            if (andSet != null) {
                andSet.subscribe(this);
            }
        } else if (!cacheDisposable.isDisposed()) {
            Throwable th = this.f58550f;
            if (th != null) {
                maybeObserver.onError(th);
                return;
            }
            T t = this.f58549e;
            if (t != null) {
                maybeObserver.onSuccess(t);
            } else {
                maybeObserver.onComplete();
            }
        }
    }

    public void onSuccess(T t) {
        this.f58549e = t;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f58548d.getAndSet(f58546b)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    public void onError(Throwable th) {
        this.f58550f = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f58548d.getAndSet(f58546b)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th);
            }
        }
    }

    public void onComplete() {
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f58548d.getAndSet(f58546b)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onComplete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo174642a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f58548d.get();
            if (cacheDisposableArr == f58546b) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f58548d.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo174643b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f58548d.get();
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
                        cacheDisposableArr2 = f58545a;
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
        } while (!this.f58548d.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeCache$CacheDisposable */
    static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;
        final MaybeObserver<? super T> downstream;

        CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.downstream = maybeObserver;
        }

        public void dispose() {
            MaybeCache maybeCache = (MaybeCache) getAndSet((Object) null);
            if (maybeCache != null) {
                maybeCache.mo174643b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }
}
