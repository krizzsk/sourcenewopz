package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p242io.reactivex.Flowable;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableFromPublisher */
public final class FlowableFromPublisher<T> extends Flowable<T> {

    /* renamed from: a */
    final Publisher<? extends T> f58325a;

    public FlowableFromPublisher(Publisher<? extends T> publisher) {
        this.f58325a = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f58325a.subscribe(subscriber);
    }
}
