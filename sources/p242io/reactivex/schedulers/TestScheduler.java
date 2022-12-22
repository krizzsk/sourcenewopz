package p242io.reactivex.schedulers;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import p242io.reactivex.Scheduler;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.disposables.Disposables;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.schedulers.TestScheduler */
public final class TestScheduler extends Scheduler {

    /* renamed from: b */
    final Queue<TimedRunnable> f59411b = new PriorityBlockingQueue(11);

    /* renamed from: c */
    long f59412c;

    /* renamed from: d */
    volatile long f59413d;

    public TestScheduler() {
    }

    public TestScheduler(long j, TimeUnit timeUnit) {
        this.f59413d = timeUnit.toNanos(j);
    }

    /* renamed from: io.reactivex.schedulers.TestScheduler$TimedRunnable */
    static final class TimedRunnable implements Comparable<TimedRunnable> {
        final long count;
        final Runnable run;
        final TestWorker scheduler;
        final long time;

        TimedRunnable(TestWorker testWorker, long j, Runnable runnable, long j2) {
            this.time = j;
            this.run = runnable;
            this.scheduler = testWorker;
            this.count = j2;
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", new Object[]{Long.valueOf(this.time), this.run.toString()});
        }

        public int compareTo(TimedRunnable timedRunnable) {
            long j = this.time;
            long j2 = timedRunnable.time;
            if (j == j2) {
                return ObjectHelper.compare(this.count, timedRunnable.count);
            }
            return ObjectHelper.compare(j, j2);
        }
    }

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(this.f59413d, TimeUnit.NANOSECONDS);
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.f59413d + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        m41912a(timeUnit.toNanos(j));
    }

    public void triggerActions() {
        m41912a(this.f59413d);
    }

    /* renamed from: a */
    private void m41912a(long j) {
        while (true) {
            TimedRunnable peek = this.f59411b.peek();
            if (peek == null || peek.time > j) {
                this.f59413d = j;
            } else {
                this.f59413d = peek.time == 0 ? this.f59413d : peek.time;
                this.f59411b.remove(peek);
                if (!peek.scheduler.disposed) {
                    peek.run.run();
                }
            }
        }
        this.f59413d = j;
    }

    public Scheduler.Worker createWorker() {
        return new TestWorker();
    }

    /* renamed from: io.reactivex.schedulers.TestScheduler$TestWorker */
    final class TestWorker extends Scheduler.Worker {
        volatile boolean disposed;

        TestWorker() {
        }

        public void dispose() {
            this.disposed = true;
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = TestScheduler.this.f59413d + timeUnit.toNanos(j);
            TestScheduler testScheduler = TestScheduler.this;
            long j2 = testScheduler.f59412c;
            testScheduler.f59412c = 1 + j2;
            TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j2);
            TestScheduler.this.f59411b.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }

        public Disposable schedule(Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j = testScheduler.f59412c;
            testScheduler.f59412c = 1 + j;
            TimedRunnable timedRunnable = new TimedRunnable(this, 0, runnable, j);
            TestScheduler.this.f59411b.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }

        public long now(TimeUnit timeUnit) {
            return TestScheduler.this.now(timeUnit);
        }

        /* renamed from: io.reactivex.schedulers.TestScheduler$TestWorker$QueueRemove */
        final class QueueRemove implements Runnable {
            final TimedRunnable timedAction;

            QueueRemove(TimedRunnable timedRunnable) {
                this.timedAction = timedRunnable;
            }

            public void run() {
                TestScheduler.this.f59411b.remove(this.timedAction);
            }
        }
    }
}
