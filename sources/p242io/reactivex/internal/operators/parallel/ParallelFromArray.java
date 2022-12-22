package p242io.reactivex.internal.operators.parallel;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p242io.reactivex.parallel.ParallelFlowable;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelFromArray */
public final class ParallelFromArray<T> extends ParallelFlowable<T> {

    /* renamed from: a */
    final Publisher<T>[] f59048a;

    public ParallelFromArray(Publisher<T>[] publisherArr) {
        this.f59048a = publisherArr;
    }

    public int parallelism() {
        return this.f59048a.length;
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            for (int i = 0; i < length; i++) {
                this.f59048a[i].subscribe(subscriberArr[i]);
            }
        }
    }
}
