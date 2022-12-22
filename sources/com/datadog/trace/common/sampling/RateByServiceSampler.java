package com.datadog.trace.common.sampling;

import com.datadog.opentracing.DDSpan;
import java.util.Collections;
import java.util.Map;

public class RateByServiceSampler implements PrioritySampler, Sampler {
    public static final String SAMPLING_AGENT_RATE = "_dd.agent_psr";

    /* renamed from: a */
    private static final String f4273a = "service:,env:";

    /* renamed from: b */
    private static final double f4274b = 1.0d;

    /* renamed from: c */
    private volatile Map<String, RateSampler> f4275c = Collections.unmodifiableMap(Collections.singletonMap(f4273a, m2603a(1.0d)));

    public boolean sample(DDSpan dDSpan) {
        return true;
    }

    public void setSamplingPriority(DDSpan dDSpan) {
        boolean z;
        String str = "service:" + dDSpan.getServiceName() + ",env:" + m2604a(dDSpan);
        Map<String, RateSampler> map = this.f4275c;
        RateSampler rateSampler = this.f4275c.get(str);
        if (rateSampler == null) {
            rateSampler = map.get(f4273a);
        }
        if (rateSampler.sample(dDSpan)) {
            z = dDSpan.context().setSamplingPriority(1);
        } else {
            z = dDSpan.context().setSamplingPriority(0);
        }
        if (z) {
            dDSpan.context().setMetric(SAMPLING_AGENT_RATE, Double.valueOf(rateSampler.getSampleRate()));
        }
    }

    /* renamed from: a */
    private static String m2604a(DDSpan dDSpan) {
        return dDSpan.getTags().get("env") == null ? "" : String.valueOf(dDSpan.getTags().get("env"));
    }

    /* renamed from: a */
    private RateSampler m2603a(double d) {
        if (d < 0.0d || d > 1.0d) {
            d = 1.0d;
        }
        return new DeterministicSampler(d);
    }
}
