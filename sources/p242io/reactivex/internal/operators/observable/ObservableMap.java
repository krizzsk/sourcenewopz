package p242io.reactivex.internal.operators.observable;

import p242io.reactivex.ObservableSource;
import p242io.reactivex.Observer;
import p242io.reactivex.functions.Function;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.observers.BasicFuseableObserver;

/* renamed from: io.reactivex.internal.operators.observable.ObservableMap */
public final class ObservableMap<T, U> extends C21211a<T, U> {

    /* renamed from: a */
    final Function<? super T, ? extends U> f58868a;

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.f58868a = function;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new MapObserver(observer, this.f58868a));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableMap$MapObserver */
    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        final Function<? super T, ? extends U> mapper;

        MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.mapper = function;
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.downstream.onNext(null);
                    return;
                }
                try {
                    this.downstream.onNext(ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        public U poll() throws Exception {
            Object poll = this.f58052qd.poll();
            if (poll != null) {
                return ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
