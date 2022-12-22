package p242io.opentracing.util;

import java.util.concurrent.atomic.AtomicInteger;
import p242io.opentracing.ScopeManager;
import p242io.opentracing.Span;
import p242io.opentracing.util.AutoFinishScope;

@Deprecated
/* renamed from: io.opentracing.util.AutoFinishScopeManager */
public class AutoFinishScopeManager implements ScopeManager {

    /* renamed from: a */
    final ThreadLocal<AutoFinishScope> f58011a = new ThreadLocal<>();

    public AutoFinishScope activate(Span span, boolean z) {
        return new AutoFinishScope(this, new AtomicInteger(1), span);
    }

    public AutoFinishScope activate(Span span) {
        return new AutoFinishScope(this, new AtomicInteger(1), span);
    }

    public AutoFinishScope active() {
        return this.f58011a.get();
    }

    public Span activeSpan() {
        AutoFinishScope autoFinishScope = this.f58011a.get();
        if (autoFinishScope == null) {
            return null;
        }
        return autoFinishScope.span();
    }

    public AutoFinishScope.Continuation captureScope() {
        AutoFinishScope autoFinishScope = this.f58011a.get();
        if (autoFinishScope == null) {
            return null;
        }
        return autoFinishScope.capture();
    }
}
