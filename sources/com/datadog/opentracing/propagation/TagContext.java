package com.datadog.opentracing.propagation;

import java.util.Collections;
import java.util.Map;
import p242io.opentracing.SpanContext;

public class TagContext implements SpanContext {

    /* renamed from: a */
    private final String f4146a;

    /* renamed from: b */
    private final Map<String, String> f4147b;

    public String toSpanId() {
        return "";
    }

    public String toTraceId() {
        return "";
    }

    public TagContext(String str, Map<String, String> map) {
        this.f4146a = str;
        this.f4147b = map;
    }

    public String getOrigin() {
        return this.f4146a;
    }

    public Map<String, String> getTags() {
        return this.f4147b;
    }

    public Iterable<Map.Entry<String, String>> baggageItems() {
        return Collections.emptyList();
    }
}
