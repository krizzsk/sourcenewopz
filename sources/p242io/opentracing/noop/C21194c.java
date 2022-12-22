package p242io.opentracing.noop;

import java.util.Map;
import p242io.opentracing.SpanContext;
import p242io.opentracing.tag.Tag;

/* renamed from: io.opentracing.noop.c */
/* compiled from: NoopSpan */
final class C21194c implements NoopSpan {
    /* renamed from: a */
    public NoopSpan log(long j, String str) {
        return this;
    }

    /* renamed from: a */
    public NoopSpan log(long j, Map<String, ?> map) {
        return this;
    }

    /* renamed from: a */
    public <T> NoopSpan setTag(Tag<T> tag, T t) {
        return this;
    }

    /* renamed from: a */
    public NoopSpan log(String str) {
        return this;
    }

    /* renamed from: a */
    public NoopSpan setTag(String str, Number number) {
        return this;
    }

    /* renamed from: a */
    public NoopSpan setTag(String str, String str2) {
        return this;
    }

    /* renamed from: a */
    public NoopSpan setTag(String str, boolean z) {
        return this;
    }

    /* renamed from: a */
    public NoopSpan log(Map<String, ?> map) {
        return this;
    }

    /* renamed from: b */
    public NoopSpan setOperationName(String str) {
        return this;
    }

    /* renamed from: b */
    public NoopSpan setBaggageItem(String str, String str2) {
        return this;
    }

    public void finish() {
    }

    public void finish(long j) {
    }

    public String getBaggageItem(String str) {
        return null;
    }

    C21194c() {
    }

    public SpanContext context() {
        return C21193b.f58005a;
    }

    public String toString() {
        return NoopSpan.class.getSimpleName();
    }
}
