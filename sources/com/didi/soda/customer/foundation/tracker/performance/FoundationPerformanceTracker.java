package com.didi.soda.customer.foundation.tracker.performance;

import com.didi.foundation.sdk.MethodAspect;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class FoundationPerformanceTracker {

    /* renamed from: a */
    private static FoundationPerformanceTracker f41114a = new FoundationPerformanceTracker();

    /* renamed from: b */
    private boolean f41115b;

    /* renamed from: c */
    private long f41116c;

    /* renamed from: d */
    private long f41117d;

    /* renamed from: e */
    private long f41118e;

    private FoundationPerformanceTracker() {
    }

    public static FoundationPerformanceTracker getTracker() {
        return f41114a;
    }

    public void init() {
        this.f41115b = true;
    }

    public void trackSplashRender(long j) {
        this.f41117d = j;
    }

    public void trackMainRender(long j) {
        this.f41116c = j;
    }

    public void trackMapRender(long j) {
        this.f41118e = j;
    }

    public void trackOmegaAppStartDuration() {
        if (this.f41115b && this.f41116c > 0 && this.f41117d > 0 && this.f41118e > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("MainActivity", String.valueOf(this.f41116c));
            hashMap.put("SplashActivity", String.valueOf(this.f41117d));
            hashMap.put("MapRender", String.valueOf(this.f41118e));
            MethodAspect.report(Arrays.asList(new Long[]{Long.valueOf(this.f41117d), Long.valueOf(this.f41116c)}), hashMap, (Map<String, Object>) null);
        }
    }
}
