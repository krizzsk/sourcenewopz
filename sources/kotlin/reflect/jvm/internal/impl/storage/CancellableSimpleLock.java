package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;

/* compiled from: locks.kt */
public final class CancellableSimpleLock extends DefaultSimpleLock {

    /* renamed from: a */
    private final Runnable f61074a;

    /* renamed from: b */
    private final Function1<InterruptedException, Unit> f61075b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellableSimpleLock(Lock lock, Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        super(lock);
        Intrinsics.checkNotNullParameter(lock, JoinPoint.SYNCHRONIZATION_LOCK);
        Intrinsics.checkNotNullParameter(runnable, "checkCancelled");
        Intrinsics.checkNotNullParameter(function1, "interruptedExceptionHandler");
        this.f61074a = runnable;
        this.f61075b = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CancellableSimpleLock(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        this(new ReentrantLock(), runnable, function1);
        Intrinsics.checkNotNullParameter(runnable, "checkCancelled");
        Intrinsics.checkNotNullParameter(function1, "interruptedExceptionHandler");
    }

    public void lock() {
        while (!getLock().tryLock(50, TimeUnit.MILLISECONDS)) {
            try {
                this.f61074a.run();
            } catch (InterruptedException e) {
                this.f61075b.invoke(e);
                return;
            }
        }
    }
}
