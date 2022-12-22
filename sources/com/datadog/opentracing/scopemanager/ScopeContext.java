package com.datadog.opentracing.scopemanager;

import p242io.opentracing.ScopeManager;

@Deprecated
public interface ScopeContext extends ScopeManager {
    boolean inContext();
}
