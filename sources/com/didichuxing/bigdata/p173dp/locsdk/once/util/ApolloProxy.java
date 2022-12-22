package com.didichuxing.bigdata.p173dp.locsdk.once.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.util.ApolloProxy */
public class ApolloProxy {

    /* renamed from: a */
    private static ApolloProxy f46147a;

    private ApolloProxy() {
    }

    public static synchronized ApolloProxy getInstance() {
        ApolloProxy apolloProxy;
        synchronized (ApolloProxy.class) {
            if (f46147a == null) {
                f46147a = new ApolloProxy();
            }
            apolloProxy = f46147a;
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

    public boolean isNTPAdjustLocTimeEnabled() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_ntp_enabled");
        return toggle.allow() && "1".equals(toggle.getExperiment().getParam("adjust_loc_time", "0"));
    }

    public boolean isNTPAdjustLocTimeWhenLocCreate() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_ntp_enabled");
        return toggle.allow() && "1".equals(toggle.getExperiment().getParam("adjust_loc_time_moment", "0"));
    }

    public int getNTPLocStatPercent() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_ntp_stat_enabled");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("loc_timediff_stat_percent", 0)).intValue();
        }
        return 0;
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

    public static long[] requestRefreshWifiParams() {
        IToggle toggle = Apollo.getToggle(Const.APOLLO_REFRESH_WIFI);
        if (!toggle.allow()) {
            return null;
        }
        IExperiment experiment = toggle.getExperiment();
        return new long[]{((Long) experiment.getParam(Const.APOLLO_REFRESH_WIFI_PARAM_SCAN_INTERVAL, 15L)).longValue() * 1000, ((Long) experiment.getParam(Const.APOLLO_REFRESH_WIFI_PARAM_RECEIVE_TIME_EXPIRED_INTERVAL, 120L)).longValue() * 1000, ((Long) experiment.getParam(Const.APOLLO_REFRESH_WIFI_PARAM_SCAN_RESULT_TIME_EXPIRED_INTERVAL, 0L)).longValue() * 1000};
    }

    public boolean isCellRssiOptmAllowed() {
        return Apollo.getToggle("locsdk_cell_rssi_optm").allow();
    }

    public boolean isDidiNlpRequestRertyOptmEnabled() {
        IToggle toggle = Apollo.getToggle("locsdk_didinlp_request_optm");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("optm_retry", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public boolean isDidiNlpRequestQueueOptmEnabled() {
        IToggle toggle = Apollo.getToggle("locsdk_didinlp_request_optm");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("optm_queue", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public boolean supportRequestDIDINLPOnce() {
        return Apollo.getToggle("locsdk_support_request_didinlp_once").allow();
    }

    public int getResultSamplePercent() {
        IToggle toggle = Apollo.getToggle("locsdk_global_result_sampling");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("percent", 50)).intValue();
        }
        return 50;
    }

    public boolean pickUpPageEventTrackingSwitcher() {
        return Apollo.getToggle("global_map_pickup_point_trackevent_toggle").allow();
    }
}
