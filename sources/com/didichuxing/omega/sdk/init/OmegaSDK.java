package com.didichuxing.omega.sdk.init;

import android.content.Context;
import com.didichuxing.omega.sdk.Omega;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import java.util.Map;

public class OmegaSDK extends Omega {
    public static void enableSaveNaitveLogcat() {
    }

    protected static void launchAnrModule(Context context) {
    }

    protected static void launchApmModule(Context context) {
    }

    protected static void launchNativeCrashModuleV2() {
    }

    public static void launchNetMonitorModule(Context context) {
    }

    public static boolean setBizConfig(String str) {
        return false;
    }

    public static void setCdnMonitorEnable(boolean z) {
    }

    public static void setMaxAnrUploadPerDay(int i) {
    }

    public static void setMaxLagUploadPerDay(int i) {
    }

    public static void setMaxNativeCrashUploadPerDay(int i) {
    }

    public static void setNetMonitorInterval(int i) {
    }

    public static void setNetMonitorUploadUrl(String str) {
    }

    public static void setSocketTrafficEnable(boolean z) {
    }

    public static void switchApmNet(boolean z) {
    }

    public static void switchApmUI(boolean z) {
    }

    public static void switchApmUploadNetErrDiag(boolean z) {
    }

    public static void switchApmUploadNetPerf(boolean z) {
    }

    public static void trackHttpTransactionEvent(Map<String, Object> map) {
    }

    public static void trackSocketConnectionEvent(Map<String, Object> map) {
    }

    public static void trackSocketTransactionEvent(Map<String, Object> map) {
    }

    public static void gpsRegister(Map<String, Object> map) {
        trackEvent("omega_gps_register", map);
    }

    public static void gpsUnregister(Map<String, Object> map) {
        trackEvent("omega_gps_unregister", map);
    }

    public static void setFPSDetectInterval(long j) {
        OmegaConfig.FPS_DETECT_INTERVAL = j;
    }

    public static void setLatestFPSCacheNum(int i) {
        OmegaConfig.FPS_LATEST_CACHE_NUM = i;
    }

    public static void setFPSDetectIntervalForAnrTrace(long j) {
        OmegaConfig.FPS_DETECT_INTERVAL_FOR_ANR_TRACE = j;
    }

    public static void setLagTime(long j) {
        OmegaConfig.LAG_TIME = j;
    }

    public static void setAnrFilterReg(String str) {
        OmegaConfig.ANR_FILTER_REG = str;
    }

    public static void setNetDiagMemoryCacheEnable(boolean z) {
        OmegaConfig.NET_DIAG_USE_MEMORY_CACHE = z;
    }

    public static void setAutoEventInputEnable(boolean z) {
        OmegaConfig.SWITCH_ATUO_EVENT_INPUT = z;
    }

    public static void setLocationBackgroundEnable(boolean z) {
        OmegaConfig.SWITCH_PUT_LOCATION_BACKGROUND = z;
    }
}
