package com.didichuxing.ditest.agent.android;

import android.content.Context;
import com.didichuxing.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.ditest.agent.android.util.C15538Util;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.AppStateMonitor;
import com.didichuxing.omega.sdk.common.backend.ScreenChangeListener;
import com.didichuxing.omega.sdk.common.backend.ScreenChangeReceiver;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.threadpool.ThreadTaskObject;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class NetworkEventAnalysis {
    private long currentWriteTimestamp = 0;
    private Map<String, Object> data;
    private long fileTimeout = 10800000;
    private final String keyCarrier = "carrier";
    private final String keyDown = "down";
    private final String keyEndTs = "endTs";
    private final String keyErrCodePrefix = "errCode,";
    private final String keyErrorCode = Constants.ERROR_CODE;
    private final String keyNetEventTs = "nts";
    private final String keyPv = "pv";
    private final String keyStartTs = "startTs";
    private final String keyStatusCode = "statusCode";
    private final String keyStatusCodePrefix = "status,";
    private final String keyTime = "time";
    private final String keyUp = "up";
    private final String keyUrlpath = "urlpath";
    private final String keyWanType = Constants.WAN_TYPE;
    private Context mContext;
    private File mNetCacheFile;
    private long maxNetEventUploadPerDay = 10000;
    private Map<String, Map<String, Object>> netCacheMap;
    private String netEventUploadNumKey = ("netevent" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
    private String netFileName = "net.log";
    private SavedState savedState;

    public NetworkEventAnalysis(Context context, long j, long j2) {
        this.savedState = new SavedState(context);
        this.fileTimeout = j;
        this.maxNetEventUploadPerDay = j2;
        this.mContext = context;
        if (OmegaConfig.NET_DIAG_USE_MEMORY_CACHE) {
            this.netCacheMap = new LinkedHashMap<String, Map<String, Object>>() {
                /* access modifiers changed from: protected */
                public boolean removeEldestEntry(Map.Entry<String, Map<String, Object>> entry) {
                    return size() > OmegaConfig.MAX_NET_CACHE_SIZE;
                }
            };
            Timer timer = new Timer(true);
            C155132 r1 = new TimerTask() {
                public void run() {
                    NetworkEventAnalysis.this.uploadEventV2();
                }
            };
            long j3 = this.fileTimeout;
            timer.schedule(r1, j3, j3);
        } else {
            this.mNetCacheFile = new File(getNetCache(context), this.netFileName);
            new Timer(true).schedule(new TimerTask() {
                public void run() {
                    NetworkEventAnalysis.this.uploadEvent();
                }
            }, 0, this.fileTimeout);
        }
        AppStateMonitor.getInstance().registerAppStateListener(new AppStateMonitor.AppStateListener() {
            public void onInForeground() {
                NetworkEventAnalysis.this.uploadEventAsync();
            }

            public void onInBackground() {
                NetworkEventAnalysis.this.uploadEventAsync();
            }
        });
        ScreenChangeReceiver.addScreenChangeListener(new ScreenChangeListener() {
            public void screenOn() {
                NetworkEventAnalysis.this.uploadEventAsync();
            }

            public void screenOff() {
                NetworkEventAnalysis.this.uploadEventAsync();
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fa A[SYNTHETIC, Splitter:B:38:0x00fa] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addEvent(com.didichuxing.ditest.agent.android.measurement.http.HttpTransactionMeasurement r7) {
        /*
            r6 = this;
            r0 = 0
            boolean r1 = r6.canUploadToday()     // Catch:{ IOException -> 0x00d4 }
            if (r1 != 0) goto L_0x0008
            return
        L_0x0008:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ IOException -> 0x00d4 }
            r1.<init>()     // Catch:{ IOException -> 0x00d4 }
            r6.data = r1     // Catch:{ IOException -> 0x00d4 }
            java.lang.String r2 = "urlpath"
            java.lang.String r3 = r7.getUrl()     // Catch:{ IOException -> 0x00d4 }
            r1.put(r2, r3)     // Catch:{ IOException -> 0x00d4 }
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.data     // Catch:{ IOException -> 0x00d4 }
            java.lang.String r2 = "up"
            long r3 = r7.getBytesSent()     // Catch:{ IOException -> 0x00d4 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ IOException -> 0x00d4 }
            r1.put(r2, r3)     // Catch:{ IOException -> 0x00d4 }
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.data     // Catch:{ IOException -> 0x00d4 }
            java.lang.String r2 = "down"
            long r3 = r7.getBytesReceived()     // Catch:{ IOException -> 0x00d4 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ IOException -> 0x00d4 }
            r1.put(r2, r3)     // Catch:{ IOException -> 0x00d4 }
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.data     // Catch:{ IOException -> 0x00d4 }
            java.lang.String r2 = "time"
            double r3 = r7.getTotalTime()     // Catch:{ IOException -> 0x00d4 }
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch:{ IOException -> 0x00d4 }
            r1.put(r2, r3)     // Catch:{ IOException -> 0x00d4 }
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.data     // Catch:{ IOException -> 0x00d4 }
            java.lang.String r2 = "wanType"
            java.lang.String r3 = r7.getWanType()     // Catch:{ IOException -> 0x00d4 }
            r1.put(r2, r3)     // Catch:{ IOException -> 0x00d4 }
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.data     // Catch:{ IOException -> 0x00d4 }
            java.lang.String r2 = "carrier"
            java.lang.String r3 = r7.getCarrier()     // Catch:{ IOException -> 0x00d4 }
            r1.put(r2, r3)     // Catch:{ IOException -> 0x00d4 }
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.data     // Catch:{ IOException -> 0x00d4 }
            java.lang.String r2 = "statusCode"
            int r3 = r7.getStatusCode()     // Catch:{ IOException -> 0x00d4 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x00d4 }
            r1.put(r2, r3)     // Catch:{ IOException -> 0x00d4 }
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.data     // Catch:{ IOException -> 0x00d4 }
            java.lang.String r2 = "errorCode"
            int r7 = r7.getErrorCode()     // Catch:{ IOException -> 0x00d4 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x00d4 }
            r1.put(r2, r7)     // Catch:{ IOException -> 0x00d4 }
            java.util.Map<java.lang.String, java.lang.Object> r7 = r6.data     // Catch:{ IOException -> 0x00d4 }
            java.lang.String r1 = "nts"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00d4 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ IOException -> 0x00d4 }
            r7.put(r1, r2)     // Catch:{ IOException -> 0x00d4 }
            java.io.File r7 = r6.mNetCacheFile     // Catch:{ IOException -> 0x00d4 }
            monitor-enter(r7)     // Catch:{ IOException -> 0x00d4 }
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ all -> 0x00c4 }
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ all -> 0x00c4 }
            java.io.File r3 = r6.mNetCacheFile     // Catch:{ all -> 0x00c4 }
            r4 = 1
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00c4 }
            r1.<init>(r2)     // Catch:{ all -> 0x00c4 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r0.<init>()     // Catch:{ all -> 0x00d0 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = r6.data     // Catch:{ all -> 0x00d0 }
            java.lang.String r2 = com.didichuxing.omega.sdk.common.utils.JsonUtil.map2Json(r2)     // Catch:{ all -> 0x00d0 }
            r0.append(r2)     // Catch:{ all -> 0x00d0 }
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch:{ all -> 0x00d0 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00d0 }
            r1.write(r0)     // Catch:{ all -> 0x00d0 }
            r1.flush()     // Catch:{ all -> 0x00d0 }
            r6.addNetEventNum()     // Catch:{ all -> 0x00d0 }
            monitor-exit(r7)     // Catch:{ all -> 0x00d0 }
            r1.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00f7
        L_0x00bd:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x00e4
        L_0x00c4:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x00c8:
            monitor-exit(r7)     // Catch:{ all -> 0x00d0 }
            throw r0     // Catch:{ IOException -> 0x00cd, all -> 0x00ca }
        L_0x00ca:
            r7 = move-exception
            r0 = r1
            goto L_0x00f8
        L_0x00cd:
            r7 = move-exception
            r0 = r1
            goto L_0x00d5
        L_0x00d0:
            r0 = move-exception
            goto L_0x00c8
        L_0x00d2:
            r7 = move-exception
            goto L_0x00f8
        L_0x00d4:
            r7 = move-exception
        L_0x00d5:
            r7.printStackTrace()     // Catch:{ all -> 0x00d2 }
            if (r0 == 0) goto L_0x00f7
            r0.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00f7
        L_0x00de:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x00e4:
            java.lang.String r1 = "add net event log err:"
            r0.append(r1)
            java.lang.String r7 = r7.toString()
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.didichuxing.omega.sdk.common.utils.OLog.m34763e(r7)
        L_0x00f7:
            return
        L_0x00f8:
            if (r0 == 0) goto L_0x0117
            r0.close()     // Catch:{ IOException -> 0x00fe }
            goto L_0x0117
        L_0x00fe:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "add net event log err:"
            r1.append(r2)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.didichuxing.omega.sdk.common.utils.OLog.m34763e(r0)
        L_0x0117:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.ditest.agent.android.NetworkEventAnalysis.addEvent(com.didichuxing.ditest.agent.android.measurement.http.HttpTransactionMeasurement):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0309, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x030a, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x031c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0322, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0325, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x02b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x02b9, code lost:
        r2 = r0;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x02bd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x02be, code lost:
        r2 = r0;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x02c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x02c2, code lost:
        r2 = r0;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x02c5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x02c6, code lost:
        r2 = r0;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x02c9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02ca, code lost:
        r2 = r0;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02db, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02dc, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02e9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02ea, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02f8, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:55:0x02b3, B:115:0x0318] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0305 A[SYNTHETIC, Splitter:B:104:0x0305] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x030f A[SYNTHETIC, Splitter:B:110:0x030f] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0318 A[SYNTHETIC, Splitter:B:115:0x0318] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02b8 A[ExcHandler: all (r0v15 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:9:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02c1 A[ExcHandler: NumberFormatException (r0v13 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:9:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x02c5 A[ExcHandler: IOException (r0v12 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:9:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02c9 A[ExcHandler: FileNotFoundException (r0v11 'e' java.io.FileNotFoundException A[CUSTOM_DECLARE]), Splitter:B:9:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02d7 A[SYNTHETIC, Splitter:B:74:0x02d7] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02e5 A[SYNTHETIC, Splitter:B:83:0x02e5] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02f3 A[SYNTHETIC, Splitter:B:92:0x02f3] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x02b3=Splitter:B:55:0x02b3, B:96:0x02f9=Splitter:B:96:0x02f9} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:80:0x02e0=Splitter:B:80:0x02e0, B:101:0x0300=Splitter:B:101:0x0300, B:71:0x02d2=Splitter:B:71:0x02d2, B:89:0x02ee=Splitter:B:89:0x02ee} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadEvent() {
        /*
            r18 = this;
            r1 = r18
            java.io.File r2 = r1.mNetCacheFile
            if (r2 == 0) goto L_0x0326
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x000e
            goto L_0x0326
        L_0x000e:
            java.io.File r3 = r1.mNetCacheFile
            monitor-enter(r3)
            r4 = 0
            r5 = 1
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x02fe, IOException -> 0x02ec, NumberFormatException -> 0x02de, Exception -> 0x02d0 }
            java.io.FileReader r7 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x02fe, IOException -> 0x02ec, NumberFormatException -> 0x02de, Exception -> 0x02d0 }
            java.io.File r8 = r1.mNetCacheFile     // Catch:{ FileNotFoundException -> 0x02fe, IOException -> 0x02ec, NumberFormatException -> 0x02de, Exception -> 0x02d0 }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x02fe, IOException -> 0x02ec, NumberFormatException -> 0x02de, Exception -> 0x02d0 }
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x02fe, IOException -> 0x02ec, NumberFormatException -> 0x02de, Exception -> 0x02d0 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
        L_0x0024:
            java.lang.String r8 = r6.readLine()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            if (r8 == 0) goto L_0x0274
            java.util.Map r8 = com.didichuxing.omega.sdk.common.utils.JsonUtil.json2Map(r8)     // Catch:{ Exception -> 0x0258, FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, all -> 0x02b8 }
            java.lang.String r9 = "urlpath"
            java.lang.Object r9 = r8.get(r9)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r9 = r9.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r9 = com.didichuxing.ditest.agent.android.util.C15538Util.getUrlPath(r9)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r10 = "nts"
            java.lang.Object r10 = r8.get(r10)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r10 = r10.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            long r10 = r10.longValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            if (r9 == 0) goto L_0x0024
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.<init>()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.append(r9)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.append(r10)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r12 = r12.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            boolean r12 = com.didichuxing.ditest.agent.android.util.CacheList.hit(r12)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            if (r12 == 0) goto L_0x0066
            goto L_0x0024
        L_0x0066:
            boolean r12 = r7.containsKey(r9)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            if (r12 == 0) goto L_0x01cb
            java.lang.Object r12 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = "up"
            java.lang.String r14 = "up"
            java.lang.Object r14 = r8.get(r14)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r14 = r14.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            long r14 = r14.longValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "up"
            java.lang.Object r2 = r12.get(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            long r16 = r2.longValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            long r14 = r14 + r16
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r13, r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "down"
            java.lang.String r13 = "down"
            java.lang.Object r13 = r8.get(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = r13.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            long r13 = r13.longValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r15 = "down"
            java.lang.Object r15 = r12.get(r15)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r15 = r15.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            long r16 = r15.longValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            long r13 = r13 + r16
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "time"
            java.lang.String r13 = "time"
            java.lang.Object r13 = r8.get(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = r13.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Double r13 = java.lang.Double.valueOf(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            double r13 = r13.doubleValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r15 = "time"
            java.lang.Object r15 = r12.get(r15)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r15 = r15.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Double r15 = java.lang.Double.valueOf(r15)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            double r16 = r15.doubleValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            double r13 = r13 + r16
            java.lang.Double r13 = java.lang.Double.valueOf(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = "status,"
            r2.append(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = "statusCode"
            java.lang.Object r13 = r8.get(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r2.append(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            boolean r13 = r12.containsKey(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            if (r13 == 0) goto L_0x012e
            java.lang.Object r13 = r12.get(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = r13.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            int r13 = r13.intValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            int r13 = r13 + r5
            goto L_0x012f
        L_0x012e:
            r13 = 1
        L_0x012f:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = "errCode,"
            r2.append(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = "errorCode"
            java.lang.Object r8 = r8.get(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r2.append(r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            boolean r8 = r12.containsKey(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            if (r8 == 0) goto L_0x0165
            java.lang.Object r8 = r12.get(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            int r8 = r8.intValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            int r8 = r8 + r5
            goto L_0x0166
        L_0x0165:
            r8 = 1
        L_0x0166:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "pv"
            java.lang.String r8 = "pv"
            java.lang.Object r8 = r12.get(r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            int r8 = r8.intValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            int r8 = r8 + r5
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "startTs"
            java.lang.Object r2 = r12.get(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            long r13 = r2.longValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            int r2 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x01aa
            java.lang.String r2 = "startTs"
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            goto L_0x0253
        L_0x01aa:
            java.lang.String r2 = "endTs"
            java.lang.Object r2 = r12.get(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            long r13 = r2.longValue()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            int r2 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x0253
            java.lang.String r2 = "endTs"
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            goto L_0x0253
        L_0x01cb:
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.<init>()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "up"
            java.lang.String r13 = "up"
            java.lang.Object r13 = r8.get(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "down"
            java.lang.String r13 = "down"
            java.lang.Object r13 = r8.get(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "time"
            java.lang.String r13 = "time"
            java.lang.Object r13 = r8.get(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = "status,"
            r2.append(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = "statusCode"
            java.lang.Object r13 = r8.get(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r2.append(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = "errCode,"
            r2.append(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r13 = "errorCode"
            java.lang.Object r13 = r8.get(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r2.append(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "carrier"
            java.lang.String r13 = "carrier"
            java.lang.Object r8 = r8.get(r13)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "pv"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "startTs"
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = "endTs"
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r12.put(r2, r8)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
        L_0x0253:
            r7.put(r9, r12)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            goto L_0x0024
        L_0x0258:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r9 = "http_api_user_reqs json data err: "
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r8.append(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r2 = r8.toString()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            com.didichuxing.omega.sdk.common.utils.OLog.m34763e(r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            goto L_0x0024
        L_0x0274:
            int r2 = r7.size()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            if (r2 <= 0) goto L_0x02ac
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.util.Set r8 = r7.keySet()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
        L_0x0287:
            boolean r9 = r8.hasNext()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            if (r9 == 0) goto L_0x02a1
            java.lang.Object r9 = r8.next()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.Object r10 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            java.lang.String r10 = com.didichuxing.omega.sdk.common.utils.JsonUtil.map2Json(r10)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            r2.put(r9, r10)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            goto L_0x0287
        L_0x02a1:
            boolean r7 = r18.deleteFile()     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
            if (r7 == 0) goto L_0x02ac
            java.lang.String r7 = "http_api_user_reqs"
            com.didichuxing.omega.sdk.analysis.Tracker.trackEvent(r7, r4, r2)     // Catch:{ FileNotFoundException -> 0x02c9, IOException -> 0x02c5, NumberFormatException -> 0x02c1, Exception -> 0x02bd, all -> 0x02b8 }
        L_0x02ac:
            r6.close()     // Catch:{ IOException -> 0x02b1 }
            goto L_0x030c
        L_0x02b1:
            r0 = move-exception
            r2 = r0
        L_0x02b3:
            r2.printStackTrace()     // Catch:{ all -> 0x0322 }
            goto L_0x030c
        L_0x02b8:
            r0 = move-exception
            r2 = r0
            r4 = r6
            goto L_0x0316
        L_0x02bd:
            r0 = move-exception
            r2 = r0
            r4 = r6
            goto L_0x02d2
        L_0x02c1:
            r0 = move-exception
            r2 = r0
            r4 = r6
            goto L_0x02e0
        L_0x02c5:
            r0 = move-exception
            r2 = r0
            r4 = r6
            goto L_0x02ee
        L_0x02c9:
            r0 = move-exception
            r2 = r0
            r4 = r6
            goto L_0x0300
        L_0x02cd:
            r0 = move-exception
            r2 = r0
            goto L_0x0316
        L_0x02d0:
            r0 = move-exception
            r2 = r0
        L_0x02d2:
            r2.printStackTrace()     // Catch:{ all -> 0x02cd }
            if (r4 == 0) goto L_0x02fc
            r4.close()     // Catch:{ IOException -> 0x02db }
            goto L_0x02fc
        L_0x02db:
            r0 = move-exception
            r2 = r0
            goto L_0x02f9
        L_0x02de:
            r0 = move-exception
            r2 = r0
        L_0x02e0:
            r2.printStackTrace()     // Catch:{ all -> 0x02cd }
            if (r4 == 0) goto L_0x02fc
            r4.close()     // Catch:{ IOException -> 0x02e9 }
            goto L_0x02fc
        L_0x02e9:
            r0 = move-exception
            r2 = r0
            goto L_0x02f9
        L_0x02ec:
            r0 = move-exception
            r2 = r0
        L_0x02ee:
            r2.printStackTrace()     // Catch:{ all -> 0x02cd }
            if (r4 == 0) goto L_0x02fc
            r4.close()     // Catch:{ IOException -> 0x02f7 }
            goto L_0x02fc
        L_0x02f7:
            r0 = move-exception
            r2 = r0
        L_0x02f9:
            r2.printStackTrace()     // Catch:{ all -> 0x0322 }
        L_0x02fc:
            r2 = 1
            goto L_0x030d
        L_0x02fe:
            r0 = move-exception
            r2 = r0
        L_0x0300:
            r2.printStackTrace()     // Catch:{ all -> 0x02cd }
            if (r4 == 0) goto L_0x030c
            r4.close()     // Catch:{ IOException -> 0x0309 }
            goto L_0x030c
        L_0x0309:
            r0 = move-exception
            r2 = r0
            goto L_0x02b3
        L_0x030c:
            r2 = 0
        L_0x030d:
            if (r2 == 0) goto L_0x0314
            java.io.File r2 = r1.mNetCacheFile     // Catch:{ all -> 0x0322 }
            r2.delete()     // Catch:{ all -> 0x0322 }
        L_0x0314:
            monitor-exit(r3)     // Catch:{ all -> 0x0322 }
            return
        L_0x0316:
            if (r4 == 0) goto L_0x0321
            r4.close()     // Catch:{ IOException -> 0x031c }
            goto L_0x0321
        L_0x031c:
            r0 = move-exception
            r4 = r0
            r4.printStackTrace()     // Catch:{ all -> 0x0322 }
        L_0x0321:
            throw r2     // Catch:{ all -> 0x0322 }
        L_0x0322:
            r0 = move-exception
            r2 = r0
            monitor-exit(r3)     // Catch:{ all -> 0x0322 }
            throw r2
        L_0x0326:
            r18.newFile()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.ditest.agent.android.NetworkEventAnalysis.uploadEvent():void");
    }

    public boolean deleteFile() {
        if (!this.mNetCacheFile.exists()) {
            return true;
        }
        try {
            if (!this.mNetCacheFile.delete()) {
                return false;
            }
            return true;
        } catch (SecurityException unused) {
        }
    }

    public boolean newFile() {
        if (this.mNetCacheFile == null) {
            this.mNetCacheFile = new File(getNetCache(this.mContext), this.netFileName);
        }
        try {
            return this.mNetCacheFile.createNewFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public File getNetCache(Context context) {
        File file;
        if (this.mNetCacheFile == null) {
            File file2 = null;
            try {
                file2 = context.getCacheDir();
                file = new File(file2, "alpha_net_cache");
                try {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                } catch (Throwable unused) {
                    file2 = file;
                    file = file2;
                    this.mNetCacheFile = file;
                    return this.mNetCacheFile;
                }
            } catch (Throwable unused2) {
                file = file2;
                this.mNetCacheFile = file;
                return this.mNetCacheFile;
            }
            this.mNetCacheFile = file;
        }
        return this.mNetCacheFile;
    }

    public boolean canUploadToday() {
        return ((long) this.savedState.getInt(this.netEventUploadNumKey)) < this.maxNetEventUploadPerDay;
    }

    private void addNetEventNum() {
        SavedState savedState2 = this.savedState;
        String str = this.netEventUploadNumKey;
        savedState2.save(str, savedState2.getInt(str) + 1);
    }

    public void addEventV2(HttpTransactionMeasurement httpTransactionMeasurement) {
        try {
            if (canUploadToday()) {
                String url = httpTransactionMeasurement.getUrl();
                if (url == null) {
                    OLog.m34763e("add event v2, but url is null!");
                    return;
                }
                String urlPath = C15538Util.getUrlPath(url);
                if (urlPath == null) {
                    OLog.m34763e("parse urlpath fail when add event v2, url:" + url);
                    return;
                }
                synchronized (this.netCacheMap) {
                    Map map = this.netCacheMap.get(urlPath);
                    if (map == null) {
                        map = new HashMap();
                        map.put("urlpath", urlPath);
                        map.put("up", Long.valueOf(httpTransactionMeasurement.getBytesSent()));
                        map.put("down", Long.valueOf(httpTransactionMeasurement.getBytesReceived()));
                        map.put("time", Double.valueOf(httpTransactionMeasurement.getTotalTime()));
                        map.put(Constants.WAN_TYPE, httpTransactionMeasurement.getWanType());
                        map.put("carrier", httpTransactionMeasurement.getCarrier());
                        map.put("errCode," + httpTransactionMeasurement.getErrorCode(), 1);
                        map.put("status," + httpTransactionMeasurement.getStatusCode(), 1);
                        long currentTimeMillis = System.currentTimeMillis();
                        map.put("startTs", Long.valueOf(currentTimeMillis));
                        map.put("endTs", Long.valueOf(currentTimeMillis));
                        map.put("pv", 1);
                    } else {
                        map.put("up", Long.valueOf(Long.valueOf(map.get("up").toString()).longValue() + httpTransactionMeasurement.getBytesSent()));
                        map.put("down", Long.valueOf(Long.valueOf(map.get("down").toString()).longValue() + httpTransactionMeasurement.getBytesReceived()));
                        map.put("time", Double.valueOf(Double.valueOf(map.get("time").toString()).doubleValue() + httpTransactionMeasurement.getTotalTime()));
                        map.put("pv", Integer.valueOf(Integer.valueOf(map.get("pv").toString()).intValue() + 1));
                        String str = "errCode," + httpTransactionMeasurement.getErrorCode();
                        Object obj = map.get(str);
                        if (obj != null) {
                            map.put(str, Integer.valueOf(Integer.valueOf(obj.toString()).intValue() + 1));
                        } else {
                            map.put(str, 1);
                        }
                        String str2 = "status," + httpTransactionMeasurement.getStatusCode();
                        Object obj2 = map.get(str2);
                        if (obj2 != null) {
                            map.put(str2, Integer.valueOf(Integer.valueOf(obj2.toString()).intValue() + 1));
                        } else {
                            map.put(str2, 1);
                        }
                        map.put("endTs", Long.valueOf(System.currentTimeMillis()));
                    }
                    this.netCacheMap.put(urlPath, map);
                }
                addNetEventNum();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadEventAsync() {
        new ThreadTaskObject() {
            public void run() {
                ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                if (OmegaConfig.NET_DIAG_USE_MEMORY_CACHE) {
                    NetworkEventAnalysis.this.uploadEventV2();
                } else {
                    NetworkEventAnalysis.this.uploadEvent();
                }
            }
        }.start();
    }

    public void uploadEventV2() {
        HashMap hashMap;
        synchronized (this.netCacheMap) {
            if (this.netCacheMap.size() > 0) {
                hashMap = new HashMap();
                Set<String> keySet = this.netCacheMap.keySet();
                if (keySet != null && !keySet.isEmpty()) {
                    for (String next : keySet) {
                        hashMap.put(next, JsonUtil.map2Json(this.netCacheMap.get(next)));
                    }
                }
                this.netCacheMap.clear();
            } else {
                hashMap = null;
            }
        }
        if (hashMap != null) {
            Tracker.trackEvent("http_api_user_reqs", (String) null, hashMap);
        }
    }
}
