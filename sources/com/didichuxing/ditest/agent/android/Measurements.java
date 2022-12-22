package com.didichuxing.ditest.agent.android;

import android.util.Log;
import com.didichuxing.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;
import com.didichuxing.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.ditest.agent.android.util.C15538Util;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.AppStateMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Measurements {
    private static final String COMPRESS_NET_PERF_CARRIER = "c";
    private static final String COMPRESS_NET_PERF_DOWN = "d";
    private static final String COMPRESS_NET_PERF_EVENT_NAME = "omg_np";
    private static final String COMPRESS_NET_PERF_HDS = "hds";
    private static final String COMPRESS_NET_PERF_HTTP_ERROR_CODE = "he";
    private static final String COMPRESS_NET_PERF_NET_ERROR_CODE = "ne";
    private static final String COMPRESS_NET_PERF_TIME = "t";
    private static final String COMPRESS_NET_PERF_TRACE_ID = "ti";
    private static final String COMPRESS_NET_PERF_UPLOAD = "u";
    private static final String COMPRESS_NET_PERF_URL = "i";
    private static final String COMPRESS_NET_PERF_WAN = "w";
    public static final ArrayList<String> EXCEPT_KEY_PREFIX_EVENT_LIST = new ArrayList<String>() {
        {
            add(Measurements.COMPRESS_NET_PERF_URL);
            add(Measurements.COMPRESS_NET_PERF_UPLOAD);
            add(Measurements.COMPRESS_NET_PERF_DOWN);
            add("t");
            add("c");
            add("w");
            add(Measurements.COMPRESS_NET_PERF_NET_ERROR_CODE);
            add(Measurements.COMPRESS_NET_PERF_HTTP_ERROR_CODE);
            add(Measurements.COMPRESS_NET_PERF_TRACE_ID);
            add(Measurements.COMPRESS_NET_PERF_HDS);
            add("url");
            add("up");
            add("down");
            add("time");
            add("carrier");
            add("wanType");
            add("errorCode");
            add("stateCode");
            add("traceid");
            add("httpdns");
            add("localError");
        }
    };
    private static final String[] FILTER_KEY_LIST_COMPRESS_NET_EVENT = {"url", "up", "down", "time", "carrier", "wanType", "errorCode", "stateCode", "traceid", "httpdns"};
    public static boolean FLAG_SYNCING = false;
    public static final String HTTP_API_ERR_DIAG_EVENT = "http_api_err_diag";
    private static final String HTTP_API_STAT_CARRIER = "carrier";
    private static final String HTTP_API_STAT_DOWN = "down";
    private static final String HTTP_API_STAT_ERROR_CODE = "errorCode";
    private static final String HTTP_API_STAT_EVENT = "http_api_stat";
    private static final String HTTP_API_STAT_HTTPDNS = "httpdns";
    private static final String HTTP_API_STAT_METHOD = "method";
    private static final String HTTP_API_STAT_STATE = "state";
    private static final String HTTP_API_STAT_STATE_CODE = "stateCode";
    private static final String HTTP_API_STAT_STATE_VALUE_BACKGROUND = "background";
    private static final String HTTP_API_STAT_STATE_VALUE_FORGROUND = "foreground";
    private static final String HTTP_API_STAT_TIME = "time";
    private static final String HTTP_API_STAT_TRACE_ID = "traceid";
    private static final String HTTP_API_STAT_UP = "up";
    private static final String HTTP_API_STAT_URL = "url";
    private static final String HTTP_API_STAT_WAN_TYPE = "wanType";
    public static final String HTTP_ERROR_CODE_EXCEPTION_CLASS = "class";
    public static final String HTTP_ERROR_CODE_EXCEPTION_INFO = "info";
    public static final String HTTP_ERROR_CODE_PING_INFO = "pingInfo";
    public static final String HTTP_ERROR_CODE_ROUTE_INFO = "routeInfo";
    public static final String HTTP_ERROR_CODE_TRACE_HOST = "traceHost";
    private static final String HTTP_ERROR_EXCEPTION_TRACE = "errTrace";
    private static final String HTTP_ERROR_LOCAL_ERROR = "localError";
    private static boolean isUploadAllNetUpperLimit = false;
    private static boolean isUploadNetErrorUpperLimit = false;
    private static long lastDiagTimestamp = 0;
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public static void initialize() {
        log.info("Measurement Engine initialized.");
        TaskQueue.start();
    }

    public static void shutdown() {
        TaskQueue.stop();
        log.info("Measurement Engine shutting down.");
    }

    public static void addHttpError(String str, String str2, int i, String str3, int i2, String str4, boolean z, String str5, String str6, Map<String, String> map) {
        String str7 = str5;
        HashMap hashMap = new HashMap();
        hashMap.put("time", 0);
        hashMap.put("url", str);
        hashMap.put("up", 0);
        hashMap.put("down", 0);
        hashMap.put("stateCode", Integer.valueOf(i));
        hashMap.put("errorCode", 0);
        hashMap.put("wanType", str7);
        hashMap.put("carrier", str6);
        hashMap.put("method", str2);
        if (z) {
            hashMap.put("state", "foreground");
        } else {
            hashMap.put("state", "background");
        }
        hashMap.put("traceid", str4 == null ? "" : str4);
        if (!Agent.isUploadErrorDiag()) {
            int i3 = i;
        } else if (i != 200 && !"none".equals(str7)) {
            if (Agent.canUploadNetErrEvent()) {
                trackNetEvent("http_api_err_diag", (String) null, hashMap);
            } else if (!isUploadNetErrorUpperLimit) {
                netErrorUpperLimit();
                isUploadNetErrorUpperLimit = true;
            }
        }
        if (!OmegaConfig.DEBUG_MODEL && Agent.isUploadNetPerf()) {
            Tracker.trackEvent(HTTP_API_STAT_EVENT, (String) null, hashMap);
        }
        HttpTransactionMeasurement httpTransactionMeasurement = new HttpTransactionMeasurement(str, str2, i, 0, 0, 0, 0, i2, str4);
        if (Agent.isNetEventLogEnabled()) {
            Agent.getImpl().addNetEventLog(httpTransactionMeasurement);
        }
        if (Agent.isUploadAllNetEnabled() && canUploadAllNetEvent()) {
            uploadCompressNetPerf(httpTransactionMeasurement);
        }
    }

    public static void addHttpTransaction(HttpTransactionMeasurement httpTransactionMeasurement) {
        HashMap hashMap = new HashMap();
        if (httpTransactionMeasurement.getOkHttp3Data() != null) {
            hashMap.putAll(httpTransactionMeasurement.getOkHttp3Data());
            if (!httpTransactionMeasurement.getOkHttp3Data().containsKey("wanType")) {
                hashMap.put("wanType", httpTransactionMeasurement.getWanType());
            } else {
                httpTransactionMeasurement.setWanType(httpTransactionMeasurement.getOkHttp3Data().get("wanType").toString());
            }
            if (!httpTransactionMeasurement.getOkHttp3Data().containsKey("carrier")) {
                hashMap.put("carrier", httpTransactionMeasurement.getCarrier());
            } else {
                httpTransactionMeasurement.setCarrier(httpTransactionMeasurement.getOkHttp3Data().get("carrier").toString());
            }
            if (httpTransactionMeasurement.getException() != null) {
                hashMap.put("localError", httpTransactionMeasurement.getException().toString());
                if (Math.random() < Agent.getImpl().getAgentConfig().getExceptionCollectRate()) {
                    hashMap.put("errTrace", Log.getStackTraceString(httpTransactionMeasurement.getException()));
                }
            }
        } else {
            hashMap.put("time", Double.valueOf(httpTransactionMeasurement.getTotalTime()));
            hashMap.put("url", httpTransactionMeasurement.getUrl());
            hashMap.put("up", Long.valueOf(httpTransactionMeasurement.getBytesSent()));
            hashMap.put("down", Long.valueOf(httpTransactionMeasurement.getBytesReceived()));
            hashMap.put("stateCode", Integer.valueOf(httpTransactionMeasurement.getStatusCode()));
            hashMap.put("errorCode", Integer.valueOf(httpTransactionMeasurement.getErrorCode()));
            hashMap.put("traceid", httpTransactionMeasurement.getTraceId() == null ? "" : httpTransactionMeasurement.getTraceId());
            hashMap.put("wanType", httpTransactionMeasurement.getWanType());
            hashMap.put("carrier", httpTransactionMeasurement.getCarrier());
            hashMap.put("method", httpTransactionMeasurement.getHttpMethod());
        }
        if (!"none".equals(httpTransactionMeasurement.getWanType())) {
            if (httpTransactionMeasurement.isForeground()) {
                hashMap.put("state", "foreground");
            } else {
                hashMap.put("state", "background");
            }
            if (!OmegaConfig.DEBUG_MODEL && Agent.isUploadNetPerf()) {
                if (httpTransactionMeasurement.getErrorCode() == -1) {
                    if (httpTransactionMeasurement.getErrCodeClass() != null) {
                        hashMap.put("class", httpTransactionMeasurement.getErrCodeClass());
                    }
                    if (httpTransactionMeasurement.getErrCodeInfo() != null) {
                        hashMap.put("info", httpTransactionMeasurement.getErrCodeInfo());
                    }
                }
                Tracker.trackEvent(HTTP_API_STAT_EVENT, (String) null, hashMap);
            }
            if (Agent.isNetEventLogEnabled()) {
                Agent.getImpl().addNetEventLog(httpTransactionMeasurement);
            }
            if (Agent.isUploadAllNetEnabled()) {
                if (canUploadAllNetEvent()) {
                    uploadCompressNetPerf(httpTransactionMeasurement);
                } else if (!isUploadAllNetUpperLimit) {
                    Tracker.trackEvent("omg_np_over_threshold", (String) null, new HashMap<String, Object>() {
                        {
                            put("cur", Long.valueOf(Agent.getImpl().getAgentConfig().getAllNetUploadLimit()));
                            put("allow", Long.valueOf(Agent.getImpl().getAgentConfig().getAllNetUploadLimit()));
                        }
                    });
                    isUploadAllNetUpperLimit = true;
                }
            }
            if (Agent.isUploadErrorDiag() && !"none".equals(httpTransactionMeasurement.getWanType())) {
                if (httpTransactionMeasurement.getErrorCode() != 0 || httpTransactionMeasurement.getStatusCode() != 200 || httpTransactionMeasurement.getTotalTime() > ((double) Agent.getImpl().getAgentConfig().getOverRequestTime())) {
                    if (Agent.canUploadNetErrEvent()) {
                        if (httpTransactionMeasurement.getUrl() == null) {
                            return;
                        }
                        if (httpTransactionMeasurement.getErrorCode() != 0) {
                            if (httpTransactionMeasurement.getErrorCode() == -1) {
                                if (httpTransactionMeasurement.getErrCodeClass() != null) {
                                    hashMap.put("class", httpTransactionMeasurement.getErrCodeClass());
                                }
                                if (httpTransactionMeasurement.getErrCodeInfo() != null) {
                                    hashMap.put("info", httpTransactionMeasurement.getErrCodeInfo());
                                }
                            }
                            String host = C15538Util.getHost(httpTransactionMeasurement.getUrl());
                            if (host == null || FLAG_SYNCING) {
                                trackNetEvent("http_api_err_diag", (String) null, hashMap);
                                return;
                            }
                            FLAG_SYNCING = true;
                            long currentTimeMillis = System.currentTimeMillis();
                            long j = lastDiagTimestamp;
                            if (currentTimeMillis - j > 60000) {
                                lastDiagTimestamp = System.currentTimeMillis();
                                new Thread(new DiagThread(host, hashMap), "Omega-measurement").start();
                                return;
                            }
                            hashMap.put("lastCheckTs", Long.valueOf(j));
                            trackNetEvent("http_api_err_diag", (String) null, hashMap);
                            return;
                        }
                        trackNetEvent("http_api_err_diag", (String) null, hashMap);
                    } else if (!isUploadNetErrorUpperLimit) {
                        netErrorUpperLimit();
                        isUploadNetErrorUpperLimit = true;
                    }
                }
            }
        }
    }

    public static void addHttpError(TransactionData transactionData, String str, Map<String, String> map) {
        addHttpError(transactionData.getUrl(), transactionData.getHttpMethod(), transactionData.getStatusCode(), str, transactionData.getBusinessType(), transactionData.getTraceId(), transactionData.isForground(), transactionData.getWanType(), transactionData.getCarrier(), map);
    }

    private static void uploadCompressNetPerf(HttpTransactionMeasurement httpTransactionMeasurement) {
        String urlPath;
        String url = httpTransactionMeasurement.getUrl();
        if (Agent.getImpl().getAgentConfig().inAllNetUploadWhiteList(url) && (urlPath = C15538Util.getUrlPath(url)) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(COMPRESS_NET_PERF_URL, urlPath);
            hashMap.put(COMPRESS_NET_PERF_UPLOAD, Long.valueOf(httpTransactionMeasurement.getBytesSent()));
            hashMap.put(COMPRESS_NET_PERF_DOWN, Long.valueOf(httpTransactionMeasurement.getBytesReceived()));
            hashMap.put("t", Double.valueOf(httpTransactionMeasurement.getTotalTime()));
            if (httpTransactionMeasurement.getTraceId() != null) {
                hashMap.put(COMPRESS_NET_PERF_TRACE_ID, httpTransactionMeasurement.getTraceId());
            }
            hashMap.put("c", httpTransactionMeasurement.getCarrier());
            hashMap.put(COMPRESS_NET_PERF_HDS, Integer.valueOf(httpTransactionMeasurement.getHttpdns()));
            if (httpTransactionMeasurement.getErrorCode() != 0) {
                hashMap.put(COMPRESS_NET_PERF_NET_ERROR_CODE, Integer.valueOf(httpTransactionMeasurement.getErrorCode()));
            }
            if (httpTransactionMeasurement.getStatusCode() != 200) {
                hashMap.put(COMPRESS_NET_PERF_HTTP_ERROR_CODE, Integer.valueOf(httpTransactionMeasurement.getStatusCode()));
            }
            hashMap.put("w", httpTransactionMeasurement.getWanType());
            Map<String, Object> okHttp3Data = httpTransactionMeasurement.getOkHttp3Data();
            if (okHttp3Data != null) {
                for (String remove : FILTER_KEY_LIST_COMPRESS_NET_EVENT) {
                    okHttp3Data.remove(remove);
                }
                hashMap.putAll(okHttp3Data);
                if (httpTransactionMeasurement.getException() != null) {
                    hashMap.put("localError", httpTransactionMeasurement.getException().toString());
                    if (Math.random() < Agent.getImpl().getAgentConfig().getExceptionCollectRate()) {
                        hashMap.put("errTrace", Log.getStackTraceString(httpTransactionMeasurement.getException()));
                    }
                }
            }
            trackNetEvent(COMPRESS_NET_PERF_EVENT_NAME, (String) null, hashMap);
        }
    }

    private static boolean canUploadAllNetEvent() {
        return !Agent.getImpl().upperLimitToday("omg_np_limit", Agent.getImpl().getAgentConfig().getAllNetUploadLimit());
    }

    private static void netErrorUpperLimit() {
        Tracker.trackEvent("http_err_diag_over_threshold", (String) null, new HashMap<String, Object>() {
            {
                put("cur", Integer.valueOf(Agent.getImpl().getAgentConfig().getMaxUploadNetErrEventPerDay()));
                put("allow", Integer.valueOf(Agent.getImpl().getAgentConfig().getMaxUploadNetErrEventPerDay()));
            }
        });
    }

    public static void trackNetEvent(String str, String str2, Map<String, Object> map) {
        int i;
        HashMap hashMap = new HashMap();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            Iterator<String> it2 = EXCEPT_KEY_PREFIX_EVENT_LIST.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().equals(next)) {
                        break;
                    }
                } else {
                    i = 0;
                    break;
                }
            }
            if (i != 0) {
                hashMap.put(next, map.get(next));
            } else {
                hashMap.put("nt_" + next, map.get(next));
            }
        }
        if (!AppStateMonitor.getInstance().isInForeground()) {
            i = 2;
        }
        hashMap.put(Constants.NT_APPSTATE, Integer.valueOf(i));
        Tracker.trackEvent(str, str2, hashMap);
    }
}
