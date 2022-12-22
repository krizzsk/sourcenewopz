package p242io.reactivex.subscribers;

import com.didi.travel.p171v2.store.IStoreCallback;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.functions.Consumer;
import p242io.reactivex.internal.fuseable.QueueSubscription;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.internal.util.ExceptionHelper;
import p242io.reactivex.observers.BaseTestConsumer;

/* renamed from: io.reactivex.subscribers.TestSubscriber */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Disposable, Subscription {

    /* renamed from: a */
    private final Subscriber<? super T> f59486a;

    /* renamed from: b */
    private volatile boolean f59487b;

    /* renamed from: c */
    private final AtomicReference<Subscription> f59488c;

    /* renamed from: d */
    private final AtomicLong f59489d;

    /* renamed from: e */
    private QueueSubscription<T> f59490e;

    /* renamed from: io.reactivex.subscribers.TestSubscriber$EmptySubscriber */
    enum EmptySubscriber implements FlowableSubscriber<Object> {
        INSTANCE;

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        public void onNext(Object obj) {
        }

        public void onSubscribe(Subscription subscription) {
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<>();
    }

    public static <T> TestSubscriber<T> create(long j) {
        return new TestSubscriber<>(j);
    }

    public static <T> TestSubscriber<T> create(Subscriber<? super T> subscriber) {
        return new TestSubscriber<>(subscriber);
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    public TestSubscriber(long j) {
        this(EmptySubscriber.INSTANCE, j);
    }

    public TestSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, Long.MAX_VALUE);
    }

    public TestSubscriber(Subscriber<? super T> subscriber, long j) {
        if (j >= 0) {
            this.f59486a = subscriber;
            this.f59488c = new AtomicReference<>();
            this.f59489d = new AtomicLong(j);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }

    public void onSubscribe(Subscription subscription) {
        this.lastThread = Thread.currentThread();
        if (subscription == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f59488c.compareAndSet((Object) null, subscription)) {
            subscription.cancel();
            if (this.f59488c.get() != SubscriptionHelper.CANCELLED) {
                this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
            }
        } else {
            if (this.initialFusionMode != 0 && (subscription instanceof QueueSubscription)) {
                QueueSubscription<T> queueSubscription = (QueueSubscription) subscription;
                this.f59490e = queueSubscription;
                int requestFusion = queueSubscription.requestFusion(this.initialFusionMode);
                this.establishedFusionMode = requestFusion;
                if (requestFusion == 1) {
                    this.checkSubscriptionOnce = true;
                    this.lastThread = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.f59490e.poll();
                            if (poll != null) {
                                this.values.add(poll);
                            } else {
                                this.completions++;
                                return;
                            }
                        } catch (Throwable th) {
                            this.errors.add(th);
                            return;
                        }
                    }
                }
            }
            this.f59486a.onSubscribe(subscription);
            long andSet = this.f59489d.getAndSet(0);
            if (andSet != 0) {
                subscription.request(andSet);
            }
            onStart();
        }
    }

    public void onNext(T t) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f59488c.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = Thread.currentThread();
        if (this.establishedFusionMode == 2) {
            while (true) {
                try {
                    T poll = this.f59490e.poll();
                    if (poll != null) {
                        this.values.add(poll);
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    this.errors.add(th);
                    this.f59490e.cancel();
                    return;
                }
            }
        } else {
            this.values.add(t);
            if (t == null) {
                this.errors.add(new NullPointerException("onNext received a null value"));
            }
            this.f59486a.onNext(t);
        }
    }

    public void onError(Throwable th) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f59488c.get() == null) {
                this.errors.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            this.errors.add(th);
            if (th == null) {
                this.errors.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.f59486a.onError(th);
        } finally {
            this.done.countDown();
        }
    }

    public void onComplete() {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.f59488c.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            this.completions++;
            this.f59486a.onComplete();
        } finally {
            this.done.countDown();
        }
    }

    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f59488c, this.f59489d, j);
    }

    public final void cancel() {
        if (!this.f59487b) {
            this.f59487b = true;
            SubscriptionHelper.cancel(this.f59488c);
        }
    }

    public final boolean isCancelled() {
        return this.f59487b;
    }

    public final void dispose() {
        cancel();
    }

    public final boolean isDisposed() {
        return this.f59487b;
    }

    public final boolean hasSubscription() {
        return this.f59488c.get() != null;
    }

    public final TestSubscriber<T> assertSubscribed() {
        if (this.f59488c.get() != null) {
            return this;
        }
        throw fail("Not subscribed!");
    }

    public final TestSubscriber<T> assertNotSubscribed() {
        if (this.f59488c.get() != null) {
            throw fail("Subscribed!");
        } else if (this.errors.isEmpty()) {
            return this;
        } else {
            throw fail("Not subscribed but errors found");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final TestSubscriber<T> mo175610a(int i) {
        this.initialFusionMode = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final TestSubscriber<T> mo175613b(int i) {
        int i2 = this.establishedFusionMode;
        if (i2 == i) {
            return this;
        }
        if (this.f59490e != null) {
            throw new AssertionError("Fusion mode different. Expected: " + m41947c(i) + ", actual: " + m41947c(i2));
        }
        throw fail("Upstream is not fuseable");
    }

    /* renamed from: c */
    static String m41947c(int i) {
        if (i == 0) {
            return IStoreCallback.DEFAULT_API_DETAIL_KEY;
        }
        if (i == 1) {
            return "SYNC";
        }
        if (i == 2) {
            return "ASYNC";
        }
        return "Unknown(" + i + ")";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final TestSubscriber<T> mo175609a() {
        if (this.f59490e != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final TestSubscriber<T> mo175612b() {
        if (this.f59490e == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    public final TestSubscriber<T> assertOf(Consumer<? super TestSubscriber<T>> consumer) {
        try {
            consumer.accept(this);
            return this;
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public final TestSubscriber<T> requestMore(long j) {
        request(j);
        return this;
    }
}
