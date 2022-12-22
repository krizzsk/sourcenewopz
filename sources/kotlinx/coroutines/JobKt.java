package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, mo175979k = 4, mo175980mv = {1, 5, 1}, mo175982xi = 48)
public final class JobKt {
    public static final DisposableHandle DisposableHandle(Function0<Unit> function0) {
        return C21990s.m46015a(function0);
    }

    public static final CompletableJob Job(Job job) {
        return C21990s.m46013a(job);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        C21990s.m46017a(coroutineContext, cancellationException);
    }

    public static final void cancel(Job job, String str, Throwable th) {
        C21990s.m46019a(job, str, th);
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        return C21990s.m46011a(job, continuation);
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, CancellationException cancellationException) {
        C21990s.m46033b(coroutineContext, cancellationException);
    }

    public static final void cancelChildren(Job job, CancellationException cancellationException) {
        C21990s.m46023a(job, cancellationException);
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        C21989r.m46010a(cancellableContinuation, future);
    }

    public static final DisposableHandle cancelFutureOnCompletion(Job job, Future<?> future) {
        return C21989r.m46009a(job, future);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return C21990s.m46016a(job, disposableHandle);
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        C21990s.m46035c(coroutineContext);
    }

    public static final void ensureActive(Job job) {
        C21990s.m46038d(job);
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        return C21990s.m46039e(coroutineContext);
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        return C21990s.m46025a(coroutineContext);
    }
}
