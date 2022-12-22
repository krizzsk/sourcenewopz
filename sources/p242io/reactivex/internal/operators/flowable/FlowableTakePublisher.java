package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p242io.reactivex.Flowable;
import p242io.reactivex.internal.operators.flowable.FlowableTake;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableTakePublisher */
public final class FlowableTakePublisher<T> extends Flowable<T> {

    /* renamed from: a */
    final Publisher<T> f58478a;

    /* renamed from: b */
    final long f58479b;

    public FlowableTakePublisher(Publisher<T> publisher, long j) {
        this.f58478a = publisher;
        this.f58479b = j;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f58478a.subscribe(new FlowableTake.TakeSubscriber(subscriber, this.f58479b));
    }
}
