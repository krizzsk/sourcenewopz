package p242io.opentracing.noop;

import p242io.opentracing.Scope;
import p242io.opentracing.ScopeManager;
import p242io.opentracing.noop.NoopScopeManagerImpl;

/* renamed from: io.opentracing.noop.NoopScopeManager */
public interface NoopScopeManager extends ScopeManager {
    public static final NoopScopeManager INSTANCE = new NoopScopeManagerImpl();

    /* renamed from: io.opentracing.noop.NoopScopeManager$NoopScope */
    public interface NoopScope extends Scope {
        public static final NoopScope INSTANCE = new NoopScopeManagerImpl.NoopScopeImpl();
    }
}
