package p242io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.Flowable;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.BiConsumer;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import p242io.reactivex.internal.subscriptions.EmptySubscription;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableCollect */
public final class FlowableCollect<T, U> extends C21208a<T, U> {

    /* renamed from: a */
    final Callable<? extends U> f58216a;

    /* renamed from: b */
    final BiConsumer<? super U, ? super T> f58217b;

    public FlowableCollect(Flowable<T> flowable, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(flowable);
        this.f58216a = callable;
        this.f58217b = biConsumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            this.source.subscribe(new CollectSubscriber(subscriber, ObjectHelper.requireNonNull(this.f58216a.call(), "The initial value supplied is null"), this.f58217b));
        } catch (Throwable th) {
            EmptySubscription.error(th, subscriber);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCollect$CollectSubscriber */
    static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final BiConsumer<? super U, ? super T> collector;
        boolean done;

        /* renamed from: u */
        final U f58218u;
        Subscription upstream;

        CollectSubscriber(Subscriber<? super U> subscriber, U u, BiConsumer<? super U, ? super T> biConsumer) {
            super(subscriber);
            this.collector = biConsumer;
            this.f58218u = u;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.collector.accept(this.f58218u, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.cancel();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                complete(this.f58218u);
            }
        }

        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }
}
