package p242io.reactivex.internal.operators.flowable;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.Flowable;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Function;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.fuseable.ConditionalSubscriber;
import p242io.reactivex.internal.subscriptions.EmptySubscription;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.internal.util.AtomicThrowable;
import p242io.reactivex.internal.util.HalfSerializer;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany */
public final class FlowableWithLatestFromMany<T, R> extends C21208a<T, R> {

    /* renamed from: a */
    final Publisher<?>[] f58533a;

    /* renamed from: b */
    final Iterable<? extends Publisher<?>> f58534b;

    /* renamed from: c */
    final Function<? super Object[], R> f58535c;

    public FlowableWithLatestFromMany(Flowable<T> flowable, Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        super(flowable);
        this.f58533a = publisherArr;
        this.f58534b = null;
        this.f58535c = function;
    }

    public FlowableWithLatestFromMany(Flowable<T> flowable, Iterable<? extends Publisher<?>> iterable, Function<? super Object[], R> function) {
        super(flowable);
        this.f58533a = null;
        this.f58534b = iterable;
        this.f58535c = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int i;
        Publisher<?>[] publisherArr = this.f58533a;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                i = 0;
                for (Publisher<?> publisher : this.f58534b) {
                    if (i == publisherArr.length) {
                        publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, (i >> 1) + i);
                    }
                    int i2 = i + 1;
                    publisherArr[i] = publisher;
                    i = i2;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            i = publisherArr.length;
        }
        if (i == 0) {
            new FlowableMap(this.source, new SingletonArrayFunc()).subscribeActual(subscriber);
            return;
        }
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(subscriber, this.f58535c, i);
        subscriber.onSubscribe(withLatestFromSubscriber);
        withLatestFromSubscriber.subscribe(publisherArr, i);
        this.source.subscribe(withLatestFromSubscriber);
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$WithLatestFromSubscriber */
    static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1577321883966341961L;
        final Function<? super Object[], R> combiner;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicThrowable error;
        final AtomicLong requested;
        final WithLatestInnerSubscriber[] subscribers;
        final AtomicReference<Subscription> upstream;
        final AtomicReferenceArray<Object> values;

        WithLatestFromSubscriber(Subscriber<? super R> subscriber, Function<? super Object[], R> function, int i) {
            this.downstream = subscriber;
            this.combiner = function;
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new WithLatestInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerSubscriberArr[i2] = new WithLatestInnerSubscriber(this, i2);
            }
            this.subscribers = withLatestInnerSubscriberArr;
            this.values = new AtomicReferenceArray<>(i);
            this.upstream = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void subscribe(Publisher<?>[] publisherArr, int i) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            AtomicReference<Subscription> atomicReference = this.upstream;
            for (int i2 = 0; i2 < i && atomicReference.get() != SubscriptionHelper.CANCELLED; i2++) {
                publisherArr[i2].subscribe(withLatestInnerSubscriberArr[i2]);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        public void onNext(T t) {
            if (!tryOnNext(t) && !this.done) {
                this.upstream.get().request(1);
            }
        }

        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[(length + 1)];
            objArr[0] = t;
            int i = 0;
            while (i < length) {
                Object obj = atomicReferenceArray.get(i);
                if (obj == null) {
                    return false;
                }
                i++;
                objArr[i] = obj;
            }
            try {
                HalfSerializer.onNext(this.downstream, ObjectHelper.requireNonNull(this.combiner.apply(objArr), "The combiner returned a null value"), (AtomicInteger) this, this.error);
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                onError(th);
                return false;
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            HalfSerializer.onError((Subscriber<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                cancelAllBut(-1);
                HalfSerializer.onComplete((Subscriber<?>) this.downstream, (AtomicInteger) this, this.error);
            }
        }

        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            for (WithLatestInnerSubscriber dispose : this.subscribers) {
                dispose.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public void innerNext(int i, Object obj) {
            this.values.set(i, obj);
        }

        /* access modifiers changed from: package-private */
        public void innerError(int i, Throwable th) {
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            cancelAllBut(i);
            HalfSerializer.onError((Subscriber<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        /* access modifiers changed from: package-private */
        public void innerComplete(int i, boolean z) {
            if (!z) {
                this.done = true;
                SubscriptionHelper.cancel(this.upstream);
                cancelAllBut(i);
                HalfSerializer.onComplete((Subscriber<?>) this.downstream, (AtomicInteger) this, this.error);
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAllBut(int i) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < withLatestInnerSubscriberArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerSubscriberArr[i2].dispose();
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$WithLatestInnerSubscriber */
    static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromSubscriber<?, ?> parent;

        WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i) {
            this.parent = withLatestFromSubscriber;
            this.index = i;
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        /* access modifiers changed from: package-private */
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$SingletonArrayFunc */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t) throws Exception {
            return ObjectHelper.requireNonNull(FlowableWithLatestFromMany.this.f58535c.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }
}
