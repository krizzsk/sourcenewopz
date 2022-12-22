package com.didichuxing.omega.sdk.common;

import android.app.ActivityManager;
import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.omega.sdk.common.collector.PackageCollector;
import com.xiaojuchefu.prism.monitor.PrismMonitor;

public class OmegaSetting {
    public static final String OMEGA_AUTOANALYTICS_FILTER_ANDROID = "omega_autoanalytics_filter_android_global";
    public static final String OMEGA_EVENT_PARAM_BLACK_LIST_ANDROID = "omega_event_param_black_list_android_global";
    public static final String OMEGA_PRISM_EVENT_BLACK_PHONE_LIST = "omega_prism_event_black_phone_list_android_global";
    public static final String OMEGA_SECURITY_CHECK_ANDROID = "omega_security_check_global_android";
    public static final String SWITCH_OMEGA_ENENT_TRACK_PRISM = "omega_autoanalytics_newedition_android_global";
    public static final String SWITCH_OMEGA_TRACKER_NEWEDITION = "omega_tracker_newedition_android_global";
    static final String UPLOAD_HOST = "omgup.didiglobal.com";

    static boolean isNormalHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("omgup.didiglobal.com".equals(str) || "omgup-de.didiglobal.com".equals(str) || "omgup-ru.didiglobal.com".equals(str) || "omgup-g.didiglobal.com".equals(str) || "omgup-us.didiglobal.com".equals(str) || "omgup.liggyglobal.com".equals(str) || "omgup.linkeeglobal.com".equals(str) || "omgup.99taxis.mobi".equals(str)) {
            return true;
        }
        return false;
    }

    public static String getUploadEventsUrl() {
        String str = "https://";
        if (OmegaConfig.DEBUG_MODEL) {
            StringBuilder sb = new StringBuilder();
            if (!OmegaConfig.SWITCH_USE_HTTPS) {
                str = "http://";
            }
            sb.append(str);
            sb.append(OmegaConfig.getUploadHost());
            sb.append(OmegaConfig.UPLOAD_EVENTS_DEBUG_PATH);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        if (!OmegaConfig.SWITCH_USE_HTTPS) {
            str = "http://";
        }
        sb2.append(str);
        sb2.append(OmegaConfig.getUploadHost());
        sb2.append(OmegaConfig.UPLOAD_EVENTS_PATH);
        return sb2.toString();
    }

    public static String getUploadCrashUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(OmegaConfig.SWITCH_USE_HTTPS ? "https://" : "http://");
        sb.append(OmegaConfig.getUploadHost());
        sb.append("/api/crash/android");
        sb.append("?an=");
        sb.append(OmegaConfig.CUSTOM_APP_NAME);
        sb.append("&nav=");
        sb.append(OmegaConfig.APP_ISSUE);
        sb.append("&av=");
        sb.append(PackageCollector.getVN());
        return sb.toString();
    }

    public static String getUploadSyncUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(OmegaConfig.SWITCH_USE_HTTPS ? "https://" : "http://");
        sb.append(OmegaConfig.getUploadHost());
        sb.append(OmegaConfig.UPLOAD_SYNC_PATH);
        sb.append("/");
        sb.append(OmegaConfig.CUSTOM_APP_NAME);
        return sb.toString();
    }

    public static String getUploadCNDUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(OmegaConfig.SWITCH_USE_HTTPS ? "https://" : "http://");
        sb.append(OmegaConfig.getUploadHost());
        sb.append(OmegaConfig.UPLOAD_CDN_PATH);
        sb.append("/");
        sb.append(OmegaConfig.CUSTOM_APP_NAME);
        return sb.toString();
    }

    public static String getRealtimeUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(OmegaConfig.SWITCH_USE_HTTPS ? "https://" : "http://");
        sb.append(OmegaConfig.getUploadHost());
        sb.append(OmegaConfig.UPLOAD_REALTIME_PATH);
        return sb.toString();
    }

    public static void initOmegaSetting() {
        if (OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
            PrismMonitor.getInstance().setBlackPhoneToggle(OMEGA_PRISM_EVENT_BLACK_PHONE_LIST);
            PrismMonitor.getInstance().setPhoneBrand(Build.BRAND);
            PrismMonitor.getInstance().setPhoneModel(Build.MODEL);
            if (Build.VERSION.SDK_INT >= 16) {
                try {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) PrismMonitor.getInstance().mApplication.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    PrismMonitor.getInstance().setTotalMem(memoryInfo.totalMem);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
