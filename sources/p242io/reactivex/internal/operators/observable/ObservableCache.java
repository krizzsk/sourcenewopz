package p242io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Observable;
import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableCache */
public final class ObservableCache<T> extends C21211a<T, T> implements Observer<T> {

    /* renamed from: d */
    static final CacheDisposable[] f58740d = new CacheDisposable[0];

    /* renamed from: e */
    static final CacheDisposable[] f58741e = new CacheDisposable[0];

    /* renamed from: a */
    final AtomicBoolean f58742a = new AtomicBoolean();

    /* renamed from: b */
    final int f58743b;

    /* renamed from: c */
    final AtomicReference<CacheDisposable<T>[]> f58744c;

    /* renamed from: f */
    volatile long f58745f;

    /* renamed from: g */
    final Node<T> f58746g;

    /* renamed from: h */
    Node<T> f58747h;

    /* renamed from: i */
    int f58748i;

    /* renamed from: j */
    Throwable f58749j;

    /* renamed from: k */
    volatile boolean f58750k;

    public void onSubscribe(Disposable disposable) {
    }

    public ObservableCache(Observable<T> observable, int i) {
        super(observable);
        this.f58743b = i;
        Node<T> node = new Node<>(i);
        this.f58746g = node;
        this.f58747h = node;
        this.f58744c = new AtomicReference<>(f58740d);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.onSubscribe(cacheDisposable);
        mo174789a(cacheDisposable);
        if (this.f58742a.get() || !this.f58742a.compareAndSet(false, true)) {
            mo174794c(cacheDisposable);
        } else {
            this.source.subscribe(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo174790a() {
        return this.f58742a.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo174792b() {
        return ((CacheDisposable[]) this.f58744c.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo174793c() {
        return this.f58745f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo174789a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f58744c.get();
            if (cacheDisposableArr != f58741e) {
                int length = cacheDisposableArr.length;
                cacheDisposableArr2 = new CacheDisposable[(length + 1)];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
                cacheDisposableArr2[length] = cacheDisposable;
            } else {
                return;
            }
        } while (!this.f58744c.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo174791b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f58744c.get();
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
                        cacheDisposableArr2 = f58740d;
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
        } while (!this.f58744c.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo174794c(CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() == 0) {
            long j = cacheDisposable.index;
            int i = cacheDisposable.offset;
            Node<T> node = cacheDisposable.node;
            Observer<? super T> observer = cacheDisposable.downstream;
            int i2 = this.f58743b;
            int i3 = 1;
            while (!cacheDisposable.disposed) {
                boolean z = this.f58750k;
                boolean z2 = this.f58745f == j;
                if (z && z2) {
                    cacheDisposable.node = null;
                    Throwable th = this.f58749j;
                    if (th != null) {
                        observer.onError(th);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z2) {
                    if (i == i2) {
                        node = node.next;
                        i = 0;
                    }
                    observer.onNext(node.values[i]);
                    i++;
                    j++;
                } else {
                    cacheDisposable.index = j;
                    cacheDisposable.offset = i;
                    cacheDisposable.node = node;
                    i3 = cacheDisposable.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
            cacheDisposable.node = null;
        }
    }

    public void onNext(T t) {
        int i = this.f58748i;
        if (i == this.f58743b) {
            Node<T> node = new Node<>(i);
            node.values[0] = t;
            this.f58748i = 1;
            this.f58747h.next = node;
            this.f58747h = node;
        } else {
            this.f58747h.values[i] = t;
            this.f58748i = i + 1;
        }
        this.f58745f++;
        for (CacheDisposable c : (CacheDisposable[]) this.f58744c.get()) {
            mo174794c(c);
        }
    }

    public void onError(Throwable th) {
        this.f58749j = th;
        this.f58750k = true;
        for (CacheDisposable c : (CacheDisposable[]) this.f58744c.getAndSet(f58741e)) {
            mo174794c(c);
        }
    }

    public void onComplete() {
        this.f58750k = true;
        for (CacheDisposable c : (CacheDisposable[]) this.f58744c.getAndSet(f58741e)) {
            mo174794c(c);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableCache$CacheDisposable */
    static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final Observer<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final ObservableCache<T> parent;

        CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.downstream = observer;
            this.parent = observableCache;
            this.node = observableCache.f58746g;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.parent.mo174791b(this);
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableCache$Node */
    static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        Node(int i) {
            this.values = (Object[]) new Object[i];
        }
    }
}
