package p242io.opentracing.util;

import java.util.concurrent.atomic.AtomicInteger;
import p242io.opentracing.Scope;
import p242io.opentracing.Span;

@Deprecated
/* renamed from: io.opentracing.util.AutoFinishScope */
public class AutoFinishScope implements Scope {

    /* renamed from: a */
    final AutoFinishScopeManager f58007a;

    /* renamed from: b */
    final AtomicInteger f58008b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Span f58009c;

    /* renamed from: d */
    private final AutoFinishScope f58010d;

    AutoFinishScope(AutoFinishScopeManager autoFinishScopeManager, AtomicInteger atomicInteger, Span span) {
        this.f58007a = autoFinishScopeManager;
        this.f58008b = atomicInteger;
        this.f58009c = span;
        this.f58010d = autoFinishScopeManager.f58011a.get();
        autoFinishScopeManager.f58011a.set(this);
    }

    /* renamed from: io.opentracing.util.AutoFinishScope$Continuation */
    public class Continuation {
        public Continuation() {
            AutoFinishScope.this.f58008b.incrementAndGet();
        }

        public AutoFinishScope activate() {
            return new AutoFinishScope(AutoFinishScope.this.f58007a, AutoFinishScope.this.f58008b, AutoFinishScope.this.f58009c);
        }
    }

    public Continuation capture() {
        return new Continuation();
    }

    public void close() {
        if (this.f58007a.f58011a.get() == this) {
            if (this.f58008b.decrementAndGet() == 0) {
                this.f58009c.finish();
            }
            this.f58007a.f58011a.set(this.f58010d);
        }
    }

    public Span span() {
        return this.f58009c;
    }
}
