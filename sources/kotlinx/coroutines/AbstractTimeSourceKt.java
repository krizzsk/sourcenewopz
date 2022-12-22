package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0006\u001a\u00020\u0007H\b\u001a\t\u0010\b\u001a\u00020\u0007H\b\u001a\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\b\u001a\t\u0010\u000e\u001a\u00020\nH\b\u001a\t\u0010\u000f\u001a\u00020\nH\b\u001a\t\u0010\u0010\u001a\u00020\nH\b\u001a\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\b\u001a\t\u0010\u0014\u001a\u00020\nH\b\u001a\u0019\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017H\b\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\u0019"}, mo175978d2 = {"timeSource", "Lkotlinx/coroutines/AbstractTimeSource;", "getTimeSource", "()Lkotlinx/coroutines/AbstractTimeSource;", "setTimeSource", "(Lkotlinx/coroutines/AbstractTimeSource;)V", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AbstractTimeSource.kt */
public final class AbstractTimeSourceKt {

    /* renamed from: a */
    private static AbstractTimeSource f61296a;

    public static final AbstractTimeSource getTimeSource() {
        return f61296a;
    }

    public static final void setTimeSource(AbstractTimeSource abstractTimeSource) {
        f61296a = abstractTimeSource;
    }

    /* renamed from: a */
    private static final long m45437a() {
        AbstractTimeSource timeSource = getTimeSource();
        return timeSource == null ? System.currentTimeMillis() : timeSource.currentTimeMillis();
    }

    /* renamed from: b */
    private static final long m45441b() {
        AbstractTimeSource timeSource = getTimeSource();
        return timeSource == null ? System.nanoTime() : timeSource.nanoTime();
    }

    /* renamed from: a */
    private static final Runnable m45438a(Runnable runnable) {
        AbstractTimeSource timeSource = getTimeSource();
        return timeSource == null ? runnable : timeSource.wrapTask(runnable);
    }

    /* renamed from: c */
    private static final void m45442c() {
        AbstractTimeSource timeSource = getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
    }

    /* renamed from: d */
    private static final void m45443d() {
        AbstractTimeSource timeSource = getTimeSource();
        if (timeSource != null) {
            timeSource.unTrackTask();
        }
    }

    /* renamed from: e */
    private static final void m45444e() {
        AbstractTimeSource timeSource = getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
    }

    /* renamed from: f */
    private static final void m45445f() {
        AbstractTimeSource timeSource = getTimeSource();
        if (timeSource != null) {
            timeSource.unregisterTimeLoopThread();
        }
    }

    /* renamed from: a */
    private static final void m45439a(Object obj, long j) {
        AbstractTimeSource timeSource = getTimeSource();
        if (timeSource == null) {
            LockSupport.parkNanos(obj, j);
        } else {
            timeSource.parkNanos(obj, j);
        }
    }

    /* renamed from: a */
    private static final void m45440a(Thread thread) {
        AbstractTimeSource timeSource = getTimeSource();
        if (timeSource == null) {
            LockSupport.unpark(thread);
        } else {
            timeSource.unpark(thread);
        }
    }
}
