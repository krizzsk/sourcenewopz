package p242io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.Flowable;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.internal.util.BackpressureHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableCache */
public final class FlowableCache<T> extends C21208a<T, T> implements FlowableSubscriber<T> {

    /* renamed from: d */
    static final CacheSubscription[] f58205d = new CacheSubscription[0];

    /* renamed from: e */
    static final CacheSubscription[] f58206e = new CacheSubscription[0];

    /* renamed from: a */
    final AtomicBoolean f58207a = new AtomicBoolean();

    /* renamed from: b */
    final int f58208b;

    /* renamed from: c */
    final AtomicReference<CacheSubscription<T>[]> f58209c;

    /* renamed from: f */
    volatile long f58210f;

    /* renamed from: g */
    final Node<T> f58211g;

    /* renamed from: h */
    Node<T> f58212h;

    /* renamed from: i */
    int f58213i;

    /* renamed from: j */
    Throwable f58214j;

    /* renamed from: k */
    volatile boolean f58215k;

    public FlowableCache(Flowable<T> flowable, int i) {
        super(flowable);
        this.f58208b = i;
        Node<T> node = new Node<>(i);
        this.f58211g = node;
        this.f58212h = node;
        this.f58209c = new AtomicReference<>(f58205d);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        CacheSubscription cacheSubscription = new CacheSubscription(subscriber, this);
        subscriber.onSubscribe(cacheSubscription);
        mo174340a(cacheSubscription);
        if (this.f58207a.get() || !this.f58207a.compareAndSet(false, true)) {
            mo174345c(cacheSubscription);
        } else {
            this.source.subscribe(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo174341a() {
        return this.f58207a.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo174343b() {
        return ((CacheSubscription[]) this.f58209c.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo174344c() {
        return this.f58210f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo174340a(CacheSubscription<T> cacheSubscription) {
        CacheSubscription[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.f58209c.get();
            if (cacheSubscriptionArr != f58206e) {
                int length = cacheSubscriptionArr.length;
                cacheSubscriptionArr2 = new CacheSubscription[(length + 1)];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
                cacheSubscriptionArr2[length] = cacheSubscription;
            } else {
                return;
            }
        } while (!this.f58209c.compareAndSet(cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo174342b(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.f58209c.get();
            int length = cacheSubscriptionArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (cacheSubscriptionArr[i2] == cacheSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        cacheSubscriptionArr2 = f58205d;
                    } else {
                        CacheSubscription[] cacheSubscriptionArr3 = new CacheSubscription[(length - 1)];
                        System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i);
                        System.arraycopy(cacheSubscriptionArr, i + 1, cacheSubscriptionArr3, i, (length - i) - 1);
                        cacheSubscriptionArr2 = cacheSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f58209c.compareAndSet(cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo174345c(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T> cacheSubscription2 = cacheSubscription;
        if (cacheSubscription.getAndIncrement() == 0) {
            long j = cacheSubscription2.index;
            int i = cacheSubscription2.offset;
            Node<T> node = cacheSubscription2.node;
            AtomicLong atomicLong = cacheSubscription2.requested;
            Subscriber<? super T> subscriber = cacheSubscription2.downstream;
            int i2 = this.f58208b;
            int i3 = 1;
            while (true) {
                boolean z = this.f58215k;
                boolean z2 = this.f58210f == j;
                if (!z || !z2) {
                    if (!z2) {
                        long j2 = atomicLong.get();
                        if (j2 == Long.MIN_VALUE) {
                            cacheSubscription2.node = null;
                            return;
                        } else if (j2 != j) {
                            if (i == i2) {
                                node = node.next;
                                i = 0;
                            }
                            subscriber.onNext(node.values[i]);
                            i++;
                            j++;
                        }
                    }
                    cacheSubscription2.index = j;
                    cacheSubscription2.offset = i;
                    cacheSubscription2.node = node;
                    i3 = cacheSubscription2.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                } else {
                    cacheSubscription2.node = null;
                    Throwable th = this.f58214j;
                    if (th != null) {
                        subscriber.onError(th);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    public void onNext(T t) {
        int i = this.f58213i;
        if (i == this.f58208b) {
            Node<T> node = new Node<>(i);
            node.values[0] = t;
            this.f58213i = 1;
            this.f58212h.next = node;
            this.f58212h = node;
        } else {
            this.f58212h.values[i] = t;
            this.f58213i = i + 1;
        }
        this.f58210f++;
        for (CacheSubscription c : (CacheSubscription[]) this.f58209c.get()) {
            mo174345c(c);
        }
    }

    public void onError(Throwable th) {
        if (this.f58215k) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f58214j = th;
        this.f58215k = true;
        for (CacheSubscription c : (CacheSubscription[]) this.f58209c.getAndSet(f58206e)) {
            mo174345c(c);
        }
    }

    public void onComplete() {
        this.f58215k = true;
        for (CacheSubscription c : (CacheSubscription[]) this.f58209c.getAndSet(f58206e)) {
            mo174345c(c);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCache$CacheSubscription */
    static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;
        final Subscriber<? super T> downstream;
        long index;
        Node<T> node;
        int offset;
        final FlowableCache<T> parent;
        final AtomicLong requested = new AtomicLong();

        CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
            this.downstream = subscriber;
            this.parent = flowableCache;
            this.node = flowableCache.f58211g;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this.requested, j);
                this.parent.mo174345c(this);
            }
        }

        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.mo174342b(this);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCache$Node */
    static final class Node<T> {
        volatile Node<T> next;
        final T[] values;

        Node(int i) {
            this.values = (Object[]) new Object[i];
        }
    }
}
