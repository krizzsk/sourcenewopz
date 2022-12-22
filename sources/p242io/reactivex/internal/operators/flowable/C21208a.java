package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import p242io.reactivex.Flowable;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.fuseable.HasUpstreamPublisher;

/* renamed from: io.reactivex.internal.operators.flowable.a */
/* compiled from: AbstractFlowableWithUpstream */
abstract class C21208a<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {
    protected final Flowable<T> source;

    C21208a(Flowable<T> flowable) {
        this.source = (Flowable) ObjectHelper.requireNonNull(flowable, "source is null");
    }

    public final Publisher<T> source() {
        return this.source;
    }
}
