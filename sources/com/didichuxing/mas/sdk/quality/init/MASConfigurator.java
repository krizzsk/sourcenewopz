package com.didichuxing.mas.sdk.quality.init;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.collect.analysis.AnalysisAppListener;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.CdnDetectAnalysis;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.config.CdnDetectConfig;
import com.didichuxing.mas.sdk.quality.collect.crash.CrashHandler;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.DiDiApm;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.SocketEventAnalysis;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.config.SocketConfig;
import com.didichuxing.mas.sdk.quality.collect.lag.OmegaLag;
import com.didichuxing.mas.sdk.quality.collect.perfromacedetect.OmegaPerformanceDetect;
import com.didichuxing.mas.sdk.quality.collect.perfromacedetect.PerformanceDetectConfig;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.TrafficStatAnalysis;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.config.TagConfig;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.config.TrafficConfig;
import com.didichuxing.mas.sdk.quality.collect.xcrash.XCrashHelper;
import com.didichuxing.mas.sdk.quality.init.IMASToggleService;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.backend.ActivityLifecycleRegister;
import com.didichuxing.mas.sdk.quality.report.backend.BackendThread;
import com.didichuxing.mas.sdk.quality.report.backend.BatteryChangeReceiver;
import com.didichuxing.mas.sdk.quality.report.customevent.CustomEventMap;
import com.didichuxing.mas.sdk.quality.report.customevent.CustomKeys;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import com.didichuxing.mas.sdk.quality.report.safe.SafetyEditTextSDK;
import com.didichuxing.mas.sdk.quality.report.safe.SafetyManager;
import com.didichuxing.mas.sdk.quality.report.safe.SafetyMenuPowerSDK;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.google.gson.Gson;
import com.kwai.koom.javaoom.KOOM;
import com.kwai.koom.javaoom.common.KConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import p242io.socket.engineio.client.transports.Polling;

public class MASConfigurator {

    /* renamed from: A */
    private static final String f48251A = "enable";
    /* access modifiers changed from: private */

    /* renamed from: B */
    public static boolean f48252B = false;

    /* renamed from: C */
    private static boolean f48253C = false;

    /* renamed from: D */
    private static boolean f48254D = false;

    /* renamed from: E */
    private static boolean f48255E = false;

    /* renamed from: F */
    private static boolean f48256F = false;

    /* renamed from: G */
    private static boolean f48257G = false;

    /* renamed from: H */
    private static boolean f48258H = false;

    /* renamed from: a */
    private static final AtomicBoolean f48259a = new AtomicBoolean(false);

    /* renamed from: b */
    private static final String f48260b = "MASConfigurator";

    /* renamed from: c */
    private static final String f48261c = "mas_quality";

    /* renamed from: d */
    private static final String f48262d = "enable_new";

    /* renamed from: e */
    private static final String f48263e = "native_crash_daily_report_limit";

    /* renamed from: f */
    private static final String f48264f = "anr_daily_report_limit";

    /* renamed from: g */
    private static final String f48265g = "lag_daily_report_limit";

    /* renamed from: h */
    private static final String f48266h = "fd_info_report_line_limit";

    /* renamed from: i */
    private static final String f48267i = "mas_oom";

    /* renamed from: j */
    private static final String f48268j = "mas_dump_census_memory_fd_thread_process_info";

    /* renamed from: k */
    private static final String f48269k = "Mas_Custom_Up_Config";

    /* renamed from: l */
    private static final String f48270l = "custom_keys";

    /* renamed from: m */
    private static final String f48271m = "max_value_byte_size";

    /* renamed from: n */
    private static final String f48272n = "MAS_Limit_Current_PID_Logcat_Upload";

    /* renamed from: o */
    private static final String f48273o = "mas_uploadreport_url";

    /* renamed from: p */
    private static final String f48274p = "upload_events_debug_path";

    /* renamed from: q */
    private static final String f48275q = "upload_events_path";

    /* renamed from: r */
    private static final String f48276r = "upload_crash_path";

    /* renamed from: s */
    private static final String f48277s = "upload_sync_path";

    /* renamed from: t */
    private static final String f48278t = "upload_cdn_path";

    /* renamed from: u */
    private static final String f48279u = "upload_realtime_path";

