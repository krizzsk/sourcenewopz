package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import p242io.reactivex.Flowable;
import p242io.reactivex.internal.subscriptions.EmptySubscription;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableNever */
public final class FlowableNever extends Flowable<Object> {
    public static final Flowable<Object> INSTANCE = new FlowableNever();

    private FlowableNever() {
    }

    public void subscribeActual(Subscriber<? super Object> subscriber) {
        subscriber.onSubscribe(EmptySubscription.INSTANCE);
    }
}
