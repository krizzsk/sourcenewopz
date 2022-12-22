package p242io.opentracing.util;

import p242io.opentracing.Scope;
import p242io.opentracing.ScopeManager;
import p242io.opentracing.Span;

/* renamed from: io.opentracing.util.ThreadLocalScopeManager */
public class ThreadLocalScopeManager implements ScopeManager {

    /* renamed from: a */
    final ThreadLocal<ThreadLocalScope> f58019a = new ThreadLocal<>();

    public Scope activate(Span span, boolean z) {
        return new ThreadLocalScope(this, span, z);
    }

    public Scope activate(Span span) {
        return new ThreadLocalScope(this, span);
    }

    public Scope active() {
        return this.f58019a.get();
    }

    public Span activeSpan() {
        Scope scope = this.f58019a.get();
        if (scope == null) {
            return null;
        }
        return scope.span();
    }
}