    /* renamed from: v */
    private static final String f48280v = "upload_host";

    /* renamed from: w */
    private static final String f48281w = "mas_not_report_native_crash";

    /* renamed from: x */
    private static final String f48282x = "mas_not_report_anr";

    /* renamed from: y */
    private static final String f48283y = "mas_not_report_lag";

    /* renamed from: z */
    private static final String f48284z = "mas_native_dump_map";

    /* renamed from: a */
    private static void m34412a(Application application) {
        try {
            KOOM.init(application);
            KOOM.getInstance().setKConfig(new KConfig.KConfigBuilder().rootDir(RecordStorage.getRecordDir().getAbsolutePath()).heapOverTimes(2).build());
            MASConfig.SWITCH_UPLOAD_OOM_DUMP = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m34413a(Application application, IMASToggleService iMASToggleService) {
        Application application2 = application;
        final IMASToggleService iMASToggleService2 = iMASToggleService;
        BatteryChangeReceiver.init(application);
        BackendThread.getInstance().init(application2);
        CrashHandler.getInstance().init();
        if (iMASToggleService2.allow(f48273o)) {
            MASConfig.UPLOAD_HOST = (String) iMASToggleService2.getParams(f48273o, f48280v, MASConfig.UPLOAD_HOST);
            MASConfig.UPLOAD_EVENTS_DEBUG_PATH = (String) iMASToggleService2.getParams(f48273o, f48274p, MASConfig.UPLOAD_EVENTS_DEBUG_PATH);
            MASConfig.UPLOAD_EVENTS_PATH = (String) iMASToggleService2.getParams(f48273o, f48275q, MASConfig.UPLOAD_EVENTS_PATH);
            MASConfig.UPLOAD_CRASH_PATH = (String) iMASToggleService2.getParams(f48273o, f48276r, MASConfig.UPLOAD_CRASH_PATH);
            MASConfig.UPLOAD_SYNC_PATH = (String) iMASToggleService2.getParams(f48273o, f48277s, MASConfig.UPLOAD_SYNC_PATH);
            MASConfig.UPLOAD_CDN_PATH = (String) iMASToggleService2.getParams(f48273o, f48278t, MASConfig.UPLOAD_CDN_PATH);
            MASConfig.UPLOAD_REALTIME_PATH = (String) iMASToggleService2.getParams(f48273o, f48279u, MASConfig.UPLOAD_REALTIME_PATH);
        }
        if (iMASToggleService2.allow(f48272n)) {
            MASConfig.BAN_LOGCAT_UPLOAD = false;
            MASConfig.LIMIT_CURRENT_PID_LOGCAT_UPLOAD = true;
        }
        if (iMASToggleService2.allow(f48267i) && ((Integer) iMASToggleService2.getParams(f48267i, f48251A, 0)).intValue() == 1) {
            m34412a(application);
        }
        if (iMASToggleService2.allow(f48284z)) {
            MASConfig.SWITCH_NATIVE_DUMP_MAP = true;
        }
        boolean z = !iMASToggleService2.allow(f48281w);
        if (z) {
            MASConfig.setUnwindUser(true);
            MASSDK.trackEvent("OMGUnwind");
            MASSDK.setMaxNativeCrashUploadPerDay(((Integer) iMASToggleService2.getParams(f48261c, f48263e, 10)).intValue());
        }
        boolean z2 = !iMASToggleService2.allow(f48282x);
        if (z2) {
            MASSDK.setMaxAnrUploadPerDay(((Integer) iMASToggleService2.getParams(f48261c, f48264f, 10)).intValue());
        }
        if (iMASToggleService2.allow(f48268j)) {
            MASSDK.setFdInfoReportLineLimitNum(((Integer) iMASToggleService2.getParams(f48268j, f48266h, 1000)).intValue());
            MASSDK.setOpenDumpMemoryFdThreadProcessInfo(((Integer) iMASToggleService2.getParams(f48268j, f48251A, 0)).intValue() == 1);
        }
        if (z || z2) {
            XCrashHelper.init(application2, z, z2);
        }
        if (!iMASToggleService2.allow(f48283y)) {
            MASSDK.setMaxLagUploadPerDay(((Integer) iMASToggleService2.getParams(f48261c, f48265g, 10)).intValue());
            MASSDK.setLagTime(3000);
            OmegaLag.getInstance().start(application2);
        }
        if (iMASToggleService2.allow(f48269k)) {
            try {
                MASConfig.customEventMap = new CustomEventMap((CustomKeys) new Gson().fromJson((String) iMASToggleService2.getParams(f48269k, f48270l, ""), CustomKeys.class), ((Integer) iMASToggleService2.getParams(f48269k, f48271m, 1024)).intValue());
            } catch (Exception e) {
                OLog.m34416d("[initQuality] Parse customKeyConfig error : " + e.getMessage());
            }
        }
        m34414a((Context) application, iMASToggleService);
        iMASToggleService2.addToggleStateChangeListener(new IMASToggleService.ToggleStateChangeListener() {
            public void onStateChanged() {
                if (MASConfigurator.f48252B) {
                    HashMap hashMap = new HashMap();
                    try {
                        JSONArray jSONArray = new JSONArray((String) iMASToggleService2.getParams("Omega_Http_Api_NP", "urlpaths", "[]"));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            if (string != null) {
                                hashMap.put(string, true);
                            }
                        }
                    } catch (Exception unused) {
                    }
                    if (iMASToggleService2.allow("Omega_Http_Api_NP_Sampling")) {
                        try {
                            JSONArray jSONArray2 = new JSONArray((String) iMASToggleService2.getParams("Omega_Http_Api_NP_Sampling", "urlpaths", "[]"));
                            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                String string2 = jSONArray2.getString(i2);
                                if (string2 != null) {
                                    hashMap.put(string2, true);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        DiDiApm.clearUploadUrlWhiteList();
                        DiDiApm.addUploadUrlWhiteListAll(hashMap);
                    }
                }
            }
        });
        boolean allow = iMASToggleService2.allow("omega_generic_traffic_stat");
        TrafficConfig.SWITCH_TRAFFIC_GENERAL_STAT = allow;
        if (!f48256F && allow) {
            f48256F = true;
            TrafficConfig.TRAFFIC_STAT_INTERVAL = ((Long) iMASToggleService2.getParams("omega_generic_traffic_stat", "traffic_stat_interval", 60000L)).longValue();
            TrafficConfig.TRAFFIC_UOLOAD_INTERVAL = ((Long) iMASToggleService2.getParams("omega_generic_traffic_stat", "traffic_upload_interval", 10L)).longValue();
            TrafficConfig.MAX_UPLOAD_LIMIT_PER_DAY = ((Integer) iMASToggleService2.getParams("omega_generic_traffic_stat", "traffic_max_upload", Integer.valueOf(TrafficConfig.DEFAULT_MAX_UPLOAD_LIMIT_PER_DAY))).intValue();
            TagConfig.setTagMapping((String) iMASToggleService2.getParams("omega_generic_traffic_stat", "tagMapList", "total:0;omega:1;"));
            TrafficStatAnalysis.getInstance().start(application2);
        }
        boolean allow2 = iMASToggleService2.allow("omega_socket_traffic");
        SocketConfig.SWITCH_SOCKET_TRANSACTION_STAT = allow2;
        if (!f48254D && allow2) {
            f48254D = true;
            int intValue = ((Integer) iMASToggleService2.getParams("omega_socket_traffic", "uploadLimitPerDay", Integer.valueOf(SocketConfig.DEFAULT_MAX_UPLOAD_LIMIT_PER_DAY))).intValue();
            long longValue = ((Long) iMASToggleService2.getParams("omega_socket_traffic", "uploadInterval", Long.valueOf(SocketConfig.DEFAULT_UPLOAD_INTERVAL))).longValue();
            long longValue2 = ((Long) iMASToggleService2.getParams("omega_socket_traffic", "fileExpirationTime", Long.valueOf(SocketConfig.DEFAULT_FILE_EXPIRATION_TIME))).longValue();
            boolean equals = ((String) iMASToggleService2.getParams("omega_socket_traffic", "openDiskCache", "on")).equals("on");
            long longValue3 = ((Long) iMASToggleService2.getParams("omega_socket_traffic", "writeDiskInterval", Long.valueOf(SocketConfig.DEFAULT_WRITE_DISK_INTERVAL))).longValue();
            SocketConfig.MAX_UPLOAD_LIMIT_PER_DAY = intValue;
            SocketConfig.UPLOAD_INTERVAL = longValue;
            SocketConfig.FILE_EXPIRATION_TIME = longValue2;
            SocketConfig.SOCKET_DISK_CACHE = equals;
            SocketConfig.WRITE_DISK_INTERVAL = longValue3;
            SocketEventAnalysis.getInstance().start(application2);
        }
        SocketConfig.SWITCH_SOCKET_CONNECTION_STAT = iMASToggleService2.allow("omega_socket_connection");
        boolean allow3 = iMASToggleService2.allow("omega_cdn_monitor");
        CdnDetectConfig.SWITCH_CDN_MONITOR = allow3;
        if (!f48255E && allow3) {
            f48255E = true;
            long longValue4 = ((Long) iMASToggleService2.getParams("omega_cdn_monitor", "cdnDetectInterval", Long.valueOf(CdnDetectConfig.DEFAULT_CND_DETECT_INTERVAL))).longValue();
            int intValue2 = ((Integer) iMASToggleService2.getParams("omega_cdn_monitor", "maxCdnDetectCount", Integer.valueOf(CdnDetectConfig.DEFAULT_MAX_CDN_DETECT_COUNT_PER_DAY))).intValue();
            int intValue3 = ((Integer) iMASToggleService2.getParams("omega_cdn_monitor", "sampleCountCdnDetect", Integer.valueOf(CdnDetectConfig.DEFAULT_SAMPLE_COUNT_CDN_DETECT))).intValue();
            boolean z3 = ((Integer) iMASToggleService2.getParams("omega_cdn_monitor", "detectCdnOnlyFirstStartPerDay", 1)).intValue() == 1;
            CdnDetectConfig.cdnDetectInterval = longValue4;
            CdnDetectConfig.maxCdnDetectCount = intValue2;
            CdnDetectConfig.sampleCountCdnDetect = intValue3;
            CdnDetectConfig.detectCdnOnlyFirstStartPerDay = z3;
            CdnDetectAnalysis.getInstance().start(application2);
        }
        MASConfig.SWITCH_SAVED_STATE_SYNC = iMASToggleService2.allow("omega_saved_state");
        MASConfig.SWITCH_OMG_HOURLY = !iMASToggleService2.allow("OMGHourly");
        if (f48253C || !iMASToggleService2.allow("app_monitor_config")) {
            Application application3 = application2;
        } else {
            f48253C = true;
            long longValue5 = ((Long) iMASToggleService2.getParams("app_monitor_config", "interval", Long.valueOf(PerformanceDetectConfig.DEFAULT_DETECT_INTERVAL))).longValue();
            boolean z4 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "cpu_monitor_enable", 0)).intValue() == 1;
            boolean z5 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "memory_monitor_enable", 0)).intValue() == 1;
            int intValue4 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "max_cpu_usage", Integer.valueOf(PerformanceDetectConfig.DEFAULT_MAX_CPU_USAGE))).intValue();
            int intValue5 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "max_mem_usage", Integer.valueOf(PerformanceDetectConfig.DEFAULT_MAX_MEM_USAGE))).intValue();
            int intValue6 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "cpu_overload_count", Integer.valueOf(PerformanceDetectConfig.DEFAULT_CPU_OVERLOAD_COUNT))).intValue();
            ((Integer) iMASToggleService2.getParams("app_monitor_config", "limit", Integer.valueOf(PerformanceDetectConfig.DEFAULT_CPU_OVERLOAD_COUNT))).intValue();
            boolean z6 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "thread_monitor_enable", 0)).intValue() == 1;
            int intValue7 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "threadLimit", Integer.valueOf(PerformanceDetectConfig.DEFAULT_THREAD_MAX_COUNT))).intValue();
            int intValue8 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "fdLimit", Integer.valueOf(PerformanceDetectConfig.DEFAULT_FD_MAX_COUNT))).intValue();
            boolean z7 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "thread_detail_enable", 0)).intValue() == 1;
            boolean z8 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "diskMonitorEnable", 0)).intValue() == 1;
            int intValue9 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "diskLimitPercent", 95)).intValue();
            int intValue10 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "diskDataLimitPercent", 95)).intValue();
            boolean z9 = z7;
            long longValue6 = ((Long) iMASToggleService2.getParams("app_monitor_config", "diskLimitThreshold", 500L)).longValue();
            String[] split = ((String) iMASToggleService2.getParams("app_monitor_config", "diskPathList", "")).split(",");
            long j = longValue6;
            int intValue11 = ((Integer) iMASToggleService2.getParams("app_monitor_config", "diskPathDepth", 2)).intValue();
            String[] split2 = ((String) iMASToggleService2.getParams("app_monitor_config", "diskCleanPath", "")).split(",");
            long longValue7 = ((Long) iMASToggleService2.getParams("app_monitor_config", "diskCleanLimit", 500L)).longValue();
            long longValue8 = ((Long) iMASToggleService2.getParams("app_monitor_config", "diskCleanExpire", Long.valueOf(PerformanceDetectConfig.DEFAULT_DISK_CLEAN_EXPIRE))).longValue();
            PerformanceDetectConfig performanceDetectConfig = new PerformanceDetectConfig();
            performanceDetectConfig.trackInterval = longValue5;
            performanceDetectConfig.cpuMonitorEnable = z4;
            performanceDetectConfig.memMonitorEnable = z5;
            performanceDetectConfig.maxCpuUsage = intValue4;
            performanceDetectConfig.maxMemUsage = intValue5;
            performanceDetectConfig.threadMonitorEnable = z6;
            performanceDetectConfig.maxThreadCount = intValue7;
            performanceDetectConfig.cpuOverloadCount = intValue6;
            performanceDetectConfig.threadDetailEnable = z9;
            performanceDetectConfig.maxFDCount = intValue8;
            performanceDetectConfig.diskMonitorEnable = z8;
            performanceDetectConfig.diskLimitPercent = intValue9;
            performanceDetectConfig.diskDataLimitPercent = intValue10;
            performanceDetectConfig.diskLimitThreshold = j;
            performanceDetectConfig.diskPathList = split;
            performanceDetectConfig.diskPathDepth = intValue11;
            performanceDetectConfig.diskCleanPath = split2;
            performanceDetectConfig.diskCleanPath_P2 = ((String) iMASToggleService2.getParams("app_monitor_config", "diskCleanPath_P2", "")).split(",");
            performanceDetectConfig.diskCleanLimit = longValue7;
            performanceDetectConfig.diskCleanExpire = longValue8;
            OmegaPerformanceDetect.getInstance().start(application, performanceDetectConfig);
        }
        IMASToggleService iMASToggleService3 = iMASToggleService;
        try {
            if (iMASToggleService3.allow("omega_safe_toggle")) {
                MASConfig.SWITCH_SAFE_POLLING = ((Integer) iMASToggleService3.getParams("omega_safe_toggle", Polling.NAME, 0)).intValue() == 1;
                MASConfig.SWITCH_SAFE_FREQUENCY = (long) ((Integer) iMASToggleService3.getParams("omega_safe_toggle", "frequency", 300000)).intValue();
                MASConfig.SWITCH_SAFE_BATTERY = ((Integer) iMASToggleService3.getParams("omega_safe_toggle", "bat", 0)).intValue() == 1;
                boolean z10 = true;
                if (((Integer) iMASToggleService3.getParams("omega_safe_toggle", "signal", 0)).intValue() != 1) {
                    z10 = false;
                }
                MASConfig.SWITCH_SAFE_SIGNAL = z10;
                MASConfig.SAFE_SIGNAL_DURATION = (long) ((Integer) iMASToggleService3.getParams("omega_safe_toggle", "signal_duration", 30000)).intValue();
                try {
                    JSONArray jSONArray = new JSONArray((String) iMASToggleService3.getParams("omega_safe_toggle", "bat_threshold", "[5,10,20]"));
                    int length = jSONArray.length();
                    int[] iArr = new int[length];
                    for (int i = 0; i < length; i++) {
                        iArr[i] = jSONArray.getInt(i);
                    }
                    MASConfig.SAFE_BATTERY_THRESHOLD = iArr;
                } catch (Exception e2) {
                    OLog.m34418e("omega_safe_toggle read fail:" + e2.toString());
                }
                if (MASConfig.SWITCH_SAFE_POLLING) {
                    SafetyManager.startSafeTimeTask(MASConfig.SWITCH_SAFE_FREQUENCY);
                }
                if (MASConfig.SWITCH_SAFE_SIGNAL) {
                    SafetyManager.registerNetworkStrengthListener(application);
                } else {
                    SafetyManager.unregisterNetworkStrengthListener(application);
                }
            }
        } catch (Exception unused) {
        }
        try {
            if (iMASToggleService3.allow("omega_safe_before_quit")) {
                SafetyMenuPowerSDK.registerPhoneReceiver(application);
            } else {
                SafetyMenuPowerSDK.unregisterPhoneReceiver(application);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            SafetyEditTextSDK.SWITCH_TYPING_MONITOR = iMASToggleService3.allow("omega_safe_typing");
        } catch (Exception e4) {
            OLog.m34418e("SAFE typing failed, " + e4.getMessage());
        }
    }

    protected static void setToggleService(Application application, IMASToggleService iMASToggleService) {
        if (f48259a.get()) {
            SystemUtils.log(5, "MASSDK.setToggleService", "massdk cannot be initialized repeatedly", (Throwable) null, "com.didichuxing.mas.sdk.quality.init.MASConfigurator", 499);
        } else if (application == null || iMASToggleService == null) {
            CommonUtil.operateErr(f48260b, "Neither the Context nor the IMASToggleService can be empty");
        } else if (TextUtils.isEmpty(MASConfig.OMEGA_SDK_VERSION)) {
            CommonUtil.operateErr(f48260b, "OmegaSdkVersion can't be empty, please call MASSDK.setOmegaSDKVersion assignment");
        } else if (!MASConfig.OMEGA_SDK_VERSION.contains(Constants.IMPROVE)) {
            CommonUtil.operateErr(f48260b, "Omegasdk version is incorrect, please use the version with -IMPROVE");
        } else if (!iMASToggleService.allow(f48261c)) {
            CommonUtil.operateErr(f48260b, "The Apollo SDK must first complete initialization and ensure that the Apollo platform mas_quality switch is turned on");
        } else {
            if (!(((Integer) iMASToggleService.getParams(f48261c, f48262d, 0)).intValue() == 1)) {
                SystemUtils.log(6, f48260b, "enableNewQuality is false, The MASSDK scheme cannot be initialized", (Throwable) null, "com.didichuxing.mas.sdk.quality.init.MASConfigurator", 528);
                return;
            }
            MASSDK.init(application);
            if (f48259a.compareAndSet(false, true)) {
                ActivityLifecycleRegister.init(application);
                AnalysisAppListener.whenAppStart(application);
                m34413a(application, iMASToggleService);
            }
        }
    }

    /* renamed from: a */
    private static void m34414a(Context context, IMASToggleService iMASToggleService) {
        int i;
        long j;
        long j2;
        boolean z;
        boolean z2;
        IMASToggleService iMASToggleService2 = iMASToggleService;
        if (!f48252B) {
            boolean allow = iMASToggleService2.allow("omg_http_api_stat");
            boolean allow2 = iMASToggleService2.allow("Omega_Http_Api_Err_Diag");
            boolean allow3 = iMASToggleService2.allow("Omega_Http_Api_User_Reqs");
            boolean allow4 = iMASToggleService2.allow("Omega_Http_Api_NP");
            if (allow || allow2 || allow3 || allow4) {
                MASSDK.switchApmNet(allow || allow2 || allow3 || allow4);
                MASSDK.switchApmUploadNetPerf(allow);
                MASSDK.switchApmUploadNetErrDiag(allow2);
                DiDiApm.setNetEventLogEnabled(allow3);
                DiDiApm.setAllNetUploadEnable(allow4 && !allow);
                long j3 = 3600000;
                try {
                    i = ((Integer) iMASToggleService2.getParams("Omega_Http_Api_Err_Diag", "maxDiagPerDay", 10)).intValue();
                } catch (Exception e) {
                    OLog.m34418e("Apollo param maxDiagTimesPerDay err:" + e.toString());
                    i = 0;
                }
                try {
                    j = (long) ((Integer) iMASToggleService2.getParams("Omega_Http_Api_Err_Diag", "timeout", 6000)).intValue();
                } catch (Exception e2) {
                    OLog.m34418e("Apollo param overRequestTime err:" + e2.toString());
                    j = 5000;
                }
                double d = 0.0d;
                try {
                    d = ((Double) iMASToggleService2.getParams("Omega_Http_Api_Err_Diag", "eCollectRate", Double.valueOf(0.0d))).doubleValue();
                } catch (Exception e3) {
                    OLog.m34418e("Apollo param exceptionCollectRate err:" + e3.toString());
                }
                long j4 = 10000;
                try {
                    z = allow4;
                    j2 = (long) ((Integer) iMASToggleService2.getParams("Omega_Http_Api_User_Reqs", "uploadLimitCount", 10000)).intValue();
                } catch (Exception e4) {
                    z = allow4;
                    OLog.m34418e("Apollo param maxEventNumber err:" + e4.toString());
                    j2 = 10000;
                }
                boolean z3 = z;
                try {
                    z2 = allow2;
                    j3 = (long) (((Integer) iMASToggleService2.getParams("Omega_Http_Api_User_Reqs", "timerTime", 300)).intValue() * 1000);
                } catch (Exception e5) {
                    z2 = allow2;
                    OLog.m34418e("Apollo param netEventUploadInterval err:" + e5.toString());
                }
                try {
                    j4 = (long) ((Integer) iMASToggleService2.getParams("Omega_Http_Api_User_Reqs", "uploadLimitCount", 100000)).intValue();
                } catch (Exception e6) {
                    OLog.m34418e("Apollo param uploadAllNetLimit err:" + e6.toString());
                }
                try {
                    try {
                        JSONArray jSONArray = new JSONArray((String) iMASToggleService2.getParams("Omega_Http_Api_NP", "urlpaths", "[]"));
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String string = jSONArray.getString(i2);
                            if (string != null) {
                                DiDiApm.addUploadUrlWhiteList(string);
                            }
                        }
                    } catch (Exception e7) {
                        OLog.m34418e("Omega_Http_Api_NP read fail:" + e7.toString());
                    }
                } catch (Exception e8) {
                    OLog.m34418e("Apollo param Omega_Http_Api_NP-urlpaths err:" + e8.toString());
                }
                DiDiApm.setMaxDiagPerDay(i);
                DiDiApm.setOverRequestTime(j);
                DiDiApm.setMaxNetEventUploadNum(j2);
                DiDiApm.setNetEventLogUploadInterval(j3);
                DiDiApm.setAllNetUploadLimit(j4);
                DiDiApm.setExceptionCollectRate(d);
                HashMap hashMap = new HashMap();
                hashMap.put("isApmNetOpen", Integer.valueOf(allow ? 1 : 0));
                hashMap.put("isApmNetErrOpen", Integer.valueOf(z2 ? 1 : 0));
                hashMap.put("isApmUserReqsCollect", Integer.valueOf(allow3 ? 1 : 0));
                hashMap.put("isApmAllNetOpen", Integer.valueOf(z3 ? 1 : 0));
                hashMap.put("maxDiagTimesPerDay", Integer.valueOf(i));
                hashMap.put("overRequestTime", Long.valueOf(j));
                hashMap.put("maxEventNumber", Long.valueOf(j2));
                hashMap.put("netEventUploadInterval", Long.valueOf(j3));
                hashMap.put("uploadAllNetLimit", Long.valueOf(j4));
                hashMap.put("exceptionCollectRate", Double.valueOf(d));
                MASSDK.trackEvent("omg_apm_apollo_toggle", (Map<String, Object>) hashMap);
                MASSDK.launchApmModule(context);
                f48252B = true;
            }
        }
        if (f48252B && iMASToggleService2.allow("Omega_Http_Api_NP_Sampling")) {
            try {
                JSONArray jSONArray2 = new JSONArray((String) iMASToggleService2.getParams("Omega_Http_Api_NP_Sampling", "urlpaths", "[]"));
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    String string2 = jSONArray2.getString(i3);
                    if (string2 != null) {
                        DiDiApm.addUploadUrlWhiteList(string2);
                    }
                }
            } catch (Exception e9) {
                OLog.m34418e("Omega_Http_Api_NP_Sampling read fail:" + e9.toString());
            }
        }
    }
}
