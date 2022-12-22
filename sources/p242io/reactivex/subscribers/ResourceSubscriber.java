package p242io.reactivex.subscribers;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.ListCompositeDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.subscribers.ResourceSubscriber */
public abstract class ResourceSubscriber<T> implements FlowableSubscriber<T>, Disposable {

    /* renamed from: a */
    private final AtomicReference<Subscription> f59473a = new AtomicReference<>();

    /* renamed from: b */
    private final ListCompositeDisposable f59474b = new ListCompositeDisposable();

    /* renamed from: c */
    private final AtomicLong f59475c = new AtomicLong();

    public final void add(Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "resource is null");
        this.f59474b.add(disposable);
    }

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.setOnce(this.f59473a, subscription, getClass())) {
            long andSet = this.f59475c.getAndSet(0);
            if (andSet != 0) {
                subscription.request(andSet);
            }
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        request(Long.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f59473a, this.f59475c, j);
    }

    public final void dispose() {
        if (SubscriptionHelper.cancel(this.f59473a)) {
            this.f59474b.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f59473a.get() == SubscriptionHelper.CANCELLED;
    }
}
