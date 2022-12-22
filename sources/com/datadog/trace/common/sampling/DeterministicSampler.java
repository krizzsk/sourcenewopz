package com.datadog.trace.common.sampling;

import com.datadog.opentracing.DDSpan;
import com.datadog.opentracing.DDTracer;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DeterministicSampler implements RateSampler {

    /* renamed from: a */
    private static final BigInteger f4268a = new BigInteger("1111111111111111111");

    /* renamed from: b */
    private static final BigDecimal f4269b = new BigDecimal(DDTracer.TRACE_ID_MAX);

    /* renamed from: c */
    private static final BigInteger f4270c = new BigInteger("2").pow(64);

    /* renamed from: d */
    private final BigInteger f4271d;

    /* renamed from: e */
    private final double f4272e;

    public DeterministicSampler(double d) {
        this.f4272e = d;
        this.f4271d = new BigDecimal(d).multiply(f4269b).toBigInteger();
    }

    public boolean sample(DDSpan dDSpan) {
        double d = this.f4272e;
        return d == 1.0d || (d != 0.0d && dDSpan.getTraceId().multiply(f4268a).mod(f4270c).compareTo(this.f4271d) < 0);
    }

    public double getSampleRate() {
        return this.f4272e;
    }
}
