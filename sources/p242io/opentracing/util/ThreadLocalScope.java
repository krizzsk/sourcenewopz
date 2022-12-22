package p242io.opentracing.util;

import p242io.opentracing.Scope;
import p242io.opentracing.Span;

/* renamed from: io.opentracing.util.ThreadLocalScope */
public class ThreadLocalScope implements Scope {

    /* renamed from: a */
    private final ThreadLocalScopeManager f58015a;

    /* renamed from: b */
    private final Span f58016b;

    /* renamed from: c */
    private final boolean f58017c;

    /* renamed from: d */
    private final ThreadLocalScope f58018d;

    ThreadLocalScope(ThreadLocalScopeManager threadLocalScopeManager, Span span) {
        this(threadLocalScopeManager, span, false);
    }

    ThreadLocalScope(ThreadLocalScopeManager threadLocalScopeManager, Span span, boolean z) {
        this.f58015a = threadLocalScopeManager;
        this.f58016b = span;
        this.f58017c = z;
        this.f58018d = threadLocalScopeManager.f58019a.get();
        threadLocalScopeManager.f58019a.set(this);
    }

    public void close() {
        if (this.f58015a.f58019a.get() == this) {
            if (this.f58017c) {
                this.f58016b.finish();
            }
            this.f58015a.f58019a.set(this.f58018d);
        }
    }

    public Span span() {
        return this.f58016b;
    }
}
