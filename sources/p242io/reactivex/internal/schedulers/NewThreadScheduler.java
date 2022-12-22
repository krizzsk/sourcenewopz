package p242io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import p242io.reactivex.Scheduler;

/* renamed from: io.reactivex.internal.schedulers.NewThreadScheduler */
public final class NewThreadScheduler extends Scheduler {

    /* renamed from: c */
    private static final String f59228c = "RxNewThreadScheduler";

    /* renamed from: d */
    private static final RxThreadFactory f59229d = new RxThreadFactory(f59228c, Math.max(1, Math.min(10, Integer.getInteger(f59230e, 5).intValue())));

    /* renamed from: e */
    private static final String f59230e = "rx2.newthread-priority";

    /* renamed from: b */
    final ThreadFactory f59231b;

    public NewThreadScheduler() {
        this(f59229d);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f59231b = threadFactory;
    }

    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.f59231b);
    }
}
