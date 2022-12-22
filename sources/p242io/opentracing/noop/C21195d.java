package p242io.opentracing.noop;

import p242io.opentracing.Scope;
import p242io.opentracing.ScopeManager;
import p242io.opentracing.Span;
import p242io.opentracing.SpanContext;
import p242io.opentracing.Tracer;
import p242io.opentracing.noop.NoopScopeManager;
import p242io.opentracing.propagation.Format;

/* renamed from: io.opentracing.noop.d */
/* compiled from: NoopTracer */
final class C21195d implements NoopTracer {

    /* renamed from: a */
    static final NoopTracer f58006a = new C21195d();

    public void close() {
    }

    public <C> void inject(SpanContext spanContext, Format<C> format, C c) {
    }

    C21195d() {
    }

    public ScopeManager scopeManager() {
        return NoopScopeManager.INSTANCE;
    }

    public Span activeSpan() {
        return C21194c.INSTANCE;
    }

    public Scope activateSpan(Span span) {
        return NoopScopeManager.NoopScope.INSTANCE;
    }

    public Tracer.SpanBuilder buildSpan(String str) {
        return C21192a.INSTANCE;
    }

    public <C> SpanContext extract(Format<C> format, C c) {
        return C21193b.f58005a;
    }

    public String toString() {
        return NoopTracer.class.getSimpleName();
    }
}
