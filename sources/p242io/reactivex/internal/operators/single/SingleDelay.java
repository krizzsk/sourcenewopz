package p242io.reactivex.internal.operators.single;

import java.util.concurrent.TimeUnit;
import p242io.reactivex.Scheduler;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.SingleSource;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.SequentialDisposable;

/* renamed from: io.reactivex.internal.operators.single.SingleDelay */
public final class SingleDelay<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<? extends T> f59095a;

    /* renamed from: b */
    final long f59096b;

    /* renamed from: c */
    final TimeUnit f59097c;

    /* renamed from: d */
    final Scheduler f59098d;

    /* renamed from: e */
    final boolean f59099e;

    public SingleDelay(SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f59095a = singleSource;
        this.f59096b = j;
        this.f59097c = timeUnit;
        this.f59098d = scheduler;
        this.f59099e = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.f59095a.subscribe(new Delay(sequentialDisposable, singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDelay$Delay */
    final class Delay implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;

        /* renamed from: sd */
        private final SequentialDisposable f59100sd;

        Delay(SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.f59100sd = sequentialDisposable;
            this.downstream = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f59100sd.replace(disposable);
        }

        public void onSuccess(T t) {
            this.f59100sd.replace(SingleDelay.this.f59098d.scheduleDirect(new OnSuccess(t), SingleDelay.this.f59096b, SingleDelay.this.f59097c));
        }

        public void onError(Throwable th) {
            this.f59100sd.replace(SingleDelay.this.f59098d.scheduleDirect(new OnError(th), SingleDelay.this.f59099e ? SingleDelay.this.f59096b : 0, SingleDelay.this.f59097c));
        }

        /* renamed from: io.reactivex.internal.operators.single.SingleDelay$Delay$OnSuccess */
        final class OnSuccess implements Runnable {
            private final T value;

            OnSuccess(T t) {
                this.value = t;
            }

            public void run() {
                Delay.this.downstream.onSuccess(this.value);
            }
        }

        /* renamed from: io.reactivex.internal.operators.single.SingleDelay$Delay$OnError */
        final class OnError implements Runnable {

            /* renamed from: e */
            private final Throwable f59101e;

            OnError(Throwable th) {
                this.f59101e = th;
            }

            public void run() {
                Delay.this.downstream.onError(this.f59101e);
            }
        }
    }
}
