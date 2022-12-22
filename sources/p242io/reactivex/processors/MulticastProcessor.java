package p242io.reactivex.processors;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.annotations.BackpressureKind;
import p242io.reactivex.annotations.BackpressureSupport;
import p242io.reactivex.annotations.CheckReturnValue;
import p242io.reactivex.annotations.SchedulerSupport;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.exceptions.MissingBackpressureException;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.fuseable.QueueSubscription;
import p242io.reactivex.internal.fuseable.SimpleQueue;
import p242io.reactivex.internal.queue.SpscArrayQueue;
import p242io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p242io.reactivex.internal.subscriptions.EmptySubscription;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

@BackpressureSupport(BackpressureKind.FULL)
@SchedulerSupport("none")
/* renamed from: io.reactivex.processors.MulticastProcessor */
public final class MulticastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: m */
    static final MulticastSubscription[] f59367m = new MulticastSubscription[0];

    /* renamed from: n */
    static final MulticastSubscription[] f59368n = new MulticastSubscription[0];

    /* renamed from: a */
    final AtomicInteger f59369a = new AtomicInteger();

    /* renamed from: b */
    final AtomicReference<Subscription> f59370b = new AtomicReference<>();

    /* renamed from: c */
    final AtomicReference<MulticastSubscription<T>[]> f59371c = new AtomicReference<>(f59367m);

    /* renamed from: d */
    final AtomicBoolean f59372d;

    /* renamed from: e */
    final int f59373e;

    /* renamed from: f */
    final int f59374f;

    /* renamed from: g */
    final boolean f59375g;

    /* renamed from: h */
    volatile SimpleQueue<T> f59376h;

    /* renamed from: i */
    volatile boolean f59377i;

    /* renamed from: j */
    volatile Throwable f59378j;

    /* renamed from: k */
    int f59379k;

    /* renamed from: l */
    int f59380l;

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(bufferSize(), false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(boolean z) {
        return new MulticastProcessor<>(bufferSize(), z);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int i) {
        return new MulticastProcessor<>(i, false);
    }

    @CheckReturnValue
    public static <T> MulticastProcessor<T> create(int i, boolean z) {
        return new MulticastProcessor<>(i, z);
    }

    MulticastProcessor(int i, boolean z) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        this.f59373e = i;
        this.f59374f = i - (i >> 2);
        this.f59375g = z;
        this.f59372d = new AtomicBoolean();
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.f59370b, EmptySubscription.INSTANCE)) {
            this.f59376h = new SpscArrayQueue(this.f59373e);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.f59370b, EmptySubscription.INSTANCE)) {
            this.f59376h = new SpscLinkedArrayQueue(this.f59373e);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f59370b, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f59380l = requestFusion;
                    this.f59376h = queueSubscription;
                    this.f59377i = true;
                    mo175447a();
                    return;
                } else if (requestFusion == 2) {
                    this.f59380l = requestFusion;
                    this.f59376h = queueSubscription;
                    subscription.request((long) this.f59373e);
                    return;
                }
            }
            this.f59376h = new SpscArrayQueue(this.f59373e);
            subscription.request((long) this.f59373e);
        }
    }

    public void onNext(T t) {
        if (!this.f59372d.get()) {
            if (this.f59380l == 0) {
                ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                if (!this.f59376h.offer(t)) {
                    SubscriptionHelper.cancel(this.f59370b);
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            mo175447a();
        }
    }

    public boolean offer(T t) {
        if (this.f59372d.get()) {
            return false;
        }
        ObjectHelper.requireNonNull(t, "offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f59380l != 0 || !this.f59376h.offer(t)) {
            return false;
        }
        mo175447a();
        return true;
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f59372d.compareAndSet(false, true)) {
            this.f59378j = th;
            this.f59377i = true;
            mo175447a();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public void onComplete() {
        if (this.f59372d.compareAndSet(false, true)) {
            this.f59377i = true;
            mo175447a();
        }
    }

    public boolean hasSubscribers() {
        return ((MulticastSubscription[]) this.f59371c.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f59372d.get() && this.f59378j != null;
    }

    public boolean hasComplete() {
        return this.f59372d.get() && this.f59378j == null;
    }

    public Throwable getThrowable() {
        if (this.f59372d.get()) {
            return this.f59378j;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Throwable th;
        MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
        subscriber.onSubscribe(multicastSubscription);
        if (mo175448a(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                mo175449b(multicastSubscription);
            } else {
                mo175447a();
            }
        } else if ((this.f59372d.get() || !this.f59375g) && (th = this.f59378j) != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo175448a(MulticastSubscription<T> multicastSubscription) {
        MulticastSubscription[] multicastSubscriptionArr;
        MulticastSubscription[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = (MulticastSubscription[]) this.f59371c.get();
            if (multicastSubscriptionArr == f59368n) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!this.f59371c.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175449b(MulticastSubscription<T> multicastSubscription) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = (MulticastSubscription[]) this.f59371c.get();
            int length = multicastSubscriptionArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (multicastSubscriptionArr[i2] == multicastSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length != 1) {
                        MulticastSubscription[] multicastSubscriptionArr2 = new MulticastSubscription[(length - 1)];
                        System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i);
                        System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr2, i, (length - i) - 1);
                        if (this.f59371c.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2)) {
                            return;
                        }
                    } else if (this.f59375g) {
                        if (this.f59371c.compareAndSet(multicastSubscriptionArr, f59368n)) {
                            SubscriptionHelper.cancel(this.f59370b);
                            this.f59372d.set(true);
                            return;
                        }
                    } else if (this.f59371c.compareAndSet(multicastSubscriptionArr, f59367m)) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175447a() {
        int i;
        T t;
        if (this.f59369a.getAndIncrement() == 0) {
            AtomicReference<MulticastSubscription<T>[]> atomicReference = this.f59371c;
            int i2 = this.f59379k;
            int i3 = this.f59374f;
            int i4 = this.f59380l;
            int i5 = 1;
            while (true) {
                SimpleQueue<T> simpleQueue = this.f59376h;
                if (simpleQueue != null) {
                    MulticastSubscription[] multicastSubscriptionArr = (MulticastSubscription[]) atomicReference.get();
                    if (multicastSubscriptionArr.length != 0) {
                        int length = multicastSubscriptionArr.length;
                        long j = -1;
                        long j2 = -1;
                        int i6 = 0;
                        while (i6 < length) {
                            MulticastSubscription multicastSubscription = multicastSubscriptionArr[i6];
                            long j3 = multicastSubscription.get();
                            if (j3 >= 0) {
                                if (j2 == j) {
                                    j2 = j3 - multicastSubscription.emitted;
                                } else {
                                    j2 = Math.min(j2, j3 - multicastSubscription.emitted);
                                }
                            }
                            i6++;
                            j = -1;
                        }
                        int i7 = i2;
                        while (true) {
                            i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                            if (i <= 0) {
                                break;
                            }
                            MulticastSubscription[] multicastSubscriptionArr2 = (MulticastSubscription[]) atomicReference.get();
                            if (multicastSubscriptionArr2 == f59368n) {
                                simpleQueue.clear();
                                return;
                            } else if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                                break;
                            } else {
                                boolean z = this.f59377i;
                                try {
                                    t = simpleQueue.poll();
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Exceptions.throwIfFatal(th2);
                                    SubscriptionHelper.cancel(this.f59370b);
                                    this.f59378j = th2;
                                    this.f59377i = true;
                                    t = null;
                                    z = true;
                                }
                                boolean z2 = t == null;
                                if (z && z2) {
                                    Throwable th3 = this.f59378j;
                                    if (th3 != null) {
                                        for (MulticastSubscription onError : (MulticastSubscription[]) atomicReference.getAndSet(f59368n)) {
                                            onError.onError(th3);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription onComplete : (MulticastSubscription[]) atomicReference.getAndSet(f59368n)) {
                                        onComplete.onComplete();
                                    }
                                    return;
                                } else if (z2) {
                                    break;
                                } else {
                                    for (MulticastSubscription onNext : multicastSubscriptionArr) {
                                        onNext.onNext(t);
                                    }
                                    j2--;
                                    if (i4 != 1 && (i7 = i7 + 1) == i3) {
                                        this.f59370b.get().request((long) i3);
                                        i7 = 0;
                                    }
                                }
                            }
                        }
                        if (i == 0) {
                            MulticastSubscription[] multicastSubscriptionArr3 = (MulticastSubscription[]) atomicReference.get();
                            if (multicastSubscriptionArr3 == f59368n) {
                                simpleQueue.clear();
                                return;
                            }
                            if (multicastSubscriptionArr == multicastSubscriptionArr3) {
                                if (this.f59377i && simpleQueue.isEmpty()) {
                                    Throwable th4 = this.f59378j;
                                    if (th4 != null) {
                                        for (MulticastSubscription onError2 : (MulticastSubscription[]) atomicReference.getAndSet(f59368n)) {
                                            onError2.onError(th4);
                                        }
                                        return;
                                    }
                                    for (MulticastSubscription onComplete2 : (MulticastSubscription[]) atomicReference.getAndSet(f59368n)) {
                                        onComplete2.onComplete();
                                    }
                                    return;
                                }
                            }
                            i2 = i7;
                        }
                        i2 = i7;
                    }
                }
                i5 = this.f59369a.addAndGet(-i5);
                if (i5 == 0) {
                    return;
                }
            }
        }
    }

    /* renamed from: io.reactivex.processors.MulticastProcessor$MulticastSubscription */
    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final Subscriber<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.downstream = subscriber;
            this.parent = multicastProcessor;
        }

        public void request(long j) {
            long j2;
            long j3;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        j3 = Long.MAX_VALUE;
                        if (j2 != Long.MAX_VALUE) {
                            long j4 = j2 + j;
                            if (j4 >= 0) {
                                j3 = j4;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                this.parent.mo175447a();
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.mo175449b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void onNext(T t) {
            if (get() != Long.MIN_VALUE) {
                this.emitted++;
                this.downstream.onNext(t);
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }
    }
}
