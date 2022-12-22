package com.didi.hawaii.utils;

import android.os.Build;
import com.didi.hawaii.log.HWLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class OmegaUtils {
    private static final String HAWAII_MAP_EXCEPTION = "hawaii_map_exception";
    public static final String HW_DEL_OLD_LOG_FILE = "hw_del_old_log_file";
    public static final String HW_MAP_HAWAII_SDK_BUBBLE_EXCEPTION = "tech_map_hawaii_sdk_bubble_exception";
    public static final String HW_SDCARD_CHANGE = "HW_SDCARD_CHANGE";
    public static final String HW_SDCARD_CHANGE_AFTER = "sd_path_after ";
    public static final String HW_SDCARD_CHANGE_BEFORE = "sd_path_before";
    private static final String SHARE_CONTEXT_EXCEPTION = "share_context_exception";
    public static final String TECH_MAP_HAWAII_SDK_REQ_FREQ_MONITOR = "tech_map_hawaii_sdk_req_freq_monitor";

    public static void trackSDCardChange(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(HW_SDCARD_CHANGE_BEFORE, str);
        hashMap.put(HW_SDCARD_CHANGE_AFTER, str2);
        OmegaSDKAdapter.trackEvent(HW_SDCARD_CHANGE, (Map<String, Object>) hashMap);
    }

    public static void trackShareContextException(String str) {
        HWLog.m16760e(1, "glSurfaceView", "exception: " + str);
        HashMap hashMap = new HashMap();
        hashMap.put("error_msg", str);
        OmegaSDKAdapter.trackEvent(SHARE_CONTEXT_EXCEPTION, (Map<String, Object>) hashMap);
    }

    public static void trackMapException(String str) {
        HWLog.m16760e(1, "glSurfaceView create", "exception: " + str);
        HashMap hashMap = new HashMap();
        hashMap.put("error_msg", str);
        OmegaSDKAdapter.trackEvent(HAWAII_MAP_EXCEPTION, (Map<String, Object>) hashMap);
    }

    public static void trackDelOldLogFilesNum(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("del_file_nums", str);
        OmegaSDKAdapter.trackEvent(HW_DEL_OLD_LOG_FILE, (Map<String, Object>) hashMap);
    }

    public static void reportRequestLimit(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        OmegaSDKAdapter.trackEvent(TECH_MAP_HAWAII_SDK_REQ_FREQ_MONITOR, (Map<String, Object>) hashMap);
    }

    public static void reportBubbleException(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("bubbleExceptionInfo", str);
        OmegaSDKAdapter.trackEvent(HW_MAP_HAWAII_SDK_BUBBLE_EXCEPTION, (Map<String, Object>) hashMap);
    }

    public static void reportTextureView() {
        HashMap hashMap = new HashMap();
        hashMap.put("phone_model", Build.MODEL);
        OmegaSDKAdapter.trackEvent("tech_hawaii_android_use_textureview", (Map<String, Object>) hashMap);
    }
}
