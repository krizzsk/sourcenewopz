package p242io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.Flowable;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.internal.util.AtomicThrowable;
import p242io.reactivex.internal.util.HalfSerializer;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableTakeUntil */
public final class FlowableTakeUntil<T, U> extends C21208a<T, T> {

    /* renamed from: a */
    final Publisher<? extends U> f58480a;

    public FlowableTakeUntil(Flowable<T> flowable, Publisher<? extends U> publisher) {
        super(flowable);
        this.f58480a = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(subscriber);
        subscriber.onSubscribe(takeUntilMainSubscriber);
        this.f58480a.subscribe(takeUntilMainSubscriber.other);
        this.source.subscribe(takeUntilMainSubscriber);
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableTakeUntil$TakeUntilMainSubscriber */
    static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4945480365982832967L;
        final Subscriber<? super T> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final TakeUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        TakeUntilMainSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        public void onNext(T t) {
            HalfSerializer.onNext(this.downstream, t, (AtomicInteger) this, this.error);
        }

        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            HalfSerializer.onError((Subscriber<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            HalfSerializer.onComplete((Subscriber<?>) this.downstream, (AtomicInteger) this, this.error);
        }

        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber */
        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            OtherSubscriber() {
            }

            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }

            public void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                onComplete();
            }

            public void onError(Throwable th) {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.upstream);
                Subscriber<? super T> subscriber = TakeUntilMainSubscriber.this.downstream;
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                HalfSerializer.onError((Subscriber<?>) subscriber, th, (AtomicInteger) takeUntilMainSubscriber, takeUntilMainSubscriber.error);
            }

            public void onComplete() {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.upstream);
                Subscriber<? super T> subscriber = TakeUntilMainSubscriber.this.downstream;
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                HalfSerializer.onComplete((Subscriber<?>) subscriber, (AtomicInteger) takeUntilMainSubscriber, takeUntilMainSubscriber.error);
            }
        }
    }
}
