package p242io.opentracing.noop;

import p242io.opentracing.Scope;
import p242io.opentracing.Span;
import p242io.opentracing.SpanContext;
import p242io.opentracing.Tracer;
import p242io.opentracing.noop.NoopScopeManager;
import p242io.opentracing.tag.Tag;

/* renamed from: io.opentracing.noop.a */
/* compiled from: NoopSpanBuilder */
final class C21192a implements NoopSpanBuilder {
    public Tracer.SpanBuilder addReference(String str, SpanContext spanContext) {
        return this;
    }

    public Tracer.SpanBuilder asChildOf(Span span) {
        return this;
    }

    public Tracer.SpanBuilder asChildOf(SpanContext spanContext) {
        return this;
    }

    public Tracer.SpanBuilder ignoreActiveSpan() {
        return this;
    }

    public Tracer.SpanBuilder withStartTimestamp(long j) {
        return this;
    }

    public <T> Tracer.SpanBuilder withTag(Tag<T> tag, T t) {
        return this;
    }

    public Tracer.SpanBuilder withTag(String str, Number number) {
        return this;
    }

    public Tracer.SpanBuilder withTag(String str, String str2) {
        return this;
    }

    public Tracer.SpanBuilder withTag(String str, boolean z) {
        return this;
    }

    C21192a() {
    }

    public Scope startActive(boolean z) {
        return NoopScopeManager.NoopScope.INSTANCE;
    }

    public Span start() {
        return startManual();
    }

    public Span startManual() {
        return C21194c.INSTANCE;
    }

    public String toString() {
        return NoopSpanBuilder.class.getSimpleName();
    }
}
