package p242io.opentracing.util;

import java.util.concurrent.Callable;
import p242io.opentracing.Scope;
import p242io.opentracing.ScopeManager;
import p242io.opentracing.Span;
import p242io.opentracing.SpanContext;
import p242io.opentracing.Tracer;
import p242io.opentracing.noop.NoopTracerFactory;
import p242io.opentracing.propagation.Format;

/* renamed from: io.opentracing.util.GlobalTracer */
public final class GlobalTracer implements Tracer {

    /* renamed from: a */
    private static final GlobalTracer f58012a = new GlobalTracer();

    /* renamed from: b */
    private static volatile Tracer f58013b = NoopTracerFactory.create();

    /* renamed from: c */
    private static volatile boolean f58014c = false;

    private GlobalTracer() {
    }

    public static Tracer get() {
        return f58012a;
    }

    public static boolean isRegistered() {
        return f58014c;
    }

    public static synchronized boolean registerIfAbsent(Callable<Tracer> callable) {
        synchronized (GlobalTracer.class) {
            m41785a(callable, "Cannot register GlobalTracer from provider <null>.");
            if (!isRegistered()) {
                try {
                    Tracer tracer = (Tracer) m41785a(callable.call(), "Cannot register GlobalTracer <null>.");
                    if (!(tracer instanceof GlobalTracer)) {
                        f58013b = tracer;
                        f58014c = true;
                        return true;
                    }
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new IllegalStateException("Exception obtaining tracer from provider: " + e2.getMessage(), e2);
                }
            }
            return false;
        }
    }

    public static synchronized boolean registerIfAbsent(final Tracer tracer) {
        boolean registerIfAbsent;
        synchronized (GlobalTracer.class) {
            m41785a(tracer, "Cannot register GlobalTracer. Tracer is null");
            registerIfAbsent = registerIfAbsent((Callable<Tracer>) new Callable<Tracer>() {
                public Tracer call() {
                    return tracer;
                }
            });
        }
        return registerIfAbsent;
    }

    @Deprecated
    public static void register(Tracer tracer) {
        if (!registerIfAbsent(m41786a(tracer)) && !tracer.equals(f58013b) && !(tracer instanceof GlobalTracer)) {
            throw new IllegalStateException("There is already a current global Tracer registered.");
        }
    }

    public ScopeManager scopeManager() {
        return f58013b.scopeManager();
    }

    public Tracer.SpanBuilder buildSpan(String str) {
        return f58013b.buildSpan(str);
    }

    public <C> void inject(SpanContext spanContext, Format<C> format, C c) {
        f58013b.inject(spanContext, format, c);
    }

    public <C> SpanContext extract(Format<C> format, C c) {
        return f58013b.extract(format, c);
    }

    public Span activeSpan() {
        return f58013b.activeSpan();
    }

    public Scope activateSpan(Span span) {
        return f58013b.activateSpan(span);
    }

    public void close() {
        f58013b.close();
    }

    public String toString() {
        return GlobalTracer.class.getSimpleName() + '{' + f58013b + '}';
    }

    /* renamed from: a */
    private static Callable<Tracer> m41786a(final Tracer tracer) {
        return new Callable<Tracer>() {
            public Tracer call() {
                return tracer;
            }
        };
    }

    /* renamed from: a */
    private static <T> T m41785a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
