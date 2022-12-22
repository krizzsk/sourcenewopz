package com.datadog.opentracing.scopemanager;

import p242io.opentracing.Scope;
import p242io.opentracing.Span;

/* renamed from: com.datadog.opentracing.scopemanager.a */
/* compiled from: DDScope */
interface C2215a extends Scope {
    int depth();

    Span span();
}
