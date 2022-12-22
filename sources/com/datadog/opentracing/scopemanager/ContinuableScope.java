package com.datadog.opentracing.scopemanager;

import com.datadog.opentracing.DDSpan;
import com.datadog.opentracing.PendingTrace;
import com.datadog.opentracing.jfr.DDScopeEvent;
import com.datadog.opentracing.jfr.DDScopeEventFactory;
import com.datadog.trace.context.ScopeListener;
import com.datadog.trace.context.TraceScope;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ContinuableScope implements C2215a, TraceScope {

    /* renamed from: a */
    static final /* synthetic */ boolean f4153a = (!ContinuableScope.class.desiredAssertionStatus());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ContextualScopeManager f4154b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final DDSpan f4155c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final DDScopeEventFactory f4156d;

    /* renamed from: e */
    private final DDScopeEvent f4157e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final boolean f4158f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AtomicInteger f4159g;

    /* renamed from: h */
    private final C2215a f4160h;

    /* renamed from: i */
    private final Continuation f4161i;

    /* renamed from: j */
    private final AtomicBoolean f4162j;

    /* renamed from: k */
    private final int f4163k;

    ContinuableScope(ContextualScopeManager contextualScopeManager, DDSpan dDSpan, boolean z, DDScopeEventFactory dDScopeEventFactory) {
        this(contextualScopeManager, new AtomicInteger(1), (Continuation) null, dDSpan, z, dDScopeEventFactory);
    }

    private ContinuableScope(ContextualScopeManager contextualScopeManager, AtomicInteger atomicInteger, Continuation continuation, DDSpan dDSpan, boolean z, DDScopeEventFactory dDScopeEventFactory) {
        int i = 0;
        this.f4162j = new AtomicBoolean(false);
        if (f4153a || dDSpan != null) {
            this.f4154b = contextualScopeManager;
            this.f4159g = atomicInteger;
            this.f4161i = continuation;
            this.f4155c = dDSpan;
            this.f4158f = z;
            this.f4156d = dDScopeEventFactory;
            DDScopeEvent create = dDScopeEventFactory.create(dDSpan.context());
            this.f4157e = create;
            create.start();
            this.f4160h = ContextualScopeManager.f4148a.get();
            ContextualScopeManager.f4148a.set(this);
            C2215a aVar = this.f4160h;
            this.f4163k = aVar != null ? aVar.depth() + 1 : i;
            for (ScopeListener afterScopeActivated : contextualScopeManager.f4150c) {
                afterScopeActivated.afterScopeActivated();
            }
            return;
        }
        throw new AssertionError("span must not be null");
    }

    public void close() {
        this.f4157e.finish();
        if (this.f4161i != null) {
            this.f4155c.context().getTrace().cancelContinuation(this.f4161i);
        }
        if (this.f4159g.decrementAndGet() == 0 && this.f4158f) {
            this.f4155c.finish();
        }
        for (ScopeListener afterScopeClosed : this.f4154b.f4150c) {
            afterScopeClosed.afterScopeClosed();
        }
        if (ContextualScopeManager.f4148a.get() == this) {
            ContextualScopeManager.f4148a.set(this.f4160h);
            if (this.f4160h != null) {
                for (ScopeListener afterScopeActivated : this.f4154b.f4150c) {
                    afterScopeActivated.afterScopeActivated();
                }
            }
        }
    }

    public DDSpan span() {
        return this.f4155c;
    }

    public int depth() {
        return this.f4163k;
    }

    public boolean isAsyncPropagating() {
        return this.f4162j.get();
    }

    public void setAsyncPropagation(boolean z) {
        this.f4162j.set(z);
    }

    public Continuation capture() {
        if (isAsyncPropagating()) {
            return new Continuation();
        }
        return null;
    }

    public String toString() {
        return super.toString() + "->" + this.f4155c;
    }

    public class Continuation implements TraceScope.Continuation, Closeable {
        public WeakReference<Continuation> ref;
        private final PendingTrace trace;
        private final AtomicBoolean used;

        private Continuation() {
            this.used = new AtomicBoolean(false);
            ContinuableScope.this.f4159g.incrementAndGet();
            PendingTrace trace2 = ContinuableScope.this.f4155c.context().getTrace();
            this.trace = trace2;
            trace2.registerContinuation(this);
        }

        public ContinuableScope activate() {
            if (!this.used.compareAndSet(false, true)) {
                return new ContinuableScope(ContinuableScope.this.f4154b, new AtomicInteger(1), (Continuation) null, ContinuableScope.this.f4155c, ContinuableScope.this.f4158f, ContinuableScope.this.f4156d);
            }
            return new ContinuableScope(ContinuableScope.this.f4154b, ContinuableScope.this.f4159g, this, ContinuableScope.this.f4155c, ContinuableScope.this.f4158f, ContinuableScope.this.f4156d);
        }

        public void close() {
            close(true);
        }

        public void close(boolean z) {
            if (this.used.compareAndSet(false, true)) {
                this.trace.cancelContinuation(this);
                if (z) {
                    ContinuableScope.this.close();
                } else if (ContinuableScope.this.f4159g.decrementAndGet() == 0 && ContinuableScope.this.f4158f) {
                    ContinuableScope.this.f4155c.finish();
                }
            }
        }
    }
}
