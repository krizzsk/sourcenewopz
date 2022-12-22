package com.didichuxing.bigdata.p173dp.locsdk;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.ApolloProxy */
public class ApolloProxy {

    /* renamed from: a */
    private static ApolloProxy f45669a;

    private ApolloProxy() {
    }

    public static synchronized ApolloProxy getInstance() {
        ApolloProxy apolloProxy;
        synchronized (ApolloProxy.class) {
            if (f45669a == null) {
                f45669a = new ApolloProxy();
            }
            apolloProxy = f45669a;
        }
        return apolloProxy;
    }

    public int getLocDispatchStatPercent() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_stat_dispatch_enabled");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("stat_percent", 0)).intValue();
        }
        return 0;
    }

    public boolean isNTPEnabled() {
        return Apollo.getToggle("ddlocsdk_ntp_enabled").allow();
    }

    public long getNTPCacheBootUTCToleranceMillis() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_ntp_enabled");
        if (toggle.allow()) {
            return ((Long) toggle.getExperiment().getParam("boot_utc_tolerance_ms", Long.MAX_VALUE)).longValue();
        }
        return Long.MAX_VALUE;
    }

    public long getNTPCacheTimeDiffToleranceMillis() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_ntp_enabled");
        if (toggle.allow()) {
            return (long) ((Integer) toggle.getExperiment().getParam("timediff_cache_tolerance_ms", 0)).intValue();
        }
        return 0;
    }

    public boolean isNTPUseStandardTimeRef() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_ntp_enabled");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("use_standard_timeref", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public int getNTPStatLocPercent() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_ntp_stat_enabled");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("loc_timediff_stat_percent", 0)).intValue();
        }
        return 0;
    }

    public int getNTPStatBasePercent() {
        return Apollo.getToggle("ddlocsdk_ntp_stat_enabled").allow() ? 100 : 0;
    }

    public int getLocTimeMonotonicStatPercent() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_ntp_stat_enabled");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("loctime_monotonic_stat_percent", 0)).intValue();
        }
        return 0;
    }

    public float getDirectNotifyIntervalRate() {
        IToggle toggle = Apollo.getToggle("locsdk_direct_notify_interval_rate");
        if (toggle == null || !toggle.allow()) {
            return 0.95f;
        }
        return ((Float) toggle.getExperiment().getParam("rate", Float.valueOf(0.95f))).floatValue();
    }
}
