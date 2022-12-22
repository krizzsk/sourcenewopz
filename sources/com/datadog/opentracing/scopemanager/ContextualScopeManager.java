package com.datadog.opentracing.scopemanager;

import com.datadog.opentracing.jfr.DDScopeEventFactory;
import com.datadog.trace.context.ScopeListener;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p242io.opentracing.Scope;
import p242io.opentracing.ScopeManager;
import p242io.opentracing.Span;

public class ContextualScopeManager implements ScopeManager {

    /* renamed from: a */
    static final ThreadLocal<C2215a> f4148a = new ThreadLocal<>();

    /* renamed from: b */
    final Deque<ScopeContext> f4149b = new LinkedList();

    /* renamed from: c */
    final List<ScopeListener> f4150c = new CopyOnWriteArrayList();

    /* renamed from: d */
    private final int f4151d;

    /* renamed from: e */
    private final DDScopeEventFactory f4152e;

    public ContextualScopeManager(int i, DDScopeEventFactory dDScopeEventFactory) {
        this.f4151d = i;
        this.f4152e = dDScopeEventFactory;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        if ((r5 instanceof com.datadog.opentracing.DDSpan) == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        return new com.datadog.opentracing.scopemanager.ContinuableScope(r4, (com.datadog.opentracing.DDSpan) r5, r6, r4.f4152e);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        return new com.datadog.opentracing.scopemanager.SimpleScope(r4, r5, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p242io.opentracing.Scope activate(p242io.opentracing.Span r5, boolean r6) {
        /*
            r4 = this;
            io.opentracing.Scope r0 = r4.active()
            boolean r1 = r0 instanceof com.datadog.opentracing.scopemanager.C2215a
            if (r1 == 0) goto L_0x0015
            com.datadog.opentracing.scopemanager.a r0 = (com.datadog.opentracing.scopemanager.C2215a) r0
            int r0 = r0.depth()
            int r1 = r4.f4151d
            if (r1 > r0) goto L_0x0015
            io.opentracing.noop.NoopScopeManager$NoopScope r5 = p242io.opentracing.noop.NoopScopeManager.NoopScope.INSTANCE
            return r5
        L_0x0015:
            java.util.Deque<com.datadog.opentracing.scopemanager.ScopeContext> r0 = r4.f4149b
            monitor-enter(r0)
            java.util.Deque<com.datadog.opentracing.scopemanager.ScopeContext> r1 = r4.f4149b     // Catch:{ all -> 0x004b }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x004b }
        L_0x001e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x004b }
            com.datadog.opentracing.scopemanager.ScopeContext r2 = (com.datadog.opentracing.scopemanager.ScopeContext) r2     // Catch:{ all -> 0x004b }
            boolean r3 = r2.inContext()     // Catch:{ all -> 0x004b }
            if (r3 == 0) goto L_0x001e
            io.opentracing.Scope r5 = r2.activate(r5, r6)     // Catch:{ all -> 0x004b }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return r5
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            boolean r0 = r5 instanceof com.datadog.opentracing.DDSpan
            if (r0 == 0) goto L_0x0045
            com.datadog.opentracing.scopemanager.ContinuableScope r0 = new com.datadog.opentracing.scopemanager.ContinuableScope
            com.datadog.opentracing.DDSpan r5 = (com.datadog.opentracing.DDSpan) r5
            com.datadog.opentracing.jfr.DDScopeEventFactory r1 = r4.f4152e
            r0.<init>(r4, r5, r6, r1)
            return r0
        L_0x0045:
            com.datadog.opentracing.scopemanager.SimpleScope r0 = new com.datadog.opentracing.scopemanager.SimpleScope
            r0.<init>(r4, r5, r6)
            return r0
        L_0x004b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.opentracing.scopemanager.ContextualScopeManager.activate(io.opentracing.Span, boolean):io.opentracing.Scope");
    }

    public Scope activate(Span span) {
        return activate(span, false);
    }

    public Scope active() {
        synchronized (this.f4149b) {
            for (ScopeContext next : this.f4149b) {
                if (next.inContext()) {
                    Scope active = next.active();
                    return active;
                }
            }
            return f4148a.get();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r0 = f4148a.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r0 != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return r0.span();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p242io.opentracing.Span activeSpan() {
        /*
            r4 = this;
            java.util.Deque<com.datadog.opentracing.scopemanager.ScopeContext> r0 = r4.f4149b
            monitor-enter(r0)
            java.util.Deque<com.datadog.opentracing.scopemanager.ScopeContext> r1 = r4.f4149b     // Catch:{ all -> 0x0033 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0033 }
        L_0x0009:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x0021
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0033 }
            com.datadog.opentracing.scopemanager.ScopeContext r2 = (com.datadog.opentracing.scopemanager.ScopeContext) r2     // Catch:{ all -> 0x0033 }
            boolean r3 = r2.inContext()     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x0009
            io.opentracing.Span r1 = r2.activeSpan()     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return r1
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            java.lang.ThreadLocal<com.datadog.opentracing.scopemanager.a> r0 = f4148a
            java.lang.Object r0 = r0.get()
            com.datadog.opentracing.scopemanager.a r0 = (com.datadog.opentracing.scopemanager.C2215a) r0
            if (r0 != 0) goto L_0x002e
            r0 = 0
            goto L_0x0032
        L_0x002e:
            io.opentracing.Span r0 = r0.span()
        L_0x0032:
            return r0
        L_0x0033:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.opentracing.scopemanager.ContextualScopeManager.activeSpan():io.opentracing.Span");
    }

    @Deprecated
    public void addScopeContext(ScopeContext scopeContext) {
        synchronized (this.f4149b) {
            this.f4149b.addFirst(scopeContext);
        }
    }

    public void addScopeListener(ScopeListener scopeListener) {
        this.f4150c.add(scopeListener);
    }
}
