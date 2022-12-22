package p242io.opentracing.noop;

import java.util.Collections;
import java.util.Map;

/* renamed from: io.opentracing.noop.b */
/* compiled from: NoopSpanContext */
final class C21193b implements NoopSpanContext {

    /* renamed from: a */
    static final C21193b f58005a = new C21193b();

    public String toSpanId() {
        return "";
    }

    public String toTraceId() {
        return "";
    }

    C21193b() {
    }

    public Iterable<Map.Entry<String, String>> baggageItems() {
        return Collections.emptyList();
    }

    public String toString() {
        return NoopSpanContext.class.getSimpleName();
    }
}
