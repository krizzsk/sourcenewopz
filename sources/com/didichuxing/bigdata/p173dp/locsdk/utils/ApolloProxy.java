package com.didichuxing.bigdata.p173dp.locsdk.utils;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.utils.ApolloProxy */
public class ApolloProxy {

    /* renamed from: a */
    private static final String f46165a = "LOC_ApolloProxy ";

    /* renamed from: b */
    private static String f46166b = "ddlocsdk_inner_toggle_demo";

    /* renamed from: c */
    private static ApolloProxy f46167c;

    /* renamed from: d */
    private boolean f46168d = false;

    /* renamed from: e */
    private boolean f46169e = false;

    private ApolloProxy() {
        m33152a();
    }

    public static synchronized ApolloProxy getInstance() {
        ApolloProxy apolloProxy;
        synchronized (ApolloProxy.class) {
            if (f46167c == null) {
                f46167c = new ApolloProxy();
            }
            apolloProxy = f46167c;
        }
        return apolloProxy;
    }

    /* renamed from: a */
    private void m33152a() {
        IToggle toggle = Apollo.getToggle("map_common_loc_hms_mock_check_toggle");
        if (toggle == null || !toggle.allow()) {
            this.f46169e = false;
            DLog.m32737d("LOC_ApolloProxy map_common_loc_hms_mock_check_toggle NOT allow");
            return;
        }
        this.f46169e = true;
        DLog.m32737d("LOC_ApolloProxy map_common_loc_hms_mock_check_toggle allow");
    }

    public boolean getIsCheckMockViaSystem() {
        return this.f46169e;
    }

    public void setToggleName(String str) {
        f46166b = str;
    }

    public long[] requestNLPRequestParams() {
        IToggle toggle = Apollo.getToggle(Const.APOLLO_NLP_REQUEST_CONFIGURE);
        if (!toggle.allow()) {
            return null;
        }
        IExperiment experiment = toggle.getExperiment();
        return new long[]{((Long) experiment.getParam(Const.APOLLO_NLP_REQUEST_CONFIGURE_PARAM_NORMAL_INTERVAL, 20L)).longValue() * 1000, ((Long) experiment.getParam(Const.APOLLO_NLP_REQUEST_CONFIGURE_PARAM_FUSION_INTERVAL, 10L)).longValue() * 1000};
    }

    public long requestUploadTraceInterval() {
        IToggle toggle = Apollo.getToggle("locsdk_upload_trace_interval");
        if (toggle.allow()) {
            return ((Long) toggle.getExperiment().getParam("locsdk_upload_trace_interval_value", 1800000L)).longValue();
        }
        return 1800000;
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

    public boolean isNTPAdjustLocTimeEnabled() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_ntp_enabled");
        return toggle.allow() && "1".equals(toggle.getExperiment().getParam("adjust_loc_time", "0"));
    }

