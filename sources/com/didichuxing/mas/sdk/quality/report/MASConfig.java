package com.didichuxing.mas.sdk.quality.report;

import androidx.work.PeriodicWorkRequest;
import com.didichuxing.mas.sdk.quality.report.customevent.CustomEventMap;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import global.didi.pay.presenter.GlobalBubbleShowHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MASConfig {
    public static int ACTIVITY_QUEUE_MAX_LEN = 10;
    public static final int ANR_LOG_FILE_LENGTH = 3145728;
    public static String APP_ISSUE = "";
    public static long APP_USAGE_STAT_INTERVAL = 10000;
    public static int ASYNC_INIT_DELAY = 300;
    public static int BACKEND_THREAD_RUN_INTERVAL = 900000;
    public static boolean BAN_LOGCAT_UPLOAD = true;
    public static long CAL_START_INTERVEL = 30000;
    public static float CRASH_SCREENSHOT_SCALE = 0.38f;
    public static String CUSTOM_APP_NAME = "";
    public static String CUSTOM_APP_VERSION = "";
    public static boolean DEBUG_MODEL = false;
    public static String DEBUG_TEMP_OMEGA_ID = null;
    public static long DEFAULT_SIZE_DIVIDE_HPROF = 10485760;
    public static float ENABLE_RATE = 1.0f;
    public static long EVENT_SEND_QUEUE_MAX_DELAY = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
    public static long EVENT_SEND_QUEUE_MAX_DELAY_MULTIPLE_APP_OUT = 6;
    public static int EVENT_SEND_QUEUE_MAX_NUMBER = 50;
    public static int EX_LOW_BATTERY_THRESHOLD = 5;
    public static boolean EX_SWITCH_BATTERY_MONITOR = false;
    public static long FD_INFO_REPORT_LINE_LIMIT_NUM = 1000;
    public static long FPS_DETECT_INTERVAL = 60000;
    public static long FPS_DETECT_INTERVAL_FOR_ANR_TRACE = 1000;
    public static int FPS_LATEST_CACHE_NUM = 60;
    public static long HOTPATCH_VERSION = -1;
    public static int HTTP_SENDER_RETRY_TIMES = 1;
    public static boolean IS_INIT = false;
    public static long LAG_TIME = 3000;
    public static boolean LIMIT_CURRENT_PID_LOGCAT_UPLOAD = false;
    public static boolean LOGCAT_ONLY_MY_APP = false;
    public static int LOGCAT_TAIL_COUNT = 300;
    public static int LOGCAT_TAIL_MAX_COUNT = 1000;
    public static boolean LOG_PAGE_DURATION = false;
    public static boolean LOG_PRINT = true;
    public static String MAS_SDK_VERSION = "1.0";
    public static int MAX_NET_CACHE_SIZE = 500;
    public static long MOMENT_ID_INTERVAL = 1800000;
    public static long NATIVE_CRASH_EXPIRE_MS = GlobalBubbleShowHelper.ONE_WEEK;
    public static boolean NATIVE_CRASH_SAVE_LOGCAT = false;
    public static boolean NET_DIAG_USE_MEMORY_CACHE = true;
    public static final String NO_RESULT = "";
    public static String OMEGA_OAID = "";
    public static String OMEGA_SDK_VERSION = "";
    public static double OMGVI_DELAY_TIME = 300.0d;
    public static boolean OPEN_DUMP_MEMORY_FD_THREAD_PROCESS_INFO = false;
    public static int PIC_COMPRESS_QUALITY = 70;
    public static float PIC_IMAGE_SIZE = 1080.0f;
    public static List<String> PPH_FH_PH_CP_BLACK_LIST = null;
    public static final String[] PREDEFINED_HTTP_TRANSACTION_KEYS = {"url", "time", Constants.STATE_CODE, Constants.ERROR_CODE, "down", "up"};
    public static boolean PRE_INIT_ANR = false;
    public static final String PROTOCOL_HTTP = "http://";
    public static final String PROTOCOL_HTTPS = "https://";
    public static long RECORD_EXPIRE_MS = GlobalBubbleShowHelper.ONE_WEEK;
    public static int[] SAFE_BATTERY_THRESHOLD = {5, 10, 20};
    public static long SAFE_SIGNAL_DURATION = 30000;
    public static double SCREENSHOT_SAMPLE_RATE = 0.001d;
    public static long SIZE_DIVIDE_DUMP_FILE = 10485760;
    public static long SNIPER_BG_WAIT_TIME = 15000;
    public static boolean SWITCH_APP_USAGE_STAT = false;
    public static boolean SWITCH_ATUO_EVENT_INPUT = false;
    public static boolean SWITCH_CRASH = true;
    public static boolean SWITCH_EVENT = true;
    public static boolean SWITCH_EVENT_PERSISTENT = true;
    public static boolean SWITCH_FULL_AUTO_UI = true;
    public static boolean SWITCH_FULL_AUTO_UI_ENV = true;
    public static boolean SWITCH_H5_HIJACK = false;
    public static boolean SWITCH_NATIVE_DUMP_MAP = false;
    public static boolean SWITCH_OMG_HOURLY = true;
    public static boolean SWITCH_OMG_SNIPER = false;
    public static boolean SWITCH_OOM_DUMP = false;
    public static boolean SWITCH_PRINT_TRACE_LOG = false;
    public static boolean SWITCH_PUT_LOCATION_BACKGROUND = true;
    public static boolean SWITCH_SAFE_BATTERY = false;
    public static long SWITCH_SAFE_FREQUENCY = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    public static boolean SWITCH_SAFE_POLLING = false;
    public static boolean SWITCH_SAFE_SIGNAL = false;
    public static boolean SWITCH_SAVED_STATE_SYNC = false;
    public static boolean SWITCH_SCREENSHOT = false;
    public static boolean SWITCH_SYNC = true;
    public static boolean SWITCH_UPLOAD_HPROF = false;
    public static boolean SWITCH_UPLOAD_OOM_DUMP = false;
    public static boolean SWITCH_USE_HTTPS = true;
    public static final long SYNC_NETWORK_ERROR_RETRY_DELAY = 600000;
    public static int SYNC_REMOTE_INTERVAL = 3600000;
    public static boolean TIMEOUT_EXCEPTION_CRASH_CATCH = true;
    public static String TOAST_CRASH_TEXT = null;
    public static String UPLOAD_CDN_PATH = OmegaConfig.UPLOAD_CDN_PATH;
    public static String UPLOAD_CRASH_PATH = "/api/crash/android";
    public static String UPLOAD_EVENTS_DEBUG_PATH = OmegaConfig.UPLOAD_EVENTS_DEBUG_PATH;
    public static String UPLOAD_EVENTS_PATH = OmegaConfig.UPLOAD_EVENTS_PATH;
    public static String UPLOAD_HOST = "omgup.didiglobal.com";
    public static String UPLOAD_REALTIME_PATH = OmegaConfig.UPLOAD_REALTIME_PATH;
    public static String UPLOAD_SYNC_PATH = OmegaConfig.UPLOAD_SYNC_PATH;
    public static int UPPER_LIMIT_ANR_EVENT_PER_DAY = 10;
    public static int UPPER_LIMIT_CRASH_EVENT_PER_DAY = 150;
    public static int UPPER_LIMIT_LAG_EVENT_PER_DAY = 10;
    public static int UPPER_LIMIT_NATIVE_CRASH_EVENT_PER_DAY = 10;
    public static long VALIDITY_PERIOD_DUMP_FILE = 86400000;
    public static List<String> blackList = new ArrayList();
    public static int cityIdFromH5 = 0;
    public static CustomEventMap customEventMap;
    public static IGetChannel iGetChannel;
    public static IGetCityId iGetCityId;
    public static IGetCountryId iGetCountryId;
    public static IGetDailingCountryCode iGetDailingCountryCode;
    public static IGetDidiDeviceId iGetDidiDeviceId;
    public static IGetDidiSuuid iGetDidiSuuid;
    public static IGetDidiToken iGetDidiToken;
    public static IGetExtraParams iGetExtraParams;
    public static IGetHotPatchVersion iGetHotPatchVersion;
    public static IGetPhone iGetPhone;
    public static IGetPluginInfo iGetPluginInfo;
    public static IGetTimeOffset iGetTimeOffset;
    public static IGetUiCid iGetUiCid;
    public static IGetUid iGetUid;
    public static IGetUploadURLWhiteList iGetUploadURLWhiteList;
    public static ILocale iLocale = null;
    public static ILocation iLocation;
    public static ILocationConfig iLocationConfig;
    public static boolean isUnwind = false;
    public static String phoneNumberFromH5 = null;
    public static String userIdFromH5 = "";

    public interface IGetChannel {
        String getChannel();
    }

    public interface IGetCityId {
        int getCityId();
    }

    public interface IGetCountryId {
        int getCountryId();
    }

    public interface IGetDailingCountryCode {
        String getDailingCountryCode();
    }

    public interface IGetDidiDeviceId {
        String getDidiDeviceId();
    }

    public interface IGetDidiSuuid {
        String getDidiSuuid();
    }

    public interface IGetDidiToken {
        String getDidiToken();
    }

    public interface IGetExtraParams {
        Map<String, Object> getExtraParams();
    }

    public interface IGetHotPatchVersion {
        long getHotPatchVersion();
    }

    public interface IGetPhone {
        String getPhone();
    }

    public interface IGetPluginInfo {
        String getPluginInfo();
    }

    public interface IGetTimeOffset {
        long getTimeOffset();
    }

    public interface IGetUiCid {
        String getUiCid();
    }

    public interface IGetUid {
        String getUid();
    }

    public interface IGetUploadURLWhiteList {
        List<String> getURLWhiteList();
    }

    public interface ILocale {
        String getLocale();
    }

    public interface ILocation {
        double[] getLocation();
    }

    public interface ILocationConfig {
        boolean isNeedUploadLocation();
    }

    public static void setUnwindUser(boolean z) {
        isUnwind = z;
    }

    public static void addBlackPages(List<String> list) {
        blackList.addAll(list);
    }

    public static void addCustomEvent(String str, String str2, String str3, boolean z) {
        CustomEventMap customEventMap2 = customEventMap;
        if (customEventMap2 != null) {
            customEventMap2.addCustomEvent(str, str2, str3, z);
        }
    }

    public static void removeCustomEvent(String str, String str2) {
        CustomEventMap customEventMap2 = customEventMap;
        if (customEventMap2 != null) {
            customEventMap2.removeCustomEvent(str, str2);
        }
    }
}
