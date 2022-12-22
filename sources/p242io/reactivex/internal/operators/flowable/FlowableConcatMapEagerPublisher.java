package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p242io.reactivex.Flowable;
import p242io.reactivex.functions.Function;
import p242io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import p242io.reactivex.internal.util.ErrorMode;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMapEagerPublisher */
public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {

    /* renamed from: a */
    final Publisher<T> f58237a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends R>> f58238b;

    /* renamed from: c */
    final int f58239c;

    /* renamed from: d */
    final int f58240d;

    /* renamed from: e */
    final ErrorMode f58241e;

    public FlowableConcatMapEagerPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
        this.f58237a = publisher;
        this.f58238b = function;
        this.f58239c = i;
        this.f58240d = i2;
        this.f58241e = errorMode;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f58237a.subscribe(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.f58238b, this.f58239c, this.f58240d, this.f58241e));
    }
}
