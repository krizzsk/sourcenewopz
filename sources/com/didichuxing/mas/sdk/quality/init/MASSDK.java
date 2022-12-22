package com.didichuxing.mas.sdk.quality.init;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.config.CdnDetectConfig;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.DiDiApm;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.Measurements;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.config.SocketConfig;
import com.didichuxing.mas.sdk.quality.collect.netmonitor.NetHeartbeat;
import com.didichuxing.mas.sdk.quality.init.impl.MASToggleService;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.collector.DeviceCollector;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MASSDK extends MAS {
    public static void reportDartException(final Context context, final Map<String, Object> map) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(new Runnable() {
            public void run() {
                if (MAS.applicationContext == null) {
                    MASSDK.init(context);
                }
                RecordStorage.saveDartException(map);
            }
        });
        newSingleThreadExecutor.shutdown();
    }

    public static void trackFlutterPageEnter(Map<String, Object> map) {
        map.put("did", DeviceCollector.getApolloKey());
        map.put("ot", "android");
        trackEvent(Constants.EVENT_FLUTTER_PAGE_EN, map);
    }

    public static void trackNetEvent(NetEventParamBean netEventParamBean) {
        if (netEventParamBean != null) {
            HashMap hashMap = new HashMap();
            String url = netEventParamBean.getURL();
            if (TextUtils.isEmpty(url)) {
                OLog.m34418e("MASSDK.trackNetEvent:url cannot be null");
                return;
            }
            String method = netEventParamBean.getMethod();
            if (TextUtils.isEmpty(method)) {
                OLog.m34418e("MASSDK.trackNetEvent:method cannot be null");
                return;
            }
            hashMap.put("url", url);
            long upBytes = netEventParamBean.getUpBytes();
            hashMap.put("up", Long.valueOf(upBytes));
            long downBytes = netEventParamBean.getDownBytes();
            hashMap.put("down", Long.valueOf(downBytes));
            long time = netEventParamBean.getTime();
            hashMap.put("time", Long.valueOf(time));
            int httpStateCode = netEventParamBean.getHttpStateCode();
            hashMap.put(Constants.STATE_CODE, Integer.valueOf(httpStateCode));
            int errorCode = netEventParamBean.getErrorCode();
            hashMap.put(Constants.ERROR_CODE, Integer.valueOf(errorCode));
            hashMap.put("method", method);
            int httpdns = netEventParamBean.getHttpdns();
            hashMap.put(Constants.HTTP_DNS, Integer.valueOf(httpdns));
            String traceid = netEventParamBean.getTraceid();
            if (!TextUtils.isEmpty(traceid)) {
                hashMap.put("traceid", traceid);
            }
            String reuseCon = netEventParamBean.getReuseCon();
            if (!TextUtils.isEmpty(reuseCon)) {
                hashMap.put(Constants.REUSE_CON, reuseCon);
            }
            hashMap.put(Constants.CON_STATE, Integer.valueOf(netEventParamBean.getConState()));
            String protocolName = netEventParamBean.getProtocolName();
            if (!TextUtils.isEmpty(protocolName)) {
                hashMap.put(Constants.PROTOCOL_NAME, protocolName);
            }
            String scheme = netEventParamBean.getScheme();
            if (!TextUtils.isEmpty(scheme)) {
                hashMap.put("scheme", scheme);
            }
            String ip = netEventParamBean.getIP();
            if (!TextUtils.isEmpty(ip)) {
                hashMap.put("ip", ip);
            }
            String wanType = netEventParamBean.getWanType();
            if (!TextUtils.isEmpty(wanType)) {
                hashMap.put(Constants.WAN_TYPE, wanType);
            }
            String carrier = netEventParamBean.getCarrier();
            if (!TextUtils.isEmpty(carrier)) {
                hashMap.put("carrier", carrier);
            }
            Exception errTrace = netEventParamBean.getErrTrace();
            if (errTrace != null) {
                hashMap.put(Constants.ERR_TRACE, errTrace);
            }
            String locaError = netEventParamBean.getLocaError();
            if (!TextUtils.isEmpty(locaError)) {
                hashMap.put(Constants.LOCAL_ERROR, locaError);
            }
            hashMap.put("state", AnalysisDelegater.isAppAtFront() ? Constants.FORGROUND : Constants.BACKGROUND);
            hashMap.put(Constants.NT_APPSTATE, Integer.valueOf(AnalysisDelegater.isAppAtFront() ? 1 : 2));
            String errorClass = netEventParamBean.getErrorClass();
            if (!TextUtils.isEmpty(errorClass)) {
                hashMap.put("class", errorClass);
            }
            String errorInfo = netEventParamBean.getErrorInfo();
            if (!TextUtils.isEmpty(errorInfo)) {
                hashMap.put("info", errorInfo);
            }
            Map<String, Object> extraParams = netEventParamBean.getExtraParams();
            if (extraParams != null) {
                hashMap.putAll(extraParams);
            }
            Measurements.addHttpTransaction(new HttpTransactionMeasurement(url, method, httpdns, httpStateCode, errorCode, 0, time, upBytes, downBytes, 0, traceid, errTrace, hashMap));
        }
    }

    public static void initEventReduction(String str) {
        HttpTransactionEventReductionUtil.m34408a(str);
    }

    public static void trackHttpTransactionEvent(Map<String, Object> map) {
        String str;
        String str2;
        Map<String, Object> map2 = map;
        if (map2 != null) {
            for (String str3 : MASConfig.PREDEFINED_HTTP_TRANSACTION_KEYS) {
                if (!map2.containsKey(str3)) {
                    OLog.m34418e(str3 + " missed! when trackHttpTransactionEvent");
                    return;
                }
            }
            Exception exc = null;
            if (map2.get("method") != null) {
                str = map2.get("method").toString();
            } else {
                str = "";
            }
            if (map2.get("traceid") != null) {
                str2 = map2.get("traceid").toString();
            } else {
                str2 = "";
            }
            try {
                int intValue = Integer.valueOf(map2.get(Constants.STATE_CODE).toString()).intValue();
                int intValue2 = Integer.valueOf(map2.get(Constants.ERROR_CODE).toString()).intValue();
                long longValue = Long.valueOf(map2.get("time").toString()).longValue();
                long longValue2 = Long.valueOf(map2.get("up").toString()).longValue();
                long longValue3 = Long.valueOf(map2.get("down").toString()).longValue();
                int intValue3 = Integer.valueOf(map2.get(Constants.HTTP_DNS).toString()).intValue();
                if (map2.containsKey("e")) {
                    try {
                        exc = (Exception) map2.get("e");
                    } catch (Throwable th) {
                        OLog.m34418e("Exception cast err:" + th.toString());
                        return;
                    }
                }
                Exception exc2 = exc;
                if (!HttpTransactionEventReductionUtil.m34409a(map2.get("url").toString(), intValue2)) {
                    Measurements.addHttpTransaction(new HttpTransactionMeasurement(map2.get("url").toString(), str, intValue3, intValue, intValue2, 0, longValue, longValue2, longValue3, 0, str2, exc2, map));
                }
            } catch (NumberFormatException e) {
                OLog.m34418e("trackHttpTransactionEvent NumberFormatException:" + e.toString());
            }
        }
    }

    public static void switchApmUI(boolean z) {
        DiDiApm.setApmUiEnable(z);
    }

    public static void switchApmNet(boolean z) {
        DiDiApm.setApmNetEnable(z);
    }

    public static void switchApmUploadNetPerf(boolean z) {
        DiDiApm.setUploadNetPerfEnable(z);
    }

    public static void switchApmUploadNetErrDiag(boolean z) {
        DiDiApm.setUploadErrorDiagEnable(z);
    }

    public static void launchApmModule(Context context) {
        if (context == null) {
            OLog.m34418e("apm module launch fail, context is null!");
        } else {
            DiDiApm.launch(context);
        }
    }

    public static boolean setBizConfig(String str) {
        try {
            NetHeartbeat.initBizConfig(str);
            return true;
        } catch (Throwable th) {
            OLog.m34418e("init biz config err:" + th.toString());
            return false;
        }
    }

    public static void setNetMonitorUploadUrl(String str) {
        NetHeartbeat.setReportUrl(str);
    }

    public static void setNetMonitorInterval(int i) {
        NetHeartbeat.setHeartBeatInterval(i);
    }

    public static void setMaxAnrUploadPerDay(int i) {
        MASConfig.UPPER_LIMIT_ANR_EVENT_PER_DAY = i;
    }

    public static void setMaxLagUploadPerDay(int i) {
        MASConfig.UPPER_LIMIT_LAG_EVENT_PER_DAY = i;
    }

    public static void setMaxNativeCrashUploadPerDay(int i) {
        MASConfig.UPPER_LIMIT_NATIVE_CRASH_EVENT_PER_DAY = i;
    }

    public static void setFPSDetectInterval(long j) {
        MASConfig.FPS_DETECT_INTERVAL = j;
    }

    public static void setFdInfoReportLineLimitNum(int i) {
        MASConfig.FD_INFO_REPORT_LINE_LIMIT_NUM = (long) i;
    }

    public static void setOpenDumpMemoryFdThreadProcessInfo(boolean z) {
        MASConfig.OPEN_DUMP_MEMORY_FD_THREAD_PROCESS_INFO = z;
    }

    public static void setLatestFPSCacheNum(int i) {
        MASConfig.FPS_LATEST_CACHE_NUM = i;
    }

    public static void setFPSDetectIntervalForAnrTrace(long j) {
        MASConfig.FPS_DETECT_INTERVAL_FOR_ANR_TRACE = j;
    }

    public static void setLagTime(long j) {
        MASConfig.LAG_TIME = j;
    }

    public static void setNetDiagMemoryCacheEnable(boolean z) {
        MASConfig.NET_DIAG_USE_MEMORY_CACHE = z;
    }

    public static void setAutoEventInputEnable(boolean z) {
        MASConfig.SWITCH_ATUO_EVENT_INPUT = z;
    }

    public static void setSocketTrafficEnable(boolean z) {
        SocketConfig.SWITCH_SOCKET_TRANSACTION_STAT = z;
        SocketConfig.SWITCH_SOCKET_CONNECTION_STAT = z;
    }

    public static void setCdnMonitorEnable(boolean z) {
        CdnDetectConfig.SWITCH_CDN_MONITOR = z;
    }

    public static void setLocationBackgroundEnable(boolean z) {
        MASConfig.SWITCH_PUT_LOCATION_BACKGROUND = z;
    }

    public static void setOmegaSDKVersion(String str) {
        MASConfig.OMEGA_SDK_VERSION = str;
    }

    public static void setPnBlackList(List<String> list) {
        MASConfig.PPH_FH_PH_CP_BLACK_LIST = list;
    }

    public static void addCustomEvent(String str, String str2, String str3, boolean z) {
        MASConfig.addCustomEvent(str, str2, str3, z);
    }

    public static void removeCustomEvent(String str, String str2) {
        MASConfig.removeCustomEvent(str, str2);
    }

    public static void launch(Application application) {
        MASConfigurator.setToggleService(application, new MASToggleService());
    }
}
