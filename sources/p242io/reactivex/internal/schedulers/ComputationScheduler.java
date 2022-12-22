package p242io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Scheduler;
import p242io.reactivex.disposables.CompositeDisposable;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.disposables.ListCompositeDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;

/* renamed from: io.reactivex.internal.schedulers.ComputationScheduler */
public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {

    /* renamed from: b */
    static final FixedSchedulerPool f59201b;

    /* renamed from: c */
    static final RxThreadFactory f59202c;

    /* renamed from: d */
    static final String f59203d = "rx2.computation-threads";

    /* renamed from: e */
    static final int f59204e = m41859a(Runtime.getRuntime().availableProcessors(), Integer.getInteger(f59203d, 0).intValue());

    /* renamed from: f */
    static final PoolWorker f59205f;

    /* renamed from: i */
    private static final String f59206i = "RxComputationThreadPool";

    /* renamed from: j */
    private static final String f59207j = "rx2.computation-priority";

    /* renamed from: g */
    final ThreadFactory f59208g;

    /* renamed from: h */
    final AtomicReference<FixedSchedulerPool> f59209h;

    /* renamed from: a */
    static int m41859a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        f59205f = poolWorker;
        poolWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory(f59206i, Math.max(1, Math.min(10, Integer.getInteger(f59207j, 5).intValue())), true);
        f59202c = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        f59201b = fixedSchedulerPool;
        fixedSchedulerPool.shutdown();
    }

    /* renamed from: io.reactivex.internal.schedulers.ComputationScheduler$FixedSchedulerPool */
    static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {
        final int cores;
        final PoolWorker[] eventLoops;

        /* renamed from: n */
        long f59210n;

        FixedSchedulerPool(int i, ThreadFactory threadFactory) {
            this.cores = i;
            this.eventLoops = new PoolWorker[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.eventLoops[i2] = new PoolWorker(threadFactory);
            }
        }

        public PoolWorker getEventLoop() {
            int i = this.cores;
            if (i == 0) {
                return ComputationScheduler.f59205f;
            }
            PoolWorker[] poolWorkerArr = this.eventLoops;
            long j = this.f59210n;
            this.f59210n = 1 + j;
            return poolWorkerArr[(int) (j % ((long) i))];
        }

        public void shutdown() {
            for (PoolWorker dispose : this.eventLoops) {
                dispose.dispose();
            }
        }

        public void createWorkers(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i2 = this.cores;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    workerCallback.onWorker(i3, ComputationScheduler.f59205f);
                }
                return;
            }
            int i4 = ((int) this.f59210n) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                workerCallback.onWorker(i5, new EventLoopWorker(this.eventLoops[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.f59210n = (long) i4;
        }
    }

    public ComputationScheduler() {
        this(f59202c);
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f59208g = threadFactory;
        this.f59209h = new AtomicReference<>(f59201b);
        start();
    }

    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.f59209h.get().getEventLoop());
    }

    public void createWorkers(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.verifyPositive(i, "number > 0 required");
        this.f59209h.get().createWorkers(i, workerCallback);
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f59209h.get().getEventLoop().scheduleDirect(runnable, j, timeUnit);
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f59209h.get().getEventLoop().schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
    }

    public void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(f59204e, this.f59208g);
        if (!this.f59209h.compareAndSet(f59201b, fixedSchedulerPool)) {
            fixedSchedulerPool.shutdown();
        }
    }

    public void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        do {
            fixedSchedulerPool = this.f59209h.get();
            fixedSchedulerPool2 = f59201b;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
        } while (!this.f59209h.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2));
        fixedSchedulerPool.shutdown();
    }

    /* renamed from: io.reactivex.internal.schedulers.ComputationScheduler$EventLoopWorker */
    static final class EventLoopWorker extends Scheduler.Worker {
        private final ListCompositeDisposable both;
        volatile boolean disposed;
        private final PoolWorker poolWorker;
        private final ListCompositeDisposable serial = new ListCompositeDisposable();
        private final CompositeDisposable timed = new CompositeDisposable();

        EventLoopWorker(PoolWorker poolWorker2) {
            this.poolWorker = poolWorker2;
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.both = listCompositeDisposable;
            listCompositeDisposable.add(this.serial);
            this.both.add(this.timed);
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.both.dispose();
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public Disposable schedule(Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, 0, TimeUnit.MILLISECONDS, this.serial);
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, j, timeUnit, this.timed);
        }
    }

    /* renamed from: io.reactivex.internal.schedulers.ComputationScheduler$PoolWorker */
    static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
