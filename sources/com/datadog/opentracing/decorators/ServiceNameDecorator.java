package com.datadog.opentracing.decorators;

import com.datadog.opentracing.DDSpanContext;

public class ServiceNameDecorator extends AbstractDecorator {

    /* renamed from: a */
    private final boolean f4125a;

    public ServiceNameDecorator() {
        this("service.name", false);
    }

    public ServiceNameDecorator(String str, boolean z) {
        this.f4125a = z;
        setMatchingTag(str);
    }

    public boolean shouldSetTag(DDSpanContext dDSpanContext, String str, Object obj) {
        dDSpanContext.setServiceName(String.valueOf(obj));
        return this.f4125a;
    }
}
