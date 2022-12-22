package com.datadog.opentracing.propagation;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExtractedContext extends TagContext {

    /* renamed from: a */
    private final BigInteger f4137a;

    /* renamed from: b */
    private final BigInteger f4138b;

    /* renamed from: c */
    private final int f4139c;

    /* renamed from: d */
    private final Map<String, String> f4140d;

    /* renamed from: e */
    private final AtomicBoolean f4141e = new AtomicBoolean(false);

    public ExtractedContext(BigInteger bigInteger, BigInteger bigInteger2, int i, String str, Map<String, String> map, Map<String, String> map2) {
        super(str, map2);
        this.f4137a = bigInteger;
        this.f4138b = bigInteger2;
        this.f4139c = i;
        this.f4140d = map;
    }

    public Iterable<Map.Entry<String, String>> baggageItems() {
        return this.f4140d.entrySet();
    }

    public void lockSamplingPriority() {
        this.f4141e.set(true);
    }

    public BigInteger getTraceId() {
        return this.f4137a;
    }

    public BigInteger getSpanId() {
        return this.f4138b;
    }

    public int getSamplingPriority() {
        return this.f4139c;
    }

    public Map<String, String> getBaggage() {
        return this.f4140d;
    }

    public boolean getSamplingPriorityLocked() {
        return this.f4141e.get();
    }
}
