package com.datadog.opentracing.scopemanager;

import com.datadog.trace.context.ScopeListener;
import p242io.opentracing.Span;

public class SimpleScope implements C2215a {

    /* renamed from: a */
    static final /* synthetic */ boolean f4164a = (!SimpleScope.class.desiredAssertionStatus());

    /* renamed from: b */
    private final ContextualScopeManager f4165b;

    /* renamed from: c */
    private final Span f4166c;

    /* renamed from: d */
    private final boolean f4167d;

    /* renamed from: e */
    private final C2215a f4168e;

    /* renamed from: f */
    private final int f4169f;

    public SimpleScope(ContextualScopeManager contextualScopeManager, Span span, boolean z) {
        if (f4164a || span != null) {
            this.f4165b = contextualScopeManager;
            this.f4166c = span;
            this.f4167d = z;
            this.f4168e = ContextualScopeManager.f4148a.get();
            ContextualScopeManager.f4148a.set(this);
            C2215a aVar = this.f4168e;
            this.f4169f = aVar == null ? 0 : aVar.depth() + 1;
            for (ScopeListener afterScopeActivated : contextualScopeManager.f4150c) {
                afterScopeActivated.afterScopeActivated();
            }
            return;
        }
        throw new AssertionError("span must not be null");
    }

    public void close() {
        if (this.f4167d) {
            this.f4166c.finish();
        }
        for (ScopeListener afterScopeClosed : this.f4165b.f4150c) {
            afterScopeClosed.afterScopeClosed();
        }
        if (ContextualScopeManager.f4148a.get() == this) {
            ContextualScopeManager.f4148a.set(this.f4168e);
            if (this.f4168e != null) {
                for (ScopeListener afterScopeActivated : this.f4165b.f4150c) {
                    afterScopeActivated.afterScopeActivated();
                }
            }
        }
    }

    public Span span() {
        return this.f4166c;
    }

    public int depth() {
        return this.f4169f;
    }
}
