package p242io.reactivex.internal.operators.parallel;

import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.BiConsumer;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import p242io.reactivex.internal.subscriptions.EmptySubscription;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.parallel.ParallelFlowable;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelCollect */
public final class ParallelCollect<T, C> extends ParallelFlowable<C> {

    /* renamed from: a */
    final ParallelFlowable<? extends T> f59028a;

    /* renamed from: b */
    final Callable<? extends C> f59029b;

    /* renamed from: c */
    final BiConsumer<? super C, ? super T> f59030c;

    public ParallelCollect(ParallelFlowable<? extends T> parallelFlowable, Callable<? extends C> callable, BiConsumer<? super C, ? super T> biConsumer) {
        this.f59028a = parallelFlowable;
        this.f59029b = callable;
        this.f59030c = biConsumer;
    }

    public void subscribe(Subscriber<? super C>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            int i = 0;
            while (i < length) {
                try {
                    subscriberArr2[i] = new ParallelCollectSubscriber(subscriberArr[i], ObjectHelper.requireNonNull(this.f59029b.call(), "The initialSupplier returned a null value"), this.f59030c);
                    i++;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    mo175045a(subscriberArr, th);
                    return;
                }
            }
            this.f59028a.subscribe(subscriberArr2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175045a(Subscriber<?>[] subscriberArr, Throwable th) {
        for (Subscriber<?> error : subscriberArr) {
            EmptySubscription.error(th, error);
        }
    }

    public int parallelism() {
        return this.f59028a.parallelism();
    }

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelCollect$ParallelCollectSubscriber */
    static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        C collection;
        final BiConsumer<? super C, ? super T> collector;
        boolean done;

        ParallelCollectSubscriber(Subscriber<? super C> subscriber, C c, BiConsumer<? super C, ? super T> biConsumer) {
            super(subscriber);
            this.collection = c;
            this.collector = biConsumer;
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
                    this.collector.accept(this.collection, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
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
            this.collection = null;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                C c = this.collection;
                this.collection = null;
                complete(c);
            }
        }

        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }
    }
}
