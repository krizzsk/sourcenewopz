package p242io.reactivex.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Scheduler;
import p242io.reactivex.disposables.CompositeDisposable;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.schedulers.SingleScheduler */
public final class SingleScheduler extends Scheduler {

    /* renamed from: d */
    static final RxThreadFactory f59241d = new RxThreadFactory(f59244g, Math.max(1, Math.min(10, Integer.getInteger(f59243f, 5).intValue())), true);

    /* renamed from: e */
    static final ScheduledExecutorService f59242e;

    /* renamed from: f */
    private static final String f59243f = "rx2.single-priority";

    /* renamed from: g */
    private static final String f59244g = "RxSingleScheduler";

    /* renamed from: b */
    final ThreadFactory f59245b;

    /* renamed from: c */
    final AtomicReference<ScheduledExecutorService> f59246c;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f59242e = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public SingleScheduler() {
        this(f59241d);
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f59246c = atomicReference;
        this.f59245b = threadFactory;
        atomicReference.lazySet(m41862a(threadFactory));
    }

    /* renamed from: a */
    static ScheduledExecutorService m41862a(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.create(threadFactory);
    }

    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.f59246c.get();
            if (scheduledExecutorService != f59242e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = m41862a(this.f59245b);
            }
        } while (!this.f59246c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    public void shutdown() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.f59246c.get();
        ScheduledExecutorService scheduledExecutorService2 = f59242e;
        if (scheduledExecutorService != scheduledExecutorService2 && (andSet = this.f59246c.getAndSet(scheduledExecutorService2)) != f59242e) {
            andSet.shutdownNow();
        }
    }

    public Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.f59246c.get());
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable));
        if (j <= 0) {
            try {
                future = this.f59246c.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f59246c.get().schedule(scheduledDirectTask, j, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f59246c.get();
            C21216b bVar = new C21216b(onSchedule, scheduledExecutorService);
            if (j <= 0) {
                try {
                    future = scheduledExecutorService.submit(bVar);
                } catch (RejectedExecutionException e) {
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(bVar, j, timeUnit);
            }
            bVar.mo175175a(future);
            return bVar;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(onSchedule);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f59246c.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* renamed from: io.reactivex.internal.schedulers.SingleScheduler$ScheduledWorker */
    static final class ScheduledWorker extends Scheduler.Worker {
        volatile boolean disposed;
        final ScheduledExecutorService executor;
        final CompositeDisposable tasks = new CompositeDisposable();

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Future future;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), this.tasks);
            this.tasks.add(scheduledRunnable);
            if (j <= 0) {
                try {
                    future = this.executor.submit(scheduledRunnable);
                } catch (RejectedExecutionException e) {
                    dispose();
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.executor.schedule(scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(future);
            return scheduledRunnable;
        }

        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.tasks.dispose();
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }
}
