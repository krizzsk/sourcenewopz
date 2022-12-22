package p242io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p242io.reactivex.ObservableSource;
import p242io.reactivex.Observer;
import p242io.reactivex.Scheduler;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.queue.SpscLinkedArrayQueue;

/* renamed from: io.reactivex.internal.operators.observable.ObservableTakeLastTimed */
public final class ObservableTakeLastTimed<T> extends C21211a<T, T> {

    /* renamed from: a */
    final long f58957a;

    /* renamed from: b */
    final long f58958b;

    /* renamed from: c */
    final TimeUnit f58959c;

    /* renamed from: d */
    final Scheduler f58960d;

    /* renamed from: e */
    final int f58961e;

    /* renamed from: f */
    final boolean f58962f;

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(observableSource);
        this.f58957a = j;
        this.f58958b = j2;
        this.f58959c = timeUnit;
        this.f58960d = scheduler;
        this.f58961e = i;
        this.f58962f = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeLastTimedObserver(observer, this.f58957a, this.f58958b, this.f58959c, this.f58960d, this.f58961e, this.f58962f));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableTakeLastTimed$TakeLastTimedObserver */
    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final Observer<? super T> downstream;
        Throwable error;
        final SpscLinkedArrayQueue<Object> queue;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Disposable upstream;

        TakeLastTimedObserver(Observer<? super T> observer, long j, long j2, TimeUnit timeUnit, Scheduler scheduler2, int i, boolean z) {
            this.downstream = observer;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.queue = new SpscLinkedArrayQueue<>(i);
            this.delayError = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            long now = this.scheduler.now(this.unit);
            long j = this.time;
            long j2 = this.count;
            boolean z = j2 == Long.MAX_VALUE;
            spscLinkedArrayQueue.offer(Long.valueOf(now), t);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() <= now - j || (!z && ((long) (spscLinkedArrayQueue.size() >> 1)) > j2)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }

        public void onError(Throwable th) {
            this.error = th;
            drain();
        }

        public void onComplete() {
            drain();
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                if (compareAndSet(false, true)) {
                    this.queue.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            Throwable th;
            if (compareAndSet(false, true)) {
                Observer<? super T> observer = this.downstream;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                boolean z = this.delayError;
                while (!this.cancelled) {
                    if (z || (th = this.error) == null) {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else {
                            Object poll2 = spscLinkedArrayQueue.poll();
                            if (((Long) poll).longValue() >= this.scheduler.now(this.unit) - this.time) {
                                observer.onNext(poll2);
                            }
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }
    }
}
