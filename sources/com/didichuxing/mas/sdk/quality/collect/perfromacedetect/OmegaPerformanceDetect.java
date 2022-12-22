package com.didichuxing.mas.sdk.quality.collect.perfromacedetect;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.C15787Util;
import com.didichuxing.mas.sdk.quality.collect.perfromacedetect.cpu.CpuUtils;
import com.didichuxing.mas.sdk.quality.collect.perfromacedetect.mem.MemUtil;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.collector.ActivityCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector;
import com.didichuxing.mas.sdk.quality.report.collector.StorageCollector;
import com.didichuxing.mas.sdk.quality.report.collector.ThreadCollector;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.FileUtil;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class OmegaPerformanceDetect {

    /* renamed from: a */
    private Timer f48199a = new Timer();

    /* renamed from: b */
    private TimerTask f48200b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f48201c = true;

    /* renamed from: d */
    private int f48202d = 0;

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static OmegaPerformanceDetect INSTANCE = new OmegaPerformanceDetect();

        private InstanceHolder() {
        }
    }

    public static OmegaPerformanceDetect getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void start(final Context context, final PerformanceDetectConfig performanceDetectConfig) {
        C158071 r1 = new TimerTask() {
            public void run() {
                try {
                    SystemUtils.setProcessThreadPriority(10);
                } catch (Exception e) {
                    OLog.m34418e("set performance thread priority failed. " + e.getMessage());
                }
                if (OmegaPerformanceDetect.this.f48201c && AppStateMonitor.getInstance().isInForeground()) {
                    if (performanceDetectConfig.cpuMonitorEnable) {
                        OmegaPerformanceDetect.this.m34351b(performanceDetectConfig);
                    }
                    if (performanceDetectConfig.memMonitorEnable) {
                        OmegaPerformanceDetect.this.m34343a(context, performanceDetectConfig);
                    }
                    if (performanceDetectConfig.threadMonitorEnable) {
                        OmegaPerformanceDetect.this.m34346a(performanceDetectConfig);
                    }
                    if (performanceDetectConfig.diskMonitorEnable) {
                        OmegaPerformanceDetect.this.m34348b(context, performanceDetectConfig);
                    }
                }
            }
        };
        this.f48200b = r1;
        this.f48199a.schedule(r1, 10000, performanceDetectConfig.trackInterval);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34346a(PerformanceDetectConfig performanceDetectConfig) {
        if (CommonUtil.isUpperLimitByDay("upper_limit_thread_count_event_key", performanceDetectConfig.limit)) {
            OLog.m34418e("thread count event upper limit.");
            return;
        }
        int currentThreadCount = ThreadCollector.getCurrentThreadCount();
        if (currentThreadCount > performanceDetectConfig.maxThreadCount) {
            HashMap hashMap = new HashMap();
            try {
                hashMap.put("currentThreadCount", Integer.valueOf(currentThreadCount));
                hashMap.put("sysThreadLimit", Integer.valueOf(ThreadCollector.getSysThreadCountLimit()));
                Map<String, Object> currentFDList = ThreadCollector.getCurrentFDList();
                hashMap.put("currentFdCount", Integer.valueOf(currentFDList.size()));
                hashMap.put("sysFdLimit", Integer.valueOf(ThreadCollector.getSysFdCountLimit()));
                hashMap.put("threadThreshold", Integer.valueOf(performanceDetectConfig.maxThreadCount));
                hashMap.put("fdThreshold", Integer.valueOf(performanceDetectConfig.maxFDCount));
                for (Map.Entry<Thread, StackTraceElement[]> key : Thread.getAllStackTraces().entrySet()) {
                    String a = m34340a(((Thread) key.getKey()).getName());
                    String str = "name:" + a.replaceAll("\\d+", "*");
                    if (hashMap.containsKey(str)) {
                        hashMap.put(str, Integer.valueOf(Integer.parseInt(hashMap.get(str).toString()) + 1));
                    } else {
                        hashMap.put(str, 1);
                    }
                }
                if (performanceDetectConfig.threadDetailEnable) {
                    hashMap.put("threadStacks", ThreadCollector.getAllThreadInfo(performanceDetectConfig.threadDetailEnable));
                    hashMap.put("fdList", JsonUtil.map2Json(currentFDList));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            OmegaSDKAdapter.trackMasEvent("xray_thread_overload", (String) null, hashMap);
            CommonUtil.addUpperLimitByDay("upper_limit_thread_count_event_key");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34351b(PerformanceDetectConfig performanceDetectConfig) {
        if (CommonUtil.isUpperLimitByDay("upper_limit_cpu_overload", performanceDetectConfig.limit)) {
            OLog.m34418e("cpu overload event upper limit");
            return;
        }
        double processCpuUsage = CpuUtils.getProcessCpuUsage(Process.myPid());
        if (processCpuUsage > ((double) performanceDetectConfig.maxCpuUsage)) {
            int i = this.f48202d + 1;
            this.f48202d = i;
            if (i >= performanceDetectConfig.cpuOverloadCount) {
                m34341a(processCpuUsage, performanceDetectConfig);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34343a(Context context, PerformanceDetectConfig performanceDetectConfig) {
        if (CommonUtil.isUpperLimitByDay("upper_limit_mem_overload", performanceDetectConfig.limit)) {
            OLog.m34418e("mem overload event upper limit");
            return;
        }
        int myPid = Process.myPid();
        long currentProcessMemUsage = MemUtil.getCurrentProcessMemUsage(context, myPid);
        int appProcessMaxMem = MemUtil.getAppProcessMaxMem(context);
        float proccessMemUsage = MemUtil.getProccessMemUsage(context, myPid);
        if (proccessMemUsage > ((float) performanceDetectConfig.maxMemUsage)) {
            m34342a(proccessMemUsage, currentProcessMemUsage, appProcessMaxMem, performanceDetectConfig);
        }
    }

    /* renamed from: a */
    private void m34341a(double d, PerformanceDetectConfig performanceDetectConfig) {
        HashMap hashMap = new HashMap();
        hashMap.put("top_thread_info", CpuUtils.getTopCpuUseThreadInfo());
        hashMap.put("callStack", ThreadCollector.getAllThreadStacks());
        hashMap.put("percent", Double.valueOf(d));
        hashMap.put("duration", Long.valueOf(performanceDetectConfig.trackInterval));
        hashMap.put("page", ActivityCollector.getCurActivityPage());
        hashMap.put("threshold", Integer.valueOf(performanceDetectConfig.maxCpuUsage));
        hashMap.put("isAppFront", String.valueOf(AppStateMonitor.getInstance().isInForeground()));
        OmegaSDKAdapter.trackMasEvent("xray_cpu_overload", (String) null, hashMap);
        this.f48202d--;
        CommonUtil.addUpperLimitByDay("upper_limit_cpu_overload");
    }

    /* renamed from: a */
    private void m34342a(float f, long j, int i, PerformanceDetectConfig performanceDetectConfig) {
        HashMap hashMap = new HashMap();
        hashMap.put("callStack", ThreadCollector.getAllThreadStacks());
        hashMap.put("page", ActivityCollector.getCurActivityPage());
        hashMap.put("percent", Float.valueOf(f));
        hashMap.put("duration", Long.valueOf(performanceDetectConfig.trackInterval));
        hashMap.put("threshold", Integer.valueOf(performanceDetectConfig.maxMemUsage));
        hashMap.put("isAppFront", String.valueOf(AppStateMonitor.getInstance().isInForeground()));
        hashMap.put("currentProcessMem", Long.valueOf(j));
        hashMap.put("maxProcessMem", Integer.valueOf(i));
        OmegaSDKAdapter.trackMasEvent("xray_mem_overload", (String) null, hashMap);
        CommonUtil.addUpperLimitByDay("upper_limit_mem_overload");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34348b(Context context, PerformanceDetectConfig performanceDetectConfig) {
        long j;
        Context context2 = context;
        PerformanceDetectConfig performanceDetectConfig2 = performanceDetectConfig;
        if (context2 != null && performanceDetectConfig2 != null && PersistentInfoCollector.ifNeedODAT("perf_detect_disk_duration_key")) {
            if (CommonUtil.isUpperLimitByDay("upper_limit_disk_detect_count_event_key", performanceDetectConfig2.limit)) {
                OLog.m34418e("disk overload event upper limit");
                return;
            }
            HashMap hashMap = new HashMap();
            long[] externalStorage = StorageCollector.getExternalStorage();
            long j2 = externalStorage[0];
            long j3 = externalStorage[1];
            hashMap.put("totalSpace", Long.valueOf(j2));
            hashMap.put("availableSpace", Long.valueOf(j3));
            try {
                long appInternalStorageSize = StorageCollector.getAppInternalStorageSize(context);
                if (appInternalStorageSize >= 0) {
                    hashMap.put("appPrivateSpace", Long.valueOf(appInternalStorageSize));
                    j = appInternalStorageSize + 0;
                } else {
                    j = 0;
                }
                long appExternalStorageSize = StorageCollector.getAppExternalStorageSize(context);
                if (appExternalStorageSize >= 0) {
                    hashMap.put("appExternalSpace", Long.valueOf(appExternalStorageSize));
                    j += appExternalStorageSize;
                }
                long appSdCardStorageSize = StorageCollector.getAppSdCardStorageSize(context2, performanceDetectConfig2.diskPathList);
                if (appSdCardStorageSize >= 0) {
                    hashMap.put("appSdcardSpace", Long.valueOf(appSdCardStorageSize));
                    j += appSdCardStorageSize;
                }
                long[] dataBlockUsage = StorageCollector.getDataBlockUsage();
                long j4 = dataBlockUsage[0];
                long j5 = j2;
                int round = Math.round((((float) (j4 - dataBlockUsage[1])) / (((float) j4) * 1.0f)) * 100.0f);
                int round2 = Math.round((((float) (j5 - j3)) / (((float) j5) * 1.0f)) * 100.0f);
                if (round2 >= performanceDetectConfig2.diskLimitPercent || round >= performanceDetectConfig2.diskDataLimitPercent || j >= performanceDetectConfig2.diskLimitThreshold * 1024 * 1024) {
                    hashMap.put("appTotalSpace", Long.valueOf(j));
                    hashMap.put("usedPercent", Integer.valueOf(round2));
                    hashMap.put("dataUsedPercent", Integer.valueOf(round));
                    hashMap.put("all", StorageCollector.listAppFilesWithRecord(context2, performanceDetectConfig2.diskPathDepth, performanceDetectConfig2.diskPathList));
                    OmegaSDKAdapter.trackMasEvent("xray_disk_overload", (String) null, hashMap);
                    CommonUtil.addUpperLimitByDay("upper_limit_disk_detect_count_event_key");
                }
                if (performanceDetectConfig2.diskCleanPath != null) {
                    if (performanceDetectConfig2.diskCleanPath.length != 0) {
                        ArrayList arrayList = new ArrayList(performanceDetectConfig2.diskCleanPath.length);
                        for (String str : performanceDetectConfig2.diskCleanPath) {
                            if (!TextUtils.isEmpty(str)) {
                                File ofFile = StorageCollector.ofFile(context2, str);
                                if (ofFile.exists()) {
                                    arrayList.add(ofFile);
                                }
                            }
                        }
                        long j6 = performanceDetectConfig2.diskCleanLimit * 1024 * 1024;
                        if (round2 >= performanceDetectConfig2.diskLimitPercent) {
                            FileUtil.cleanFiles(arrayList);
                        } else if (j >= j6) {
                            FileUtil.cleanFiles(arrayList);
                        } else if (((double) j) >= ((double) j6) * 0.9d) {
                            FileUtil.cleanFilesWithoutRecentUsed(arrayList, TimeUnit.DAYS.toMillis(1));
                        } else {
                            FileUtil.cleanFilesRarelyUsed(arrayList, performanceDetectConfig2.diskCleanExpire * 1000);
                        }
                    }
                }
                String[] strArr = performanceDetectConfig2.diskCleanPath_P2;
                if (strArr != null && strArr.length > 0) {
                    ArrayList arrayList2 = new ArrayList(strArr.length);
                    for (String str2 : strArr) {
                        if (!TextUtils.isEmpty(str2)) {
                            arrayList2.add(StorageCollector.ofFile(context2, str2));
                        }
                    }
                    FileUtil.cleanFilesWithNameMatched(arrayList2);
                }
            } catch (Exception e) {
                OLog.m34419e("detectStorageUsage error", e);
            }
        }
    }

    /* renamed from: a */
    private static String m34340a(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || !str.startsWith("OneNet http") || (indexOf = str.indexOf("http")) <= 0) {
            return str;
        }
        String substring = str.substring(indexOf);
        return "OneNet " + C15787Util.sanitizeUrl(substring);
    }

    public void stop() {
        Timer timer = this.f48199a;
        if (timer != null) {
            timer.cancel();
            this.f48199a = null;
        }
    }

    public void pause() {
        if (this.f48199a != null) {
            this.f48201c = false;
        }
    }

    public void resume() {
        if (this.f48199a != null) {
            this.f48201c = true;
        }
    }
}
