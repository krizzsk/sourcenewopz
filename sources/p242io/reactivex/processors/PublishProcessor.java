package p242io.reactivex.processors;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.annotations.CheckReturnValue;
import p242io.reactivex.exceptions.MissingBackpressureException;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.internal.util.BackpressureHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.processors.PublishProcessor */
public final class PublishProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: a */
    static final PublishSubscription[] f59381a = new PublishSubscription[0];

    /* renamed from: b */
    static final PublishSubscription[] f59382b = new PublishSubscription[0];

    /* renamed from: c */
    final AtomicReference<PublishSubscription<T>[]> f59383c = new AtomicReference<>(f59382b);

    /* renamed from: d */
    Throwable f59384d;

    @CheckReturnValue
    public static <T> PublishProcessor<T> create() {
        return new PublishProcessor<>();
    }

    PublishProcessor() {
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        PublishSubscription publishSubscription = new PublishSubscription(subscriber, this);
        subscriber.onSubscribe(publishSubscription);
        if (!mo175456a(publishSubscription)) {
            Throwable th = this.f59384d;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        } else if (publishSubscription.isCancelled()) {
            mo175457b(publishSubscription);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo175456a(PublishSubscription<T> publishSubscription) {
        PublishSubscription[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = (PublishSubscription[]) this.f59383c.get();
            if (publishSubscriptionArr == f59381a) {
                return false;
            }
            int length = publishSubscriptionArr.length;
            publishSubscriptionArr2 = new PublishSubscription[(length + 1)];
            System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
            publishSubscriptionArr2[length] = publishSubscription;
        } while (!this.f59383c.compareAndSet(publishSubscriptionArr, publishSubscriptionArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175457b(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = (PublishSubscription[]) this.f59383c.get();
            if (publishSubscriptionArr != f59381a && publishSubscriptionArr != f59382b) {
                int length = publishSubscriptionArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (publishSubscriptionArr[i2] == publishSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        publishSubscriptionArr2 = f59382b;
                    } else {
                        PublishSubscription[] publishSubscriptionArr3 = new PublishSubscription[(length - 1)];
                        System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr3, 0, i);
                        System.arraycopy(publishSubscriptionArr, i + 1, publishSubscriptionArr3, i, (length - i) - 1);
                        publishSubscriptionArr2 = publishSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f59383c.compareAndSet(publishSubscriptionArr, publishSubscriptionArr2));
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f59383c.get() == f59381a) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishSubscription onNext : (PublishSubscription[]) this.f59383c.get()) {
            onNext.onNext(t);
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubscription<T>[] publishSubscriptionArr = this.f59383c.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = f59381a;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f59384d = th;
        for (PublishSubscription onError : (PublishSubscription[]) this.f59383c.getAndSet(publishSubscriptionArr2)) {
            onError.onError(th);
        }
    }

    public void onComplete() {
        PublishSubscription<T>[] publishSubscriptionArr = this.f59383c.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = f59381a;
        if (publishSubscriptionArr != publishSubscriptionArr2) {
            for (PublishSubscription onComplete : (PublishSubscription[]) this.f59383c.getAndSet(publishSubscriptionArr2)) {
                onComplete.onComplete();
            }
        }
    }

    public boolean offer(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        PublishSubscription[] publishSubscriptionArr = (PublishSubscription[]) this.f59383c.get();
        for (PublishSubscription isFull : publishSubscriptionArr) {
            if (isFull.isFull()) {
                return false;
            }
        }
        for (PublishSubscription onNext : publishSubscriptionArr) {
            onNext.onNext(t);
        }
        return true;
    }

    public boolean hasSubscribers() {
        return ((PublishSubscription[]) this.f59383c.get()).length != 0;
    }

    public Throwable getThrowable() {
        if (this.f59383c.get() == f59381a) {
            return this.f59384d;
        }
        return null;
    }

    public boolean hasThrowable() {
        return this.f59383c.get() == f59381a && this.f59384d != null;
    }

    public boolean hasComplete() {
        return this.f59383c.get() == f59381a && this.f59384d == null;
    }

    /* renamed from: io.reactivex.processors.PublishProcessor$PublishSubscription */
    static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 3562861878281475070L;
        final Subscriber<? super T> downstream;
        final PublishProcessor<T> parent;

        PublishSubscription(Subscriber<? super T> subscriber, PublishProcessor<T> publishProcessor) {
            this.downstream = subscriber;
            this.parent = publishProcessor;
        }

        public void onNext(T t) {
            long j = get();
            if (j != Long.MIN_VALUE) {
                if (j != 0) {
                    this.downstream.onNext(t);
                    BackpressureHelper.producedCancel(this, 1);
                    return;
                }
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.mo175457b(this);
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public boolean isFull() {
            return get() == 0;
        }
    }
}
