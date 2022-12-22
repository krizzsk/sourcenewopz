package com.didi.entrega.customer.foundation.tracker.performance;

import com.didi.entrega.customer.foundation.util.SingletonFactory;
import java.util.HashSet;
import java.util.Set;

public final class PerformanceOmegaHelper {

    /* renamed from: a */
    private long f20059a = -1;

    /* renamed from: b */
    private boolean f20060b;

    /* renamed from: c */
    private Set f20061c = new HashSet();

    public void trackImagePerformance(String str, long j, int i) {
    }

    public void trackWebViewPerformance(String str, long j) {
    }

    private PerformanceOmegaHelper() {
    }

    public static PerformanceOmegaHelper getInstance() {
        return (PerformanceOmegaHelper) SingletonFactory.get(PerformanceOmegaHelper.class);
    }
}