    public boolean isNTPAdjustLocTimeWhenLocCreate() {
        IToggle toggle = Apollo.getToggle("ddlocsdk_ntp_enabled");
        return toggle.allow() && "1".equals(toggle.getExperiment().getParam("adjust_loc_time_moment", "0"));
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

    public boolean enableInertialVDRAsNormal() {
        IToggle toggle = Apollo.getToggle("vdrsdk_inertial_as_normal_loc");
        if ((toggle.allow() ? ((Integer) toggle.getExperiment().getParam("enable", 0)).intValue() : 0) > 0) {
            return true;
        }
        return false;
    }

    public boolean isStatGpsEnabled() {
        return Apollo.getToggle("locsdk_stat_navi_gps").allow();
    }

    public boolean isStatGpsWeakEnabled() {
        IToggle toggle = Apollo.getToggle("locsdk_stat_navi_gps");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("stat_weak_enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public boolean isStatGpsUnavailableEnabled() {
        IToggle toggle = Apollo.getToggle("locsdk_stat_navi_gps");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("stat_unavailable_enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public int getNaviCollectionGroup() {
        IToggle toggle = Apollo.getToggle("driver_navigation_data_collection_toggle");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("group", 0)).intValue();
        }
        return 0;
    }

    public boolean getNaviOpenEvaluation() {
        return Apollo.getToggle("driver_navigation_open_evaluation").allow();
    }

    public boolean justifyStartAtStopErr() {
        return Apollo.getToggle("didisdk_start_stop_control_flag").allow();
    }

    public long[] requestContinuousLocParams() {
        IToggle toggle = Apollo.getToggle("location_continuous_optimize_toggle");
        if (!toggle.allow()) {
            return null;
        }
        IExperiment experiment = toggle.getExperiment();
        long[] jArr = new long[2];
        String str = (String) experiment.getParam("gps2network_interval", String.valueOf(30));
        String str2 = (String) experiment.getParam("wifi2cell_interval", "0");
        try {
            jArr[0] = Long.parseLong(str) * 1000;
            jArr[1] = Long.parseLong(str2) * 1000;
            return jArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isAllowLowPowerGPSMode() {
        return Apollo.getToggle(Const.APOLLO_ALLOW_LOW_POWER_GPS_MODE).allow();
    }

    public float getDirectNotifyIntervalRate() {
        IToggle toggle = Apollo.getToggle("locsdk_direct_notify_interval_rate");
        if (toggle == null || !toggle.allow()) {
            return 0.95f;
        }
        return ((Float) toggle.getExperiment().getParam("rate", Float.valueOf(0.95f))).floatValue();
    }

    public long[] requestFilterGPSParams() {
        IToggle toggle = Apollo.getToggle("locsdk_filter_wrong_timestamp_jump_gps");
        if (!toggle.allow()) {
            return null;
        }
        IExperiment experiment = toggle.getExperiment();
        return new long[]{((Long) experiment.getParam("interval_more_than_actual", 1800000L)).longValue(), ((Long) experiment.getParam("jump_speed", 200L)).longValue()};
    }

    public static long[] requestRefreshWifiParams() {
        IToggle toggle = Apollo.getToggle(Const.APOLLO_REFRESH_WIFI);
        if (!toggle.allow()) {
            return null;
        }
        IExperiment experiment = toggle.getExperiment();
        return new long[]{((Long) experiment.getParam(Const.APOLLO_REFRESH_WIFI_PARAM_SCAN_INTERVAL, 15L)).longValue() * 1000, ((Long) experiment.getParam(Const.APOLLO_REFRESH_WIFI_PARAM_RECEIVE_TIME_EXPIRED_INTERVAL, 120L)).longValue() * 1000, ((Long) experiment.getParam(Const.APOLLO_REFRESH_WIFI_PARAM_SCAN_RESULT_TIME_EXPIRED_INTERVAL, 0L)).longValue() * 1000};
    }

    public boolean isGlobalDIDINLPAllowed() {
        return Apollo.getToggle("locsdk_global_didinlp_enabled").allow();
    }

    public boolean isGlobalDIDINLPReplacementStrategyAllowed() {
        IToggle toggle = Apollo.getToggle("locsdk_global_didinlp_strategy");
        return toggle.allow() && "true".equalsIgnoreCase((String) toggle.getExperiment().getParam("replace_googleflp", SDKConsts.BOOLEAN_FALSE));
    }

    public boolean isGlobalDIDINLPReplacementStrategyCheckBearing() {
        IToggle toggle = Apollo.getToggle("locsdk_global_didinlp_strategy");
        return toggle.allow() && 1 == ((Integer) toggle.getExperiment().getParam("check_bearing", 1)).intValue();
    }

    public long getGlobalDIDINLPReplacementStrategyMinDuration() {
        IToggle toggle = Apollo.getToggle("locsdk_global_didinlp_strategy");
        if (toggle.allow()) {
            return ((Long) toggle.getExperiment().getParam("replace_googleflp_min_duration_ms", 120000L)).longValue();
        }
        return 120000;
    }

    public Set<String> getGlobalDIDINLPReplacementStrategyWifiList() {
        String[] split;
        HashSet hashSet = new HashSet();
        IToggle toggle = Apollo.getToggle("locsdk_global_didinlp_strategy");
        if (toggle.allow()) {
            String str = (String) toggle.getExperiment().getParam("replace_wifi", "");
            if (!TextUtils.isEmpty(str) && (split = str.split(";")) != null && split.length > 0) {
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2)) {
                        hashSet.add(str2.trim().toLowerCase());
                    }
                }
            }
        }
        return hashSet;
    }

    public int getGlobalDIDINLPStatPercent() {
        IToggle toggle = Apollo.getToggle("locsdk_global_didinlp_strategy");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("stat_percent", 0)).intValue();
        }
        return 0;
    }

    public int getDIDINLPStatRequestPercent() {
        IToggle toggle = Apollo.getToggle("locsdk_didinlp_stat_request");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("stat_percent", 0)).intValue();
        }
        return 0;
    }

    public boolean isAlwaysScanWifiAllowed() {
        return Apollo.getToggle("locsdk_always_scan_wifi").allow();
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

    public boolean usePathLogger() {
        return Apollo.getToggle("locsdk_use_path_logger").allow();
    }

    public int getResultSamplePercent() {
        IToggle toggle = Apollo.getToggle("locsdk_global_result_sampling");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("percent", 50)).intValue();
        }
        return 50;
    }

    public boolean supportLogBamaiUnencrypt() {
        return Apollo.getToggle("didisdk_write_unencrypt_log").allow();
    }

    public int getDataSourceFilterType() {
        IToggle toggle = Apollo.getToggle("global_locsdk_source_priority");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("type", 0)).intValue();
        }
        return 0;
    }

    public boolean supportLogBamaiInDetail() {
        return Apollo.getToggle("locsdk_log_bamai_in_detail").allow();
    }

    public boolean supportRequestDIDINLPOnce() {
        return Apollo.getToggle("locsdk_support_request_didinlp_once").allow();
    }
}
