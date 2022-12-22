package p242io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Observer;
import p242io.reactivex.annotations.CheckReturnValue;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.fuseable.SimpleQueue;
import p242io.reactivex.internal.observers.BasicIntQueueDisposable;
import p242io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subjects.UnicastSubject */
public final class UnicastSubject<T> extends Subject<T> {

    /* renamed from: a */
    final SpscLinkedArrayQueue<T> f59459a;

    /* renamed from: b */
    final AtomicReference<Observer<? super T>> f59460b;

    /* renamed from: c */
    final AtomicReference<Runnable> f59461c;

    /* renamed from: d */
    final boolean f59462d;

    /* renamed from: e */
    volatile boolean f59463e;

    /* renamed from: f */
    volatile boolean f59464f;

    /* renamed from: g */
    Throwable f59465g;

    /* renamed from: h */
    final AtomicBoolean f59466h;

    /* renamed from: i */
    final BasicIntQueueDisposable<T> f59467i;

    /* renamed from: j */
    boolean f59468j;

    @CheckReturnValue
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(bufferSize(), true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i) {
        return new UnicastSubject<>(i, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i, Runnable runnable) {
        return new UnicastSubject<>(i, runnable, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(int i, Runnable runnable, boolean z) {
        return new UnicastSubject<>(i, runnable, z);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> create(boolean z) {
        return new UnicastSubject<>(bufferSize(), z);
    }

    UnicastSubject(int i, boolean z) {
        this.f59459a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.f59461c = new AtomicReference<>();
        this.f59462d = z;
        this.f59460b = new AtomicReference<>();
        this.f59466h = new AtomicBoolean();
        this.f59467i = new UnicastQueueDisposable();
    }

    UnicastSubject(int i, Runnable runnable) {
        this(i, runnable, true);
    }

    UnicastSubject(int i, Runnable runnable, boolean z) {
        this.f59459a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.f59461c = new AtomicReference<>(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.f59462d = z;
        this.f59460b = new AtomicReference<>();
        this.f59466h = new AtomicBoolean();
        this.f59467i = new UnicastQueueDisposable();
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        if (this.f59466h.get() || !this.f59466h.compareAndSet(false, true)) {
            EmptyDisposable.error((Throwable) new IllegalStateException("Only a single observer allowed."), (Observer<?>) observer);
            return;
        }
        observer.onSubscribe(this.f59467i);
        this.f59460b.lazySet(observer);
        if (this.f59463e) {
            this.f59460b.lazySet((Object) null);
        } else {
            mo175593b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175590a() {
        Runnable runnable = this.f59461c.get();
        if (runnable != null && this.f59461c.compareAndSet(runnable, (Object) null)) {
            runnable.run();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f59464f || this.f59463e) {
            disposable.dispose();
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f59464f && !this.f59463e) {
            this.f59459a.offer(t);
            mo175593b();
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f59464f || this.f59463e) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f59465g = th;
        this.f59464f = true;
        mo175590a();
        mo175593b();
    }

    public void onComplete() {
        if (!this.f59464f && !this.f59463e) {
            this.f59464f = true;
            mo175590a();
            mo175593b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175591a(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f59459a;
        boolean z = !this.f59462d;
        boolean z2 = true;
        int i = 1;
        while (!this.f59463e) {
            boolean z3 = this.f59464f;
            T poll = this.f59459a.poll();
            boolean z4 = poll == null;
            if (z3) {
                if (z && z2) {
                    if (!mo175592a(spscLinkedArrayQueue, observer)) {
                        z2 = false;
                    } else {
                        return;
                    }
                }
                if (z4) {
                    mo175595c(observer);
                    return;
                }
            }
            if (z4) {
                i = this.f59467i.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.f59460b.lazySet((Object) null);
        spscLinkedArrayQueue.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175594b(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f59459a;
        int i = 1;
        boolean z = !this.f59462d;
        while (!this.f59463e) {
            boolean z2 = this.f59464f;
            if (!z || !z2 || !mo175592a(spscLinkedArrayQueue, observer)) {
                observer.onNext(null);
                if (z2) {
                    mo175595c(observer);
                    return;
                }
                i = this.f59467i.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f59460b.lazySet((Object) null);
        spscLinkedArrayQueue.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo175595c(Observer<? super T> observer) {
        this.f59460b.lazySet((Object) null);
        Throwable th = this.f59465g;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo175592a(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.f59465g;
        if (th == null) {
            return false;
        }
        this.f59460b.lazySet((Object) null);
        simpleQueue.clear();
        observer.onError(th);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175593b() {
        if (this.f59467i.getAndIncrement() == 0) {
            Observer observer = this.f59460b.get();
            int i = 1;
            while (observer == null) {
                i = this.f59467i.addAndGet(-i);
                if (i != 0) {
                    observer = this.f59460b.get();
                } else {
                    return;
                }
            }
            if (this.f59468j) {
                mo175594b(observer);
            } else {
                mo175591a(observer);
            }
        }
    }

    public boolean hasObservers() {
        return this.f59460b.get() != null;
    }

    public Throwable getThrowable() {
        if (this.f59464f) {
            return this.f59465g;
        }
        return null;
    }

    public boolean hasThrowable() {
        return this.f59464f && this.f59465g != null;
    }

    public boolean hasComplete() {
        return this.f59464f && this.f59465g == null;
    }

    /* renamed from: io.reactivex.subjects.UnicastSubject$UnicastQueueDisposable */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f59468j = true;
            return 2;
        }

        public T poll() throws Exception {
            return UnicastSubject.this.f59459a.poll();
        }

        public boolean isEmpty() {
            return UnicastSubject.this.f59459a.isEmpty();
        }

        public void clear() {
            UnicastSubject.this.f59459a.clear();
        }

        public void dispose() {
            if (!UnicastSubject.this.f59463e) {
                UnicastSubject.this.f59463e = true;
                UnicastSubject.this.mo175590a();
                UnicastSubject.this.f59460b.lazySet((Object) null);
                if (UnicastSubject.this.f59467i.getAndIncrement() == 0) {
                    UnicastSubject.this.f59460b.lazySet((Object) null);
                    UnicastSubject.this.f59459a.clear();
                }
            }
        }

        public boolean isDisposed() {
            return UnicastSubject.this.f59463e;
        }
    }
}
