package p242io.reactivex.processors;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.annotations.CheckReturnValue;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.processors.AsyncProcessor */
public final class AsyncProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: a */
    static final AsyncSubscription[] f59352a = new AsyncSubscription[0];

    /* renamed from: b */
    static final AsyncSubscription[] f59353b = new AsyncSubscription[0];

    /* renamed from: c */
    final AtomicReference<AsyncSubscription<T>[]> f59354c = new AtomicReference<>(f59352a);

    /* renamed from: d */
    Throwable f59355d;

    /* renamed from: e */
    T f59356e;

    @CheckReturnValue
    public static <T> AsyncProcessor<T> create() {
        return new AsyncProcessor<>();
    }

    AsyncProcessor() {
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f59354c.get() == f59353b) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f59354c.get() != f59353b) {
            this.f59356e = t;
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncSubscription<T>[] asyncSubscriptionArr = this.f59354c.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = f59353b;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f59356e = null;
        this.f59355d = th;
        for (AsyncSubscription onError : (AsyncSubscription[]) this.f59354c.getAndSet(asyncSubscriptionArr2)) {
            onError.onError(th);
        }
    }

    public void onComplete() {
        AsyncSubscription<T>[] asyncSubscriptionArr = this.f59354c.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = f59353b;
        if (asyncSubscriptionArr != asyncSubscriptionArr2) {
            T t = this.f59356e;
            AsyncSubscription[] asyncSubscriptionArr3 = (AsyncSubscription[]) this.f59354c.getAndSet(asyncSubscriptionArr2);
            int i = 0;
            if (t == null) {
                int length = asyncSubscriptionArr3.length;
                while (i < length) {
                    asyncSubscriptionArr3[i].onComplete();
                    i++;
                }
                return;
            }
            int length2 = asyncSubscriptionArr3.length;
            while (i < length2) {
                asyncSubscriptionArr3[i].complete(t);
                i++;
            }
        }
    }

    public boolean hasSubscribers() {
        return ((AsyncSubscription[]) this.f59354c.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f59354c.get() == f59353b && this.f59355d != null;
    }

    public boolean hasComplete() {
        return this.f59354c.get() == f59353b && this.f59355d == null;
    }

    public Throwable getThrowable() {
        if (this.f59354c.get() == f59353b) {
            return this.f59355d;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        AsyncSubscription asyncSubscription = new AsyncSubscription(subscriber, this);
        subscriber.onSubscribe(asyncSubscription);
        if (!mo175420a(asyncSubscription)) {
            Throwable th = this.f59355d;
            if (th != null) {
                subscriber.onError(th);
                return;
            }
            T t = this.f59356e;
            if (t != null) {
                asyncSubscription.complete(t);
            } else {
                asyncSubscription.onComplete();
            }
        } else if (asyncSubscription.isCancelled()) {
            mo175421b(asyncSubscription);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo175420a(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.f59354c.get();
            if (asyncSubscriptionArr == f59353b) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new AsyncSubscription[(length + 1)];
            System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!this.f59354c.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175421b(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.f59354c.get();
            int length = asyncSubscriptionArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (asyncSubscriptionArr[i2] == asyncSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        asyncSubscriptionArr2 = f59352a;
                    } else {
                        AsyncSubscription[] asyncSubscriptionArr3 = new AsyncSubscription[(length - 1)];
                        System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i);
                        System.arraycopy(asyncSubscriptionArr, i + 1, asyncSubscriptionArr3, i, (length - i) - 1);
                        asyncSubscriptionArr2 = asyncSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f59354c.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
    }

    public boolean hasValue() {
        return this.f59354c.get() == f59353b && this.f59356e != null;
    }

    public T getValue() {
        if (this.f59354c.get() == f59353b) {
            return this.f59356e;
        }
        return null;
    }

    @Deprecated
    public Object[] getValues() {
        Object value = getValue();
        if (value == null) {
            return new Object[0];
        }
        return new Object[]{value};
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    /* renamed from: io.reactivex.processors.AsyncProcessor$AsyncSubscription */
    static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
            this.parent = asyncProcessor;
        }

        public void cancel() {
            if (super.tryCancel()) {
                this.parent.mo175421b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (!isCancelled()) {
                this.downstream.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (isCancelled()) {
                RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }
    }
}
