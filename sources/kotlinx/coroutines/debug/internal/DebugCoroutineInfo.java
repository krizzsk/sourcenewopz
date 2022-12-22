package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8G¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, mo175978d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "", "source", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCreationStackBottom", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", "lastObservedFrame", "getLastObservedFrame", "lastObservedStackTrace", "lastObservedThread", "Ljava/lang/Thread;", "getLastObservedThread", "()Ljava/lang/Thread;", "sequenceNumber", "", "getSequenceNumber", "()J", "state", "", "getState", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DebugCoroutineInfo.kt */
public final class DebugCoroutineInfo {

    /* renamed from: a */
    private final CoroutineContext f61413a;

    /* renamed from: b */
    private final CoroutineStackFrame f61414b;

    /* renamed from: c */
    private final long f61415c;

    /* renamed from: d */
    private final List<StackTraceElement> f61416d;

    /* renamed from: e */
    private final String f61417e;

    /* renamed from: f */
    private final Thread f61418f;

    /* renamed from: g */
    private final CoroutineStackFrame f61419g;

    /* renamed from: h */
    private final List<StackTraceElement> f61420h;

    public DebugCoroutineInfo(DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineContext coroutineContext) {
        this.f61413a = coroutineContext;
        this.f61414b = debugCoroutineInfoImpl.getCreationStackBottom();
        this.f61415c = debugCoroutineInfoImpl.sequenceNumber;
        this.f61416d = debugCoroutineInfoImpl.getCreationStackTrace();
        this.f61417e = debugCoroutineInfoImpl.getState();
        this.f61418f = debugCoroutineInfoImpl.lastObservedThread;
        this.f61419g = debugCoroutineInfoImpl.getLastObservedFrame$kotlinx_coroutines_core();
        this.f61420h = debugCoroutineInfoImpl.lastObservedStackTrace();
    }

    public final CoroutineContext getContext() {
        return this.f61413a;
    }

    public final CoroutineStackFrame getCreationStackBottom() {
        return this.f61414b;
    }

    public final long getSequenceNumber() {
        return this.f61415c;
    }

    public final List<StackTraceElement> getCreationStackTrace() {
        return this.f61416d;
    }

    public final String getState() {
        return this.f61417e;
    }

    public final Thread getLastObservedThread() {
        return this.f61418f;
    }

    public final CoroutineStackFrame getLastObservedFrame() {
        return this.f61419g;
    }

    public final List<StackTraceElement> lastObservedStackTrace() {
        return this.f61420h;
    }
}
