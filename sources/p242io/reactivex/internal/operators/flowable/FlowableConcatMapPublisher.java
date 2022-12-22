package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p242io.reactivex.Flowable;
import p242io.reactivex.functions.Function;
import p242io.reactivex.internal.util.ErrorMode;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher */
public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: a */
    final Publisher<T> f58242a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends R>> f58243b;

    /* renamed from: c */
    final int f58244c;

    /* renamed from: d */
    final ErrorMode f58245d;

    public FlowableConcatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.f58242a = publisher;
        this.f58243b = function;
        this.f58244c = i;
        this.f58245d = errorMode;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f58242a, subscriber, this.f58243b)) {
            this.f58242a.subscribe(FlowableConcatMap.subscribe(subscriber, this.f58243b, this.f58244c, this.f58245d));
        }
    }
}
