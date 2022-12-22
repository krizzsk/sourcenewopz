package p242io.reactivex.processors;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.annotations.CheckReturnValue;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p242io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import p242io.reactivex.internal.subscriptions.EmptySubscription;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.internal.util.BackpressureHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.processors.UnicastProcessor */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: a */
    final SpscLinkedArrayQueue<T> f59391a;

    /* renamed from: b */
    final AtomicReference<Runnable> f59392b;

    /* renamed from: c */
    final boolean f59393c;

    /* renamed from: d */
    volatile boolean f59394d;

    /* renamed from: e */
    Throwable f59395e;

    /* renamed from: f */
    final AtomicReference<Subscriber<? super T>> f59396f;

    /* renamed from: g */
    volatile boolean f59397g;

    /* renamed from: h */
    final AtomicBoolean f59398h;

    /* renamed from: i */
    final BasicIntQueueSubscription<T> f59399i;

    /* renamed from: j */
    final AtomicLong f59400j;

    /* renamed from: k */
    boolean f59401k;

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create() {
        return new UnicastProcessor<>(bufferSize());
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i) {
        return new UnicastProcessor<>(i);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(boolean z) {
        return new UnicastProcessor<>(bufferSize(), (Runnable) null, z);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i, runnable);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> create(int i, Runnable runnable, boolean z) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i, runnable, z);
    }

    UnicastProcessor(int i) {
        this(i, (Runnable) null, true);
    }

    UnicastProcessor(int i, Runnable runnable) {
        this(i, runnable, true);
    }

    UnicastProcessor(int i, Runnable runnable, boolean z) {
        this.f59391a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.f59392b = new AtomicReference<>(runnable);
        this.f59393c = z;
        this.f59396f = new AtomicReference<>();
        this.f59398h = new AtomicBoolean();
        this.f59399i = new UnicastQueueSubscription();
        this.f59400j = new AtomicLong();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175488a() {
        Runnable andSet = this.f59392b.getAndSet((Object) null);
        if (andSet != null) {
            andSet.run();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175489a(Subscriber<? super T> subscriber) {
        int i;
        long j;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f59391a;
        boolean z = !this.f59393c;
        int i2 = 1;
        while (true) {
            long j2 = this.f59400j.get();
            long j3 = 0;
            while (true) {
                i = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i == 0) {
                    j = j3;
                    break;
                }
                boolean z2 = this.f59394d;
                T poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                T t = poll;
                j = j3;
                if (!mo175490a(z, z2, z3, subscriber, spscLinkedArrayQueue)) {
                    if (z3) {
                        break;
                    }
                    subscriber.onNext(t);
                    j3 = 1 + j;
                } else {
                    return;
                }
            }
            Subscriber<? super T> subscriber2 = subscriber;
            if (i == 0) {
                if (mo175490a(z, this.f59394d, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
            }
            if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                this.f59400j.addAndGet(-j);
            }
            i2 = this.f59399i.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175492b(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f59391a;
        int i = 1;
        boolean z = !this.f59393c;
        while (!this.f59397g) {
            boolean z2 = this.f59394d;
            if (!z || !z2 || this.f59395e == null) {
                subscriber.onNext(null);
                if (z2) {
                    this.f59396f.lazySet((Object) null);
                    Throwable th = this.f59395e;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                } else {
                    i = this.f59399i.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            } else {
                spscLinkedArrayQueue.clear();
                this.f59396f.lazySet((Object) null);
                subscriber.onError(this.f59395e);
                return;
            }
        }
        spscLinkedArrayQueue.clear();
        this.f59396f.lazySet((Object) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175491b() {
        if (this.f59399i.getAndIncrement() == 0) {
            int i = 1;
            Subscriber subscriber = this.f59396f.get();
            while (subscriber == null) {
                i = this.f59399i.addAndGet(-i);
                if (i != 0) {
                    subscriber = this.f59396f.get();
                } else {
                    return;
                }
            }
            if (this.f59401k) {
                mo175492b(subscriber);
            } else {
                mo175489a(subscriber);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo175490a(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.f59397g) {
            spscLinkedArrayQueue.clear();
            this.f59396f.lazySet((Object) null);
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (z && this.f59395e != null) {
                spscLinkedArrayQueue.clear();
                this.f59396f.lazySet((Object) null);
                subscriber.onError(this.f59395e);
                return true;
            } else if (!z3) {
                return false;
            } else {
                Throwable th = this.f59395e;
                this.f59396f.lazySet((Object) null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f59394d || this.f59397g) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f59394d && !this.f59397g) {
            this.f59391a.offer(t);
            mo175491b();
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f59394d || this.f59397g) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f59395e = th;
        this.f59394d = true;
        mo175488a();
        mo175491b();
    }

    public void onComplete() {
        if (!this.f59394d && !this.f59397g) {
            this.f59394d = true;
            mo175488a();
            mo175491b();
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f59398h.get() || !this.f59398h.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.f59399i);
        this.f59396f.set(subscriber);
        if (this.f59397g) {
            this.f59396f.lazySet((Object) null);
        } else {
            mo175491b();
        }
    }

    /* renamed from: io.reactivex.processors.UnicastProcessor$UnicastQueueSubscription */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        public T poll() {
            return UnicastProcessor.this.f59391a.poll();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.f59391a.isEmpty();
        }

        public void clear() {
            UnicastProcessor.this.f59391a.clear();
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f59401k = true;
            return 2;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(UnicastProcessor.this.f59400j, j);
                UnicastProcessor.this.mo175491b();
            }
        }

        public void cancel() {
            if (!UnicastProcessor.this.f59397g) {
                UnicastProcessor.this.f59397g = true;
                UnicastProcessor.this.mo175488a();
                if (!UnicastProcessor.this.f59401k && UnicastProcessor.this.f59399i.getAndIncrement() == 0) {
                    UnicastProcessor.this.f59391a.clear();
                    UnicastProcessor.this.f59396f.lazySet((Object) null);
                }
            }
        }
    }

    public boolean hasSubscribers() {
        return this.f59396f.get() != null;
    }

    public Throwable getThrowable() {
        if (this.f59394d) {
            return this.f59395e;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f59394d && this.f59395e == null;
    }

    public boolean hasThrowable() {
        return this.f59394d && this.f59395e != null;
    }
}
